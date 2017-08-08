package application;
import java.util.Scanner;


public class TestPerson {
	
	public static void main (String[] args) throws IllegalInput {
		
		
        Scanner user = new Scanner(System.in);
		
		System.out.println("Enter name ");
		String name = user.nextLine();
		System.out.println("Enter phoneNum ");
		String phoneNum = user.nextLine();
		System.out.println("Enter the address ");
		String address = user.nextLine();
		System.out.println("Enter the city");
		String city = user.nextLine();
		System.out.println("Enter zipCode");
		String zip = user.nextLine();
		System.out.println("Enter state");
		String state = user.nextLine();
		System.out.println("Enter ID");
		int id = user.nextInt();
		System.out.println("Enter plan");
		String plan = user.nextLine();
		System.out.println("Enter branch");
		String branch = user.nextLine();
		System.out.println("Enter jobFunction");
		String jobFunction = user.nextLine();
		System.out.println("Enter the salary: ");
		double salary = user.nextDouble();
		System.out.println("Enter the hourly rate:");
		double hourlyRate = user.nextDouble();
		System.out.println("Enter the hours worked: ");
		double hoursWork = user.nextDouble();
		System.out.println("Enter the rate: ");
		int rate = user.nextInt();

		Customer c1 = new Customer( name, phoneNum, address, city, 
				zip, state, id, plan, branch);
		FullTimeEmployee e1 = new FullTimeEmployee(name, phoneNum, address, city, 
				zip, state, id, jobFunction, salary);
		PartTimeEmployee e2 = new PartTimeEmployee(name, phoneNum, address, city, 
				zip, state, id, jobFunction, hourlyRate, hoursWork);
		PayAsYouGoCustomer p1 = new PayAsYouGoCustomer(name, phoneNum, address, city, 
				zip, state, id, plan, branch, rate);
		
		
	}

}
