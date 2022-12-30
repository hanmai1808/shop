package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useSSL=false","han","123");
			System.out.println("ok");
			//userLegacyDatetimeCode=false&serverTimezone=UTC&
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cons;
	}
	public static void main(String[] args) {
	getConnection();
}

}
