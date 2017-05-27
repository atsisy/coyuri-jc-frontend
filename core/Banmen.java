package core;

import config.Values;
import javafx.scene.layout.AnchorPane;

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
