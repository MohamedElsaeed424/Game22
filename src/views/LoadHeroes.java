package views;

import engine.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.characters.Character;
import model.characters.Hero;

import java.awt.*;
import java.util.ArrayList;

public class LoadHeroes  {
    Scene LoadHeroes ;

    BorderPane layoutheroes = new BorderPane();
    VBox layoutdetails = new VBox();
    TextArea heroesdetails = new TextArea("Hero details:\n");
    public LoadHeroes() {

        heroesdetails.setMaxSize(375,1000);
        heroesdetails.setEditable(false);
        GridPane grid = new GridPane();
        grid.setMaxSize(1125,1000);
        layoutheroes.setRight(heroesdetails);
        layoutheroes.setLeft(grid);
         LoadHeroes = new Scene(layoutheroes, 1500,1000);


        heroesdetails.setFont(new Font(24));
    }
    public void addHeroes(Button hero){

        layoutheroes.getChildren().add(hero);

        layoutdetails.getChildren().add(hero);

    }
    public void addDetails(String herosdetails){
        heroesdetails.appendText(herosdetails);
    }
    public void setLoadHeroesScene (Scene loadHeroes) {
        LoadHeroes = loadHeroes;
    }
    public Scene getLoadHeroesScene() {
        return LoadHeroes;
    }
}