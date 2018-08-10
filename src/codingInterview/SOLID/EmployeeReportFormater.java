package codingInterview.SOLID;

public class EmployeeReportFormater extends ReportFormatter {

	public EmployeeReportFormater(Employee obj, FormatType f) {
		super(obj, f);
		// TODO Auto-generated constructor stub
	}

	public String getFormatedValue() {
		return super.getFormateOutput();
	}

}
