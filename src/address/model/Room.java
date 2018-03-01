package address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
	private final StringProperty occupied;
	private final StringProperty cleaningStatus;
	private final IntegerProperty monthlyRate;
	private final IntegerProperty roomNumber;


	/**
	 * @param occupied
	 * @param cleaningStatus
	 * @param monthlyRate
	 * @param roomNumber
	 */
	public Room(String occupied, String cleaningStatus, int monthlyRate, int roomNumber) {
		this.occupied = new SimpleStringProperty(occupied);
		this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
		this.monthlyRate = new SimpleIntegerProperty(monthlyRate);
		this.roomNumber = new SimpleIntegerProperty(roomNumber);
	}
	
	public Room() {
		this(null, null, 0, 0);
	}

	/**
	 * @return the occupied
	 */
	public String getOccupied() {
		return occupied.get();
	}


	/**
	 * @param occupied
	 *            the occupied to set
	 */
	public void setOccupied(String occupied) {
		this.occupied.set(occupied);
	}

	/**
	 * @return the cleaningStatus
	 */
	public String getCleaningStatus() {
		return cleaningStatus.get();
	}

	/**
	 * @param cleaningStatus
	 *            the cleaningStatus to set
	 */
	public void setCleaningStatus(String cleaningStatus) {
		this.cleaningStatus.set(cleaningStatus);
	}

	/**
	 * @return the monthlyRate
	 */
	public int getMonthlyRate() {
		return monthlyRate.get();
	}

	/**
	 * @param monthlyRate
	 *            the monthlyRate to set
	 */
	public void setMonthlyRate(int monthlyRate) {
		this.monthlyRate.set(monthlyRate);
	}

	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber.get();
	}

	/**
	 * @return the roomNumberProperty
	 */
	public IntegerProperty roomNumberProperty() {
		return roomNumber;
	}

	/**
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber.set(roomNumber);
	}

}