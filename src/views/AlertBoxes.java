package views;

import javafx.scene.control.Alert;

public class AlertBoxes {

    public void alertBoxForInvalidToSetTarget(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Cant set This Position to be Target");
        alert.setContentText("You Should Choose Valid Target");
        alert.showAndWait();
    }

    public void alertBoxForInvalidHeroSelection(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("This is not a Hero");
        alert.setContentText("You Should Choose Valid Hero");
        alert.showAndWait();
    }


    public void alertBoxForInvalidTargetAttack(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Target To Attack");
        alert.setContentText("You Should Choose Valid Target");
        alert.showAndWait();
    }

    public void alertBoxForNotEnougthActionsAttack (){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Actions To Attack");
        alert.setContentText("You Can Not Attack  , No Actions Available");
        alert.showAndWait();
    }

    public void alertBoxForInvalidTargetCure(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Target To Cure");
        alert.setContentText("You Should Choose Valid Target");
        alert.showAndWait();
    }

    public void alertBoxForNotEnougthActionsCure(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Actions To Cure");
        alert.setContentText("You Can Not Cure  , No Actions Available");
        alert.showAndWait();
    }

    public void alretBoxForNoAvailableResourcesCure(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Vaccine To Cure");
        alert.setContentText("Try to collect Vaccine");
        alert.showAndWait();
    }

    public void alretBoxForNoHeroestobeaddedCure(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Heroes to be added To Cure");
        alert.setContentText("You will not be able to cure");
        alert.showAndWait();
    }



    public void alertBoxForInvalidTargetUseSpecial(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Target To UseSpecial");
        alert.setContentText("You Should Choose Valid Target");
        alert.showAndWait();
    }

    public void alertBoxForNotEnougthActionsUseSpecial(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Actions To UseSpecial");
        alert.setContentText("You Can Not Cure  , No Actions Available");
        alert.showAndWait();
    }

    public void alretBoxForNoAvailableResourcesUseSpecial(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Vaccine To UseSpecial");
        alert.setContentText("Try to collect Vaccine");
        alert.showAndWait();
    }

    public void alertBoxForNotEnougthActionsForMovement(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No Enough Actions To Move");
        alert.setContentText("No Actions Available");
        alert.showAndWait();
    }

    public void alertBoxForMovementDirection(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Not Valid Direction");
        alert.setContentText("You can not move there");
        alert.showAndWait();
    }


}
