package fxAhvenbooking;
	

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import bookings.CalendarView;




/**
 * Start main program
 * @author Konstantin Sakharovskiy
 * @version Feb 7, 2019
 * 
 */
public class AhvenbookingMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			final FXMLLoader ldr = new FXMLLoader(getClass().getResource("AhvenbookingGUIView.fxml"));
			final Pane root = (Pane)ldr.load();
			final AhvenbookingGUIController ahvenbookingCtrl = (AhvenbookingGUIController)ldr.getController();
			final Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("ahvenbooking.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ahvenbooking");
			
			CalendarView calendar = new CalendarView();
            ahvenbookingCtrl.setCalendarView(calendar);
			
			primaryStage.show();
			
			
			
			 Application.Parameters param = getParameters();
			 if ( param.getRaw().size() > 0 ) {
			     ahvenbookingCtrl.readData(param.getRaw().get(0));
			     ahvenbookingCtrl.open();
			     
			 }
			 else if ( !ahvenbookingCtrl.open() ) Platform.exit();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launch the user interface
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
