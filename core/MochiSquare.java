package core;

/**
 * Created by Akihiro on 2017/06/10.
 */
public class MochiSquare extends SquareLayer {

    int koma_type;

    public MochiSquare(Banmen ban, int type, double width, double height){
        super(width, height);

        this.koma_type = type;

        canvas.setOnMouseClicked(event -> {
            ban.clear_target_mark();
            ban.mark_target(Wcm.mochigoma_wcm(ban));
        });
    }

}
