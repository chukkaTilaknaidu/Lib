package jdbcfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {

	private Jdbc() {
	}

	static {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Sucessfully");

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		// String
		// path="C:\\Users\\tilak\\eclipse-workspace\\JavaTransactionApp\\transaction.properties";
		String path = "C:\\Users\\tilak\\eclipse-workspace\\Lib\\src\\main\\java\\jdbcfiles\\db.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pr = new Properties();
		pr.load(fis);
		String url = pr.getProperty("url");
		String user = pr.getProperty("user");
		String password = pr.getProperty("password");
		return DriverManager.getConnection(url, user, password);

	}

	public static void main(String[] args) {

	}

}
