package sql_connector;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Solution_SQL {

	public static PreparedStatement preStmt_Solution;
	
	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}
	
	public static  void update_FMFR(BigDecimal FM, BigDecimal FR, int idMontOP) {
		Connection conn = null;
		Statement stmt = null;
	
		//String query= "update kriterienkatalog.kriterienkataloge set anz_Auspr=? where idKriterienkataloge=?;";
		
		String query= "update kriterienkatalog.mont_op set FM=?, FR=?  where idmontOP=?";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_Solution = conn.prepareStatement(query);
		    preStmt_Solution.setBigDecimal(1,FM);
		    preStmt_Solution.setBigDecimal(2,FR);
		    preStmt_Solution.setInt(3,idMontOP);
		    preStmt_Solution.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		
	
}
}
