package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Mont_OP;
//import Data.Projekte;
//import Data.Used_auspr;

public class Mont_OPSQL {

	public static PreparedStatement preStmt_Mont_Name;	
	
	
	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}




	public static  ArrayList<Mont_OP> giveMontOP() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kriterienkatalog.mont_op ");
			while (rs.next()) {
				Mont_OP Mont_OPobj= new Mont_OP();
				Mont_OPobj.idmontOP = rs.getInt("idmontOP");
				Mont_OPobj.montOP_name = rs.getString("montOP_name");
				Mont_OPobj.idProjekte = rs.getInt("idProjekte");
				Mont_OParray.add(Mont_OPobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); }     catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return Mont_OParray;

	}


	public static  int get_lastMontOPID() {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;

		String query= "SELECT max(idmontOP) FROM kriterienkatalog.mont_op";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);


			if (rs.next()) {
				id = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return id;
	}

	public static  ArrayList<Mont_OP> get_lastMontOP() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
		String query= "SELECT * FROM kriterienkatalog.mont_op WHERE idProjekte=(SELECT max(idProjekte) FROM kriterienkatalog.mont_op )";
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Mont_OP Mont_OPobj= new Mont_OP();
				Mont_OPobj.idmontOP = rs.getInt("idmontOP");
				Mont_OPobj.montOP_name = rs.getString("montOP_name");
				Mont_OPobj.idProjekte = rs.getInt("idProjekte");
				Mont_OPobj.FM = rs.getBigDecimal("FM");
				Mont_OPobj.FR = rs.getBigDecimal("FR");
				Mont_OParray.add(Mont_OPobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return Mont_OParray;
	}

	public static  void set_Montage_Name(String montOPName) {
		Connection conn = null;
		Statement stmt = null;
	
		
		String query= "insert kriterienkatalog.mont_op  (montOP_name,idProjekte) values(?,?)";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_Mont_Name = conn.prepareStatement(query);
		    preStmt_Mont_Name.setString(1,montOPName);
		    preStmt_Mont_Name.setInt(2,New_project_SQL.get_lastProjID());
		    preStmt_Mont_Name.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		
	
}
	public static  ArrayList<Mont_OP>  get_MontOPzuProjekt(int idProjekte) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		
		ArrayList<Mont_OP> Mont_OParray= new ArrayList<Mont_OP>();
		
		String query= "select * FROM kriterienkatalog.mont_op   WHERE idProjekte =? ";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		    preStmt_Mont_Name = conn.prepareStatement(query);
		    preStmt_Mont_Name.setInt(1,idProjekte);
		    preStmt_Mont_Name.execute();
			
			rs = preStmt_Mont_Name.executeQuery();

			
			while (rs.next()) {
				Mont_OP Mont_OPobj= new Mont_OP();
				Mont_OPobj.idmontOP = rs.getInt("idmontOP");
				Mont_OPobj.montOP_name= rs.getString("montOP_name");
				Mont_OPobj.idProjekte= rs.getInt("idProjekte");
				Mont_OPobj.FM=rs.getBigDecimal("FM");
				Mont_OPobj.FR=rs.getBigDecimal("FR");
				Mont_OParray.add(Mont_OPobj);
		
			}
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	return Mont_OParray;
	}	
	
}
