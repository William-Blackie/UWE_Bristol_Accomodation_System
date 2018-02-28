package address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
	
	
	//Room info
		private final StringProperty occupied; 
		private final StringProperty cleaningStatus;
	    private final StringProperty monthlyRate;
	    
public Room() {
	this(null, null, null);
}
	    public Room(String occupied, String cleaningStatus, String monthlyRate) {
	    	this.occupied = new SimpleStringProperty(occupied);
	    	this.cleaningStatus = new SimpleStringProperty(cleaningStatus);
	    	this.monthlyRate = new SimpleStringProperty(monthlyRate);
		}
	    
	public String getOccupied() {
		return occupied.get();
	}

	public void setOccupied(String occupied) {
		this.occupied.set(occupied);
	}
	
	public StringProperty OccupiedProperty() {
		return occupied;
	}
	
	public String getCleaningStatus() {
		return cleaningStatus.get();
	}

	public void setCleaningStatus(String cleaningStatus) {
		this.cleaningStatus.set(cleaningStatus);
	}
	
	public StringProperty cleaningStatusProperty() {
		return cleaningStatus;
	}
	
	public String getMonthlyRate() {
		return monthlyRate.get();
	}

	public void setMonthlyRate(String monthlyRate) {
		this.monthlyRate.set(monthlyRate);
	}
	
	public StringProperty monthlyRateProperty() {
		return monthlyRate;
	}

}