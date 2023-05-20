package controller;

import engine.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.characters.Hero;

import java.util.ArrayList;

public class LoadHeroes {
    private ArrayList<Hero>Heroes  = Game.availableHeroes ;
    private ArrayList<Button>HeroesBtn;

    public LoadHeroes (){
        HeroesBtn  = new ArrayList<>() ;

        int sizeOfHeroes = Heroes.size();

        for(int i =0 ; i<sizeOfHeroes ; i++){
            Hero h = Heroes.get(i);
            Button heroeBtn = new Button();
            heroeBtn.setText(i + " "+h.getName() );
            heroeBtn.setOnAction(e-> HeroesBtnHandler(e));

            HeroesBtn.add(heroeBtn);

        }
    }

    public void HeroesBtnHandler (ActionEvent e){
        if ( e.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
            onHeroesDetailsUpdate();
        }else if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            // start game
        }
    }

    public void onHeroesDetailsUpdate(){
        ArrayList<String> HeroesData = new ArrayList<>() ;
        for (int i =0 ; i<Heroes.size() ; i++){
            Hero h = Heroes.get(i);
            HeroesData.add(h.toString());
        }
        // add To view
    }
}
