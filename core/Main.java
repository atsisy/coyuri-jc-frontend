package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setFullScreen(true);

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
