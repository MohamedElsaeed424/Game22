// iadded target
package views;

import java.awt.*;
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
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class duringGame extends StackPane {
    Hero currentHero;
    Scene duringGameScene;
    AlertBoxes alertBoxes = new AlertBoxes();
    StartGame startScene = new StartGame();
    Group layout;
    GridPane grid = new GridPane();
    BorderPane border = new BorderPane();
    VBox move = new VBox();


    private Button up;
    private Button down;
    private Button left;
    private Button attack;
    private Button right;
    private Button cure;
    private Button endTurn;
    private Button useSpecial;
    private GridPane map ;

   private Point target;



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

    public duringGame(Hero currentHero) throws IOException, MovementException, NotEnoughActionsException {
        System.out.println(currentHero);
        Image image = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/red%20wallpaper.jfif");
        Background backgroundImage = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

        // duringGameScene.getRoot().setBackground(backgroundImage);

        up = new Button("\u2191");
        up.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

        up.setOnAction(e -> {
            up.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onMoveUpHandler(currentHero);
            } catch (MovementException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        up.setOnMouseReleased(event -> {
            up.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        down = new Button("\u2193");
        down.setAlignment(Pos.CENTER_RIGHT);
        down.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        down.setOnAction(e -> {
            down.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            try {
                onMoveDownHandler(currentHero);
            } catch (MovementException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        down.setOnMouseReleased(event -> {
            down.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        left = new Button("\u2190");
        left.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        left.setOnAction(e -> {
            left.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onMoveLeftHandler(currentHero);
            } catch (MovementException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        left.setOnMouseReleased(event -> {
            left.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        right = new Button("\u2192");
        right.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        right.setOnAction(e -> {
            right.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onMoveRightHandler(currentHero);
            } catch (MovementException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        right.setOnMouseReleased(event -> {
            right.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        ;
        attack = new Button("attack");
        attack.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

        attack.setOnAction(e -> {
            attack.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onAttackHandler(currentHero);
            } catch (InvalidTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        attack.setOnMouseReleased(event -> {
            attack.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        cure = new Button("cure");
        cure.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

        cure.setOnAction(e -> {
            cure.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onCureHandler(currentHero);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        cure.setOnMouseReleased(event -> {
            cure.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        endTurn = new Button("end turn");
        endTurn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

        endTurn.setOnAction(e -> {
            endTurn.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onEndTurnHandler();
            } catch (InvalidTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        });
        endTurn.setOnMouseReleased(event -> {
            endTurn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });
        useSpecial = new Button("use special");
        useSpecial.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

        useSpecial.setOnAction(e -> {
            useSpecial.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            try {
                onUseSpecialHandler(currentHero);
            } catch (InvalidTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            } catch (NoAvailableResourcesException ex) {
                throw new RuntimeException(ex);
            }
        });
        useSpecial.setOnMouseReleased(event -> {
            useSpecial.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        });

//        StackPane stack = new StackPane();
//        stack.getChildren().addAll(up , down , left , right , attack , cure , endTurn , useSpecial);
        HBox move1 = new HBox(10, left, down, right);
        HBox move2 = new HBox(10, up);
        move2.setAlignment(Pos.CENTER);
        move = new VBox(10, move2, move1);
        move.setAlignment(Pos.BASELINE_RIGHT);
//        move.setTranslateY(-100);
        grid.getChildren().add(move);
        HBox takeAction = new HBox(10, attack, cure, endTurn, useSpecial);
//        takeAction.setTranslateY(-1011);
        grid.getChildren().add(takeAction);
        grid.setTranslateY(-200);
        grid.setAlignment(Pos.CENTER);
        // border.setTop(move);
        duringGame.setAlignment(takeAction, Pos.CENTER);

        //HBox both = new HBox(20, move, takeAction);
//        both.setAlignment(Pos.BOTTOM_CENTER);
        //both.setPadding(new Insets(20));

         map = new GridPane();
        //map.getChildren().add(layout);
        // map.setAlignment(Pos.TOP_CENTER);
//        map.setHgap(30);
//        map.setVgap(10);
        layout = new Group();
        // layout.setLayoutX(80);
        layout.setLayoutY(490);

        Game.startGame(currentHero);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Button empty = new Button("E");
                layout = new Group(empty);
                layout.setLayoutY(490);
                empty.setMinWidth(40);
                empty.setMinHeight(20);
                GridPane.setConstraints(empty, i, j);
                map.getChildren().add(empty);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Cell cell = Game.map[i][j];
                System.out.println(cell instanceof CharacterCell);
                if (cell instanceof CollectibleCell) {
                    if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Vaccine) {
                        Button Vaccine = new Button("V");
                        Vaccine.setOnAction(e -> setInvalidTargetCellAsTarget(Vaccine));
                        layout = new Group(Vaccine);
                        Vaccine.setStyle("-fx-background-color: blue");
                        Vaccine.setMinWidth(40);
                        Vaccine.setMinHeight(20);
                        GridPane.setConstraints(Vaccine, i, 14 - j);
                        map.getChildren().add(Vaccine);
                    } else if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Supply) {
                        Button Supply = new Button("S");
                        Supply.setOnAction(e -> setInvalidTargetCellAsTarget(Supply));
                        layout = new Group(Supply);
                        Supply.setStyle("-fx-background-color: Yellow");
                        Supply.setMinWidth(40);
                        Supply.setMinHeight(20);
                        GridPane.setConstraints(Supply, i, 14 - j);
                        map.getChildren().add(Supply);
                    }
                } else if (cell instanceof CharacterCell) {
                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie) {
//                        Button zombie = new Button( "Z "+((Zombie)(Character)((CharacterCell) Game.map[i][j]).getCharacter()).getZombiesCount());
                        Button zombie = new Button("Z");
                        zombie.setOnAction(e -> setZombieAsTarget(zombie));
                        layout = new Group(zombie);
                        zombie.setStyle("-fx-background-color: red");
                        zombie.setMinWidth(40);
                        zombie.setMinHeight(20);
                        GridPane.setConstraints(zombie, i, 14 - j);
                        map.getChildren().add(zombie);
                    } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
//                        Button Hero = new Button( ((CharacterCell) Game.map[i][j]).getCharacter().getName());
                        Button Hero = new Button("H");
                        Hero.setOnAction((e) -> {
                            setCurrentHero(Hero);
                            setHeroAsTarget(Hero);
                        });
                        layout = new Group(Hero);
                        Hero.setStyle("-fx-background-color: black");
                        Hero.setMinWidth(40);
                        Hero.setMinHeight(20);
                        GridPane.setConstraints(Hero, i, 14 - j);
                        map.getChildren().add(Hero);
                    }
                } else {
                    Button empty = new Button("E");
                    empty.setOnAction(e -> setInvalidTargetCellAsTarget(empty));
                    layout = new Group(empty);
                    GridPane.setConstraints(empty, i, j);
                    map.getChildren().add(empty);
                }
            }
        }
        layout.setLayoutY(300);
        layout.setLayoutX(200);
        //layout.getChildren().removeAll(move,takeAction);
        //---------------------AvailableHeroes and Heroes and current Hero Added to the scene-------------------
        VBox availableHeroesBox = new VBox();
        map.getChildren().add(availableHeroesBox);
        map.setAlignment(Pos.CENTER);
        ArrayList<Hero> availableHeroes = Game.availableHeroes;
        for (int i = 0; i < availableHeroes.size(); i++) {
            Hero h = availableHeroes.get(i);
            Button availableHeroeBtn = new Button(h.getName());
            availableHeroeBtn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            availableHeroeBtn.setMinWidth(90);
            availableHeroeBtn.setMinHeight(40);
            availableHeroeBtn.setPrefSize(20, 50);
            availableHeroesBox.getChildren().add(availableHeroeBtn);
            availableHeroesBox.setLayoutY(800);
            availableHeroeBtn.setAlignment(Pos.CENTER);
            availableHeroesBox.setLayoutX(550);
        }
        VBox HeroesBox = new VBox();
        ArrayList<Hero> Heroes = Game.heroes;
        for (int i = 0; i < Heroes.size(); i++) {
            Hero h = availableHeroes.get(i);
            Button HeroeBtn = new Button(h.getName());
            HeroeBtn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            HeroeBtn.setMinWidth(90);
            HeroeBtn.setMinHeight(40);
            HeroeBtn.setPrefSize(20, 50);
            HeroesBox.getChildren().add(HeroeBtn);
            HeroesBox.setLayoutY(800);
            HeroesBox.setLayoutY(700);
            HeroeBtn.setAlignment(Pos.CENTER_RIGHT);
        }
        Button currentHeroBtn = new Button();
        VBox currentHeroBox = new VBox(currentHeroBtn);
        // Button currentHeroBtn = new Button() ;
        //duringGameScene = new Scene(currentHeroBox, 100,100);
        // duringGameScene.getRoot().getChildrenUnmodifiable().add(currentHeroBox);
        currentHeroBox.setAlignment(Pos.CENTER);
        currentHeroBtn.setMinWidth(90);
        currentHeroBtn.setMinHeight(40);
        currentHeroBtn.setPrefSize(20, 50);
        // currentHeroBox.getChildren().add(currentHeroBtn);
        //--------------------------------------------
        availableHeroesBox.setLayoutX(800);
        availableHeroesBox.setLayoutY(500);
        HeroesBox.setLayoutX(400);
        HeroesBox.setLayoutY(900);
        currentHeroBox.setLayoutX(400);
        currentHeroBox.setLayoutY(800);
        VBox allHeroesBoxes = new VBox();
        duringGameScene = new Scene(allHeroesBoxes);
        allHeroesBoxes.getChildren().addAll(currentHeroBox, availableHeroesBox, HeroesBox);
        StackPane pic = new StackPane();
        pic.setBackground(backgroundImage);
        layout.getChildren().addAll(map, availableHeroesBox, currentHeroBox, HeroesBox, move, takeAction);
        takeAction.setTranslateX(400);
        takeAction.setTranslateY(-200);
        move.setTranslateX(400);
        move.setTranslateY(500);
//        allHeroesBoxes.setTranslateX(-100);
        availableHeroesBox.setTranslateX(99);
        HeroesBox.setTranslateX(100);
        currentHeroBox.setTranslateX(101);
        //-------------------------------------------------------------------------
        allHeroesBoxes.setAlignment(Pos.TOP_RIGHT);
        map.setAlignment(Pos.TOP_CENTER);
        //both.setAlignment(Pos.BOTTOM_LEFT);
        duringGameScene.getRoot().setStyle("-fx-background-image: url('" + "file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/red%20wallpaper.jfif" + "'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: no-repeat;");
        duringGameScene = new Scene(layout, 1000, 1000);
        // duringGameScene= new Scene(allHeroesBoxes);

    }

    public void setZombieAsTarget(Button zombie) {
        int x = GridPane.getRowIndex(zombie);
        int y = GridPane.getColumnIndex(zombie);
        target = new Point(x, y);
        currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
    }

    public void setHeroAsTarget(Button Hero) {
        int x = GridPane.getRowIndex(Hero);
        int y = GridPane.getColumnIndex(Hero);
        target = new Point(x, y);
        currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
    }

    public void setInvalidTargetCellAsTarget(Button invalidTarget) {
        int x = GridPane.getRowIndex(invalidTarget);
        int y = GridPane.getColumnIndex(invalidTarget);
        target = new Point(x, y);
        alertBoxes.alertBoxForInvalidToSetTarget();
    }

    public void onAttackHandler(Character c) throws InvalidTargetException, NotEnoughActionsException {
        try {
            if (c instanceof Hero) {
                currentHero = (Hero) c;
                currentHero.attack();
            } else {
                c.attack();
            }
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetAttack();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsAttack();
        }
    }

    public void onCureHandler(Hero h) throws Exception {
        try {
            currentHero = h;
            currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
            currentHero.cure();
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
            currentHero = h;
            currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
            currentHero.useSpecial();
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
            currentHero = h;
            Button heroNewLocationBtn = new Button("H");
            heroNewLocationBtn.setStyle("-fx-background-color: black");
            Point heroCurrentLocation = h.getLocation() ;
            GridPane.setConstraints( heroNewLocationBtn,heroCurrentLocation.x+1 , heroCurrentLocation.y);
            Button heroLastLocation = new Button("H");
            GridPane.setConstraints( heroLastLocation,heroCurrentLocation.x , heroCurrentLocation.y);
            map.getChildren().add(heroLastLocation);
            currentHero.move(Direction.UP);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveDownHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero = h;
            Button heroNewLocationBtn = new Button("H");
            heroNewLocationBtn.setStyle("-fx-background-color: black");
            Point heroCurrentLocation = h.getLocation() ;
            GridPane.setConstraints( heroNewLocationBtn,heroCurrentLocation.x-1 , heroCurrentLocation.y);
            Button heroLastLocation = new Button("H");
            GridPane.setConstraints( heroLastLocation,heroCurrentLocation.x , heroCurrentLocation.y);
            map.getChildren().add(heroLastLocation);
            currentHero.move(Direction.DOWN);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveRightHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero = h;
            Button heroNewLocationBtn = new Button("H");
            heroNewLocationBtn.setStyle("-fx-background-color: black");
            Point heroCurrentLocation = h.getLocation() ;
            GridPane.setConstraints( heroNewLocationBtn,heroCurrentLocation.x, heroCurrentLocation.y+1);
            Button heroLastLocation = new Button("H");
            GridPane.setConstraints( heroLastLocation,heroCurrentLocation.x , heroCurrentLocation.y);
            map.getChildren().add(heroLastLocation);
            currentHero.move(Direction.RIGHT);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }

    public void onMoveLeftHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero = h;
            Button heroNewLocationBtn = new Button("H");
            heroNewLocationBtn.setStyle("-fx-background-color: black");
            Point heroCurrentLocation = h.getLocation() ;
            GridPane.setConstraints( heroNewLocationBtn,heroCurrentLocation.x , heroCurrentLocation.y-1);
            Button heroLastLocation = new Button("H");
            GridPane.setConstraints( heroLastLocation,heroCurrentLocation.x , heroCurrentLocation.y);
            map.getChildren().add(heroLastLocation);
            currentHero.move(Direction.LEFT);
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
    }


    public void setCurrentHero(Button h) {
        int x = GridPane.getRowIndex(h);
        int y = GridPane.getColumnIndex(h);
        try {
            currentHero = (Hero) (((CharacterCell) Game.map[x][y]).getCharacter());
        } catch (Exception e) {
            alertBoxes.alertBoxForInvalidHeroSelection();
        }
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public Scene getDuringGameScene() {
        return duringGameScene;
    }


}