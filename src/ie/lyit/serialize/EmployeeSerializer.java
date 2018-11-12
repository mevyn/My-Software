package ie.lyit.serialize;

import java.util.ArrayList;
import java.util.Scanner;
import ie.lyit.flight.Employee;
import java.io.*;

public class EmployeeSerializer {
	private ArrayList<Employee> employees;
	
	private final String FILENAME = "employee.ser";	
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct employeeList ArrayList
		employees = new ArrayList<Employee>();
	}	

	public void add(){
		// Create a Employee object
		Employee employee = new Employee();
		// If Employee is empty
		if (employees.isEmpty()){
			employee.setNumber(1000);
			employee.read();
		}
		else {
			int previous = employees.size() -1 ;
			int nextNumber = employees.get(previous).getNumber() +1 ;
			employee.setNumber(nextNumber);
			employee.read();
		}
		// And add it to the employees ArrayList
		employees.add(employee);
	}

	public void list(){
		// for every Employee object in books
        for(Employee tmpEmployee:employees)
			// display it
			System.out.println(tmpEmployee);
	}
	
	public Employee view() {
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the employee to be viewed from the user
		System.out.println("ENTER EMPLOYEE ID : ");
		int employeeToView=keyboard.nextInt();
		
		// for every Employee object in the employees ArrayList
        for(Employee tmpEmployee:employees) {
		
  		   // if it's number equals the number of the employeeToView
  		   if(tmpEmployee.getNumber() == employeeToView){
  		      // display it and...
  			  System.out.println(tmpEmployee);
  			  // return it
  			  return tmpEmployee;
  		   }
        }
  		return null;  
	}
	
	public void delete() {
		// Call view() to find, display, & return the employee to delete
		Employee tempEmployee = view();
		
		// If the employee != null, i.e. it was found then...
	    if(tempEmployee != null)
		   // ...remove it from employees
	    	employees.remove(tempEmployee);	
	}
	
	public void edit() {
		// Call view() to find, display, & return the employee to edit
		Employee tempEmployee = view();
		
		// If the employee != null, i.e. it was found then...
	    if(tempEmployee != null){
		   // get it's index
		   int index=employees.indexOf(tempEmployee);
		   // read in a new employee and...
		   tempEmployee.read();
		   // reset the object in employees
		   employees.set(index, tempEmployee);
	    }
	}
	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write it to a file called employee.ser
	public void serializeEmployees(){
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
				
			os.writeObject(employees);

			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
	}

	// This method will deserialize the employees ArrayList when called, 
	// i.e. it will restore the ArrayList from the file employee.ser
	public void deserializeEmployees(){
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
				
			employees = (ArrayList<Employee>)is.readObject();	

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}