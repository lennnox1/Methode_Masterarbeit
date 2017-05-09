package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class New_project_SQL {
	public static PreparedStatement preStmt_Mont_Nr;
	
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
		String query = " insert into projekte (Projekt_name)" + " values (?)"; 
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
			
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
		     preparedStmt.setString (1, r);
		     preparedStmt.execute();
		     
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return r;
	}

	public static  int set_Montage_Nr(int t, String r) {
			Connection conn = null;
			Statement stmt = null;
		
			//String query1 = " insert into projekte (Anz_Montageop)" + " values (?)";
			String query1= "update kriterienkatalog.projekte  set Anz_Montageop = ? where Projekt_name = ?";
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn = get_connection();
			    
			    preStmt_Mont_Nr = conn.prepareStatement(query1);
			    preStmt_Mont_Nr.setInt(1, t);
			    preStmt_Mont_Nr.setString(2,r);
			    preStmt_Mont_Nr.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			return t;
		
	}
	
	
	
	
	
	
	
}
