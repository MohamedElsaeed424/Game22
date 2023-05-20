package views;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class duringGame extends StackPane{
   private Button up;
    private Button down;
    private Button left;
    private Button right;
    private Button attack;
    private Button cure;
    private Button endTurn;
    private Button useSpecial;


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

    public duringGame(){
         up = new Button("up");
         down = new Button("down");
         left = new Button("left");
         right = new Button("right");
         attack = new Button("attack");
         cure = new Button("cure");
         endTurn = new Button("end turn");
         useSpecial = new Button("use special");
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Trap Cell");
        alert.setHeaderText("You have entered a trap cell!");
        alert.setContentText("You lost some of your current HP!!");
        alert.showAndWait();
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
        move.setAlignment(Pos.CENTER);
        HBox takeAction = new HBox(10, attack, cure , endTurn, useSpecial);
        takeAction.setAlignment(Pos.CENTER);

        VBox both = new VBox(20, move, takeAction);
        both.setAlignment(Pos.CENTER);
        both.setPadding(new Insets(20));

        this.getChildren().add(both);





    }



}
