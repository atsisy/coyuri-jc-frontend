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

    @Override
    public void start(Stage stage) {
        stage.setWidth(1366);
        stage.setHeight(768);

        AnchorPane root = new AnchorPane();
        Banmen banmen = new Banmen();

        final Images image = new Images();

        for(int i = 0;i < 9;i++){
            for(int n = 0;n < 9;n++){
                banmen.edit(i, n).drawImage(image.getImage(Values.EMPTY));
            }
        }

        banmen.register(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
