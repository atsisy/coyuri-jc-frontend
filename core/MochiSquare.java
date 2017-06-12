package core;

import javafx.scene.control.Label;

/**
 * Created by Akihiro on 2017/06/10.
 */
public class MochiSquare extends SquareLayer {

    private int koma_type;
    Label count_label;


    public MochiSquare(Banmen ban, int type, double width, double height){
        super(width, height);

        koma_type = type;
        count_label = new Label("0");

        canvas.setOnMouseClicked(event -> {
            if(Integer.valueOf(count_label.getText()) == 0){
                return;
            }
            ban.clear_target_mark();
            ban.hold_koma(koma_type, new Masume(-1, -1));
            ban.mark_target(Wcm.mochigoma_wcm(ban));
        });
    }

    public void update_score(int count){
        count_label.setText(String.valueOf(count));
    }

    public Label getCountLabel() {
        return count_label;
    }
}
