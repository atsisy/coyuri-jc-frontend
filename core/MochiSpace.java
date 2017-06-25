package core;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/06/10.
 */
public class MochiSpace {

    //自分がAI用なのかプレイヤー用なのかのフラグ
    //true -> PLAYER  false -> AI
    private boolean who_am_i;

    //持ち駒用のSQUAREの配列
    private MochiSquare[] spaces;

    //持ち駒の内部処理用の配列
    private int[] system_mochi;

    public MochiSpace(Banmen ban, boolean flag){
        spaces = new MochiSquare[7];
        system_mochi = new int[7];

        for(int i = 0;i < 7;++i){
            spaces[i] = new MochiSquare(ban, i + HU, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
            system_mochi[i] = 0;
        }

        who_am_i = flag;

        redraw();

    }

    int at(int index){
        return system_mochi[index];
    }

    public void redraw(){
        for(int i = 0;i < system_mochi.length;++i){
            if(system_mochi[i] != 0) {
                if (who_am_i) {
                    spaces[i].drawImage(Main.image.getImage(i + 2));
                    spaces[i].update_score(system_mochi[i]);
                }else{
                    spaces[i].drawImage(Main.image.getImage(i + EN_HU));
                    spaces[i].update_score(system_mochi[i]);
                }
            }else{
                spaces[i].drawImage(Main.image.getImage(EMPTY));
            }
        }
    }

    public void register(AnchorPane root){
        if(who_am_i) {
            for (int i = 0; i < 7; i++) {
                root.getChildren().add(spaces[i].getCanvas());
                root.getChildren().add(spaces[i].getCountLabel());
                AnchorPane.setLeftAnchor(spaces[i].getCanvas(), ((i + 1) * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM);
                AnchorPane.setTopAnchor(spaces[i].getCanvas(), TOP_FROM_PL_MOCHI + M_SQUARE_HEIGHT + 10);
                AnchorPane.setLeftAnchor(spaces[i].getCountLabel(), ((i + 1) * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM);
                AnchorPane.setTopAnchor(spaces[i].getCountLabel(), TOP_FROM_PL_MOCHI + (M_SQUARE_HEIGHT * 2) + 10);
            }
        }else{
            for (int i = 0; i < 7; i++) {
                root.getChildren().add(spaces[i].getCanvas());
                root.getChildren().add(spaces[i].getCountLabel());
                AnchorPane.setLeftAnchor(spaces[i].getCanvas(), ((i + 1) * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM);
                AnchorPane.setTopAnchor(spaces[i].getCanvas(), TOP_FROM_BANMEN - (10 + M_SQUARE_HEIGHT));
                AnchorPane.setLeftAnchor(spaces[i].getCountLabel(), ((i + 1) * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM);
                AnchorPane.setTopAnchor(spaces[i].getCountLabel(), TOP_FROM_BANMEN - (M_SQUARE_HEIGHT + 27));
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(who_am_i) {
            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < system_mochi[i]; ++j) {
                    sb.append(i + HU);
                    sb.append(" ");
                }
            }
        }else{
            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < system_mochi[i]; ++j) {
                    sb.append(i + EN_HU);
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public void add_koma(int type){
        if(who_am_i) {
            system_mochi[koma_to_index(type)]++;
        }else{
            if(type == EN_OU){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("将棋少女　勝敗");
                alert.setHeaderText("あなたの勝利です。");
                alert.setContentText("");
            }
            system_mochi[koma_to_index(Naru.reset_koma(type))]++;
        }
    }

    private int koma_to_index(int type){
        switch (type){
            case HU:
                return 0;
            case KYOUSHA:
                return 1;
            case KEIMA:
                return 2;
            case GIN:
                return 3;
            case KIN:
                return 4;
            case HISHA:
                return 5;
            case KAKU:
                return 6;
            case EN_HU:
                return 0;
            case EN_KYOUSHA:
                return 1;
            case EN_KEIMA:
                return 2;
            case EN_GIN:
                return 3;
            case EN_KIN:
                return 4;
            case EN_HISHA:
                return 5;
            case EN_KAKU:
                return 6;
        }
        return type;
    }

    void add_koma_for_java(int type){
        if (who_am_i){
            if (type >= TOKIN){
                type -= (KAKU - HU);
            }
            system_mochi[type - HU]++;
        }
    }

    public void clear(){
        for(int i = 0;i < 7;i++){
            system_mochi[i] = 0;
            spaces[i].update_score(0);
        }
    }

    public void edit_system_mochi_element(int type, int val) {
        system_mochi[type - HU] += val;
        spaces[type - HU].update_score(system_mochi[type - HU]);
    }
}
