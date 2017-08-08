package application;

import java.io.Serializable;

public class PayAsYouGoCustomer extends Customer implements Serializable{
	
	private int rate;
	
	public PayAsYouGoCustomer(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo, 
			String plan, String branch, int rate) throws IllegalInput {
		super(name, phoneNum, address, 
				city, zipCode, state, idNo, 
				plan, branch);
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "PayAsYouGoCustomer [rate=" + rate + ", getRate()=" + getRate() + "]";
	}

	
}
