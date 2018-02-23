package address.model;
import java.util.HashMap;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HallOfResidence {

	private StringProperty name;

	/**
	 * @param name
	 * @param totalRooms
	 * @param address
	 * @param telephoneNumber
	 */

	private final StringProperty address;

	private final StringProperty telephoneNumber;

	private Warden warden;

	public HashMap<Object, Student> studentMap;

	/**
	 * @param name
	 * @param totalRooms
	 * @param address
	 * @param telephoneNumber
	 * @param warden
	 * @param studentArray
	 */
	public HallOfResidence(String name, int totalRooms, String address,
			String telephoneNumber) {
		this.name = new SimpleStringProperty(name);
		this.address = new SimpleStringProperty(address);
		this.telephoneNumber = new SimpleStringProperty(telephoneNumber);
		this.warden = new Warden();
		this.studentMap = new HashMap<>(totalRooms);
	}
	
	public HallOfResidence() {
		this(null, (Integer) null, null, null);
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
	 * @param name the name to set
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
	 * @param address the address to set
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
	 * @param telephoneNumber the telephoneNumber to set
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
	 * @param warden the warden to set
	 */
	public void setWarden(Warden warden) {
		this.warden = warden;
	}


}
