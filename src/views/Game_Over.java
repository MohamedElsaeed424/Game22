package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class Game_Over {

    Scene GameOverScene ;
    StackPane GameOverLayout = new StackPane() ;
    Button closeGame ;
    StartGame s = new StartGame();


    public Game_Over () {
        closeGame = new Button("Close Game") ;
        closeGame.setOnAction(e-> {
            try {
                s.getWindow().close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        GameOverLayout.getChildren().add(closeGame);
        GameOverScene = new Scene(GameOverLayout , 50 ,50);
    }

    public Scene getGameOverScene() {
        return GameOverScene;
    }
}
