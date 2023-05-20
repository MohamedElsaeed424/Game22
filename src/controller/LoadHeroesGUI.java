package controller;

import engine.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.characters.Hero;
import views.LoadHeroes;

import javax.swing.*;
import java.util.ArrayList;

public class LoadHeroesGUI {
    private ArrayList<Hero>Heroes  = Game.availableHeroes ;
    private ArrayList<Button>HeroesBtn;
    private LoadHeroes loadHeroes ;

    public LoadHeroesGUI (){
        HeroesBtn  = new ArrayList<>() ;
        int sizeOfHeroes = Heroes.size();
        for(int i =0 ; i<sizeOfHeroes ; i++){
            Hero h = Heroes.get(i);
            Button heroeBtn = new Button();
            heroeBtn.setText(i + " "+h.getName() );
            heroeBtn.setOnAction(e-> HeroesBtnHandler(e));
            loadHeroes.addHeroes(heroeBtn);
            HeroesBtn.add(heroeBtn);
        }
    }

    public void HeroesBtnHandler (ActionEvent e){
        Button heroBtn = (Button) e.getSource();
        int heroIndex = HeroesBtn.indexOf(heroBtn);
       Hero h = Game.availableHeroes.get(heroIndex);
        if ( e.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
            onHeroesDetailsUpdate(h);
        }else if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            onHeroesChoose(h);
        }
    }

    public void onHeroesDetailsUpdate(Hero h){
            loadHeroes.addDetails(h.toString());
    }

    public void onHeroesChoose(Hero h){

    }
}