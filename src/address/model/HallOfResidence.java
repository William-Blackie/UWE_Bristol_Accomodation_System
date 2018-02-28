package address.model;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HallOfResidence {

	private StringProperty name;

	/**
	 * @param name
	 * @param totalRooms
	 * @param address
	 * @param telephoneNumber
	 */

	private IntegerProperty hallNumber;

	private final StringProperty address;

	private final IntegerProperty totalRooms;

	private final StringProperty telephoneNumber;

	public Warden warden;

	public ObservableList<Student> studentList;

	/**
	 * @param name
	 * @param totalRooms
	 * @param address
	 * @param telephoneNumber
	 * @param studentList
	 * @param warden
	 * @param studentArray
	 */
	public HallOfResidence(String name, int hallNumber, int totalRooms, String address, String telephoneNumber,
			Warden warden) {
		this.name = new SimpleStringProperty(name);
		this.hallNumber = new SimpleIntegerProperty(hallNumber);
		this.address = new SimpleStringProperty(address);
		this.telephoneNumber = new SimpleStringProperty(telephoneNumber);
		this.warden = warden;
		this.totalRooms = new SimpleIntegerProperty(totalRooms);
		this.studentList = FXCollections.observableArrayList();
	}

	public HallOfResidence() {
		this(null, 0, 0, null, null, null);
	}

	/**
	 * @return the name property
	 */
	public StringProperty nameProperty() {
		return name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name.get();
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name.set(name);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address.get();
	}

	/**
	 * @return the address addressProperty
	 */
	public StringProperty addressProperty() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address.set(address);
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber.get();
	}

	/**
	 * @return the telephoneNumberProperty
	 */
	public StringProperty telephoneNumberProperty() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber
	 *            the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber.set(telephoneNumber);
	}

	/**
	 * @return the warden
	 */
	public Warden getWarden() {
		return warden;
	}

	/**
	 * @param warden
	 *            the warden to set
	 */
	public void setWarden(Warden warden) {
		this.warden = warden;
	}

	/**
	 * @return the name property
	 */
	public IntegerProperty totalRoomsProperty() {
		return totalRooms;
	}

	/**
	 * @return the name
	 */
	public int getTotalRooms() {
		return totalRooms.get();
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(int totalRooms) {
		this.totalRooms.set(totalRooms);
	}

	/**
	 * @return the hallNumber
	 */
	public Integer getHallNumber() {
		return hallNumber.get();
	}

	/**
	 * @param hallNumber
	 *            the hallNumber to set
	 */
	public void setHallNumber(int hallNumber) {
		this.hallNumber.set(hallNumber);
	}
}
