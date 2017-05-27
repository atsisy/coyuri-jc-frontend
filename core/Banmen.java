package core;

import config.Values;
import javafx.scene.layout.AnchorPane;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Banmen {

    private Square[][] ban;

    public Banmen(){
        ban = new Square[9][9];
        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                ban[x][y] = new Square(70, 70);
            }
        }

        for(int y = 1;y <= 9;y++){
            for(int x = 1;x <= 9;x++){
                redraw(x, y, Values.EMPTY);
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
    }

    public Square edit(int x, int y){
        return ban[x][y];
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

}
