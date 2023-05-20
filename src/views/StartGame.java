package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.effect.Shadow;
import javafx.scene.layout.StackPane;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


//import java.awt.*;

public class StartGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("First scene");
        Button button = new Button("Start Game");
        button.setFont(new javafx.scene.text.Font(80));
        button.setStyle("-fx-border-color:#000000;-fx-border-width:5px;");
       // WebView webView = new WebView();
       // WebEngine webEngine = webView.getEngine();
       // webEngine.load("https://media.giphy.com/media/GrJLbDwSeKL8A/giphy.gif");
        StackPane stack = new StackPane();
        //stack.getChildren().add(webView);
        stack.getChildren().add(button);
        Scene scene = new Scene(stack,900,900);
        primaryStage.setScene(scene);
        primaryStage.show();




    }

}
