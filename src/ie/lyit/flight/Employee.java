package ie.lyit.flight;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ie.lyit.flight.Person; 
import java.io.Serializable;

//INHERITANCE - Employee IS-A Person, and CAN-DO Payable methods
public class Employee extends Person implements Payable, Serializable {
    private Date startDate;	// Employee has name&dateOfBirth from Person		
    private double salary;	// AND startdate,salary, & number
    private int number;

	private static int nextNumber=1000;	// static for unique number - starts off at 1000    

	private final double MAX_SALARY = 150000.00;
	
    // Default Constructor
	// Called when object is created like this ==> 
	// Employee eObj = new Employee();	
    public Employee(){
    	super();
    	startDate=new Date();
 		salary=0.0;
		// Set number to static nextNumber before incrementing nextNumber
 		number=nextNumber++;
    }

    // Initialization Constructor
	// Called when object is created like this ==>
	//    Employee empObj = new Employee("Mr","Joe","Doe",
    //                                   25,12,1970,
    //									 new Date(10,11,2009),
    //                                   55000);
    //    NOTE:For dob and startDate you can either pass in a d,m,y OR a date object
    //         To show this, I have done dob as d,m,y, and startDate as a date object
    public Employee(String t, String fN, String sn, 
    		        int d, int m, int y,
    		        Date startDate, double salary){
       // Call super class constructor - Passing parameters required by Person ONLY!
	   super(t, fN, sn, d, m, y);
	   // And then initialise Employees own instance variables
	   this.startDate=startDate;	// Set instance variable to parameter
	   this.salary=salary;
	   
		// Set number to static nextNumber before incrementing nextNumber
	   number = nextNumber++;						
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
    public String toString(){
		return number + " " + super.toString() + " €" + salary;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(e1.equals(e2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
		   eObject = (Employee)obj;
		else
		   return false;
		   
	    return(this.number==eObject.number);
	}

	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}	
	public void setSalary(int salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	
	public void setNumber(int numberId) {
		this.number=numberId;
	}
	
	public double calculateWage(double taxPercentage) {
		// calculate and return the wage as salary/12 less taxPercentage
		double wage=salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	public double incrementSalary(double incrementAmount) {
		// add incrementAmount to, and return the new salary
		// salary should not go over a maximum salary of €150,000
		salary += incrementAmount;
		
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
		
		return salary;
	}
	
	// read() - To read details from the user	
	   public void read(){
	      JTextField txtEmployeeNo = new JTextField();
	      txtEmployeeNo.setText("" + this.getNumber());
	      JTextField txtTitle = new JTextField();
	      if (txtTitle != null) {
	    	  txtTitle.setText(this.getName().getTitle());
	      }
	      JTextField txtFirstName = new JTextField();
	      if (txtFirstName != null) {
	    	  txtFirstName.setText(this.getName().getFirstName());
	      }
	      JTextField txtSurname = new JTextField();
	      if (txtSurname != null) {
	    	  txtSurname.setText(this.getName().getSurname());
	      }
	      txtTitle.requestFocus();
	      JTextField txtBirthDate = new JTextField();
	      if (txtBirthDate != null) {
	    	  txtBirthDate.setText("" + this.getDateOfBirth().getDay());
	      }
	      JTextField txtBirthMonth = new JTextField();
	      if (txtBirthMonth != null) {
	    	  txtBirthMonth.setText("" + this.getDateOfBirth().getMonth());
	      }
	      JTextField txtBirthYear = new JTextField();
	      if (txtBirthYear != null) {
	    	  txtBirthYear.setText("" + this.getDateOfBirth().getYear());
	      }
	      JTextField txtStartDate = new JTextField();
	      if (txtStartDate != null) {
	    	  txtStartDate.setText("" + this.getStartDate().getDay());
	      }
	      JTextField txtStartMonth = new JTextField();
	      if (txtStartMonth != null) {
	    	  txtStartMonth.setText("" + this.getStartDate().getMonth());
	      }
	      JTextField txtStartYear = new JTextField();
	      if (txtStartYear != null) {
	    	  txtStartYear.setText("" + this.getStartDate().getYear());
	      }
	      JTextField txtSalary = new JTextField();
	      if (txtSalary != null) {
	    	  txtSalary.setText("" + this.getSalary());
	      }

	      Object[] message = {
	          "Employee ID:", txtEmployeeNo,
	          "Title (Mr/Mrs/Ms):", txtTitle,
	          "First Name:", txtFirstName,
	          "Surname:", txtSurname,
	          "Date of Birth:", "Day:", txtBirthDate, "Month:", txtBirthMonth, "Year:", txtBirthYear,
	          "Start Date:", "Day:", txtStartDate, "Month:", txtStartMonth, "Year:", txtStartYear,
	          "Salary:", txtSalary,
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter employee details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	    	  try {
	          this.name = new Name(txtTitle.getText(), txtFirstName.getText(), txtSurname.getText());
	          this.dateOfBirth = new Date (Integer.parseInt(txtBirthDate.getText()), Integer.parseInt(txtBirthMonth.getText()), Integer.parseInt(txtBirthYear.getText()));
	          this.startDate = new Date (Integer.parseInt(txtStartDate.getText()), Integer.parseInt(txtStartMonth.getText()), Integer.parseInt(txtStartYear.getText()));
	          this.number = Integer.parseInt(txtEmployeeNo.getText());
	          this.salary = Double.parseDouble(txtSalary.getText());
	          if (txtTitle.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtSurname.getText().isEmpty()) {
	        	  throw new IllegalArgumentException ();
	          }
	    	  }
	    	  catch (NumberFormatException nfe) {
	    		  System.out.println("Invalid input!");
	    		  read();
	    	  }
	    	  
	    	  catch (IllegalArgumentException iae) {
	    		  System.out.println("Invalid input!");
	    		  read();
	    	  }
	      }   
		}
}