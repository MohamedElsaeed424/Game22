package controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.LoadHeroes;
import views.StartGame;

public class StartGameGUI {

    Button startGame ;
    LoadHeroes loadHeroes ;

    public StartGameGUI (){

        Scene loadHeroesScene = loadHeroes.getLoadHeroesScene();
        startGame = new Button("Start Game");
        startGame.setFont(new javafx.scene.text.Font(80));
        startGame.setStyle("-fx-border-color:#000000;-fx-border-width:5px;");
        // Here want to add the window
//        startGame.setOnAction(e-> );
    }



}
