package address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import address.model.HallOfResidence;
import address.model.Student;

public class HallOfResidenceEditDialogController {
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField studentIDField;
	
	@FXML
	private TextField leaseIDField;
	
	private Stage dialogStage;
	
    private boolean okClicked = false;

	private HallOfResidence hallOfResidence;
    
    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setStudent(HallOfResidence hallOfResidence) {
    	this.hallOfResidence = hallOfResidence;
    	firstNameField.setText(hallOfResidence.getAddress());
       // lastNameField.setText(student.getLastName());
        //studentIDField.setText(student.getStudentID());
        //leaseIDField.setText(student.getLeaseID());
        
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            //student.setFirstName(firstNameField.getText());
           // student.setLastName(lastNameField.getText());
            
            okClicked = true;
            dialogStage.close();
        }
    }
        @FXML
        private void handleCancel() {
            dialogStage.close();
        }
        
        private boolean isInputValid() {
            String errorMessage = "";

            if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
                errorMessage += "No valid first name!\n"; 
            }
            if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
                errorMessage += "No valid last name!\n"; 
            }
            if (leaseIDField.getText() == null || leaseIDField.getText().length() == 0) {
                errorMessage += "No valid lease ID!\n"; 
            }
            if (studentIDField.getText() == null || studentIDField.getText().length() == 0) {
                errorMessage += "No valid student ID!\n"; 
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
}
