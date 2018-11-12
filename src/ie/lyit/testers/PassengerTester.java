package ie.lyit.testers;

import java.util.ArrayList;
import ie.lyit.flight.Passenger;

class PassengerTester{
   public static void main(String[] args){
	   // Create a Passenger object called passengerA
		Passenger passengerA = new Passenger();
							
		// display passengerA's details on screen
		System.out.println(passengerA);
					
		// set passengerA's details
		passengerA.getName().setTitle("Mr");
		passengerA.getName().setFirstName("Homer");
		passengerA.getName().setSurname("Simpson");		
		passengerA.getDateOfBirth().setDay(25);
		passengerA.getDateOfBirth().setMonth(10);
		passengerA.getDateOfBirth().setYear(1965);		
		passengerA.setNoBags(6);				
		passengerA.setPriorityBoarding(false);				
							
		// display passengerA's details on screen
		System.out.println(passengerA);
					
	   // Create a Passenger object called passengerB with initial values
		Passenger passengerB = new Passenger("Ms", "Lisa", "Simpson", 20, 12, 1992, 1, true);
							
		// display passengerB's details on screen
		System.out.println(passengerB);
							
		// change passengerB's firstName to "Lisa-Marie"
		passengerB.getName().setFirstName("Lisa-Marie");
					
		// display passengerB's details on screen
		System.out.println(passengerB);
					
	   // Create a Passenger object called passengerC with initial values
		Passenger passengerC = new Passenger("Mr", "Homer", "Simpson", 25, 10, 1965, 6 ,true);
					
		// check if passengerA is the same as passengerB
		if(passengerA.equals(passengerB))
		   System.out.println(passengerA + " is the same passenger as " + passengerB);
		else
		   System.out.println(passengerA + " is not the same passenger as " + passengerB);
					
		// check if passengerA is female
		if(passengerA.getName().isFemale())		// OR	if(personA.isFemale()==true)
		   System.out.println(passengerA + " is female.");			
		else
		   System.out.println(passengerA + " is male.");	
							
		// Create an ArrayList of Passenger objects called passengers
	   ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		// Add 4 Passenger objects to names
	   passengers.add(new Passenger("Mrs", "Marge", "Simpson", 18, 12, 1968, 4, true));
	   passengers.add(new Passenger("Mr", "Bart", "Simpson", 10, 10, 1990, 0, false));
	   passengers.add(passengerA);
	   passengers.add(passengerB);
		// trim the capacity of names to be names current size
 		passengers.trimToSize();	
							
		// print every element in passengers
		System.out.print("\nArrayList contains ==>");
	    for(Passenger tempPassenger:passengers)
 	       System.out.println(tempPassenger);
	}
}
					