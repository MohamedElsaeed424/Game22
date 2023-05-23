package views;

import java.io.IOException;
import java.util.ArrayList;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
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
import model.characters.Direction;
import model.characters.Hero;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;

public class duringGame extends StackPane{
    Scene duringGameScene ;
    AlertBoxes alertBoxes = new AlertBoxes();

    BorderPane layout ;
   private Button up;
    private Button down;
    private Button left;
    private Button attack;
    private Button cure;
    private Button endTurn;
    private Button useSpecial;

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
        Button right = new Button("right");
         attack = new Button("attack");
         cure = new Button("cure");
         endTurn = new Button("end turn");
         useSpecial = new Button("use special");

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
        map.setHgap(20);
        map.setVgap(20);
         layout = new BorderPane();

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15;j++){
                if(Game.map[j][i] instanceof CollectibleCell){
                    if ( ( ((CollectibleCell) Game.map[j][i]).getCollectible()) instanceof Vaccine){
                        Button Vaccine = new Button( "V");
                    }else  if ( ( ((CollectibleCell) Game.map[j][i]).getCollectible()) instanceof Supply){
                        Button Supply = new Button( "S");
                    }
                    Button colllectible = new Button("C");
                    GridPane.setConstraints(colllectible,i,j);
                    map.getChildren().add(colllectible);
                }
                else if(Game.map[j][i] instanceof CharacterCell){
                    if ( ((CharacterCell) Game.map[j][i]).getCharacter() instanceof Zombie){
                        Button zombie = new Button( "Z "+((Zombie)(Character)((CharacterCell) Game.map[j][i]).getCharacter()).getZombiesCount());
                    }else  if (((CharacterCell) Game.map[j][i]).getCharacter() instanceof Hero){
                        Button Hero = new Button( ((CharacterCell) Game.map[j][i]).getCharacter().getName());
                    }
                }else{
                    Button cell = new Button("e");
                    GridPane.setConstraints(cell,j,i);
                    map.getChildren().add(cell);}
            }
        }
        map.setAlignment(Pos.TOP_CENTER);
        layout.setCenter(map);
        layout.setRight(both);
        duringGameScene = new Scene(layout, 1000,1000);
    }


        public void onAttackHandler(Character c) throws InvalidTargetException, NotEnoughActionsException {

            try {
            c.attack();
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetAttack();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsAttack();
        }
    }

    public void onCureHandler(Hero h) throws Exception {
        try {
            h.cure();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsCure();
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetCure();
        } catch (NoAvailableResourcesException e) {
            alertBoxes.alretBoxForNoAvailableResourcesCure();
        } catch (Exception e) {
            alertBoxes.alretBoxForNoHeroestobeaddedCure();
        }
    }

    public void onUseSpecialHandler(Hero h) throws InvalidTargetException, NotEnoughActionsException, NoAvailableResourcesException {
        try {
            h.useSpecial();
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetUseSpecial();

        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsUseSpecial();
        } catch (NoAvailableResourcesException e) {
            alertBoxes.alretBoxForNoAvailableResourcesUseSpecial();
        }
    }

    public void onEndTurnHandler() throws InvalidTargetException, NotEnoughActionsException {
        try {
            Game.endTurn();
        } catch (InvalidTargetException e) {

        } catch (NotEnoughActionsException e) {

        }
    }

    public void onMoveUpHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            h.move(Direction.UP);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveDownHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            h.move(Direction.DOWN);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveRightHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            h.move(Direction.RIGHT);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveLeftHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            h.move(Direction.LEFT);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }
    public Scene getDuringGameScene() {
        return duringGameScene;
    }
}
