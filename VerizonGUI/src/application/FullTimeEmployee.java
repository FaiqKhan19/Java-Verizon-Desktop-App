package application;

import java.io.Serializable;

public class FullTimeEmployee extends Employee implements Serializable{
	
	private double salary;
	
	public FullTimeEmployee(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo, 
			String jobFunction, double salary) throws IllegalInput {
		super(name, phoneNum, address, 
				city, zipCode, state, idNo, jobFunction);
		this.salary = salary;
	}

	public double getPay() {
		return this.salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "FullTimeEmployee [salary=" + salary + ", getSalary()="
				+ getSalary() + "]";
	}
	

}
