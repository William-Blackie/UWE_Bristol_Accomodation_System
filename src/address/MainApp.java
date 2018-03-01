package address;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

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
	public ArrayList<HallOfResidence> hallArray = new ArrayList<HallOfResidence>();
	private String tempHallName;

	HallManager hallManager = new HallManager("Jhon Smith", "ps1");

	HallOfResidence hall1 = new HallOfResidence("Student Village", 1, 400, "307 Coldharbour Ln", "0744839872",
			new Warden("James Doe", "password1"));
	
	HallOfResidence hall2 = new HallOfResidence("Carroll Court", 2, 300, "200 coldharber Lane", "07557530287",
			new Warden("Jhon Doe", "password2"));
	
	HallOfResidence hall3 = new HallOfResidence("Wallscourt Park", 3, 200, "50 coldharber Lane", "07383619249",
			new Warden("Jane Doe", "password3"));

	public MainApp() {
		
		hallArray.add(hall1);
		hallArray.add(hall2);
		hallArray.add(hall3);
		
		hall1.studentList.addAll(new Student("William", "Blackie", new Room("Occupied", "Clean", 760, 11),new Lease("S16011054", 12, "35 coldharber Lane", 11, "William", "Blackie", "S16011054"), "16011054"),
				new Student("Joseph", "Blackie", new Room("Occupied", "Clean", 760, 12),new Lease("S16011053", 12, "35 coldharber Lane", 12, "Joseph", "Blackie", "16011053"),"16011053"),
				new Student("", "", new Room("Unoccupied", "Unclean", 400, 13), new Lease(), ""));
		
		hall2.studentList.addAll(new Student("Dylan", "Conway", new Room("Occupied", "Clean", 100, 21),new Lease("C17011376", 12, "35 coldharber Lane", 21, "Dylan", "Conway", "C17011376"), "17011376"),
				new Student("Joseph", "Blackie", new Room("Occupied", "Clean", 760, 12),new Lease("S16011053", 12, "35 coldharber Lane", 12, "Joseph", "Blackie", "16011053"),"16011053"),
				new Student("", "", new Room("Unoccupied", "Unclean", 400, 13), new Lease(), ""));
		
		initHallOfResidence(hall1);
		initHallOfResidence(hall2);
		initHallOfResidence(hall3);
	}
	
	public void initHallOfResidence(HallOfResidence hall) {
		while (hall.studentList.size() < hall.getTotalRooms()) {
			hall.studentList.add(new Student("", "", new Room("Unoccupied", "Clean", 0, Integer.valueOf(String.valueOf(hall.getHallNumber()) + String.valueOf(hall.studentList.size()))),
					new Lease(), ""));
		}
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
	
	public void setHallNameString(String hallName) {
		this.tempHallName = hallName;
	}
	
	public String getHallNameString() {
		return tempHallName;
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
			boolean isAHall = false;
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/HallOfResidenceOverview.fxml"));
			AnchorPane HallOfResidenceOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(HallOfResidenceOverview);

			HallOfResidenceOverviewController controller = loader.getController();
			
			for(HallOfResidence hall : hallArray) {
				if(getHallNameString() == hall.getName()) {
					controller.setHall(hall);
					isAHall = true;
				}
				}
			if(isAHall == false) {
				controller.setHall(hall1);
			}
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

			// Set the Student into the controller.
			LeaseEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.getStudent(student);
			controller.getHallManager(hallManager);
			//controller.getHallOfResidence(hall); TODO may have to fix

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
			//controller.getHallOfResidence(hall); TODO may need fix

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