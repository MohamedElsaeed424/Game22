package views;

import java.io.IOException;
import java.util.ArrayList;

import engine.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.stage.Window;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;
import model.characters.Character;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.world.CharacterCell;
import model.world.CollectibleCell;

public class duringGame extends StackPane{
    Scene duringGameScene ;

    BorderPane layout ;
   private Button up;
    private Button down;
    private Button left;
    private Button right;
    private Button attack;
    private Button cure;
    private Button endTurn;
    private Button useSpecial;
    Stage mapie  = new Stage();
    StartGame  startScene = new StartGame ();
    Scene game;

    public Button getUp() {
        return up;
    }

    public Button getDown() {
        return down;
    }

    public Button getAttack() {
        return attack;
    }

    public Button getCure() {
        return cure;
    }

    public Button getEndTurn() {
        return endTurn;
    }

    public Button getUseSpecial() {
        return useSpecial;
    }
    public duringGame() throws IOException {
         up = new Button("up");
         down = new Button("down");
         left = new Button("left");
         right = new Button("right");
         attack = new Button("attack");
         cure = new Button("cure");
         endTurn = new Button("end turn");
         useSpecial = new Button("use special");
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Trap Cell");
//        alert.setHeaderText("You have entered a trap cell!");
//        alert.setContentText("You lost some of your current HP!!");
//        alert.showAndWait();
        StackPane stack = new StackPane();
        stack.getChildren().add(up);
        stack.getChildren().add(down);
        stack.getChildren().add(left);
        stack.getChildren().add(right);
        stack.getChildren().add(attack);
        stack.getChildren().add(cure);
        stack.getChildren().add(endTurn);
        stack.getChildren().add(useSpecial);
        HBox move = new HBox(10, up, down, right, left);
        move.setAlignment(Pos.BOTTOM_RIGHT);
        HBox takeAction = new HBox(10, attack, cure , endTurn, useSpecial);
        takeAction.setAlignment(Pos.BOTTOM_LEFT);

        VBox both = new VBox(20, move, takeAction);
        both.setAlignment(Pos.BOTTOM_CENTER);
        both.setPadding(new Insets(20));

        this.getChildren().add(both);
        GridPane map = new GridPane();
         layout = new BorderPane();

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15;j++){
                if(Game.map[j][i] instanceof CollectibleCell){
                    Button colllectible = new Button("Collectible");
                    GridPane.setConstraints(colllectible,i,j);
                    map.getChildren().add(colllectible);

                }
                if(Game.map[j][i] instanceof CharacterCell){
                    if ((Character) ((CharacterCell) Game.map[j][i]).getCharacter() instanceof Zombie){
                        Button zombie = new Button("Zombie");
                    }
                }else{
                    Button cell = new Button();
                    GridPane.setConstraints(cell,j,i);
                    map.getChildren().add(cell);}
            }
        }
        map.setAlignment(Pos.CENTER);
        layout.setCenter(map);
        layout.setRight(both);
        duringGameScene = new Scene(layout, 1000,1000);
        mapie.setScene(duringGameScene);
        mapie.show();
    }
    public Scene getDuringGameScene() {
        return duringGameScene;
    }
}
