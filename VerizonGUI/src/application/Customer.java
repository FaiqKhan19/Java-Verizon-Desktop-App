package application;

import java.io.Serializable;

public class Customer extends Person implements Serializable{
	public static String plan;
	public static String branch;
	
	public Customer(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo, String plan, String branch) throws IllegalInput{
	super(name, phoneNum, address, 
			city, zipCode, state, idNo);
	this.plan = plan;
	this.branch = branch;

	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String toString() {
		return "Customer [plan=" + plan + ", branch=" + branch + ", getPlan()="
				+ getPlan() + ", getBranch()=" + getBranch() + "]";
	}
	
	
}
