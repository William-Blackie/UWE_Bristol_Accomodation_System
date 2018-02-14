package address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	public Room room = new Room();
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty leaseID;
	private final StringProperty studentID;
	private final ObjectProperty<LocalDate> birthday;

public Student() {
	this(null, null, null);
}

public Student(String firstName, String lastName, Room room) {
	this.room = room;
	this.firstName = new SimpleStringProperty(firstName);
	this.lastName = new SimpleStringProperty(lastName);
	
	//intial dummy data for testing
	
	this.leaseID = new SimpleStringProperty("some lease");
	this.studentID = new SimpleStringProperty("00000");
	this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
}

public String getFirstName() {
	return firstName.get();
}

public void setFirstName(String firstName) {
	this.firstName.set(firstName);
}

public StringProperty firstNameProperty() {
	return firstName;
}

public String getLastName() {
	return lastName.get();
}

public void setLastName(String lastName) {
	this.lastName.set(lastName);
}

public StringProperty lastNameProperty() {
    return lastName;
}

public String getLeaseID() {
	return leaseID.get();
}

public void setLeaseID(String leaseID) {
	this.leaseID.set(leaseID);
}

public StringProperty leaseIDProperty() {
	return leaseID;
}

public String getStudentID() {
	return studentID.get();
}

public void setStudentID(String studentID) {
	this.studentID.set(studentID);
}

public StringProperty studentIDProperty() {
	return studentID;
}

public ObjectProperty<LocalDate> getBirthday() {
	return birthday;
}

public void setBirthday(LocalDate birthday) {
    this.birthday.set(birthday);
}
}
