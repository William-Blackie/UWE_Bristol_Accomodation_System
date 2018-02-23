package address;

import java.io.IOException;
import java.util.ArrayList;

import address.model.HallOfResidence;
import address.model.Room;
import address.model.Student;
import address.view.HallOfResidenceEditDialogController;
import address.view.HallOfResidenceOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<HallOfResidence> hallOfResidenceData = FXCollections.observableArrayList(); 
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("UWE Bristol Accommodation System");

        initRootLayout();

        showStudentOverview();
    }
    
    public MainApp() {
    	
    	hallOfResidenceData.addAll(new HallOfResidence("Walls Court", 1000, "25 ColdHarber Lane", "07557530287"),
    			new HallOfResidence("Carrol Court", 200, "35 ColdHarber Lane", "0755743098"),
    			new HallOfResidence("Student Village", 1000, "45 ColdHarber Lane", "07557589048"));
    }
    

	public ObservableList<HallOfResidence> gethallOfResidenceData() {
        return hallOfResidenceData;
    }

    /**
     * Initialises the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showStudentOverview() {
        try {
            // Load StudentOverview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HallOfResidenceOverview.fxml"));
            AnchorPane StudentOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(StudentOverview);
        
            // Give the controller access to the main app.
            HallOfResidenceOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public boolean showStudentEditDialog(HallOfResidence student) {
	try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/StudentEditor.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the person into the controller
        HallOfResidenceEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setStudent(student);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}