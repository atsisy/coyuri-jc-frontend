package core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.Random;

import static config.Values.*;

/**
 * Created by Akihiro on 6/24/2017.
 */
public class FurigomaWindow extends Stage {

    private int tl_count;
    private int hu, tokin;
    private Random random;
    private boolean sente_gote;
    private boolean furigoma_now;

    public FurigomaWindow(Window window){

        sente_gote = furigoma_now = false;

        tl_count = 0;
        hu = tokin = 0;
        random = new Random();

        setTitle("振り駒");
        setWidth(350);
        setHeight(200);
        initStyle(StageStyle.UTILITY);
        initOwner(window);
        initModality(Modality.APPLICATION_MODAL);

        AnchorPane root = new AnchorPane();

        Label furigoma_label = new Label("振り駒をします。開始ボタンを押してください。");
        AnchorPane.setLeftAnchor(furigoma_label, 85.0);
        AnchorPane.setTopAnchor(furigoma_label, 10.0);
        root.getChildren().add(furigoma_label);

        SquareLayer[] layers = new SquareLayer[5];

        for(int i = 0;i < 5;++i){
            layers[i] = new SquareLayer(M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
            layers[i].getGraphicsContext().drawImage(Main.image.getImage(EMPTY), 0, 0, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
            root.getChildren().add(layers[i].getCanvas());
            AnchorPane.setLeftAnchor(layers[i].getCanvas(), 25 + (i * M_SQUARE_WIDTH));
            AnchorPane.setTopAnchor(layers[i].getCanvas(), 40.0);
        }

        Button start = new Button("開始");
        start.setOnAction(event -> {
            if (!furigoma_now) {
                furigoma_now = true;
                Timeline timer = new Timeline(new KeyFrame(Duration.millis(900), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (random.nextBoolean()) {
                            hu++;
                            layers[tl_count].getGraphicsContext().drawImage(Main.image.getImage(HU), 0.0, 0.0, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
                        } else {
                            tokin++;
                            layers[tl_count].getGraphicsContext().drawImage(Main.image.getImage(TOKIN), 0.0, 0.0, M_SQUARE_WIDTH, M_SQUARE_HEIGHT);
                        }
                        tl_count++;
                    }
                }));
                timer.setCycleCount(5);
                timer.play();

                timer.setOnFinished(event1 -> {
                    tl_count = 0;
                    Alert finish_furigoma = new Alert(Alert.AlertType.INFORMATION);
                    finish_furigoma.setTitle("振り駒結果");
                    finish_furigoma.setHeaderText("振り駒の結果");
                    if (hu > tokin) {
                        sente_gote = true;
                        finish_furigoma.setContentText("歩:" + hu + "枚\n" + "と金:" + tokin + "枚\n\n" + "歩の方が多いため、あなたは先手です。");
                    } else {
                        sente_gote = false;
                        finish_furigoma.setContentText("歩:" + hu + "枚\n" + "と金:" + tokin + "枚\n\n" + "と金の方が多いため、あなたは後手です。");
                    }
                    finish_furigoma.show();
                    finish_furigoma.setOnCloseRequest(event2 -> {
                        this.close();
                    });
                });
            }
        });

        AnchorPane.setLeftAnchor(start, 150.0);
        AnchorPane.setTopAnchor(start, 115.0);

        root.getChildren().add(start);

        setScene(new Scene(root));

    }

    public boolean is_sente() {
        return sente_gote;
    }
}
