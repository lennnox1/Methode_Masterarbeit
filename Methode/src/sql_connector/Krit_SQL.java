package sql_connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Kriterien;




public class Krit_SQL {

	public static PreparedStatement preStmt_Krit;






	public static  ArrayList<Kriterien> giveKrits() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Kriterien> Kritarray= new ArrayList<Kriterien>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kriterienkatalog.kriterien ");
			while (rs.next()) {
				Kriterien Kritobj= new Kriterien();
				Kritobj.idKrit = rs.getInt("idKrit");
				Kritobj.Krit_Nr = rs.getString("Krit_Nr");
				Kritobj.Krit_Beschreibung = rs.getString("Krit_Beschreibung");
				Kritarray.add(Kritobj);
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
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kriterien   WHERE idKrit = " + r);
			while (rs.next()) {
				retKrit = new Kriterien();
				retKrit.idKrit = rs.getInt("idKrit");
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
		String query= "SELECT * FROM kriterienkatalog.kriterien   WHERE idKrit = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_Krit = conn.prepareStatement(query);
			preStmt_Krit.setInt(1,id);
			preStmt_Krit.execute();
			rs = preStmt_Krit.executeQuery();
			while (rs.next()) {

				Kriterien Kritobj= new Kriterien();
				Kritobj.idKrit = rs.getInt("idKrit");
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


	public static Kriterien giveKrit(int kritNr, int katID) {
		Kriterien retKrit= null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		String query= "SELECT * FROM kriterienkatalog.kriterien   WHERE idKrit = ? and idKriterienkataloge=?";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_Krit = conn.prepareStatement(query);
			preStmt_Krit.setInt(1,kritNr);
			preStmt_Krit.setInt(2,katID);
			preStmt_Krit.execute();
			rs = preStmt_Krit.executeQuery();
			while (rs.next()) {

				retKrit = new Kriterien();
				retKrit.idKrit = rs.getInt("idKrit");
				retKrit.Krit_Nr = rs.getString("Krit_Nr");
				retKrit.Krit_Beschreibung = rs.getString("Krit_Beschreibung");

			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return retKrit;

	}

	
	public static ArrayList<Kriterien> giveKrits(int katID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Kriterien> Kritarray= new ArrayList<Kriterien>();
		String query= "SELECT * FROM kriterienkatalog.kriterien   WHERE idKriterienkataloge=?";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			preStmt_Krit = conn.prepareStatement(query);
			preStmt_Krit.setInt(1,katID);
			preStmt_Krit.execute();
			rs = preStmt_Krit.executeQuery();
			while (rs.next()) {
				Kriterien Kritobj= new Kriterien();
				Kritobj.idKrit = rs.getInt("idKrit");
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
	
	public static  int get_minKritID(int idKat) {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		
		String query= "SELECT min(idKrit) FROM kriterienkatalog.kriterien  where idKriterienkataloge=?";
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_Krit = conn.prepareStatement(query);
			preStmt_Krit.setInt(1,idKat);
			preStmt_Krit.execute();
			
			rs = preStmt_Krit.executeQuery();
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
	
	public static  int get_maxKritID(int idKat) {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		
		String query= "SELECT max(idKrit) FROM kriterienkatalog.kriterien  where idKriterienkataloge=?";
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_Krit = conn.prepareStatement(query);
			preStmt_Krit.setInt(1,idKat);
			preStmt_Krit.execute();
			
			rs = preStmt_Krit.executeQuery();
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
	
}
