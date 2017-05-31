package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Data.Projekte;

public class list_projectsSQL {
	public static PreparedStatement preStmt_Mont_Nr;
	
	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}
	
	public static  ArrayList<Projekte> giveProjects() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Projekte> Projectsarray= new ArrayList<Projekte>();
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
//// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM projekte ");
			while (rs.next()) {
				Projekte Projektobj= new Projekte();
				Projektobj.idProjekte = rs.getInt("idProjekte");
				Projektobj.Projekt_name = rs.getString("Projekt_name");
				Projectsarray.add(Projektobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Projectsarray;
		
	}
	public static  int giveMontage_Nr(String r) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int Mont_Nr=0;
		String query1= "SELECT Anz_Montageop FROM projekte   WHERE Projekt_name =?";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		    
		    preStmt_Mont_Nr = conn.prepareStatement(query1);
		    preStmt_Mont_Nr.setString(1, r);
		    preStmt_Mont_Nr.execute();
		    rs = preStmt_Mont_Nr.executeQuery();
		    while (rs.next()) {

		    	Mont_Nr = rs.getInt("Anz_Montageop");
				
		    				  }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Mont_Nr;
		
	}
	
public static  ArrayList<Projekte> get_lastProject() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Projekte> Projektarray= new ArrayList<Projekte>();
		String query= "SELECT * FROM kriterienkatalog.projekte WHERE idProjekte=(SELECT max(idProjekte) FROM kriterienkatalog.projekte )";
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Projekte Projobj= new Projekte();
				Projobj.idProjekte = rs.getInt("idProjekte");
				Projobj.Projekt_name = rs.getString("Projekt_name");
				Projobj.idKriterienkataloge = rs.getInt("idKriterienkataloge");
				
				Projektarray.add(Projobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return Projektarray;
	}
}
