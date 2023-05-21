package views;


//import controller.LoadHeroesGUI;

import engine.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.characters.Character;
import model.characters.Hero;

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
    private ArrayList<Button> HeroesBtn;

    // ---------------------------Constructor to create Load Heroes Scene-----------------------
    public LoadHeroes() throws IOException {
        //--------------------loading heroes from csv File
        try {
            Game.loadHeroes("C:\\Users\\Habiba Elguindy\\IdeaProjects\\Game22\\src\\test_heros.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Not found File");
        }
        //---------------------For text box---------------------------------------
        heroesdetails.setMaxSize(350, 250);
        heroesdetails.setFont(new Font(28));
        heroesdetails.setEditable(false);
        heroesdetails.setTranslateX(-320);
        heroesdetails.setTranslateY(700);
        heroesDetailsPlaceHolder.getChildren().add(heroesdetails);
        layoutheroes.setRight(heroesdetails);
//        layoutheroes.getChildren().add(heroesdetails);
        //-----------------------initializing grid-------------------------------------------------------
//        for (int i = 0; i < 7; i++) {
//            RowConstraints row = new RowConstraints();
//            row.setPercentHeight(50);
//            gridHeroesLayOut.getRowConstraints().add(row);
//            if (i < 3) {
//                ColumnConstraints coloum = new ColumnConstraints();
//                coloum.setPercentWidth(50);
//                gridHeroesLayOut.getColumnConstraints().add(coloum);
//            }
//        }
//        handelAddingHeroesBtns(Game.availableHeroes);
//        layoutheroes.setLeft(gridHeroesLayOut);
//        gridHeroesLayOut.setVisible(true);
        addingHeroesBtnsToGrid(Game.availableHeroes);
        //----------------------Creating Scene----------------------------------
//        LoadHeroes = new Scene(gridHeroesLayOut, 1000, 1000);
        LoadHeroes = new Scene(layoutheroes, 1000, 1000);
    }

    //------------------------------Adding Heroes buttons to grid and set their actions--------------------------------------------------------
    public void addingHeroesBtnsToGrid(ArrayList<Hero> Heroes){
        gridHeroesLayOut.setPadding(new Insets(10,10,10,10));
        gridHeroesLayOut.setVgap(120);
        gridHeroesLayOut.setHgap(90);
        Button h0 = new Button( Heroes.get(0).getName()) ;
        h0.setFont(new Font(60));
        GridPane.setConstraints(h0,0,0);
        h0.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(0)));
        h0.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h1 = new Button( Heroes.get(1).getName()) ;
        h1.setFont(new Font(60));
        GridPane.setConstraints(h1,1,0);
//        h1.setOnAction(e -> HeroesBtnHandler(e, h1 ,1));
        h1.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(1)));
        h1.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h2 = new Button( Heroes.get(2).getName()) ;
        h2.setFont(new Font(60));
        GridPane.setConstraints(h2,2,0);
//        h2.setOnAction(e -> HeroesBtnHandler(e, h2,2));
        h2.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(2)));
        h2.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h3 = new Button( Heroes.get(3).getName()) ;
        h3.setFont(new Font(60));
        GridPane.setConstraints(h3,0,1);
//        h3.setOnAction(e -> HeroesBtnHandler(e, h3,3));
        h3.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(3)));
        h3.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h4 = new Button( Heroes.get(4).getName()) ;
        h4.setFont(new Font(60));
        GridPane.setConstraints(h4,1,1);
//        h4.setOnAction(e -> HeroesBtnHandler(e, h4,4));
        h4.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(4)));
        h4.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h5 = new Button( Heroes.get(5).getName()) ;
        h5.setFont(new Font(60));
        GridPane.setConstraints(h5,2,1);
//        h5.setOnAction(e -> HeroesBtnHandler(e, h5,5));
        h5.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(5)));
        h5.setOnMouseClicked(e-> System.out.println("hello click"));
        Button h6 = new Button( Heroes.get(6).getName()) ;
        h6.setFont(new Font(60));
        GridPane.setConstraints(h6,1,2);
//        h6.setOnAction(e -> HeroesBtnHandler(e, h6,6));
        h6.setOnMouseEntered(e-> onHeroesDetailsUpdate(Heroes.get(6)));
        h6.setOnMouseClicked(e-> System.out.println("hello click"));
        gridHeroesLayOut.getChildren().addAll(h0,h1,h2,h3,h4,h5,h6);
        layoutheroes.setLeft(gridHeroesLayOut);
    }
//    public void handelAddingHeroesBtns(ArrayList<Hero> Heroes) throws IOException {
//        HeroesBtn = new ArrayList<>();
//        int sizeOfHeroes = Heroes.size();
//        for (int i = 0; i < sizeOfHeroes; i++) {
//            Hero h = Heroes.get(i);
//
//            Button heroeBtn = new Button();
//            heroeBtn.setText(i + " " + h.getName());
//
//            // test print
//            System.out.println(heroeBtn.getText());
//            // set up actions for each btn
//            heroeBtn.setOnAction(e -> HeroesBtnHandler(e));
//            // addHeroesToGrid Function takes btn and column
//            addHeroesToGrid(heroeBtn, i);
//            HeroesBtn.add(heroeBtn);
//        }
//    }
//    public void addHeroesToGrid(Button hero, int i) {
//        if (i <= 2) {
//            gridHeroesLayOut.add(hero, i, 0);
//            System.out.println(gridHeroesLayOut.getColumnIndex(hero)+" hello iam here in first row");
//        } else if (i <= 5) {
//            gridHeroesLayOut.add(hero, i - 3, 1);
//            System.out.println(gridHeroesLayOut.getColumnIndex(hero)+" hello iam here in secound row");
//        } else {
//            gridHeroesLayOut.add(hero, 0, 2);
//            System.out.println(gridHeroesLayOut.getColumnIndex(hero)+" hello iam here in  third row ");
//        }
//        layoutheroes.getChildren().add(hero);
//        System.out.println("done adding to grid");
//    }
    //--------------------Handling Events on buttons------------------------------------
//    public void HeroesBtnHandler(ActionEvent e, Button btn , int heroIndex) {
//
////        Button heroBtn = (Button) e.getSource();
//        System.out.println("heloo in Heroes btn handler");
////        int heroIndex = HeroesBtn.indexOf(heroBtn);
//        Hero h = Game.availableHeroes.get(heroIndex);
//
//        btn.setOnMouseEntered((event) -> {
//            System.out.println("You have just entered button" + heroIndex);
//            onHeroesDetailsUpdate(h);
//        });
//        btn.setOnMouseClicked((event) -> {
//            System.out.println("You have just clicked button" + heroIndex);
////            onHeroesDetailsUpdate(h);
//        });
////        if (e.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
////
////        } else if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
////            // start game
////        }
//    }
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