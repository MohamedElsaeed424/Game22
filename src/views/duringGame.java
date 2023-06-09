package views;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.characters.*;
import model.characters.Character;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import javafx.scene.control.TextArea;
import model.world.TrapCell;


import static engine.Game.zombies;

public class duringGame extends StackPane {
   private static Hero currentHero;
    Scene duringGameScene;
    AlertBoxes alertBoxes = new AlertBoxes();
    StartGame startScene = new StartGame();

    WinGame winGameScene = new WinGame() ;
    Game_Over gameOverscene = new Game_Over();
    Group duringGameLayout;
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
//   private Point heroAsTarget ;

   private Label Name ;
   private Label Type ;
   private Label CurrentHp ;
    private Label ActionsAvailables ;
    private Label AttackDamage ;
    private Label Vaccines ;
    private Label Supplies ;
    private ProgressBar healthBar ;
    private ProgressBar hp ;
    private  ProgressBar dmg ;
    private  ProgressBar actpnts ;
    private VBox infoBox ;
    String davidbutton = getClass().getResource("hero.jpg").toExternalForm();

//    HBox availableHeroesBox = new HBox() ;

    public duringGame(Hero currentHero) throws IOException, MovementException, NotEnoughActionsException {
        System.out.println(currentHero.getName());
//        Image image = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/red%20wallpaper.jfif");
//        Background backgroundImage = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

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
        HBox move1 = new HBox(10, left,down,right);
        HBox move2 = new HBox(10,up);
        move2.setAlignment(Pos.TOP_CENTER);
        move1.setTranslateX(400);
        move1.setTranslateY(-200);
        move2.setTranslateX(400);
        move2.setTranslateY(-200);
        move = new VBox(10,move2,move1);
        move.setLayoutX(-190);
        move.setLayoutY(-100);
//        move.setAlignment(Pos.BOTTOM_LEFT);
//        move.setTranslateY(-100);
        grid.getChildren().add(move);
        HBox takeAction = new HBox(10, attack, cure , endTurn, useSpecial);
        grid.getChildren().add(takeAction);
        grid.setAlignment(Pos.BOTTOM_LEFT);
        // border.setTop(move);
        duringGame.setAlignment(takeAction,Pos.CENTER);

        //HBox both = new HBox(20, move, takeAction);
//        both.setAlignment(Pos.BOTTOM_CENTER);
        //both.setPadding(new Insets(20));

        map = new GridPane();
        //map.getChildren().add(layout);
        // map.setAlignment(Pos.TOP_CENTER);
//        map.setHgap(30);
//        map.setVgap(10);
        duringGameLayout = new Group();
        // layout.setLayoutX(80);
        duringGameLayout.setLayoutY(490);

        String vbutton = getClass().getResource("vaccine.png").toExternalForm();
        String sbutton = getClass().getResource("supply.png").toExternalForm();
        String zbutton = getClass().getResource("zombie.png").toExternalForm();
        String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();


        Game.startGame(currentHero);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Cell cell = Game.map[i][j];
                if (cell instanceof CollectibleCell) {
                    if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Vaccine) {
                        Button Vaccine = new Button();
//                        Vaccine.setOnAction(e -> setInvalidTargetCellAsTarget(Vaccine));
                        duringGameLayout = new Group(Vaccine);
                        Vaccine.setStyle("-fx-background-image: url('" + vbutton + "');");
                        Vaccine.setMinWidth(40);
                        Vaccine.setMinHeight(40);
                        GridPane.setConstraints(Vaccine,  j ,14-i);
                        map.getChildren().add(Vaccine);

                        if(!(i < 2 && j < 2)){
                            Vaccine.setVisible(false);
                        }
                    } else if ((((CollectibleCell) Game.map[i][j]).getCollectible()) instanceof Supply) {
                        Button Supply = new Button();
//                        Supply.setOnAction(e -> setInvalidTargetCellAsTarget(Supply));
                        Supply.setStyle("-fx-background-image: url('" + sbutton + "');");
                        Supply.setMinWidth(40);
                        Supply.setMinHeight(40);
                        GridPane.setConstraints(Supply, j ,14-i);
                        map.getChildren().add(Supply);
                        if(!(i < 2 && j < 2)){
                            Supply.setVisible(false);}
                    }
                } else if (cell instanceof CharacterCell && (((CharacterCell) cell).getCharacter()!=null)) {
                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie) {
//                        Button zombie = new Button( "Z "+((Zombie)(Character)((CharacterCell) Game.map[i][j]).getCharacter()).getZombiesCount());
                        Button zombie = new Button();
//                        Image image = new Image(getClass().getResourceAsStream("z button.jpg"));
//                        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));
//                        Background background = new Background(backgroundImage);
//                        zombie.setBackground(background);

//                        zombie.setOnAction(e -> {
//                            try {
//                                setTarget(zombie);
//                            } catch (IOException ex) {
//                                throw new RuntimeException(ex);
//                            }
//                        });
                        duringGameLayout = new Group(zombie);
                        zombie.setStyle("-fx-background-image: url('" + zbutton + "');");
                        zombie.setMinWidth(40);
                        zombie.setMinHeight(40);
                        GridPane.setConstraints(zombie,   j ,14-i);
                        map.getChildren().add(zombie);
                        if(!(i < 2 && j < 2)){
                            zombie.setVisible(false);}
                    } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
//                        Button Hero = new Button( ((CharacterCell) Game.map[i][j]).getCharacter().getName());
                        Button Hero = new Button();
                        Hero.setStyle("-fx-background-image: url('" + davidbutton + "');");
                        duringGameLayout = new Group(Hero);
                        Hero.setMinWidth(40);
                        Hero.setMinHeight(40);
                        GridPane.setConstraints(Hero,  j ,14-i);
                        map.getChildren().add(Hero);
                        editVisibility(currentHero);
                    }
                } else {
                    Button empty = new Button();
                    empty.setStyle("-fx-background-image: url('" + ebutton + "');");
//                    empty.setOnAction(e -> setInvalidTargetCellAsTarget(empty));
                    duringGameLayout = new Group(empty);
                    empty.setMinWidth(40);
                    empty.setMinHeight(40);
                    GridPane.setConstraints(empty, j ,14-i);
                    map.getChildren().add(empty);
                    if(!(i < 2 && j < 2)){
                        empty.setVisible(false);}
                }
            }
        }
        // set actions on Hero and Zombies btn
        for (int i =0 ; i<15 ; i++){
            for (int j =0 ; j<15 ; j++){
                if (Game.map[i][j] instanceof  CharacterCell){
                    Button currentBtn = (Button)getNodeByRowColumnIndex(i,j,map);
                    (currentBtn).setOnMouseClicked(e->{
                        if (e.getButton() == MouseButton.SECONDARY){ // right click currnet Hero
                            setCurrentHero(currentBtn);
                        }else if (e.getButton() == MouseButton.PRIMARY){ // Left click Target
                            try {
                                setTarget( currentBtn);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                }
            }
        }
        duringGameLayout.setLayoutY(300);
        duringGameLayout.setLayoutX(200);
        //---------------------AvailableHeroes and Heroes and current Hero Added to the scene-------------------
        HBox availableHeroesBox = new HBox() ;
        // move.setTranslateY(500);
        //------------------------------
        //-----------------------------
        map.setLayoutX(-110);
        map.setLayoutY(-280);
        //----------------------------
        //---------------------------
        map.getChildren().add(availableHeroesBox);
        map.setAlignment(Pos.CENTER);
        ArrayList<Hero> availableHeroes = Game.availableHeroes ;
        for (int i =0 ; i< availableHeroes.size() ; i++) {
            Hero h = availableHeroes.get(i);
            Button availableHeroeBtn = new Button(h.getName());
            availableHeroeBtn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            availableHeroeBtn.setMinWidth(90);
            availableHeroeBtn.setMinHeight(40);
            availableHeroeBtn.setPrefSize(20 ,50);
            availableHeroesBox.getChildren().add(availableHeroeBtn);
            availableHeroeBtn.setAlignment(Pos.CENTER);
        }
        availableHeroesBox.setTranslateX(-500);
        availableHeroesBox.setTranslateY(400);
        VBox HeroesBox = new VBox() ;
        ArrayList<Hero> Heroes = Game.heroes ;
        for (int i =0 ; i< Heroes.size() ; i++){
            Hero h= availableHeroes.get(i);
            Button HeroeBtn = new Button(h.getName()) ;
            HeroeBtn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            HeroeBtn.setMinWidth(90);
            HeroeBtn.setMinHeight(40);
            HeroeBtn.setPrefSize(20 ,50);
            HeroesBox.getChildren().add(HeroeBtn);
            HeroeBtn.setAlignment(Pos.CENTER_RIGHT );
        }
        HeroesBox.setTranslateX(800);
        HeroesBox.setTranslateY(700);

        Button currentHeroBtn = new Button("currentHero") ;
        currentHeroBtn.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        VBox currentHeroBox = new VBox(currentHeroBtn);
        // Button currentHeroBtn = new Button() ;
        //duringGameScene = new Scene(currentHeroBox, 100,100);
        // duringGameScene.getRoot().getChildrenUnmodifiable().add(currentHeroBox);
        currentHeroBox.setAlignment(Pos.CENTER);
        currentHeroBtn.setMinWidth(90);
        currentHeroBtn.setMinHeight(40);
        currentHeroBtn.setPrefSize(20 ,50);
        //currentHeroBox.getChildren().add(currentHeroBtn);
        //--------------------------------------------
        availableHeroesBox.setLayoutX(620);
        availableHeroesBox.setLayoutY(-10);
        HeroesBox.setLayoutX(900);
        HeroesBox.setLayoutY(1000);
        currentHeroBox.setLayoutX(480);
        currentHeroBox.setLayoutY(-60);
        VBox allHeroesBoxes = new VBox();
        duringGameScene = new Scene(allHeroesBoxes);
//        allHeroesBoxes.getChildren().addAll(currentHeroBox,availableHeroesBox,HeroesBox);
        allHeroesBoxes.getChildren().addAll(availableHeroesBox,HeroesBox);
        StackPane pic = new StackPane();
        //-------------------------------------------
        //-------------------------------------------
        takeAction.setTranslateX(450);
        takeAction.setTranslateY(340);
        //-------------------------------------------
        //-------------------------------------------
        move.setTranslateX(360);
        move.setTranslateY(520);
        //---------------------------------------
//        //----------------------------------------
        TextArea text = new TextArea("Current Hero");
        text.setEditable(false);
        text.setStyle("-fx-font-weight: bold; -fx-alignment: center;-fx-font-weight: bold;-fx-font-size: 24px;-fx-pref-width: 1px; -fx-pref-height: 2px;-fx-background-color: #DAA520; -fx-text-fill: red;");
        Name = new Label("Name: "+currentHero.getName());
        Type = new Label("Hero Type: "+currentHero.getClass().getSimpleName());
        CurrentHp = new Label("Hero Current Health: "+currentHero.getCurrentHp());
        AttackDamage = new Label("Attack Damage: " + currentHero.getAttackDmg());
        ActionsAvailables = new Label("Actions Available: "+currentHero.getActionsAvailable());
        Vaccines = new Label("Vaccines: "+currentHero.getVaccineInventory().size());
        Supplies = new Label("Supplies: "+currentHero.getSupplyInventory().size());
//        hp = new ProgressBar();
//        hp.setMinWidth(50);
//        hp.setMaxWidth(Double.MAX_VALUE);
//        double progress = currentHero.getCurrentHp() / currentHero.getMaxHp();
//        hp.setProgress(progress);
//
//        dmg = new ProgressBar();
//        dmg.setMinWidth(50);
//        dmg.setMaxWidth(Double.MAX_VALUE);
//        double progress1 = currentHero.getAttackDmg() / currentHero.getCurrentHp();
//        dmg.setProgress(progress1);
//
//        actpnts = new ProgressBar();
//        actpnts.setMinWidth(50);
//        actpnts.setMaxWidth(Double.MAX_VALUE);
//        double progress2 = currentHero.getActionsAvailable() / currentHero.getMaxActions();
//        actpnts.setProgress(progress2);

        infoBox = new VBox(10); // 10 is the spacing between child nodes
        infoBox.getChildren().addAll(Name , Type , CurrentHp , AttackDamage , ActionsAvailables,Vaccines , Supplies);
        HBox all = new HBox(10);
        all.getChildren().addAll(infoBox);
        infoBox.setStyle("-fx-background-color: white ; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: blue;");
        infoBox.setTranslateX(500);
        infoBox.setTranslateY(-230);
        infoBox.setMinWidth(300);
        String grass = getClass().getResource("grass.jpg").toExternalForm();
        Label AvailableHeroes = new Label("Available Heroes");

        AvailableHeroes.setStyle("-fx-font-weight: bold ;-fx-font-size:30 ,-fx-font-color: black");
        AvailableHeroes.setTranslateY(400);
//        AvailableHeroes.setTranslateX(-500);
        duringGameLayout.getChildren().addAll(map,availableHeroesBox,allHeroesBoxes,HeroesBox,move,takeAction,grid,pic,infoBox ,all,AvailableHeroes );

        //-------------------------------------------------------------------------
        allHeroesBoxes.setAlignment(Pos.TOP_RIGHT);
        map.setAlignment(Pos.TOP_CENTER);
//        Image image = new Image(getClass().getResourceAsStream("red wallpaper.jfif"));
////        Image image = new Image(getClass().getResourceAsStream("red.jpg"));
//        BackgroundImage backgroundImage = new BackgroundImage(image,
//                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
//                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//        duringGameLayout.setStyle("-fx-background-image: url('" + grass + "');");
        duringGameScene.getRoot().setStyle("-fx-background-image: url('" + grass + "');");
        duringGameScene = new Scene(duringGameLayout,1000,4000  , Color.DARKRED);

    }

    public void setTarget(Button character) throws IOException {
        int x = GridPane.getRowIndex(character);
        int y = GridPane.getColumnIndex(character);
//        System.out.println("Zombie at "+ x + " " + y);
        target = new Point(14-x, y);
//        System.out.println("So Zombie at "+( 14-x) + " " + y);
//        System.out.println("Target seted to zombie");
        if(Game.checkWin()){
            startScene.getWindow().setScene(winGameScene.getWinGameScene());
        } else if (Game.checkGameOver()) {
            startScene.getWindow().setScene(gameOverscene.getGameOverScene());
        }
    }
    public void setCurrentHero(Button h) {
        int x = 14- GridPane.getRowIndex(h);
        int y = GridPane.getColumnIndex(h);
        System.out.println(x + " " + y);
        try {
           this.currentHero = (Hero)(((CharacterCell) Game.map[x][y]).getCharacter()) ;
            System.out.println("This is Current Hero " + currentHero.getName() );
            up.setOnAction(e-> {
                try {
                    onMoveUpHandler(currentHero);
                } catch (MovementException ex) {
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    throw new RuntimeException(ex);
                }
            });
            down.setOnAction(e-> {
                try {
                    onMoveDownHandler(currentHero);
                } catch (MovementException ex) {
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    throw new RuntimeException(ex);
                }
            });
            right.setOnAction(e-> {
                try {
                    onMoveRightHandler(currentHero);
                } catch (MovementException ex) {
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    throw new RuntimeException(ex);
                }
            });
            left.setOnAction(e-> {
                try {
                    onMoveLeftHandler(currentHero);
                } catch (MovementException ex) {
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    throw new RuntimeException(ex);
                }
            });
            updateDataInInfoBox();
            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            alertBoxes.alertBoxForInvalidHeroSelection();
        }
    }

    public void onAttackHandler(Character c) throws InvalidTargetException, NotEnoughActionsException {
        try {
            if (c instanceof Hero) {
                currentHero = (Hero) c;
                if ((((CharacterCell) Game.map[target.x][target.y]).getCharacter()) instanceof  Zombie){
                currentHero.setTarget((((CharacterCell) Game.map[target.x][target.y]).getCharacter())) ;
                currentHero.attack();
                }
            } else {
                c.attack();
            }
            if ((((CharacterCell) Game.map[(target.x)][target.y]).getCharacter())==null){
                int row  = 14 - target.x ;
                Button newcell = (Button) getNodeByRowColumnIndex(row , target.y , map);
                String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();
                newcell.setStyle("-fx-background-image: url('" + ebutton + "');");
                if(Game.checkWin()){
                    startScene.getWindow().setScene(winGameScene.getWinGameScene());
                } else if (Game.checkGameOver()) {
                    startScene.getWindow().setScene(gameOverscene.getGameOverScene());
                }
            }
            updateDataInInfoBox();
        } catch (InvalidTargetException e) {
            System.out.println(e.getMessage());
            alertBoxes.alertBoxForInvalidTargetAttack();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsAttack();
        }catch (Exception e){
            alertBoxes.alertBoxForNotSelectingTarget();
        }
    }
    public void onCureHandler(Hero h) throws Exception {
        try {
            currentHero = h;
            currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
            currentHero.cure();
            if ((((CharacterCell) Game.map[target.x][target.y]).getCharacter()) instanceof  Hero){
                Button actualTargetBtn = (Button) getNodeByRowColumnIndex(14-target.x  , target.y , map);
                String davidbutton = getClass().getResource("David buton.png").toExternalForm();
                actualTargetBtn.setStyle("-fx-background-image: url('" + davidbutton + "');");
                actualTargetBtn.setOnMouseClicked((e) -> {
                    // right click
                    if (e.getButton() == MouseButton.SECONDARY){
                        setCurrentHero(actualTargetBtn);
                        //left
                    }else if (e.getButton() == MouseButton.PRIMARY){
                        try {
                            setTarget(actualTargetBtn);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                updateDataInInfoBox();
                if(Game.checkWin()){
                    startScene.getWindow().setScene(winGameScene.getWinGameScene());
                } else if (Game.checkGameOver()) {
                    startScene.getWindow().setScene(gameOverscene.getGameOverScene());
                }
            }
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsCure();
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetCure();
        } catch (NoAvailableResourcesException e) {
            alertBoxes.alretBoxForNoAvailableResourcesCure();
        } catch (Exception e) {
            alertBoxes.alertBoxForNotSelectingTarget();
        }
    }
    public void onUseSpecialHandler(Hero h) throws InvalidTargetException, NotEnoughActionsException, NoAvailableResourcesException {
        try {
            currentHero = h;
            if (currentHero instanceof Fighter) {
                currentHero.setTarget(((CharacterCell) Game.map[target.x][target.y]).getCharacter());
            }else if (currentHero instanceof Medic){
                      currentHero.setTarget((((CharacterCell) Game.map[target.x][target.y]).getCharacter()));
            }else{
                setAllMabVisible(currentHero);
            }
            currentHero.useSpecial();
            updateDataInInfoBox();
            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (InvalidTargetException e) {
            alertBoxes.alertBoxForInvalidTargetUseSpecial();
        } catch (NoAvailableResourcesException e) {
            alertBoxes.alretBoxForNoAvailableResourcesUseSpecial();
        }catch (Exception e){
            alertBoxes.alertBoxForNotSelectingTarget();
        }
    }

    public void onEndTurnHandler() throws InvalidTargetException, NotEnoughActionsException {
        try {
            Game.endTurn();
            int x = 14- zombies.get(zombies.size() - 1).getLocation().x;
            int y = zombies.get(zombies.size() - 1).getLocation().y;
            System.out.println("Max Actions "+currentHero.getMaxActions());
            Button newzom = (Button) getNodeByRowColumnIndex(x,y,map);
            newzom.setOnMouseClicked((e) -> {
                // right click
                if (e.getButton() == MouseButton.SECONDARY){
                    setCurrentHero(newzom);
                    //left
                }else if (e.getButton() == MouseButton.PRIMARY){
                    try {
                        setTarget(newzom);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            String zbutton = getClass().getResource("zombie.png").toExternalForm();
            newzom.setStyle("-fx-background-image: url('" + zbutton + "');");
            newzom.setVisible(false);
            updateDataInInfoBox();
            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (InvalidTargetException e) {

        } catch (NotEnoughActionsException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onMoveUpHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero =h ;
            checktrapcell(14-currentHero.getLocation().x-1,currentHero.getLocation().y);
            currentHero.move(Direction.UP);
//                checktrapcell(currentHero.getLocation().x ,currentHero.getLocation().y);
            System.out.println("CurrentHp: "+currentHero.getCurrentHp());
            System.out.println("Actions Available: "+currentHero.getActionsAvailable());
            int x = 14- currentHero.getLocation().x ;
            int y = currentHero.getLocation().y;
            System.out.println((currentHero.getLocation().x)+" "+y);

            int row  = x + 1 ;
            Button heroLastLocation = (Button)getNodeByRowColumnIndex(row ,y,map);
            String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();
            heroLastLocation.setStyle("-fx-background-image: url('" + ebutton + "');");

            Button heroNewLocationBtn = (Button) getNodeByRowColumnIndex(x ,y,map);
            String davidbuton = getClass().getResource("David buton.png").toExternalForm();
            heroNewLocationBtn.setStyle("-fx-background-image: url('" + davidbutton + "');");
            heroNewLocationBtn.setOnAction(e->setCurrentHero(heroNewLocationBtn));

            editVisibility(h);
            System.out.println("Supply: "+currentHero.getSupplyInventory().size());
            System.out.println("Vaccine "+currentHero.getVaccineInventory().size());
            updateDataInInfoBox();

            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        } catch (Exception e){
            alertBoxes.alertBoxForMovementDirection();
//            System.out.println(e.getMessage());
//            alertBoxes.alertBoxForNotSelectingHero();
        }
    }

    public void onMoveDownHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero =h ;
            checktrapcell(14-currentHero.getLocation().x+1,currentHero.getLocation().y);
            currentHero.move(Direction.DOWN);
            System.out.println("CurrentHp: "+currentHero.getCurrentHp());
            System.out.println("Actions Available: "+currentHero.getActionsAvailable());
            int x = 14- currentHero.getLocation().x ;
            int y = currentHero.getLocation().y;
            System.out.println((currentHero.getLocation().x)+" "+y);
            int row  = x - 1 ;
            Button heroLastLocation = (Button)getNodeByRowColumnIndex(row ,y,map);
            String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();
            heroLastLocation.setStyle("-fx-background-image: url('" + ebutton + "');");
            Button heroNewLocationBtn = (Button) getNodeByRowColumnIndex(x ,y,map);
            String davidbuton = getClass().getResource("David buton.png").toExternalForm();
            heroNewLocationBtn.setStyle("-fx-background-image: url('" + davidbutton + "');");
            heroNewLocationBtn.setOnMouseClicked((e) -> {
                // right click
                if (e.getButton() == MouseButton.SECONDARY){
                    setCurrentHero(heroNewLocationBtn);
                    //left
                }else if (e.getButton() == MouseButton.PRIMARY){
                    try {
                        setTarget(heroNewLocationBtn);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            System.out.println("Supply: "+currentHero.getSupplyInventory().size());
            System.out.println("Vaccine "+currentHero.getVaccineInventory().size());
            editVisibility(h);
            updateDataInInfoBox();

            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
        catch (Exception e){
            alertBoxes.alertBoxForMovementDirection();
//            System.out.println(e.getMessage());
//            alertBoxes.alertBoxForNotSelectingHero();
        }
    }

    public void onMoveRightHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero =h ;
            checktrapcell(14-currentHero.getLocation().x,currentHero.getLocation().y+1);
            currentHero.move(Direction.RIGHT);
//            checktrapcell(currentHero.getLocation().x ,currentHero.getLocation().y);
            System.out.println("CurrentHp: "+currentHero.getCurrentHp());
            System.out.println("Actions Available: "+currentHero.getActionsAvailable());
            int x = 14- currentHero.getLocation().x ;
            int y = currentHero.getLocation().y;
            System.out.println((currentHero.getLocation().x)+" "+y);

            int coloum  = y - 1 ;
            Button heroLastLocation = (Button)getNodeByRowColumnIndex(x ,coloum,map);
            String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();
            heroLastLocation.setStyle("-fx-background-image: url('" + ebutton + "');");

            Button heroNewLocationBtn = (Button) getNodeByRowColumnIndex(x ,y,map);
            String davidbuton = getClass().getResource("David buton.png").toExternalForm();
            heroNewLocationBtn.setStyle("-fx-background-image: url('" + davidbutton + "');");
            heroNewLocationBtn.setOnMouseClicked((e) -> {
                // right click
                if (e.getButton() == MouseButton.SECONDARY){
                    setCurrentHero(heroNewLocationBtn);
                    //left
                }else if (e.getButton() == MouseButton.PRIMARY){
                    try {
                        setTarget(heroNewLocationBtn);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            System.out.println("Supply: "+currentHero.getSupplyInventory().size());
            System.out.println("Vaccine "+currentHero.getVaccineInventory().size());
            editVisibility(h);
            updateDataInInfoBox();

            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
        catch (Exception e){
            alertBoxes.alertBoxForMovementDirection();
//            System.out.println(e.getMessage());
//            alertBoxes.alertBoxForNotSelectingHero();
        }
    }

    public void onMoveLeftHandler(Hero h) throws MovementException, NotEnoughActionsException {
        try {
            currentHero =h ;
            checktrapcell(14-currentHero.getLocation().x,currentHero.getLocation().y-1);
            currentHero.move(Direction.LEFT);
//            checktrapcell(currentHero.getLocation().x ,currentHero.getLocation().y);
            System.out.println("CurrentHp: "+currentHero.getCurrentHp());
            System.out.println("Actions Available: "+currentHero.getActionsAvailable());
            int x = 14- currentHero.getLocation().x ;
            int y = currentHero.getLocation().y;
            System.out.println((currentHero.getLocation().x)+" "+y);

            int coloum  = y + 1 ;
            Button heroLastLocation = (Button)getNodeByRowColumnIndex(x ,coloum,map);
            String ebutton = getClass().getResource("emptyy.jpg").toExternalForm();
            heroLastLocation.setStyle("-fx-background-image: url('" + ebutton + "');");
            Button heroNewLocationBtn = (Button) getNodeByRowColumnIndex(x ,y,map);
//            String davidbuton = getClass().getResource("David buton.png").toExternalForm();
            heroNewLocationBtn.setStyle("-fx-background-image: url('" + davidbutton + "');");
            heroNewLocationBtn.setOnMouseClicked((e) -> {
                // right click
                if (e.getButton() == MouseButton.SECONDARY){
                    setCurrentHero(heroNewLocationBtn);
                    //left
                }else if (e.getButton() == MouseButton.PRIMARY){
                    try {
                        setTarget(heroNewLocationBtn);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            System.out.println("Supply: "+currentHero.getSupplyInventory().size());
            System.out.println("Vaccine "+currentHero.getVaccineInventory().size());
            editVisibility(h);
            updateDataInInfoBox();

            if(Game.checkWin()){
                startScene.getWindow().setScene(winGameScene.getWinGameScene());
            } else if (Game.checkGameOver()) {
                startScene.getWindow().setScene(gameOverscene.getGameOverScene());
            }
        } catch (MovementException e) {
            alertBoxes.alertBoxForMovementDirection();
        } catch (NotEnoughActionsException e) {
            alertBoxes.alertBoxForNotEnougthActionsForMovement();
        }
        catch (Exception e){
            alertBoxes.alertBoxForMovementDirection();
//            System.out.println(e.getMessage());
//            alertBoxes.alertBoxForNotSelectingHero();
        }
    }

    public void editVisibility(Hero h){
        Point p = h.getLocation();
        for (int i = -1; i <= 1; i++) {
            int cx = 14 - p.x + i;
            if (cx >= 0 && cx <= 14) {
                for (int j = -1; j <= 1; j++) {
                    int cy = p.y + j;
                    if (cy >= 0 && cy <= 14) {
                        if (cy >= 0 && cy <= map.getWidth() - 1) {
                            Button updated = (Button)getNodeByRowColumnIndex(cx,cy,map);
                            updated.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    public void setAllMabVisible(Hero h){
        for (int i =0 ; i<15 ; i++){
            for (int j = 0 ; j<15 ; j++){
                Button updated = (Button)getNodeByRowColumnIndex(i,j,map);
                updated.setVisible(true);
            }
        }
    }

    public void checktrapcell(int x, int y){
        System.out.println(x);
        System.out.println(y);
        System.out.println(Game.map[14-x][y]);
        System.out.println(Game.map[x][y] instanceof TrapCell);
        if (Game.map[14-x][y] instanceof TrapCell){
            alertBoxes.alertBoxForEnteringTrapCell();
        }
    }
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    public void updateDataInInfoBox(){
        Name.setText("Name: "+currentHero.getName());
        Type.setText("Hero Type: "+currentHero.getClass().getSimpleName());
        CurrentHp .setText("Hero Current Health: "+currentHero.getCurrentHp());
        AttackDamage .setText("Attack Damage: " + currentHero.getAttackDmg());
        ActionsAvailables .setText("Actions Available: "+currentHero.getActionsAvailable());
        Vaccines .setText("Vaccines: "+currentHero.getVaccineInventory().size());
        Supplies .setText("Supplies: "+currentHero.getSupplyInventory().size());
        infoBox.layout();
//        hp.setProgress(currentHero.getCurrentHp() / currentHero.getMaxHp());
    }

    public void updateHeroesLists (){

    }
    public Hero getCurrentHero() {
        return currentHero;
    }

    public Scene getDuringGameScene() {
        return duringGameScene;
    }


}