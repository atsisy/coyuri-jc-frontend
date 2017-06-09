package core;

import config.Values;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Square {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Masume masume;

    public Square(Banmen ban, double width, double height){
        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(event -> {
            if(ban.is_targeted(masume)){
                //内部データを動かした状態にする。
                ban.move(masume);

                //描画状態を同期
                ban.sync();

                //マークするターゲットのリストを空にしたい
                ban.mark_target(new ArrayList<>());

                //手数を一つ増やす
                ban.increase_tesuu();

                //描画処理等が終わったので。AIを実行してもいいことを伝える
                ban.ready_ai();
            }else {
                ban.clear_target_mark();
                switch (ban.get_system_ban_value(masume.getX(), masume.getY())) {
                    case HU:
                        ban.mark_target(Wcm.pl_hu_wcm(ban, masume));
                        ban.hold_koma(HU, masume);
                        break;
                    case KYOUSHA:
                        ban.mark_target(Wcm.pl_kyousha_wcm(ban, masume));
                        ban.hold_koma(KYOUSHA, masume);
                        break;
                    case KEIMA:
                        ban.mark_target(Wcm.pl_keima_wcm(ban, masume));
                        ban.hold_koma(KEIMA, masume);
                        break;
                    case GIN:
                        ban.mark_target(Wcm.pl_gin_wcm(ban, masume));
                        ban.hold_koma(GIN, masume);
                        break;
                    case KIN:
                        ban.mark_target(Wcm.pl_kin_wcm(ban, masume));
                        ban.hold_koma(KIN, masume);
                        break;
                    case HISHA:
                        ban.mark_target(Wcm.pl_hisha_wcm(ban, masume));
                        ban.hold_koma(HISHA, masume);
                        break;
                    case KAKU:
                        ban.mark_target(Wcm.pl_kaku_wcm(ban, masume));
                        ban.hold_koma(KAKU, masume);
                        break;
                    case RYU:
                        ban.mark_target(Wcm.pl_ryu_wcm(ban, masume));
                        ban.hold_koma(RYU, masume);
                        break;
                    case UMA:
                        ban.mark_target(Wcm.pl_uma_wcm(ban, masume));
                        ban.hold_koma(UMA, masume);
                    case OU:
                        ban.mark_target(Wcm.pl_ou_wcm(ban, masume));
                        ban.hold_koma(OU, masume);
                        break;
                    default:
                        ban.mark_target(new ArrayList<>());
                        ban.clear_holding();
                        break;
                }
            }
        });
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    /*
    * 指定したグラフィックレイヤーをすべて消す関数
     */
    public void eraseLayer(){
        this.graphicsContext.clearRect(0, 0, Values.SQUARE_WIDTH,Values.SQUARE_WIDTH);
    }

    /*
    * アクティブレイヤーの変更を行うメソッド
     */
    public void beForward(){
        canvas.toFront();
    }

    public void drawImage(Image image){
        graphicsContext.drawImage(image, 0, 0, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
    }

    public void set_masume(int x, int y){
        masume = new Masume(x, y);
    }
}
