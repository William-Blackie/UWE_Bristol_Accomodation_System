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
	public Lease lease = new Lease();
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty studentID;

	public Student() {
		this(null, null, null, null, null);
	}

	public Student(String firstName, String lastName, Room room, Lease lease, String studentID) {
		this.room = room;
		this.lease = lease;
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);

		// intial dummy data for testin
		this.studentID = new SimpleStringProperty(studentID);
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

	public String getStudentID() {
		return studentID.get();
	}

	public void setStudentID(String studentID) {
		this.studentID.set(studentID);
	}

	public StringProperty studentIDProperty() {
		return studentID;
	}
}
