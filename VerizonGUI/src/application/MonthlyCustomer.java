package application;

import java.io.Serializable;

public class MonthlyCustomer extends Customer implements Serializable{
	
	private double rate;
	public MonthlyCustomer(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo,
			String plan, String branch, double rate) throws IllegalInput {
		super(name, phoneNum, address, 
				city, zipCode, state, idNo,
				plan, branch);
		this.rate = rate;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}

}
