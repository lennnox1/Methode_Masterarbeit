package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Mont_OP;

public class Mont_OPSQL {

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
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
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
		int id=0;
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
