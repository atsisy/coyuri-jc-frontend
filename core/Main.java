package core;

import config.Values;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        Banmen banmen = new Banmen();

        banmen.register(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
