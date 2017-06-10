package core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Main extends Application {

    public static final Images image = new Images();

    @Override
    public void start(Stage stage) {
        stage.setWidth(1366);
        stage.setHeight(768);

        AnchorPane root = new AnchorPane();

        Rectangle rect = new Rectangle(1366, 768);
        rect.setFill(Color.BEIGE);
        root.getChildren().add(rect);

        Banmen banmen = new Banmen();
        banmen.register(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Thread t = new Thread(() -> {
            for (;;) {
                Platform.runLater(() -> {
                    if(banmen.is_ready_to_ai()) {
                        banmen.run_ai();
                        banmen.finish_ai();
                    }
                });
                try {
                    sleep(150);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        t.setDaemon(true);
        t.start();

    }

}
