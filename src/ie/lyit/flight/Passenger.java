package ie.lyit.flight;

public class Passenger extends Person{ //INHERITANCE-Passenger IS-A Person
	private int noBags;				 // Passenger has name & dateOfBirth from Person
	private boolean priorityBoarding;// AND noBags & priorityBoarding

	// Default Constructor
	// Called when object is created like this ==> 
	// Passenger prObj = new Passenger();
	public Passenger(){
		// The super() constructor will get called automatically!
		super(); // You don't need to put in, but you can!
	 	noBags = 0;
		priorityBoarding = false;
	}

	// Initialization Constructor
	// Called when object is created like this ==>
	//    Passenger prObj = new Passenger("Mr", "Joe", "Doe", 25, 12, 1985, 2, true);
	public Passenger(String t, String fN, String sn, int d, int m, int y, int noB, boolean pB){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, d, m, y);
		// And then initialise Passengers own instance variables
		noBags=noB;
		priorityBoarding=pB;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
	   return super.toString() + " ==> " + noBags + " bags, Priority Boarding is " + priorityBoarding;
	}

	// OVERRIDING the Person equals() method!
	// ==> Called when comparing an object with another object, e.g. - 
	//       if(pr1.equals(pr2))										
	// Calling Persons equals() method, and adding additional bits
	@Override
	public boolean equals(Object obj){
	   Passenger pObject;
	   if (obj instanceof Passenger)
		   pObject = (Passenger)obj;
	   else
	       return false;
	 
	   return super.equals(pObject)
	          && this.noBags == pObject.noBags
	          && this.priorityBoarding == pObject.priorityBoarding;
	}	

	// set() and get() methods
	public void setNoBags(int noBagsIn){
	    noBags=noBagsIn;
	}
    public int getNoBags(){
       return noBags;
    }
					
    public void setPriorityBoarding(boolean priorityBoardingIn){
       priorityBoarding=priorityBoardingIn;
    }
    public boolean getPriorityBoarding(){
       return priorityBoarding;
    }	
}