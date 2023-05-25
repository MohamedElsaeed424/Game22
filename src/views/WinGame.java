package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;


public class WinGame {

    Scene WinGameScene ;
    StackPane winLayout = new StackPane() ;
    Button closeGame ;
    StartGame s = new StartGame();
    Text winner = new Text("You Won ! " + "\uD83D\uDE00");
    GridPane grid = new GridPane();


    public WinGame () {
        closeGame = new Button("Close Game") ;
        closeGame.setOnAction(e-> {
            try {
                s.getWindow().close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button closeGame = new Button("Close Game");
        closeGame.setOnAction(event -> System.exit(0));
        closeGame.setStyle("-fx-background-color: black;-fx-font-size: 4em ;-fx-border-color:#000000; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        winner.setStyle("-fx-font-size: 100px; -fx-font-weight: bold; -fx-fill: green;");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(winner);
        borderPane.setStyle("-fx-border-color: green ;-fx-background-color: black; -fx-border-width: 20px; -fx-padding: 20px;");
        HBox close = new HBox();
        close.getChildren().add(closeGame);
        close.setAlignment(Pos.CENTER);
        grid.add(borderPane,5000,2050);
        grid.add(close , 5000,5000);
        grid.setAlignment(Pos.CENTER);
        Image image = new Image(getClass().getResourceAsStream("red wallpaper.jfif"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        grid.setBackground(new Background(backgroundImage));
        WinGameScene = new Scene(grid , 1000 ,1000);

    }





    public Scene getWinGameScene() {
        return WinGameScene;
    }
}
