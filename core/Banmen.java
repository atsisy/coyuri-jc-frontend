package core;

import config.Values;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Banmen {

    private Square[][] ban;
    private int[][] system_ban;
    private ArrayList<Masume> target_masume_list;
    private int holding_koma;
    private Masume holding_koma_s_masume;

    public Banmen(){

        ban = new Square[9][9];
        system_ban = new int[9][9];
        target_masume_list = null;
        holding_koma = -1;
        holding_koma_s_masume = new Masume(0, 0);

        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                ban[x][y] = new Square(this, 70, 70);
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
                AnchorPane.setLeftAnchor(ban[x][y].getCanvas(), x * 70.0);
                AnchorPane.setTopAnchor(ban[x][y].getCanvas(), y * 70.0);
            }
        }
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

    void sync(){
        for(int y = 1;y <= 9;y++){
            for(int x = 1;x <= 9;x++){
                redraw(x, y, system_ban[9 - x][y - 1]);
            }
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
        system_ban[9 - masume.getX()][masume.getY() - 1] = holding_koma;
        system_ban[9 - holding_koma_s_masume.getX()][holding_koma_s_masume.getY() - 1] = EMPTY;

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
}
