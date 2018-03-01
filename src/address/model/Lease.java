package address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lease {

	private StringProperty leaseID;

	private IntegerProperty durationInMonths;
	
	private StringProperty hallAdress;
	
	private IntegerProperty studentRoomNumber;
	
	private StringProperty firstName;
	
	private StringProperty lastName;
	
	private StringProperty studentIDNumber;

	/**
	 * @param leaseID
	 * @param durationInMonths
	 * @param hallAddress
	 * @param studentRoomNumber
	 * @param firstName
	 * @param lastName
	 * @param studentID
	 */
	public Lease(String leaseID, int durationInMonths, String hallAddress, int studentRoomNumber, String firstName, String lastName, String studentID) {
		this.leaseID = new SimpleStringProperty(leaseID);
		this.durationInMonths = new SimpleIntegerProperty(durationInMonths);
		this.hallAdress = new SimpleStringProperty(hallAddress);
		this.studentRoomNumber = new SimpleIntegerProperty(studentRoomNumber);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.studentIDNumber = new SimpleStringProperty(studentID);
	}
	
	public Lease() {
		this(null, 0, null, 0, null, null, null);
	}

	/**
	 * @return the leaseID
	 */
	public String getLeaseID() {
		return leaseID.get();
	}
	
	/**
	 * @param leaseID the leaseID to set
	 */
	public void setLeaseID(String leaseID) {
		this.leaseID.set(leaseID);
	}
	
	/**
	 * @return the durationInMonthsProperty
	 */
	public int getDurationInMonths() {
		return durationInMonths.get();
	}

	/**
	 * @param durationInMonths the durationInMonths to set
	 */
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths.set(durationInMonths);
	}

	/**
	 * @return the hallAdress
	 */
	public String getHallAdress() {
		return hallAdress.get();
	}

	/**
	 * @param hallAdress the hallAdress to set
	 */
	public void setHallAdress(String hallAdress) {
		this.hallAdress.set(hallAdress);
	}

	/**
	 * @return the studentRoomNumber
	 */
	public int getStudentRoomNumber() {
		return studentRoomNumber.get();
	}

	/**
	 * @param studentRoomNumber the studentRoomNumber to set
	 */
	public void setStudentRoomNumber(int studentRoomNumber) {
		this.studentRoomNumber.set(studentRoomNumber);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	/**
	 * @return the studentIDNumber
	 */
	public String getStudentIDNumber() {
		return studentIDNumber.get();
	}

	/**
	 * @param studentIDNumber the studentIDNumber to set
	 */
	public void setStudentIDNumber(String studentIDNumber) {
		this.studentIDNumber.set(studentIDNumber);
	}

}
