package address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HallManager {
	private StringProperty name;

	private String password;

	/**
	 * 
	 */
	public HallManager(String name, String password) {
		this.name = new SimpleStringProperty(name);
		this.password = password;	}

	/**
	 * @param name
	 * @param password
	 */
	public HallManager() {
		this(null, null);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name.get();
	}
	
	/**
	 * @return the nameProperty
	 */
	public StringProperty nameProperty() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name.set(name);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

