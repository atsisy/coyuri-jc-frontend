package core;

import config.Values;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Square {
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public Square(double width, double height){
        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
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
        graphicsContext.drawImage(image, 0, 0);
    }
}
