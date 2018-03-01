package address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	// Accommodation Office
	@FXML
	private Label totalRoomLabel;
	@FXML
	private Label totalEmptyRoomsLabel;

	@FXML
	public ComboBox<String> hallOfResidenceComboBox = new ComboBox<String>();

	private MainApp mainApp;

	private HallOfResidence hall;

	private int totalRooms = 0;

	private int totalEmptyRooms = 0;

	/**
	 * 
	 */
	public HallOfResidenceOverviewController() {

	}

	/**
	 * 
	 */
	@FXML
	private void initialize() {
		// Initialize the Student TableView with the three columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		roomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().room.roomNumberProperty());

		showHallOfResidenceDetails(null);

		studentTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showHallOfResidenceDetails(newValue));

		// Initialize HallsOfResidence in ComboBox
		hallOfResidenceComboBox.getItems().removeAll(hallOfResidenceComboBox.getItems());
		hallOfResidenceComboBox.getItems().addAll("Student Village", "Carroll Court", "Wallscourt Park");
	}

	/**
	 * @return HallOfResidence Name
	 */
	public String getHallSelection() {
		return hallOfResidenceComboBox.getValue();
	}

	/**
	 * @param hall
	 */
	public void setHall(HallOfResidence hall) {
		this.hall = hall;
	}

	/**
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		studentTable.setItems(hall.studentList);
	}

	/**
	 * @param totalRooms
	 * @param totalEmptyRooms
	 */
	public void setRoomData(int totalRooms, int totalEmptyRooms) {
		this.totalEmptyRooms = totalEmptyRooms;
		this.totalRooms = totalRooms;
	}

	/**
	 * @param student
	 */
	private void showHallOfResidenceDetails(Student student) {
		if (student != null) { // Populate Student & HallOfResidence data into GridPane Labels
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

			// Accommodation Office
			totalEmptyRoomsLabel.setText(Integer.toString(totalEmptyRooms));
			totalRoomLabel.setText(Integer.toString(totalRooms));

		} else { // No selection set blank
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

			// Accommodation Office
			totalEmptyRoomsLabel.setText("");
			totalRoomLabel.setText("");
		}
	}

	/**
	 * 
	 */
	@FXML
	private void handleHallSelect() {// Force HallsOfRecidenceOverview to update
		mainApp.setHallNameString(getHallSelection());
		mainApp.showHallOfResidenceOverview();
	}

	/**
	 * 
	 */
	@FXML
	private void handleEditStudent() { //Edit Student or throw warning
		Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		if (selectedStudent != null) {
			boolean okClicked = mainApp.showStudentEditDialog(selectedStudent);
			if (okClicked) {
				showHallOfResidenceDetails(selectedStudent);
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Student Selected");
			alert.setContentText("Please select a Student in the TableView.");
			
			alert.showAndWait();
		}
	}

	/**
	 * 
	 */
	@FXML
	private void handleEditRoom() { //Edit Room or throw warning
		Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		if (selectedStudent != null) {
			boolean okClicked = mainApp.showRoomEditDialog(selectedStudent);
			if (okClicked) {
				showHallOfResidenceDetails(selectedStudent);
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Student Selected");
			alert.setContentText("Please select a Student in the TableView.");
			
			alert.showAndWait();
		}
	}

	/**
	 * 
	 */
	@FXML
	private void handleEditLease() { // Edit Lease or throw warning
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
			alert.setHeaderText("No Student Selected");
			alert.setContentText("Please select a Student in the TableView.");
			
			alert.showAndWait();
		}
	}
}
