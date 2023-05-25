package views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class testloose extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Scene GameOverScene ;
    //StackPane GameOverLayout = new StackPane() ;
    Button closeGame ;
    Text loser = new Text("You Lost ! " + "\uD83D\uDE22");
    GridPane grid = new GridPane();
    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage s = primaryStage ;
        Button closeGame = new Button("Close Game");
        closeGame.setOnAction(event -> System.exit(0));
        closeGame.setStyle("-fx-background-color: black;-fx-font-size: 4em ;-fx-border-color:#000000; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        loser.setStyle("-fx-font-size: 100px; -fx-font-weight: bold; -fx-fill: red;");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(loser);
        borderPane.setStyle("-fx-border-color: red;-fx-background-color: black; -fx-border-width: 20px; -fx-padding: 20px;");
        HBox close = new HBox();
        close.getChildren().addAll(closeGame);
        close.setAlignment(Pos.CENTER);
        Image image = new Image(getClass().getResourceAsStream("youlost.png"));
        Image im = new Image(getClass().getResourceAsStream("zombie.gif"));
        ImageView imageView1 = new ImageView(im);
        imageView1.setFitHeight(500);
        imageView1.setFitWidth(500);
        VBox pic = new VBox();
        pic.getChildren().add(imageView1);
        grid.add(borderPane,5000,2050);
        grid.add(close , 5000,5000);
        grid.add(pic,5000,1000);
        grid.setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        grid.setBackground(new Background(backgroundImage));


        GameOverScene = new Scene(grid , 1000 ,1000);
        s.setScene(GameOverScene);
        s.show();

    }
}
