package application;

import java.io.Serializable;

public abstract class Employee extends Person implements Serializable{
	
	private String jobFunction;
	
	public Employee(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo, String JobFunction) throws IllegalInput {
		super(name, phoneNum, address, 
				city, zipCode, state, idNo);
		this.jobFunction = jobFunction;
	}
	
	public abstract double getPay();

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public String toString() {
		return "Employee [jobFunction=" + jobFunction + ", getJobFunction()="
				+ getJobFunction() + "]";
	}
	
	

}
