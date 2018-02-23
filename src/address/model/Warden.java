package address.model;

import javafx.beans.property.StringProperty;

public class Warden {

	private StringProperty name;

	private String password;

	/**
	 * @param name
	 * @param password
	 */
	public Warden(StringProperty name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Warden() {
		this(null, null);
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
