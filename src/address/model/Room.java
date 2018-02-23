package address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Room {

	private StringProperty occupied;

	private StringProperty cleaningStatus;

	private StringProperty monthlyRate;

	private IntegerProperty roomNumber;

	/**
	 * @param occupied
	 * @param cleaningStatus
	 * @param monthlyRate
	 * @param roomNumber
	 */
	public Room(StringProperty occupied, StringProperty cleaningStatus, StringProperty monthlyRate,
			IntegerProperty roomNumber) {
		this.occupied = occupied;
		this.cleaningStatus = cleaningStatus;
		this.monthlyRate = monthlyRate;
		this.roomNumber = roomNumber;
	}
	
	public Room() {
		this(null, null, null, null);
	}

	/**
	 * @return the occupied
	 */
	public String getOccupied() {
		return occupied.get();
	}
	
	/**
	 * @return the occupiedProperty
	 */
	public StringProperty occupiedProperty() {
		return occupied;
	}
	
	/**
	 * @param occupied the occupied to set
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
	 * @return the cleaningStatusProperty
	 */
	public StringProperty cleaningStatusProperty() {
		return cleaningStatus;
	}

	/**
	 * @param cleaningStatus the cleaningStatus to set
	 */
	public void setCleaningStatus(String cleaningStatus) {
		this.cleaningStatus.set(cleaningStatus);
	}

	/**
	 * @return the monthlyRate
	 */
	public String getMonthlyRate() {
		return monthlyRate.get();
	}
	
	/**
	 * @return the monthlyRateProperty
	 */
	public StringProperty monthlyRateProperty() {
		return monthlyRate;
	}

	/**
	 * @param monthlyRate the monthlyRate to set
	 */
	public void setMonthlyRate(String monthlyRate) {
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
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber.set(roomNumber);
	}

}
