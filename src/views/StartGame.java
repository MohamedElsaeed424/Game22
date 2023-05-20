package views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.effect.Shadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        button.setFont(new Font(80));
         button.setStyle("-fx-border-color:#000000;-fx-border-width:5px;");
         button.setFont(Font.font("Tahoma", FontWeight.BOLD, 100));
       //  button.setAlignment(Pos.BOTTOM_CENTER);
      //  Text text = new Text("Welcome to The Last of Us!");
        //text.setX(10);
        //text.setY(10);
      //  text.setFont(Font.font("Ariel", FontWeight.EXTRA_BOLD, 60));
        BorderPane border = new BorderPane();
       // text.setTextAlignment(Pos.TOP_RIGHT);
        StackPane stack = new StackPane();
        stack.getChildren().add(button);
       // stack.getChildren().add(text);
      // border.getChildren().add(text);
       //border.getChildren().add(button);
        Scene scene = new Scene(stack,1500,1000);
        //Scene scene1 = new Scene(border,900,900);
        primaryStage.setScene(scene);
       // primaryStage.setScene(scene1);
        primaryStage.show();




    }

}
