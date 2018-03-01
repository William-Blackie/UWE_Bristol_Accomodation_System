package address.view;

import address.model.HallManager;
import address.model.HallOfResidence;
import address.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RoomEditDialogController {

	private Stage dialogStage;
	private Student student;
	private HallManager hallManager;
	private HallOfResidence hallOfResidence;

	private boolean delClicked = false;
	private boolean okClicked = false;

	@FXML
	private Label roomIDLabel;
	@FXML
	private ComboBox<String> cleaningComboBox = new ComboBox<String>();
	@FXML
	private Label cleaningStausLabel;
	@FXML
	private ComboBox<String> roomOptionsComboBox = new ComboBox<String>();
	@FXML
	private Label roomStatusLabel;
	@FXML
	private TextField monthlyRateField;
	@FXML
	private PasswordField passwordField;

	/**
	 * 
	 */
	@FXML
	private void initialize() {// Initalize ComboBoxes
		roomOptionsComboBox.getItems().removeAll(roomOptionsComboBox.getItems());
		roomOptionsComboBox.getItems().addAll("Occupied", "Unoccupied");

		cleaningComboBox.getItems().removeAll(cleaningComboBox.getItems());
		cleaningComboBox.getItems().addAll("Clean", "Unclean", "Offline");
	}

	/**
	 * @param student
	 */
	public void getStudent(Student student) {
		this.student = student;

		roomIDLabel.setText(Integer.toString(student.room.getRoomNumber()));
		cleaningStausLabel.setText(student.room.getCleaningStatus());
		roomStatusLabel.setText(student.room.getOccupied());
		monthlyRateField.setText(Integer.toString((student.room.getMonthlyRate())));

		okClicked = true;
		dialogStage.close();
	}

	/**
	 * @param hallManager
	 */
	public void getHallManager(HallManager hallManager) {
		this.hallManager = hallManager;
	}

	/**
	 * @param hallOfResidence
	 */
	public void getHallOfResidence(HallOfResidence hallOfResidence) {
		this.hallOfResidence = hallOfResidence;
	}

	/**
	 * @return
	 */
	@FXML
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * @return
	 */
	private boolean isInputValid() { // Validate user input & password

		String errorMessage = "";

		if (delClicked == false) {
			if (roomIDLabel.getText() == null || roomIDLabel.getText().length() == 0) {
				errorMessage += "Not a valid room number!\n";
			}
			if (roomStatusLabel.getText() == null || roomStatusLabel.getText().length() == 0) {
				errorMessage += "Not a valid room staus!\n";
			}
			if (monthlyRateField.getText() == null || monthlyRateField.getText().length() == 0) {
				errorMessage += "Not a valid monthly rate!\n";
			}
		}

		if (passwordField.getText() == null || !((passwordField.getText().equals(hallManager.getPassword()))
				|| (passwordField.getText().equals(hallOfResidence.warden.getPassword())))) {
			errorMessage += "Not a valid Password!\n";
		}

		if (passwordField.getText().equals(hallOfResidence.warden.getPassword())) {
			if (!(Integer.valueOf(roomIDLabel.getText()).equals(student.room.getRoomNumber()))) {
				errorMessage += "You cannot change room number!\n";
			}
			if (!(roomStatusLabel.getText().equals(roomOptionsComboBox.getValue()))) {
				errorMessage += "You cannot change room staus!\n";
			}
			if (!(monthlyRateField.getText().equals(Integer.toString(student.room.getMonthlyRate())))) {
				errorMessage += "You cannot change monthly rate!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid fields or user priviliges");
			alert.setHeaderText("Please correct invalid fields or ask Hall Manager to alter fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	/**
	 * 
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * 
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			student.room.setRoomNumber(Integer.valueOf((roomIDLabel.getText())));
			student.room.setCleaningStatus(cleaningComboBox.getValue());
			student.room.setOccupied(roomOptionsComboBox.getValue());
			student.room.setMonthlyRate(Integer.valueOf(monthlyRateField.getText()));

			okClicked = true;
			dialogStage.close();

		}
	}

	/**
	 * 
	 */
	@FXML
	private void handleDelete() {
		cleaningStausLabel.setText("");
		roomStatusLabel.setText("");
		monthlyRateField.setText("");

		delClicked = true;
	}

	/**
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
