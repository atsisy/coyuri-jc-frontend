package core;

import javafx.scene.control.Label;

import static config.Values.HU;

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
            if(koma_type == HU){
                ban.mark_target(Wcm.mochigoma_nihu_wcm(ban));
            }else {
                ban.mark_target(Wcm.mochigoma_wcm(ban));
            }
        });
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        int num = Integer.valueOf(count_label.getText());

        for(int i = 0;i < num;++i){
            buffer.append(" ");
            buffer.append(koma_type);
        }

        return buffer.toString();
    }

    public void update_score(int count){
        count_label.setText(String.valueOf(count));
    }

    public Label getCountLabel() {
        return count_label;
    }
}
