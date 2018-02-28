package address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import address.MainApp;
import address.model.Student;

public class StudentOverviewController {
	@FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    
    
    //Student info
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label studentIDLabel;
    @FXML
    private Label leaseIDLable;
    @FXML
    private Label birthdayLabel;
    
    //Room info
    @FXML
    private Label occupiedLabel;
    @FXML
    private Label cleaningStatusLabel;
    @FXML
    private Label monthlyRateLabel;
    
    @SuppressWarnings("unused")
	private MainApp mainApp;
    
    @FXML
    private void showStudentDetails(Student student) {
    	if (student != null) {
    		firstNameLabel.setText(student.getFirstName());
    		lastNameLabel.setText(student.getLastName());
    		studentIDLabel.setText(student.getLeaseID());
    		leaseIDLable.setText(student.getLeaseID());
    		
    		//Room
    		cleaningStatusLabel.setText(student.room.getCleaningStatus());
    		occupiedLabel.setText(student.room.getOccupied());
    		monthlyRateLabel.setText(student.room.getMonthlyRate());
    		
    		//birthdayLabel.setText(student.getBirthday());
    	}
    	else {
    		firstNameLabel.setText("");
    		lastNameLabel.setText("");
    		studentIDLabel.setText("");
    		leaseIDLable.setText("");
    		
    		//Room
    		cleaningStatusLabel.setText("");
    		occupiedLabel.setText("");
    		monthlyRateLabel.setText("");
    	}
    }
    
    
    public StudentOverviewController() {
    }
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    
        
        showStudentDetails(null);
        
        studentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentDetails(newValue));
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        studentTable.setItems(mainApp.getStudentData());
    }
    
    @FXML
    private void handleDeleteStudent() {
        int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        studentTable.getItems().remove(selectedIndex);
    
    //TODO: handle array out of bounds exception
    }
    
    @FXML
    private void handleNewStudent() {
        Student tempStudent = new Student();
        boolean okClicked = mainApp.showStudentEditDialog(tempStudent);
        if (okClicked) {
            mainApp.getStudentData().add(tempStudent);
        }
    }


    @FXML
    private void handleEditStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            boolean okClicked = mainApp.showStudentEditDialog(selectedStudent);
            if (okClicked) {
                showStudentDetails(selectedStudent);
            }
            else {
            	Alert alert = new Alert(AlertType.WARNING);
            	alert.initOwner(mainApp.getPrimaryStage());
            	alert.setTitle("No selected Student");
            	alert.setHeaderText("No selected Student");
            	alert.setContentText("Please select student in the table");
            	
            	alert.showAndWait();
            }
        }
    
    
    }
}
    