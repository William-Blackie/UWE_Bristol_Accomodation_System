package address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Lease {

	private StringProperty leaseID;

	private IntegerProperty durationInMonths;

	/**
	 * @param leaseID
	 * @param durationInMonths
	 */
	public Lease(StringProperty leaseID, IntegerProperty durationInMonths) {
		this.leaseID = leaseID;
		this.durationInMonths = durationInMonths;
	}
	
	public Lease() {
		this(null, null);
	}

	/**
	 * @return the leaseID
	 */
	public String getLeaseID() {
		return leaseID.get();
	}

	/**
	 * @return the leaseID
	 */
	public StringProperty leaseIDProperty() {
		return leaseID;
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
	public IntegerProperty durationInMonthsProperty() {
		return durationInMonths;
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

}
