package address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

	private StringProperty firstName;

	private StringProperty lastName;

	private StringProperty studentID;

	private Room Room;

	private Lease Lease;

	/**
	 * @param firstName
	 * @param lastName
	 * @param studentID
	 * @param room
	 * @param lease
	 */
	public Student(String firstName, String lastName, String studentID, Room room, Lease lease) {
		this.firstName =  new SimpleStringProperty(firstName);
		this.lastName =  new SimpleStringProperty(lastName);
		this.studentID =  new SimpleStringProperty(studentID);
		Room = room;
		Lease = lease;
	}
	
	public Student() {
		this(null, null, null, null, null);
	}

	/**
	 * @return the firstName
	 */
	public StringProperty getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public StringProperty getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the studentID
	 */
	public StringProperty getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(StringProperty studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return Room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		Room = room;
	}

	/**
	 * @return the lease
	 */
	public Lease getLease() {
		return Lease;
	}

	/**
	 * @param lease the lease to set
	 */
	public void setLease(Lease lease) {
		Lease = lease;
	}


}
