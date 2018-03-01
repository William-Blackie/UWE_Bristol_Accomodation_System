package address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import address.MainApp;
import address.model.HallOfResidence;
import address.model.Student;

public class HallOfResidenceOverviewController {
	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> firstNameColumn;
	@FXML
	private TableColumn<Student, String> lastNameColumn;
	@FXML
	private TableColumn<Student, Number> roomNumberColumn;

	// Student
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label studentIDLabel;
	@FXML
	private Label birthdayLabel;

	// HallOfResidence
	@FXML
	private Label hallNameLabel;
	@FXML
	private Label hallAdressLabel;
	@FXML
	private Label hallTelephoneLabel;
	@FXML
	private Label hallWardenNameLabel;

	// Lease
	@FXML
	private Label leaseIDLabel;
	@FXML
	private Label durationMonthsLabel;

	// Room
	@FXML
	private Label roomNumberLabel;
	@FXML
	private Label occupiedLabel;
	@FXML
	private Label cleaningStatusLabel;
	@FXML
	private Label monthlyRateLabel;

	// Warden
	@FXML
	private Label wardenNameLabel;
	
	@FXML
	public ComboBox<String> hallOfResidenceComboBox = new ComboBox<String>();

	private MainApp mainApp;

	private HallOfResidence hall;

	public HallOfResidenceOverviewController() {

	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		roomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().room.roomNumberProperty());

		showHallOfResidenceDetails(null);

		studentTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showHallOfResidenceDetails(newValue));

		hallOfResidenceComboBox.getItems().removeAll(hallOfResidenceComboBox.getItems());
		hallOfResidenceComboBox.getItems().addAll("Student Village", "Carroll Court", "Wallscourt Park");
	}
	
	public String getHallSelection() {
		return hallOfResidenceComboBox.getValue();
	}
	
	public void setHall(HallOfResidence hall) {
		this.hall = hall;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		//hall = mainApp.getHallOfResidence();
		
		studentTable.setItems(hall.studentList);
	}

	private void showHallOfResidenceDetails(Student student) {
		if (student != null) {
			// Student Info
			firstNameLabel.setText(student.getFirstName());
			lastNameLabel.setText(student.getLastName());
			studentIDLabel.setText(student.getStudentID());

			// Hall Info
			hallNameLabel.setText(hall.getName());
			hallAdressLabel.setText(hall.getAddress());
			hallTelephoneLabel.setText(hall.getTelephoneNumber());

			// Room
			roomNumberLabel.setText(Integer.toString(student.room.getRoomNumber()));
			occupiedLabel.setText(student.room.getOccupied());
			cleaningStatusLabel.setText(student.room.getCleaningStatus());
			monthlyRateLabel.setText(Integer.toString(student.room.getMonthlyRate()));

			// Lease
			leaseIDLabel.setText(student.lease.getLeaseID());
			durationMonthsLabel.setText(Integer.toString(student.lease.getDurationInMonths()));

			// Warden
			wardenNameLabel.setText(hall.warden.getName());

		} else {
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			studentIDLabel.setText("");

			// Hall Info
			hallNameLabel.setText("");
			hallAdressLabel.setText("");
			hallTelephoneLabel.setText("");

			// Room
			roomNumberLabel.setText("");
			occupiedLabel.setText("");
			cleaningStatusLabel.setText("");
			monthlyRateLabel.setText("");

			// Lease
			leaseIDLabel.setText("");
			durationMonthsLabel.setText("");

			// Warden
			wardenNameLabel.setText("");
		}
	}

	@FXML
	private void handleHallSelect() {
			mainApp.setHallNameString(getHallSelection());
			mainApp.showHallOfResidenceOverview();
			System.out.print("Something");
			
			Alert alert = new Alert(AlertType.ERROR);
			Window dialogStage;
			alert.setTitle("Invalid fields or user priviliges");
			alert.setHeaderText(hallOfResidenceComboBox.getValue());
			alert.setContentText("TEST");

			alert.showAndWait();
	}
	
	@FXML
	private void deleteStudent() {
		int studentIndex = studentTable.getSelectionModel().getSelectedIndex();
		if (studentIndex >= 0) {
			studentTable.getItems().remove(studentIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Nothing selected");
			alert.setHeaderText("No Student selected");
			alert.setContentText("Please select a student in the table.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleEditPerson() {
		Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		if (selectedStudent != null) {
			boolean okClicked = mainApp.showStudentEditDialog(selectedStudent);
			if (okClicked) {
				showHallOfResidenceDetails(selectedStudent);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleEditRoom() {
		Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		if (selectedStudent != null) {
			boolean okClicked = mainApp.showRoomEditDialog(selectedStudent);
			if (okClicked) {
				showHallOfResidenceDetails(selectedStudent);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleEditLease() {
		Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		if (selectedStudent != null) {
			boolean okClicked = mainApp.showLeaseEditDialog(selectedStudent);
			if (okClicked) {
				showHallOfResidenceDetails(selectedStudent);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
}
