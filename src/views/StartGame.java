package views;

import controller.StartGameGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.effect.Shadow;
import javafx.scene.layout.StackPane;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


//import java.awt.*;

public class StartGame extends Application {
    Stage window = new Stage() ;

    public static void main(String[] args) {
        launch(args);
    }



    public void setWindow(Stage window) {
        this.window = window;
    }

    @Override
    public void start(Stage primaryStage) {
        window.setTitle("Last Of Us");
        StartGameGUI start = new StartGameGUI() ;
        Button button = start.getStartGameButton() ;
        StackPane stack = new StackPane();
        //stack.getChildren().add(webView);
        stack.getChildren().add(button);
        Scene scene = new Scene(stack,1000,1000);
        window.setScene(scene);
        window.show();
    }

    public Stage getWindow() {
        start(window);
        return window;
    }

}
