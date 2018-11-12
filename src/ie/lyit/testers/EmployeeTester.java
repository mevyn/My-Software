package ie.lyit.testers;

import ie.lyit.flight.Employee;
import ie.lyit.flight.Name;
import ie.lyit.flight.Date;
import java.util.ArrayList;

public class EmployeeTester {

	public static void main(String[] args) {
		// Create a Employee object called employeeA
		Employee employeeA = new Employee();
							
		// display employeeA's details on screen
		System.out.println(employeeA);
					
		// set employeeA's details
		employeeA.setName(new Name("Mr","Homer","Simpson"));
		employeeA.setDateOfBirth(new Date(12, 2, 1999));
		employeeA.setStartDate(new Date(12, 2, 2015));
		employeeA.setSalary(60000);		
							
		// display employeeA's details on screen
		System.out.println(employeeA);

		// Create a Employee object called employeeB with initial values
		Employee employeeB = new Employee("Ms","Lisa","Simpson",
				                          20,12,1992,
				                          new Date(1,2,2009),
				                          25000);

		// display employeeB's details on screen
		System.out.println(employeeB);

		// check if employeeA is the same as employeeB
		if(employeeA.equals(employeeB))
			System.out.println(employeeA + " is the same employee as " + employeeB);
		else
			System.out.println(employeeA + " is not the same employee as " + employeeB);

		// check if employeeA is female
		if(employeeA.getName().isFemale())		// OR	if(personA.isFemale()==true)
			System.out.println(employeeA + " is female.");			
		else
			System.out.println(employeeA + " is male.");	
		
		// calculateWage() for employeeA
		System.out.println(employeeA + " Wage="+ employeeA.calculateWage(25));

		// An ArrayList of Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeA);
		employees.add(employeeB);
		employees.add(new Employee("Mrs","Marge","Simpson",
				                   12,10,1954,new Date(1,1,1990),
				                   80000));
		employees.add(new Employee("Mr","Bart","Simpson",
                                   5,3,1988,new Date(4,8,2010),
                                   20000));
		employees.trimToSize( );

		for(Employee tempEmp:employees )
		    System.out.println(tempEmp);

		if(employeeSearch(employeeB, employees))
		    System.out.println("FOUND!");
		else
		    System.out.println("NOT FOUND!");
	}
	public static boolean employeeSearch(Employee employeeSearch, ArrayList<Employee> listOfEmployees){
		return listOfEmployees.contains(employeeSearch);
	}
}