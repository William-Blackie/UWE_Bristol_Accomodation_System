package address.model;

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

	/**
	 * @param firstName
	 * @param lastName
	 * @param room
	 * @param lease
	 * @param studentID
	 */
	public Student(String firstName, String lastName, Room room, Lease lease, String studentID) {
		this.room = room;
		this.lease = lease;
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.studentID = new SimpleStringProperty(studentID);
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	/**
	 * @return firstNameProperty
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	/**
	 * @return lastNameProperty
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * @return studentID
	 */
	public String getStudentID() {
		return studentID.get();
	}

	/**
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.studentID.set(studentID);
	}
}
