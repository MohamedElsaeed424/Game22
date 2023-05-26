package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class Game_Over {

    Scene GameOverScene ;
    StackPane GameOverLayout = new StackPane() ;
    Button closeGame ;
    StartGame startGameScene = new StartGame();

    Text loser = new Text("You Lost ! " + "\uD83D\uDE22");
    GridPane grid = new GridPane();


    public Game_Over () throws IOException {
        closeGame = new Button("Close Game") ;
        closeGame.setOnAction(e-> {
            try {
                startGameScene.getWindow().close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        GameOverLayout.getChildren().add(closeGame);
        GameOverScene = new Scene(GameOverLayout , 50 ,50);
        Button closeGame = new Button("Close Game");
        closeGame.setOnAction(event -> System.exit(0));
        closeGame.setStyle("-fx-background-color: black;-fx-font-size: 4em ;-fx-border-color:#000000; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        loser.setStyle("-fx-font-size: 100px; -fx-font-weight: bold; -fx-fill: red;");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(loser);
        borderPane.setStyle("-fx-border-color: red;-fx-background-color: black; -fx-border-width: 20px; -fx-padding: 20px;");
        HBox close = new HBox();
        close.getChildren().add(closeGame);
        close.setAlignment(Pos.CENTER);
        grid.add(borderPane,5000,2050);
        grid.add(close , 5000,5000);
        grid.setAlignment(Pos.CENTER);
        Image image = new Image(getClass().getResourceAsStream("gameover1.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        grid.setBackground(new Background(backgroundImage));
        GameOverScene = new Scene(grid , 1000 ,1000);
    }

    public Scene getGameOverScene() {
        return GameOverScene;
    }
}
