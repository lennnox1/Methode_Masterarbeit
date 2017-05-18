package sql_connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Kriterien;
import Data.Projekte;

//import com.mysql.jdbc.Driver;

public class Krit_SQL {

	public static PreparedStatement preStmt_Krit;
	
	
	
	
	
	
	public static  ArrayList<Kriterien> giveKrits() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Kriterien> Kritarray= new ArrayList<Kriterien>();
		try {
			//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kriterien ");
			while (rs.next()) {
				Kriterien Kritobj= new Kriterien();
				Kritobj.Krit_id = rs.getInt("Krit_id");
				Kritobj.Krit_Nr = rs.getString("Krit_Nr");
				Kritobj.Krit_Beschreibung = rs.getString("Krit_Beschreibung");
				Kritarray.add(Kritobj);
				//	System.out.println("ID: " + Krit_id + ", Krit_Nr: " + Krit_nr
				//		+ ", Anzahl Ausprägungen: " + Krit_Ausp_anzahl+" Beschreibung: "+ Krit_Beschreibung);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return Kritarray;

	}

	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}

	public static  Kriterien giveKrit(int r) {
		Kriterien retKrit= null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String Krit_Beschreibung = "unbekannt";
		try {
			//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kriterien   WHERE Krit_id = " + r);
			///rs = stmt.executeQuery("SELECT * FROM kriterien  ");
			while (rs.next()) {
				retKrit = new Kriterien();
				retKrit.Krit_id = rs.getInt("Krit_id");
				retKrit.Krit_Nr = rs.getString("Krit_Nr");
				retKrit.Krit_Beschreibung = rs.getString("Krit_Beschreibung");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return retKrit;

	}

	public static  ArrayList<Kriterien> giveKritzuKritID(int id) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Kriterien> Kritarray= new ArrayList<Kriterien>();
		String query= "SELECT * FROM kriterienkatalog.kriterien   WHERE Krit_id = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		    
		     preStmt_Krit = conn.prepareStatement(query);
		     preStmt_Krit.setInt(1,id);
		     preStmt_Krit.execute();
		     rs = preStmt_Krit.executeQuery();
		    while (rs.next()) {

		    	Kriterien Kritobj= new Kriterien();
		    	Kritobj.Krit_id = rs.getInt("Krit_id");
		    	Kritobj.Krit_Nr = rs.getString("Krit_Nr");
		    	Kritobj.Krit_Beschreibung = rs.getString("Krit_Beschreibung");
				Kritarray.add(Kritobj);
				
		    				  }


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return Kritarray;

	}




}
