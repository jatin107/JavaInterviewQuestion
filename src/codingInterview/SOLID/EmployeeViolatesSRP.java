package codingInterview.SOLID;

public class EmployeeViolatesSRP {

	int id;
	String Name, depart;
	boolean working;

	// responsiblity --Violates Single Responsibility Principle
	//DRY Don't Repeat Yourself (SRP)
	
	void saveEmployeeDetails() {
	}

	void terminateEmployee() {
	}

	void printEmployeeXML() {
	}

	void printEmployeeCSV() {
	}

}
