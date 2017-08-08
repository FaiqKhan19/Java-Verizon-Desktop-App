package application;

import java.io.Serializable;

public class PartTimeEmployee extends Employee implements Serializable{
	
	private double hourlyRate;
	private double hoursWork;
	
	public PartTimeEmployee(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo, 
			String jobFunction, double hourlyRate, double hoursWork) throws IllegalInput {
		super(name, phoneNum, address, 
				city, zipCode, state, idNo, jobFunction);
		this.hourlyRate = hourlyRate;
		this.hoursWork = hoursWork;
	}

	public double getPay() {
		return hoursWork * hourlyRate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(double hoursWork) {
		this.hoursWork = hoursWork;
	}

	public String toString() {
		return "PartTimeEmployee [hourlyRate=" + hourlyRate + ", hoursWork="
				+ hoursWork + ", getHourlyRate()=" + getHourlyRate()
				+ ", getHoursWork()=" + getHoursWork() + "]";
	}
	
	

}
