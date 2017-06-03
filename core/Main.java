package core;

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

        /*
        ArrayList<String> bin_command = new ArrayList<>();
        bin_command.add("/home/takai/a.out");

        ReadCoyuriBanmen.read_coyuri_input_stream(bin_command).forEach(System.out::println);
        */

        AnchorPane root = new AnchorPane();
        Banmen banmen = new Banmen();

        banmen.register(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
