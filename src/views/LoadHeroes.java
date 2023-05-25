package views;


//import controller.LoadHeroesGUI;

import engine.Game;
import exceptions.MovementException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.characters.Character;
import model.characters.Hero;
import model.world.CharacterCell;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class LoadHeroes {
    Scene LoadHeroes;
    BorderPane layoutheroes = new BorderPane();
    GridPane gridHeroesLayOut = new GridPane();
    VBox heroesDetailsPlaceHolder = new VBox();
    TextArea heroesdetails = new TextArea("Hero details:\n");

    StartGame startGameScene = new StartGame()  ;
    duringGame duringGameScene  ;
    private ArrayList<Button> HeroesBtn;

    // ---------------------------Constructor to create Load Heroes Scene-----------------------
    public LoadHeroes() throws IOException {
        //--------------------loading heroes from csv File
        try {
//            Game.loadHeroes("C:\\Users\\Habiba Elguindy\\IdeaProjects\\Game22\\src\\test_heros.csv");
            Game.loadHeroes("C:\\Users\\sahar\\Desktop\\src\\Heros.csv");
            //Game.loadHeroes("C:\\Users\\Dell\\OneDrive\\Desktop\\Eclipse_DATA\\My-Game\\Game22\\src\\views\\Heros.csv");
//            Game.loadHeroes(getClass().getResourceAsStream("Heros.csv")+"");
        } catch (FileNotFoundException e) {
            System.out.println("Not found File");
        }
        //---------------------For text box---------------------------------------
        heroesdetails.setMaxSize(400, 300);
        heroesdetails.setFont(new Font(28));
        heroesdetails.setEditable(false);
        heroesdetails.setTranslateX(-40);
        heroesdetails.setTranslateY(450);
        heroesDetailsPlaceHolder.getChildren().add(heroesdetails);
        heroesdetails.setStyle("-fx-background-color: red; -fx-border-color: black; -fx-border-width: 20px; -fx-border-radius: 5px; -fx-text-fill: black;");
        layoutheroes.setRight(heroesdetails);
        heroesDetailsPlaceHolder.setStyle("-fx-background-color: red;");
        //-----------------------initializing grid-------------------------------------------------------
        addingHeroesBtnsToGrid(Game.availableHeroes);
        //----------------------Creating Scene----------------------------------
        //        Image image = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/red%20wallpaper.jfif");
        Image image = new Image(getClass().getResourceAsStream("red wallpaper.jfif"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layoutheroes.setBackground(new Background(backgroundImage));
        LoadHeroes = new Scene(layoutheroes, 1000, 1000);
    }
    //------------------------------Adding Heroes buttons to grid and set their actions--------------------------------------------------------
    public void addingHeroesBtnsToGrid(ArrayList<Hero> Heroes){
        Image hh0 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero1.jpg");
        Image hh1 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero2.jpg");
        Image hh2 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero3.jpg");
        Image hh3 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero4.jpg");
        Image hh4 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero5.jpg");
        Image hh5 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero6.jpg");
        Image hh6 = new Image("file:///C:/Users/Habiba%20Elguindy/IdeaProjects/Game22/src/views/hero7.jpg");
        ImageView imageView1 = new ImageView(hh0);
        ImageView imageView2 = new ImageView(hh1);
        ImageView imageView3 = new ImageView(hh2);
        ImageView imageView4 = new ImageView(hh3);
        ImageView imageView5 = new ImageView(hh4);
        ImageView imageView6 = new ImageView(hh5);
        ImageView imageView7 = new ImageView(hh6);
        imageView1.setFitWidth(350);
        imageView1.setFitHeight(350);
        imageView2.setFitWidth(350);
        imageView2.setFitHeight(350);
        imageView3.setFitWidth(350);
        imageView3.setFitHeight(350);
        imageView4.setFitWidth(350);
        imageView4.setFitHeight(350);
        imageView5.setFitWidth(350);
        imageView5.setFitHeight(350);
        imageView6.setFitWidth(350);
        imageView6.setFitHeight(350);
        imageView7.setFitWidth(350);
        imageView7.setFitHeight(350);
        gridHeroesLayOut.setPadding(new Insets(10,10,10,10));
        gridHeroesLayOut.setVgap(90);
        gridHeroesLayOut.setHgap(50);
        Button h0 = new Button( Heroes.get(0).getName()) ;
        h0.setFont(new Font(20));
        GridPane.setConstraints(h0,0,0);
        h0.setOnMouseEntered((e)->{
            h0.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            BorderPane.setAlignment(imageView4 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView4, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView4);

            onHeroesDetailsUpdate(Heroes.get(0));});
                h0.setOnMouseExited(event -> h0.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h0.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        h0.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(0).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(0)) ;
//                duringGameScene.setHeroToStart();
//                System.out.println(((CharacterCell)Game.map[0][0]).getCharacter().getName());
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //---------------------------------------------------------------------
        Button h1 = new Button( Heroes.get(1).getName()) ;
        h1.setFont(new Font(20));
        h1.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h1,1,0);
        h1.setOnMouseEntered((e)->{
                    h1.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
                    BorderPane.setAlignment(imageView1 , Pos.BOTTOM_LEFT);
                    BorderPane.setMargin(imageView1, new Insets(12,12,12,12)); // optional
                    layoutheroes.setBottom(imageView1);
            onHeroesDetailsUpdate(Heroes.get(1));
        });
                h1.setOnMouseExited(event -> h1.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));


        ;
        h1.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(1).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(1)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //-------------------------------------------------------------------------

        Button h2 = new Button( Heroes.get(2).getName()) ;
        h2.setFont(new Font(20));
        h2.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h2,2,0);
        h2.setOnMouseEntered((e)->{
            h2.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            BorderPane.setAlignment(imageView2 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView2, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView2);
                    onHeroesDetailsUpdate(Heroes.get(2)) ; });
        h2.setOnMouseExited(event -> h2.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h2.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(2).getName()+ " Clicked");
                duringGameScene = new duringGame(Heroes.get(2)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //--------------------------------------------------------------------------
        Button h3 = new Button( Heroes.get(3).getName()) ;
        h3.setFont(new Font(20));
        h3.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h3,0,1);
        h3.setOnMouseEntered((e)->{
            h3.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            BorderPane.setAlignment(imageView3, Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView3, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView3);
            onHeroesDetailsUpdate(Heroes.get(3));}

        );
        h3.setOnMouseExited(event -> h3.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h3.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(3).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(3)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //-----------------------------------------------------------------------------
        Button h4 = new Button( Heroes.get(4).getName()) ;
        h4.setFont(new Font(20));
        h4.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h4,1,1);
        h4.setOnMouseEntered((e)->{
            h4.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            BorderPane.setAlignment(imageView5 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView5, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView5);
            onHeroesDetailsUpdate(Heroes.get(4));}

        );
        h4.setOnMouseExited(event -> h4.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h4.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(4).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(4)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //----------------------------------------------------------------------------
        Button h5 = new Button( Heroes.get(5).getName()) ;
        h5.setFont(new Font(20));
        h5.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h5,2,1);
        h5.setOnMouseEntered((e)->{
            h5.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            BorderPane.setAlignment(imageView6 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView6 ,new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView6);
            onHeroesDetailsUpdate(Heroes.get(5));}

        );
        h5.setOnMouseExited(event -> h5.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h5.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(5).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(5)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //-----------------------------------------------------------------------------
        Button h6 = new Button( Heroes.get(6).getName()) ;
        h6.setFont(new Font(20));
        h6.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h6,1,2);
        h6.setOnMouseEntered((e)->{
            h6.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");

            BorderPane.setAlignment(imageView7 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView7, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView7);
            onHeroesDetailsUpdate(Heroes.get(6));}

        );
        h6.setOnMouseExited(event -> h6.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h6.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(6).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(6)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }

        } );
        //----------------------------------------------------------------------------
        Button h7 = new Button( Heroes.get(7).getName()) ;
        h7.setFont(new Font(20));
        h7.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
        GridPane.setConstraints(h7,2,2);
        h7.setOnMouseEntered((e)->{
            h7.setStyle("-fx-background-color: yellow; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;");
            BorderPane.setAlignment(imageView2 , Pos.BOTTOM_LEFT);
            BorderPane.setMargin(imageView2, new Insets(12,12,12,12)); // optional
            layoutheroes.setBottom(imageView2);
            onHeroesDetailsUpdate(Heroes.get(7)) ; });
        h7.setOnMouseExited(event -> h7.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 10px; -fx-border-radius: 5px; -fx-text-fill: red;"));

        h7.setOnMouseClicked((e)->{
            try {
                System.out.println(Heroes.get(7).getName() + " Clicked");
                duringGameScene = new duringGame(Heroes.get(7)) ;
                startGameScene.getWindow().setScene(duringGameScene.getDuringGameScene());
            } catch (IOException | MovementException | NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            }
        } );
        //---------------------------------------------------------------
        gridHeroesLayOut.getChildren().addAll(h0,h1,h2,h3,h4,h5,h6 ,h7);
        layoutheroes.setLeft(gridHeroesLayOut);


    }
    //---------------------Text Box Details------------------------------------------------
    public void onHeroesDetailsUpdate(Hero h) {
        addDetails(h.toString());
    }
    public void addDetails(String herosdetails) {
        heroesdetails.setText(herosdetails);
    }
    //------------------------------------------
    public Scene getLoadHeroesScene() {
        return LoadHeroes;
    }
}