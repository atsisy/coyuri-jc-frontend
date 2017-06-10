package core;

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

    public MochiSpace(boolean flag){
        spaces = new MochiSquare[7];
        system_mochi = new int[7];

        for(int i = 0;i < 7;++i){
            spaces[i] = new MochiSquare(M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
            system_mochi[i] = 0;
        }

        who_am_i = flag;

        redraw();

    }

    public void redraw(){
        int koma;
        for(int i = 0;i < system_mochi.length;++i){
            if(system_mochi[i] != 0) {
                if (who_am_i) {
                    spaces[i].drawImage(Main.image.getImage(i + 2));
                }else{
                    spaces[i].drawImage(Main.image.getImage(i + EN_HU));
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
                AnchorPane.setLeftAnchor(spaces[i].getCanvas(), (i * M_SQUARE_WIDTH) + LEFT_FROM_BANMEM + (M_SQUARE_WIDTH * 9) + 10);
                AnchorPane.setTopAnchor(spaces[i].getCanvas(), TOP_FROM_PL_MOCHI);
            }
        }else{
            for (int i = 0; i < 7; i++) {
                root.getChildren().add(spaces[i].getCanvas());
                AnchorPane.setLeftAnchor(spaces[i].getCanvas(), (i * M_SQUARE_WIDTH) + 10);
                AnchorPane.setTopAnchor(spaces[i].getCanvas(), TOP_FROM_BANMEN);
            }
        }
    }

}
