package core;

import javafx.scene.control.Label;

/**
 * Created by Akihiro on 2017/06/10.
 */
public class MochiSquare extends SquareLayer {

    int koma_type;
    Label count_label;

    public MochiSquare(Banmen ban, int type, double width, double height){
        super(width, height);

        this.koma_type = type;
        count_label = new Label("0");

        canvas.setOnMouseClicked(event -> {
            ban.clear_target_mark();
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
