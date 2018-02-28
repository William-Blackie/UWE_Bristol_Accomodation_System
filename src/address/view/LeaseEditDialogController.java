package address.view;

import address.model.HallManager;
import address.model.HallOfResidence;
import address.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LeaseEditDialogController {

	private Stage dialogStage;
	private Student student;
	private HallManager hallManager;
	private HallOfResidence hallOfResidence;

	private boolean delClicked = false;
	private boolean okClicked = false;

	@FXML
	private Label leaseIDLabel;
	@FXML
	private TextField rentalDurationField;
	@FXML 
	private Label hallAddressLabel;
	@FXML
	private Label roomNumberLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private PasswordField passwordField;

	@FXML
	private void initialize() {
	}

	public void getStudent(Student student) {
		this.student = student;

		leaseIDLabel.setText(student.lease.getLeaseID());
		rentalDurationField.setText(Integer.toString(student.lease.getDurationInMonths()));
		hallAddressLabel.setText(student.lease.getHallAdress());
		roomNumberLabel.setText(Integer.toString(student.lease.getStudentRoomNumber()));
		firstNameLabel.setText(student.lease.getFirstName());
		lastNameLabel.setText(student.lease.getLastName());
		

		okClicked = true;
		dialogStage.close();
	}

	public void getHallManager(HallManager hallManager) {
		this.hallManager = hallManager;
	}

	public void getHallOfResidence(HallOfResidence hallOfResidence) {
		this.hallOfResidence = hallOfResidence;
	}

	@FXML
	public boolean isOkClicked() {
		return okClicked;
	}

	private boolean isInputValid() {

		String errorMessage = "";

		if (delClicked == false) {
			if (rentalDurationField.getText() == null || rentalDurationField.getText().length() == 0 || (Integer.valueOf(rentalDurationField.getText()) > 12)) {
				errorMessage += "Not a valid rental Duration(Max 12)!\n";
			}
		}

		if (passwordField.getText() == null || !((passwordField.getText().equals(hallManager.getPassword()))
				|| (passwordField.getText().equals(hallOfResidence.warden.getPassword())))) {
			errorMessage += "Not a valid Password!\n";
		}
		

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid field");
			alert.setHeaderText("Please correct invalid field");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			student.lease.setDurationInMonths(Integer.valueOf(rentalDurationField.getText()));
			okClicked = true;
			dialogStage.close();

		}
	}

	@FXML
	private void handleDelete() {
		delClicked = true;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
