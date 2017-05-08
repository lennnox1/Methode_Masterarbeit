package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class New_project_SQL {

	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}
	
	public static  String createProject(String r) {
		Connection conn = null;
		Statement stmt = null;
		String Test= null;
	    Test = String.format("CREATE TABLE %s("
	            + "idNo INT(64) NOT NULL AUTO_INCREMENT,"  
	            + "initials VARCHAR(2)," 
	            + "agentDate DATE,"  
	            + "agentCount INT(64), "
	            + "PRIMARY KEY(idNo))",r);  
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(Test);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Test;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
