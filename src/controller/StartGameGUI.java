package controller;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.characters.Hero;
import views.LoadHeroes;
import views.StartGame;

import java.util.ArrayList;

public class StartGameGUI {

    Button startGame ;
    LoadHeroes loadHeroes = new LoadHeroes();
    StartGame startGameScene  = new StartGame() ;
    LoadHeroesGUI load = new LoadHeroesGUI();

    public StartGameGUI () {

        startGame = new Button("Start Game");
        startGame.setFont(new javafx.scene.text.Font(80));
        startGame.setStyle("-fx-border-color:#000000;-fx-border-width:5px;");
        startGame.setFont(Font.font("Tahoma", FontWeight.BOLD, 80));

        // Here want to add the window
        startGame.setOnAction(e-> startGameScene.getWindow().setScene(loadHeroes.getLoadHeroesScene()));



    }
    public Button getStartGameButton() {
        return startGame;
    }
}
