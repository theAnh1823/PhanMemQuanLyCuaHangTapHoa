package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	private static final String DATABASE_URL = "jdbc:sqlserver://AD:1433;databaseName=CuaHangTapHoa;encrypt=false";
    private static final String DATABASE_USER_NAME = "sa";
    private static final String DATABASE_PASSWORD = "123456789";
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
    }
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
