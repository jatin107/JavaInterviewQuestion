package codingInterview.SOLID;

public class ReportFormatter {
	String formattedOutput;

	protected  String getFormateOutput()
	{
		return formattedOutput;
	}

	public ReportFormatter(Object obj, FormatType f) {
		switch (f) {
		case XML:
			formattedOutput = convertObjecttoXML(obj);
			break;
		case CSV:
			formattedOutput = convertObjecttoCSV(obj);
			break;
		}

	}

	private String convertObjecttoXML(Object e) {
		return "XML: <Tag>" + e.toString() + "</Tag>";
	}

	private String convertObjecttoCSV(Object e) {
		return "CSV:,,,," + e.toString() + "</Tag>";
	}
}
