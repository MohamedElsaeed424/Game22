package controller;

import javafx.scene.control.Button;

public class WinGameGUI {


        private Button winBtn ;

        public WinGameGUI (){
                winBtn = new Button("Win Game") ;
                winBtn.setOnAction(e->);
        }

        public Button getWinBtn() {
                return winBtn;
        }
}
