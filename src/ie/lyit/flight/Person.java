package ie.lyit.flight;

import java.io.Serializable;

public abstract class Person implements Serializable {
	protected Name name;		// COMPOSITION - Person HAS-A name
	protected Date dateOfBirth;	// COMPOSITION - Person HAS-A dateOfBirth

    // Default Constructor
	// Called when object is created like this 
	//   ==> Person pObj = new Person();
	//   NOTE-This won't work because Person is abstract	
	public Person(){
		name = new Name();
		dateOfBirth = new Date();
	}
	
	// Initialisation Constructor
	// Called when object would have been created like this (not possible cos Abstract!)
	//    ==> Person pObj = new Person("Mr", "Joe", "Doe", 
	//                                 25, 12, 1985);
	//    NOTE-This won't work because Person is abstract!
    public Person(String t, String fN, String sn, 
    		      int d, int m, int y){
		name = new Name(t, fN, sn);
		dateOfBirth=new Date(d, m, y);
	}
    
	// toString() method
	// ==> Calls Name's toString() to display name, and
	//		       Date's toString() to display dateOfBirth
	@Override  // Overrides Object toString()
    public String toString(){
	   return name.toString() + "," + dateOfBirth;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(p1.equals(p2))				
	// ==> Calls Name's equals() to compare name to personIn's name, and
	//		compares phoneNumber to personIn's phoneNumber
	@Override  // Overrides Object equals()
	public boolean equals(Object obj){
	   Person pObject;
	   if (obj instanceof Person)
	      pObject = (Person)obj;
	   else
	      return false;
	   
       return(name.equals(pObject.name) &&
    		  dateOfBirth.equals(pObject.dateOfBirth));
	}
	
	// set() and get() methods
	public void setName(Name nameIn){
		name = nameIn;
	}
	public Name getName(){
		return name;
	}
	public void setDateOfBirth(Date dateOfBirthIn){
		dateOfBirth = dateOfBirthIn;
	}
	public Date getDateOfBirth(){
		return dateOfBirth;
	}	
}