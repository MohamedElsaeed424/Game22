package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Clock extends Application {
static Label hours = new Label();
static Label minutes = new Label();
 int h = 23;
int m = 24;
static Button timechanger = new Button();
static Label indicator = new Label();
static StackPane clock = new StackPane();
Stage window = new Stage();
 Scene layout;
    public static void main(String[] args) {


        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window.setTitle("Clock");
        hours.setText("Hours");
        hours.setStyle("-fx-font-size: 100px; -fx-font-weight: bold;");
        minutes.setText("Minutes");
        minutes.setStyle("-fx-font-size: 100px; -fx-font-weight: bold;");
        //etRight(minutes);
        Label h1 = new Label("" + h);
        Label m1 = new Label("" + m);
        timechanger.setText("Advance 15 minutes");
        timechanger.setOnAction(event -> {
            m=m+ 15;
            if(m==60){
                m=0;
                 m1.setText("" + m);
                h++;
            }
            if(h==24){

                h=0;
                h1.setText(""+h);
            }
        });
        if (h==0 && m<=0){
            indicator.setText("Morning time:You are safe");
        }
        if(h==23){
            indicator.setText("Night:Beware zombies");
        }
        //clock.setLeft(h1);
        //clock.setRight(m1);
        //clock.setCenter(indicator);
        clock.getChildren().addAll(hours,h1,minutes,m1,timechanger,indicator);

        layout = new Scene(clock,1000,1000);

        window.setScene(layout);
        window.show();

    }
}
