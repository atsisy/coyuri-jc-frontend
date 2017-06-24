package core;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import static config.Values.WINDOW_HEIGHT;
import static config.Values.WINDOW_WIDTH;
import static java.lang.Thread.sleep;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Main extends Application {

    public static final Images image = new Images();
    static Label evalue_label = new Label("評価値 : -");

    @Override
    public void start(Stage stage) {
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);

        AnchorPane root = new AnchorPane();

        Rectangle rect = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
        rect.setFill(Color.BEIGE);
        root.getChildren().add(rect);

        Banmen banmen = new Banmen();
        banmen.register(root);

        Button run_ai_button = new Button("AIのターン");
        run_ai_button.setFont(new Font("ゆたぽん（コーディング）Bold", 15));
        run_ai_button.setOnAction(event -> {
            if(banmen.is_ready_to_ai()) {
                banmen.run_ai();
                banmen.finish_ai();
            }
        });

        AnchorPane.setLeftAnchor(evalue_label, 90.0);
        AnchorPane.setTopAnchor(evalue_label, WINDOW_HEIGHT / 2);
        evalue_label.setFont(new Font(30));
        root.getChildren().add(evalue_label);

        AnchorPane.setRightAnchor(run_ai_button, 100.0);
        AnchorPane.setTopAnchor(run_ai_button, WINDOW_HEIGHT / 1.5);
        root.getChildren().add(run_ai_button);
        run_ai_button.setMinWidth(100);
        run_ai_button.setMinHeight(100);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Window window = stage;
        FurigomaWindow furigoma = new FurigomaWindow(window);
        furigoma.showAndWait();

        if (!furigoma.is_sente()){
            banmen.run_ai();
            banmen.finish_ai();
        }

    }

}
