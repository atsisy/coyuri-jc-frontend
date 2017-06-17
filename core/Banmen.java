package core;

import config.Values;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringTokenizer;

import static config.Values.*;
import static core.ReadCoyuriBanmen.read_coyuri_input_stream;
import static java.lang.Thread.sleep;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Banmen {

    private Square[][] ban;
    private int[][] system_ban;
    private ArrayList<Masume> target_masume_list;
    private int holding_koma;
    private Masume holding_koma_s_masume;
    private long tesuu;
    private boolean ready_to_ai;
    private MochiSpace ai_mochi;
    private MochiSpace pl_mochi;

    public Banmen(){

        ban = new Square[9][9];
        system_ban = new int[9][9];
        target_masume_list = null;
        holding_koma = -1;
        holding_koma_s_masume = new Masume(0, 0);
        tesuu = 0;
        ready_to_ai = false;

        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                ban[x][y] = new Square(this, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
                system_ban[x][y] = EMPTY;
            }
        }

        for(int y = 1;y <= 9;y++){
            for(int x = 1;x <= 9;x++){
                redraw(x, y, Values.EMPTY);
                ban[9-x][y-1].set_masume(x, y);
            }
        }

        redraw(1, 1, EN_KYOUSHA);
        redraw(2, 1, EN_KEIMA);
        redraw(2, 2, EN_KAKU);
        redraw(3, 1, EN_GIN);
        redraw(4, 1, EN_KIN);
        redraw(5, 1, EN_OU);
        redraw(5, 1, EN_OU);
        redraw(6, 1, EN_KIN);
        redraw(7, 1, EN_GIN);
        redraw(8, 1, EN_KEIMA);
        redraw(8, 2, EN_HISHA);
        redraw(9, 1, EN_KYOUSHA);
        for(int i = 1;i <= 9;i++){
            redraw(i, 3, EN_HU);
        }

        redraw(1, 9, KYOUSHA);
        redraw(2, 9, KEIMA);
        redraw(2, 8, HISHA);
        redraw(3, 9, GIN);
        redraw(4, 9, KIN);
        redraw(5, 9, OU);
        redraw(5, 9, OU);
        redraw(6, 9, KIN);
        redraw(7, 9, GIN);
        redraw(8, 9, KEIMA);
        redraw(8, 8, KAKU);
        redraw(9, 9, KYOUSHA);
        for(int i = 1;i <= 9;i++){
            redraw(i, 7, HU);
        }

        ai_mochi = new MochiSpace(this, false);
        pl_mochi = new MochiSpace(this, true);

    }

    void redraw(int x, int y, int koma_type){
        ban[9-x][y-1].drawImage(Main.image.getImage(koma_type));
        system_ban[9-x][y-1] = koma_type;
    }

    void redraw(Masume masume, int koma_type){
        ban[9-masume.getX()][masume.getY()-1].drawImage(Main.image.getImage(koma_type));
        system_ban[9-masume.getX()][masume.getY()-1] = koma_type;
    }

    public Square edit(int x, int y){
        return ban[x][y];
    }

    public int get_system_ban_value(int x, int y){
        return system_ban[9-x][y-1];
    }

    public void register(AnchorPane root){
        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                root.getChildren().add(ban[x][y].getCanvas());
                AnchorPane.setLeftAnchor(ban[x][y].getCanvas(), (x * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM);
                AnchorPane.setTopAnchor(ban[x][y].getCanvas(), (y * M_SQUARE_HEIGHT) + TOP_FROM_BANMEN);
            }
        }

        ai_mochi.register(root);
        pl_mochi.register(root);
    }

    public void mark_target(ArrayList<Masume> list){
        target_masume_list = list;
        target_masume_list.forEach(masume -> {
            ban[9-masume.getX()][masume.getY()-1].drawImage(Main.image.getImage(TARGET));
        });
    }

    void clear_target_mark(){
        if(target_masume_list != null) {
            target_masume_list.forEach(masume -> {
                redraw(masume, system_ban[9 - masume.getX()][masume.getY() - 1]);
            });
        }
    }

    void sync() {
        for (int y = 1; y <= 9; y++) {
            for (int x = 1; x <= 9; x++) {
                redraw(x, y, system_ban[9 - x][y - 1]);
            }
        }
    }

    void run_ai(){
        write_data();
        ArrayList<String> bin_command = new ArrayList<>();
        bin_command.add("./coyuri_jc_backend.exe");
        bin_command.add("./banmen.coyuri");
        bin_command.add("./out.coyuri");

        reload(ReadCoyuriBanmen.read_coyuri_input_stream(bin_command));

        sync();
        increase_tesuu();
    }

    private void reload(ArrayList<String> list){

        int y;
        for(y = 0;y < 9;++y){
            StringTokenizer stringTokenizer = new StringTokenizer(list.get(y));
            for(int x = 0;x < 9;++x) {
                this.system_ban[x][y] = Integer.valueOf(stringTokenizer.nextToken());
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(list.get(y));
        stringTokenizer.nextToken();
        ai_mochi.clear();
        while(stringTokenizer.hasMoreTokens()){
            ai_mochi.add_koma(Integer.valueOf(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(list.get(y + 1));
        stringTokenizer.nextToken();
        pl_mochi.clear();
        while(stringTokenizer.hasMoreTokens()){
            pl_mochi.add_koma(Integer.valueOf(stringTokenizer.nextToken()));
        }

        ai_mochi.redraw();
        pl_mochi.redraw();
    }

    private void write_data(){
        try {
            //上書きモードでファイル作成
            FileWriter fileWriter = new FileWriter("./banmen.coyuri", false);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));

            //手数を出力
            printWriter.println(tesuu);

            //書き込み
            for(int i = 0;i < 9;i++) {
                for(int j = 0;j < 9;j++) {
                    printWriter.print(system_ban[j][i]);
                    printWriter.print(" ");
                }
                printWriter.print('\n');
            }

            printWriter.print("ai_mochi ");
            printWriter.println(ai_mochi.toString());

            printWriter.print("pl_mochi ");
            printWriter.println(pl_mochi.toString());

            //flush
            printWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    void hold_koma(int koma, Masume masume){
        holding_koma = koma;
        holding_koma_s_masume = masume;
    }

    boolean is_targeted(Masume masume){
        if(target_masume_list == null){
            return false;
        }
        for(Masume m : target_masume_list){
            if(m.equals(masume)){
                return true;
            }
        }
        return false;
    }

    private boolean is_holding(){
        return holding_koma != -1;
    }

    void move(Masume masume){
        if(!is_holding()){
            return;
        }

        if (masume.getY() <= 3){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("成りますか？");
            alert.setTitle("成り判定");
            alert.setContentText("" + holding_koma);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                holding_koma = Naru.naru(holding_koma);
            }
        }

        if(system_ban[9 - masume.getX()][masume.getY() - 1] != EMPTY){
            pl_mochi.add_koma_for_java(system_ban[9 - masume.getX()][masume.getY() - 1] - (EN_HU - HU));
            pl_mochi.redraw();
        }
        system_ban[9 - masume.getX()][masume.getY() - 1] = holding_koma;
        if(holding_koma_s_masume.getX() != -1) {
            system_ban[9 - holding_koma_s_masume.getX()][holding_koma_s_masume.getY() - 1] = EMPTY;
        }else{
            pl_mochi.edit_system_mochi_element(holding_koma, -1);
        }
    }

    void clear_holding(){
        holding_koma = -1;
    }

    boolean is_empty(Masume masume){
        return system_ban[9 - masume.getX()][masume.getY() - 1] == EMPTY;
    }

    boolean is_empty(int x, int y){
        return system_ban[9 - x][y - 1] == EMPTY;
    }

    void increase_tesuu(){
        tesuu++;
    }

    boolean is_ready_to_ai(){
        return ready_to_ai;
    }

    void ready_ai(){
        ready_to_ai = true;
    }

    void finish_ai(){
        ready_to_ai = false;
    }

}
