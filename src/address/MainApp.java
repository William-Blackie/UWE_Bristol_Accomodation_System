package address;

import java.io.IOException;

import address.model.HallManager;
import address.model.HallOfResidence;
import address.model.Lease;
import address.model.Room;
import address.model.Student;
import address.model.Warden;
import address.view.HallOfResidenceOverviewController;
import address.view.LeaseEditDialogController;
import address.view.StudentEditDialogController;
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

	HallManager hallManager = new HallManager("Jhon Smith", "ps1");

	HallOfResidence hall = new HallOfResidence("Student Village", 1, 100, "35 coldharber Lane", "07557530287",
			new Warden("Tim Test", "password1"));

	public MainApp() {
		hall.studentList.addAll(new Student("William", "Blackie", new Room("Occupied", "Clean", 760, 11),new Lease("S16011054", 12, "35 coldharber Lane", 11, "William", "Blackie", "S16011054"), "16011054"),
				new Student("Joseph", "Blackie", new Room("Occupied", "Clean", 760, 12),new Lease("S16011053", 12, "35 coldharber Lane", 12, "Joseph", "Blackie", "16011053"),"16011053"),
				new Student("", "", new Room("Unoccupied", "Unclean", 400, 13), new Lease(), ""));

		while (hall.studentList.size() < hall.getTotalRooms()) {
			hall.studentList.add(new Student("", "", new Room("Unoccupied", "Clean", 0, Integer.valueOf(String.valueOf(hall.getHallNumber()) + String.valueOf(hall.studentList.size()))),
					new Lease(), ""));
		}
	}

	public HallOfResidence getHallOfResidence() {
		return hall;
	}

	public HallManager getHallManager() {
		return hallManager;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("UWE Bristol Accomomodation");

		initRootLayout();

		showHallOfResidenceOverview();
	}

	/**
	 * Initializes the root layout.
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
	public void showHallOfResidenceOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/HallOfResidenceOverview.fxml"));
			AnchorPane HallOfResidenceOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(HallOfResidenceOverview);

			HallOfResidenceOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showStudentEditDialog(Student student) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StudentEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Student");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			StudentEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.getStudent(student);
			controller.getHallManager(hallManager);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showRoomEditDialog(Student student) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RoomEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Room");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			LeaseEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.getStudent(student);
			controller.getHallManager(hallManager);
			controller.getHallOfResidence(hall);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showLeaseEditDialog(Student student) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/LeaseEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Lease");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			LeaseEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.getStudent(student);
			controller.getHallManager(hallManager);
			controller.getHallOfResidence(hall);

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
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}