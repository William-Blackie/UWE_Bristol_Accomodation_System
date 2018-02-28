package address;

import java.io.IOException;

import address.model.Room;
import address.model.Student;
import address.view.StudentEditDialogController;
import address.view.StudentOverviewController;
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
    private ObservableList<Student> studentData = FXCollections.observableArrayList();
   
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("UWE Bristol Accommodation System");

        initRootLayout();

        showStudentOverview();
    }
    
    public MainApp() {
    	
    	Room room = new Room("Occupied", "Clean", "1600");
        // Add some sample data
        studentData.add(new Student("Hans", "Muster", room));
        studentData.add(new Student("Ruth", "Mueller", room));
        studentData.add(new Student("Heinz", "Kurz", room));
        studentData.add(new Student("Cornelia", "Meier", room));
        studentData.add(new Student("Werner", "Meyer", room));
        studentData.add(new Student("Lydia", "Kunz", room));
        studentData.add(new Student("Anna", "Best", room));
        studentData.add(new Student("Stefan", "Meier", room));
        studentData.add(new Student("Martin", "Mueller", room));
    }
    
    public ObservableList<Student> getStudentData() {
        return studentData;
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
            loader.setLocation(MainApp.class.getResource("view/StudentOverview.fxml"));
            AnchorPane StudentOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(StudentOverview);
        
            // Give the controller access to the main app.
            StudentOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public boolean showStudentEditDialog(Student student) {
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
        StudentEditDialogController controller = loader.getController();
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