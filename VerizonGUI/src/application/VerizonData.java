package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class VerizonData implements Serializable{
	
	// ArrayList
	private ArrayList<Employee> employeeList;
	private ArrayList<Customer> customerList;
	
	public VerizonData() {
		
		this.employeeList = new ArrayList<>();
		this.customerList = new ArrayList<>();	
		
	}
	
	@SuppressWarnings("Unchecked")
	public void loadArrays(VerizonData data) throws FileNotFoundException, ClassNotFoundException {
		
		FileInputStream fis = null;
		ObjectInputStream input = null;
		
		try
		{
			fis = new FileInputStream("VerizonData.dat");
			input = new ObjectInputStream(fis);
			
		}
		catch (IOException e) 
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Unable to save data file");
			alert.setHeaderText(null);
			alert.setContentText("Unable to save data file"
					+ ". \n Please contact your administator.");
			alert.showAndWait();	
		}
		
		try {
			VerizonData d = (VerizonData) input.readObject();
			data.setEmployeeList(d.getEmployeeList());
			data.setCustomerList(d.getCustomerList());
			
		} catch(Exception e) {
			System.out.println("");
		}
		try {
			input.close();
		} catch (IOException | NullPointerException e) {
				//e.printStackTrace();
			}
		    
	}
	
		public void saveArrays(VerizonData data)
		{
			FileOutputStream fos = null;
			ObjectOutputStream output = null;
		
		
		try{
			fos = new FileOutputStream("VerizonData.dat");
			output = new ObjectOutputStream(fos);
			
		}
		catch(IOException e) {
			System.out.println("ERROR, TRY AGAIN!");
			
		}
		
		try 
		{
			//output.writeObject(data.getEmployeeList());
			//output.writeObject(data.getCustomerList());
			output.close();
			
		} 
		catch(IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Unable to save data file");
			alert.setHeaderText(null);
			alert.setContentText("Unable to save data file"
					+ ". \n Please contact your administator.");
			alert.showAndWait();
		}
		
	}
		public static Person searchArrays(int idNo, VerizonData data) {
			System.out.println(data.getCustomerList().size());
			for(Customer customer: data.getCustomerList())
			{
				System.out.println(customer.getIdNo());
			}
			for(Employee employee : data.getEmployeeList())
			{
				if(employee.getIdNo() == idNo)
				{
					return employee;
				}
			}
			
			for(Customer customer : data.getCustomerList())
			{
				if(customer.getIdNo() == idNo)
				{
					return customer;
				}
			}
			return null;	
		}

		
public ArrayList<Employee> getEmployeeList() {
	return employeeList;
}

public void setEmployeeList(ArrayList<Employee> employeeList) {
	this.employeeList = employeeList;
}

public ArrayList<Customer> getCustomerList() {
	return customerList;
}

public void setCustomerList(ArrayList<Customer> customerList) {
	this.customerList = customerList;
}


public boolean checkIdNo(int idNo, VerizonData data)
{
	for(Employee employee: data.getEmployeeList())
	{
		if(employee.getIdNo() == idNo)
		{
			return false;
		}
	}
	
	for(Customer customer: data.getCustomerList())
	{
		if(customer.getIdNo() == idNo)
		{
			return false;
		}
	}
	return false;
}

public void removeEmployee(int Employee, VerizonData data) {
	getEmployeeList().remove(VerizonData.searchArrays(Employee, data));
}

public void removeCustomer(int Customer, VerizonData data) {
	getEmployeeList().remove(VerizonData.searchArrays(Customer, data));
}
	
}
