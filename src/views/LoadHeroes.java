package views;


import controller.LoadHeroesGUI;
import engine.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.characters.Character;
import model.characters.Hero;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHeroes  {
    Scene LoadHeroes ;
    BorderPane layoutheroes = new BorderPane();
    GridPane grid = new GridPane();
    VBox layoutdetails = new VBox();
    TextArea heroesdetails = new TextArea("Hero details:\n");


    public LoadHeroes() throws IOException {
        try {
            Game.loadHeroes("C:\\Users\\Dell\\OneDrive\\Desktop\\Eclipse_DATA\\My-Game\\Game22\\src\\test_heros.csv");
        }catch (FileNotFoundException e){
            System.out.println("Not found File");
        }
        //LoadHeroesGUI loadHeroesGUI = new LoadHeroesGUI() ;
        heroesdetails.setMaxSize(375,1000);
        heroesdetails.setEditable(false);

        for(int i = 0 ; i<7 ; i++){
            RowConstraints row  = new RowConstraints() ;
            row.setPercentHeight(90);
            grid.getRowConstraints().add(row);
            if (i<3) {
                ColumnConstraints coloum = new ColumnConstraints();
                coloum.setPercentWidth(90);
                grid.getColumnConstraints().add(coloum);
            }
        }
        layoutheroes.setRight(heroesdetails);
        layoutheroes.setLeft(grid);
        LoadHeroes = new Scene(layoutheroes, 1000,1000);
        heroesdetails.setFont(new Font(24));
    }
    public void addHeroes(Button hero, int i){
        if (i<2){
            grid.add(hero,i,0);
        }
        else if(i<5){
            grid.add(hero,i-3,1);
        }
        else{
            grid.add(hero,1,2);
        }
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