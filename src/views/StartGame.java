package views;

//import controller.StartGameGUI;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.security.auth.callback.ConfirmationCallback;
import java.io.IOException;

//import java.awt.*;

public class StartGame extends Application {
    Stage window = new Stage() ;
    Button startGame ;
    LoadHeroes loadHeroes;
    public static void main(String[] args) {
        launch(args);
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window.setTitle("Last Of Us");
//        StartGameGUI start = new StartGameGUI() ;
        //-------------------------------------
        startGame = new Button("Start Game");
       // startGame.setFont(new javafx.scene.text.Font(50));
        startGame.setStyle("-fx-border-color:#000000;-fx-border-width:5px;");
        startGame.setFont(Font.font("Tahoma", FontWeight.BOLD, 70));
        startGame.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        startGame.setAlignment(Pos.BASELINE_LEFT);
        startGame.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        loadHeroes = new LoadHeroes() ;
        // Here want to add the window
        startGame.setOnAction(e-> {
                window.setScene(loadHeroes.getLoadHeroesScene());
        });
        //-------------------------------------
        StackPane stack = new StackPane();
        stack.setAlignment(startGame, Pos.CENTER);
        //stack.getChildren().add(webView);
        stack.getChildren().add(startGame);
//        Image image = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/red%20wallpaper.jfif");
        Image image = new Image(getClass().getResourceAsStream("red wallpaper.jfif"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        stack.setBackground(new Background(backgroundImage));
        window.setOnCloseRequest(e->window.close());
        Scene scene = new Scene(stack,1000,1000);
        window.setScene(scene);
        window.show();
    }


    public Stage getWindow() throws IOException {
        start(window);
        return window;
    }

}
