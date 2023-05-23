package views;

import java.io.IOException;
import java.util.ArrayList;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.scene.Group;
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
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;

public class duringGame extends StackPane{
    Hero heroToStart ;
    Scene duringGameScene ;
    AlertBoxes alertBoxes = new AlertBoxes();
    StartGame  startScene = new StartGame ();
    Group layout ;

   private Button up;
    private Button down;
    private Button left;
    private Button attack;
    private Button right ;
    private Button cure;
    private Button endTurn;
    private Button useSpecial;

    Hero currentHero ;

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
    public duringGame(Hero heroToStart) throws IOException, MovementException, NotEnoughActionsException {
        System.out.println(heroToStart);
         up = new Button("up");
         up.setOnAction(e-> {
             try {
                 onMoveUpHandler(heroToStart);
             } catch (MovementException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             }
         });
         down = new Button("down");
         down.setOnAction(e-> {
             try {
                 onMoveDownHandler(heroToStart);
             } catch (MovementException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             }
         });
         left = new Button("left");
         left.setOnAction(e-> {
             try {
                 onMoveLeftHandler(heroToStart);
             } catch (MovementException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             }
         });
         right = new Button("right");
        right.setOnAction(e-> {
            try {
                onMoveLeftHandler(heroToStart);
            } catch (MovementException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
         attack = new Button("attack");
         attack.setOnAction(e-> {
             try {
                 onAttackHandler(heroToStart);
             } catch (InvalidTargetException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             }
         });
         cure = new Button("cure");
         cure.setOnAction(e-> {
             try {
                 onCureHandler(heroToStart);
             } catch (Exception ex) {
                 throw new RuntimeException(ex);
             }
         });
         endTurn = new Button("end turn");
         endTurn.setOnAction(e-> {
             try {
                 onEndTurnHandler();
             } catch (InvalidTargetException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             }
         });
         useSpecial = new Button("use special");
         useSpecial.setOnAction(e-> {
             try {
                 onUseSpecialHandler(heroToStart);
             } catch (InvalidTargetException ex) {
                 throw new RuntimeException(ex);
             } catch (NotEnoughActionsException ex) {
                 throw new RuntimeException(ex);
             } catch (NoAvailableResourcesException ex) {
                 throw new RuntimeException(ex);
             }
         });

//        StackPane stack = new StackPane();
//        stack.getChildren().addAll(up , down , left , right , attack , cure , endTurn , useSpecial);
        HBox move = new HBox(10, up, down, right, left);
        move.setAlignment(Pos.BOTTOM_RIGHT);
        HBox takeAction = new HBox(10, attack, cure , endTurn, useSpecial);
        takeAction.setAlignment(Pos.BOTTOM_LEFT);

        HBox both = new HBox(20, move, takeAction);
//        both.setAlignment(Pos.BOTTOM_CENTER);
        both.setPadding(new Insets(20));

        GridPane map = new GridPane();
//        map.setHgap(30);
//        map.setVgap(10);
         layout = new Group();

        Game.startGame(heroToStart);
        for (int i =0 ; i<15 ; i++){
            for (int j =0 ; j<15 ; j++){
                Button empty = new Button( "E");
                empty.setMinWidth(20);
                empty.setMinHeight(10);
                GridPane.setConstraints(empty,i,j);
                map.getChildren().add(empty);
            }
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15;j++){
                Cell cell = Game.map[i][j];
                System.out.println(cell instanceof CharacterCell);
                if(cell instanceof CollectibleCell){
                    if ( ( ((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Vaccine){
                        Button Vaccine = new Button( "V");
                        Vaccine.setStyle("-fx-background-color: blue");
                        Vaccine.setMinWidth(20);
                        Vaccine.setMinHeight(10);
                        GridPane.setConstraints(Vaccine,i,14-j);
                        map.getChildren().add(Vaccine);
                    }else  if ( ( ((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Supply){
                        Button Supply = new Button( "S");
                        Supply.setStyle("-fx-background-color: Yellow");
                        Supply.setMinWidth(20);
                        Supply.setMinHeight(10);
                        GridPane.setConstraints(Supply,i,14-j);
                        map.getChildren().add(Supply);
                    }
                }
                else if(cell instanceof CharacterCell){
                    if ( ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
//                        Button zombie = new Button( "Z "+((Zombie)(Character)((CharacterCell) Game.map[i][j]).getCharacter()).getZombiesCount());
                        Button zombie = new Button( "Z");
                        zombie.setStyle("-fx-background-color: red");
                        zombie.setMinWidth(20);
                        zombie.setMinHeight(10);
                        GridPane.setConstraints(zombie,i,14-j);
                        map.getChildren().add(zombie);
                    }else  if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero){
//                        Button Hero = new Button( ((CharacterCell) Game.map[i][j]).getCharacter().getName());
                        Button Hero = new Button( "H");
                        Hero.setStyle("-fx-background-color: black");
                        Hero.setMinWidth(20);
                        Hero.setMinHeight(10);
                        GridPane.setConstraints(Hero,i,14-j);
                        map.getChildren().add(Hero);
                    }
                }else{
                    Button empty = new Button("E");
                    GridPane.setConstraints(empty,i,j);
                    map.getChildren().add(empty);
                }
            }
        }
        //---------------------AvailableHeroes and Heroes and current Hero Added to the scene-------------------
        VBox availableHeroesBox = new VBox() ;
        ArrayList<Hero> availableHeroes = Game.availableHeroes ;
        for (int i =0 ; i< availableHeroes.size() ; i++) {
            Hero h = availableHeroes.get(i);
            Button availableHeroeBtn = new Button(h.getName());
            availableHeroeBtn.setMinWidth(20);
            availableHeroeBtn.setMinHeight(10);
            availableHeroeBtn.setPrefSize(20 ,50);
            availableHeroesBox.getChildren().add(availableHeroeBtn);
        }
        VBox HeroesBox = new VBox() ;
        ArrayList<Hero> Heroes = Game.heroes ;
        for (int i =0 ; i< Heroes.size() ; i++){
            Hero h= availableHeroes.get(i);
            Button HeroeBtn = new Button(h.getName()) ;
            HeroeBtn.setMinWidth(20);
            HeroeBtn.setMinHeight(10);
            HeroeBtn.setPrefSize(20 ,50);
            HeroesBox.getChildren().add(HeroeBtn);
        }
        VBox currentHeroBox = new VBox();
        Button currentHeroBtn = new Button() ;
        currentHeroBtn.setMinWidth(20);
        currentHeroBtn.setMinHeight(10);
        currentHeroBtn.setPrefSize(20 ,50);
        currentHeroBox.getChildren().add(currentHeroBtn);
        //--------------------------------------------
        availableHeroesBox.setLayoutX(190);
        availableHeroesBox.setLayoutY(150);
        HeroesBox.setLayoutX(400);
        HeroesBox.setLayoutY(900);
        currentHeroBox.setLayoutX(400);
        currentHeroBox.setLayoutY(800);
        VBox allHeroesBoxes = new VBox();
        allHeroesBoxes.getChildren().addAll(currentHeroBox,availableHeroesBox,HeroesBox);
        layout.getChildren().addAll(allHeroesBoxes ,map ,both);
        //-------------------------------------------------------------------------
        allHeroesBoxes.setAlignment(Pos.TOP_RIGHT);
        map.setAlignment(Pos.TOP_CENTER);
        both.setAlignment(Pos.BOTTOM_LEFT);
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
//            h.setTarget();
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

    public void  setHeroToStart (Hero h){
        heroToStart = h ;
    }

    public Hero getHeroToStart(){
        return heroToStart ;
    }
    public Scene getDuringGameScene() {
        return duringGameScene;
    }
}
