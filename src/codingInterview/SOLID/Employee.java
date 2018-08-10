package codingInterview.SOLID;

public class Employee {

	int id;
	String Name, depart;
	boolean working;

	public Employee(int id, String name, String depart, boolean working) {
		super();
		this.id = id;
		Name = name;
		this.depart = depart;
		this.working = working;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", depart=" + depart + ", working=" + working + "]";
	}
	

}
