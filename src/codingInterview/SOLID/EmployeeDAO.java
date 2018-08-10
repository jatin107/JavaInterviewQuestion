package codingInterview.SOLID;

public class EmployeeDAO {

	// has- a dependency on Employee and DataConnectionManger
	public boolean saveEmployee(Employee e) throws Exception {
		// DataBaseConnectionManger dcm=DataBaseConnectionManger.getInstance();
		// dcm.connect();
		// dcm.getConnectionInstance().prepareStatement("Insert into Table
		// values('','')");
		// dcm.disconnect();
		System.out.println("Saved Emplyee on database.");
		

		return true;
	}

	public boolean deleteEmployee(Employee e) {
		return true;

	}

}
