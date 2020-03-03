package fxAhvenbooking;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Konstantin Sakharovskiy
 * @version Feb 7, 2019
 * event handle for Reservation Card page
 */
public class ReservationCardGUIController {

   
    @FXML private void DoseNotWork() {
        
        Dialogs.showMessageDialog("Does not work yet, keep calm");
        
    }
    
    @FXML private void handlePressedClientSearch() {

    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientSearchView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New windows");
        stage.setScene(new Scene(root1));
        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }

    }
    

    @FXML private void handlePressedReservationSearch() {

    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservationSearchView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New windows");
        stage.setScene(new Scene(root1));
        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }

    }    
    
    
    @FXML private void handlePressedCalendar() {

    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AhvenbookingGUIView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New windows");
        stage.setScene(new Scene(root1));
        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }

    }
    

    
    
    
}