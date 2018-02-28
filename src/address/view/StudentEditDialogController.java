package address.view;

import address.model.HallManager;
import address.model.HallOfResidence;
import address.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentEditDialogController {

	private Stage dialogStage;
	private Student student;
	private HallManager hallManager;

	private boolean delClicked = false;
	private boolean okClicked = false;

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField studentIDField;

	@FXML
	private PasswordField hallManagerPasswordField;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void getStudent(Student student) {
		this.student = student;

		firstNameField.setText(student.getFirstName());
		lastNameField.setText(student.getLastName());
		studentIDField.setText(student.getStudentID());

		okClicked = true;
		dialogStage.close();
	}

	public void getHallManager(HallManager hallManager) {
		this.hallManager = hallManager;
	}

	@FXML
	public boolean isOkClicked() {
		return okClicked;
	}

	private boolean isInputValid() {

		String errorMessage = "";

		if (delClicked == false) {
			if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
				errorMessage += "Not a valid first name!\n";
			}
			if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
				errorMessage += "Not a valid last name!\n";
			}
			if (studentIDField.getText() == null || studentIDField.getText().length() == 0
					|| studentIDField.getText().length() > 8) {
				errorMessage += "Not a valid student ID!\n";
			}
		}

		if (hallManagerPasswordField.getText() == null
				|| !(hallManagerPasswordField.getText().equals(hallManager.getPassword()))) {
			errorMessage += "Not a valid Password!\n";
			System.out.println(hallManager.getPassword());
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
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
			student.setFirstName(firstNameField.getText());
			student.setLastName(lastNameField.getText());
			student.setStudentID((studentIDField.getText()));

			okClicked = true;
			dialogStage.close();

		}
	}

	@FXML
	private void handleDelete() {
		firstNameField.setText("");
		lastNameField.setText("");
		studentIDField.setText("");

		delClicked = true;

	}

}
