package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.ArrayList;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Main extends Application {

    public static final Images image = new Images();
    static Label evalue_label = new Label("評価値 : -");
    static ArrayList<BanmenData> banmen_history = new ArrayList<>();
    static final Label cols_numbers = new Label("" +
            "9               " +
            "8               " +
            "7               " +
            "6               " +
            "5               " +
            "4               " +
            "3               " +
            "2               " +
            "1");

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
        AnchorPane.setRightAnchor(run_ai_button, 100.0);
        AnchorPane.setTopAnchor(run_ai_button, WINDOW_HEIGHT / 1.5);
        root.getChildren().add(run_ai_button);
        run_ai_button.setMinWidth(100);
        run_ai_button.setMinHeight(100);


        Button matta_button = new Button("待った");
        matta_button.setFont(new Font("ゆたぽん（コーディング）Bold", 15));
        matta_button.setOnAction(event -> {
            System.out.println(banmen_history.size());
            if (banmen_history.size() > 1) {
                if(banmen.is_ready_to_ai()){
                    banmen.restore(banmen_history.get(banmen_history.size() - 2));
                    banmen.simple_redraw();
                    banmen_history.remove(banmen_history.size() - 1);
                }else {
                    if (banmen_history.size() > 2) {
                        banmen.restore(banmen_history.get(banmen_history.size() - 3));
                        banmen.simple_redraw();
                        banmen_history.remove(banmen_history.size() - 1);
                        banmen_history.remove(banmen_history.size() - 2);
                    }
                }
            }
        });
        AnchorPane.setRightAnchor(matta_button, 100.0);
        AnchorPane.setTopAnchor(matta_button, WINDOW_HEIGHT / 2);
        root.getChildren().add(matta_button);
        matta_button.setMinWidth(100);
        matta_button.setMinHeight(100);

        root.getChildren().add(cols_numbers);
        AnchorPane.setLeftAnchor(cols_numbers, LEFT_FROM_BANMEM + (M_SQUARE_WIDTH / 2));
        AnchorPane.setTopAnchor(cols_numbers, TOP_FROM_BANMEN - 20);


        AnchorPane.setLeftAnchor(evalue_label, 90.0);
        AnchorPane.setTopAnchor(evalue_label, WINDOW_HEIGHT / 2);
        evalue_label.setFont(new Font(30));
        root.getChildren().add(evalue_label);

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
