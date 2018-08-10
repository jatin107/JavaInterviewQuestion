package codingInterview.SOLID;

public class ClientModule {

	public static void hireEmployee(Employee e) throws Exception {
		EmployeeDAO edao = new EmployeeDAO();
		edao.saveEmployee(e);

	}

	public static void terminateEmployee(Employee e) {
		EmployeeDAO edao = new EmployeeDAO();
		edao.deleteEmployee(e);

	}
	public static void printEmplyeeReport(Employee e,FormatType f) {
		EmployeeReportFormater erf=new EmployeeReportFormater(e,f);
		System.out.println(erf.getFormatedValue());

	}

	public static void main(String[] args) throws Exception {

		Employee e = new Employee(1, "Jatin", "IT", true);
		ClientModule.hireEmployee(e);
		printEmplyeeReport(e,FormatType.CSV);

	}

}
