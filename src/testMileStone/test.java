package testMileStone;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import sun.misc.Queue;
import java.util.* ;

public class test extends Application {
   int num1 ;
   int num2 ;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        StackPane view = new StackPane();
        TextArea z = new TextArea(" The Zombie has a health of 7, roll two dice to attack it!");
        Button dice1 = new Button("Roll Die 1");
        Button dice2 = new Button("Roll Die 2");
        Text t1 = new Text();
        Text t2 = new Text();

        view.getChildren().addAll(z, dice1, dice2 ,t1 ,t2);
//        view.setAlignment(Pos.CENTER);
        z.setTranslateX(30);
        z.setTranslateY(30);
        z.setMaxSize(400,100);
        dice1.setTranslateX(30);
        dice1.setTranslateY(100);
        dice2.setTranslateX(100);
        dice2.setTranslateY(100);
        t1.setTranslateX(30);
        t1.setTranslateY(80);
        t2.setTranslateX(100);
        t2.setTranslateY(80);
        dice1.setOnAction(e -> {
            num1 = ((int) (Math.random() * 6 + 1));
            t1.setText("" + num1);
        });
        dice2.setOnAction(e -> {
            num2 = ((int) (Math.random() * 6 + 1));
            t2.setText("" + num2);
            z.setText("Your Total attack was " + (num2 + num1) + " you should have slain the Zombie");
        });

        Scene test = new Scene(view, 500, 500);
        primaryStage.setScene(test);
        primaryStage.show();

//    }

//    @Override
//    public void start(Stage primaryStage) {
//
//        StackPane layout = new StackPane() ;
//        Text t1 = new Text("Hero 1") ;
//        Text t2 = new Text("Hero 2") ;
//        Text t3 = new Text("Hero 3") ;
//        Text t4 = new Text("Hero 4") ;
//
//        Queue<Text> Heroes = new sun.misc.Queue<>()
//        Heroes.enqueue(t1);
//        Heroes.enqueue(t2);
//        Heroes.enqueue(t3);
//        Heroes.enqueue(t4);
//
//        layout.setAlignment(Heroes.remove(), Pos.TOP_CENTER);
//        layout.setAlignment(t2,Pos.CENTER_RIGHT);
//        layout.setAlignment(t3 , Pos.BOTTOM_CENTER);
//        layout.setAlignment(t4 , Pos.CENTER_LEFT);
//
//
//
//        Button rotate = new Button("rotate");
//        rotate.setOnAction((e)->{
//            try {
//                Heroes.enqueue(Heroes.dequeue());
//
//
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        layout.setAlignment(rotate,Pos.CENTER);
//        layout.getChildren().addAll(t1,t2,t3,t4 ,rotate);
//        Scene scene = new Scene(layout , 2000,1000);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//
//
//    }

//        @Override
//    public void start(Stage primaryStage) {
//
//
//
//    }

    }
}
