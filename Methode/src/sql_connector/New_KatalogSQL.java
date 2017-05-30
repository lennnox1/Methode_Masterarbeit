package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Ausp_LPS;
import Data.Auspraegungen;
import Data.Krit_LPS;
import Data.Kriterien;
import Data.Kriterienkataloge;
import Data.Mont_OP;

public class New_KatalogSQL {

	private static PreparedStatement preStmt_kritKatalog;

	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}


	public static  void set_KatalogName(String katalogName) {
		Connection conn = null;
		Statement stmt = null;


		String query= "insert kriterienkatalog.kriterienkataloge  (katalog_Name) values(?)";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);
			preStmt_kritKatalog.setString(1,katalogName);
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}
	public static  void update_anzKrit(int anz_Krit) {
		Connection conn = null;
		Statement stmt = null;

		String query= "update kriterienkatalog.kriterienkataloge set anz_Krit =? where idKriterienkataloge=?;";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);

			preStmt_kritKatalog.setInt(1,anz_Krit);
			preStmt_kritKatalog.setInt(2,get_lastKatalogID());
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}
	public static  int get_lastKatalogID() {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;

		String query= "SELECT max(idKriterienkataloge) FROM kriterienkatalog.kriterienkataloge ";

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

	public static  ArrayList<Kriterienkataloge> get_lastKatalog() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Kriterienkataloge> KritKatalogArray= new ArrayList<Kriterienkataloge>();

		String query= "SELECT * FROM kriterienkatalog.kriterienkataloge WHERE idKriterienkataloge=(SELECT max(idKriterienkataloge) FROM kriterienkatalog.kriterienkataloge )";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Kriterienkataloge KritKat_obj= new Kriterienkataloge();
				KritKat_obj.idKriterienkataloge = rs.getInt("idKriterienkataloge");
				KritKat_obj.katalog_Name = rs.getString("katalog_Name");
				KritKat_obj.anz_Krit	=rs.getInt("anz_Krit");

				KritKatalogArray.add(KritKat_obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return KritKatalogArray;
	}

	public static  void update_KritKatalog(String krit_Beschreibug, int idKrit) {
		Connection conn = null;
		Statement stmt = null;

		String query= "update kriterienkatalog.kriterien set Krit_Beschreibung =? where idKrit=?;";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);

			preStmt_kritKatalog.setString(1, krit_Beschreibug);
			preStmt_kritKatalog.setInt(2,idKrit);
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}


	public static  void set_Kriterien(String krit_Nr) {
		Connection conn = null;
		Statement stmt = null;
		
		String query= "insert kriterienkatalog.kriterien  (idKriterienkataloge,Krit_Nr) values(?,?)";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);
			preStmt_kritKatalog.setInt(1,get_lastKatalogID());
			preStmt_kritKatalog.setString(2, krit_Nr);
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}

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
				Kritobj.Krit_Nr= rs.getString("Krit_Nr");
				Kritobj.Krit_Beschreibung = rs.getString("Krit_Beschreibung");
				Kritobj.idKriterienkataloge= rs.getInt("idKriterienkataloge");
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
	
	
	public static  ArrayList<Kriterien> get_KritsofKatID(int idKritKat) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Kriterien> KritArray= new ArrayList<Kriterien>();

		String query= "SELECT * FROM kriterienkatalog.kriterien WHERE idKriterienkataloge=?";

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);
			preStmt_kritKatalog.setInt(1,idKritKat);
			preStmt_kritKatalog.execute();
			
			rs = preStmt_kritKatalog.executeQuery();
			
			while (rs.next()) {
				Kriterien Krit_obj= new Kriterien();
				Krit_obj.idKrit = rs.getInt("idKrit");
				Krit_obj.Krit_Nr= rs.getString("Krit_Nr");
				Krit_obj.Krit_Beschreibung = rs.getString("Krit_Beschreibung");
				Krit_obj.idKriterienkataloge = rs.getInt("idKriterienkataloge");
				KritArray.add(Krit_obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return KritArray;
	}
	
	public static  void update_anzAusp(int anz_Ausp) {
		Connection conn = null;
		Statement stmt = null;

		String query= "update kriterienkatalog.kriterienkataloge set anz_Auspr=? where idKriterienkataloge=?;";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);

			preStmt_kritKatalog.setInt(1,anz_Ausp);
			preStmt_kritKatalog.setInt(2,get_lastKatalogID());
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}
	
	public static  void set_Ausp(int kritid,String auspr_Nr) {
		Connection conn = null;
		Statement stmt = null;
		
		String query= "insert kriterienkatalog.auspraegungen  (idKrit,Auspr_Nr) values(?,?)";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);
			preStmt_kritKatalog.setInt(1,kritid);
			preStmt_kritKatalog.setString(2, auspr_Nr);
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}
	public static  void update_Ausp(String ausp_Beschreibug, int idAusp) {
		Connection conn = null;
		Statement stmt = null;

		String query= "update kriterienkatalog.auspraegungen set Auspr_Beschreibung =? where idAuspr=?;";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);

			preStmt_kritKatalog.setString(1, ausp_Beschreibug);
			preStmt_kritKatalog.setInt(2,idAusp);
			preStmt_kritKatalog.execute();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
	}
	
	public static  ArrayList<Auspraegungen> get_AuspofKatID(int idKrit_LPS) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Auspraegungen> AuspArray= new ArrayList<Auspraegungen>();

		String query= "SELECT * FROM kriterienkatalog.auspraegungen WHERE idKrit=?";

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();

			preStmt_kritKatalog = conn.prepareStatement(query);
			preStmt_kritKatalog.setInt(1,idKrit_LPS);
			preStmt_kritKatalog.execute();
			
			rs = preStmt_kritKatalog.executeQuery();
			
			while (rs.next()) {
				Auspraegungen Ausp_obj= new Auspraegungen();
				Ausp_obj.idAuspr = rs.getInt("idAuspr");
				Ausp_obj.Auspr_Nr= rs.getString("Auspr_Nr");
				Ausp_obj.Auspr_Beschreibung = rs.getString("Auspr_Beschreibung");
				Ausp_obj.idKrit = rs.getInt("idKrit");
				AuspArray.add(Ausp_obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return AuspArray;
	}
	
	public static  ArrayList<Kriterienkataloge> get_Kataloge() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		ArrayList<Kriterienkataloge> KritKatalogArray= new ArrayList<Kriterienkataloge>();

		String query= "SELECT * FROM kriterienkatalog.kriterienkataloge ";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Kriterienkataloge KritKat_obj= new Kriterienkataloge();
				KritKat_obj.idKriterienkataloge = rs.getInt("idKriterienkataloge");
				KritKat_obj.katalog_Name = rs.getString("katalog_Name");
				KritKat_obj.anz_Krit	=rs.getInt("anz_Krit");

				KritKatalogArray.add(KritKat_obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


		return KritKatalogArray;
	}
}




