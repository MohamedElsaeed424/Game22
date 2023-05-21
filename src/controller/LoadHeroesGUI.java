//package controller;
//
//import engine.Game;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//import model.characters.Hero;
//import views.LoadHeroes;
//import views.StartGame;
//
//import javax.swing.*;
//import javax.swing.text.View;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class LoadHeroesGUI {
////    private ArrayList<Hero>Heroes ;
//    private ArrayList<Button>HeroesBtn;
//    private LoadHeroes loadHeroes  = new LoadHeroes();
//
//    public LoadHeroesGUI() throws IOException {
//    }
//
//    public void handelAddingHeroesBtns (ArrayList<Hero>Heroes) throws IOException {
//        HeroesBtn = new ArrayList<>();
//        int sizeOfHeroes = Heroes.size();
//        for(int i =0 ; i<sizeOfHeroes ; i++){
//            Hero h = Heroes.get(i);
//            Button heroeBtn = new Button();
//            heroeBtn.setText(i + " "+h.getName() );
//            heroeBtn.setOnAction(e-> HeroesBtnHandler(e));
//            loadHeroes.addHeroes(heroeBtn,i);
//            HeroesBtn.add(heroeBtn);
//        }
//    }
//    public void HeroesBtnHandler (ActionEvent e){
//        Button heroBtn = (Button) e.getSource();
//        int heroIndex = HeroesBtn.indexOf(heroBtn);
//       Hero h = Game.availableHeroes.get(heroIndex);
//        if ( e.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
//            onHeroesDetailsUpdate(h);
//        }else if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
//            // start game
//        }
//    }
//    public void onHeroesDetailsUpdate(Hero h){
//            loadHeroes.addDetails(h.toString());
//    }
//
//    public static void main(String[] args) throws IOException {
//
//    }
//}