package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class WinGame {

    Scene WinGameScene ;
    StackPane winLayout ;
    Button closeGame ;
    StartGame s = new StartGame();


    public WinGame () {
        closeGame = new Button("Close Game") ;
        closeGame.setOnAction(e-> {
            try {
                s.getWindow().close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        winLayout.getChildren().add(closeGame);
        WinGameScene = new Scene(winLayout , 50 ,50);
    }

    public Scene getWinGameScene() {
        return WinGameScene;
    }
}
