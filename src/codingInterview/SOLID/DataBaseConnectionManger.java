package codingInterview.SOLID;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionManger {

	private Connection con = null;
	private static DataBaseConnectionManger instance = null;

	private DataBaseConnectionManger() {

	}

	static DataBaseConnectionManger getInstance() {
		return instance;

	}

	public Connection getConnectionInstance() {
		return con;
	}

	public boolean saveEmployee(Employee e) {
		return true;
	}

	public boolean deleteEmployee(Employee e) {
		return true;

	}

	public boolean connect() throws SQLException {
		return true;
	}

	public boolean disconnect() throws SQLException {
		return true;

	}

}
