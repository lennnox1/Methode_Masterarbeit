package sql_connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Auspraegungen;
import Data.Kriterien;

//import com.mysql.jdbc.Driver;

public class Ausp_SQL {
	
	public static  ArrayList<Auspraegungen> giveAuspraegungen() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Auspraegungen> Ausparray= new ArrayList<Auspraegungen>();
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
//// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM auspraegungen ");
			while (rs.next()) {
				Auspraegungen Auspobj= new Auspraegungen();
				Auspobj.Krit_id = rs.getInt("Krit_id");
				Auspobj.Auspr_id = rs.getInt("Auspr_id");
				Auspobj.Auspr_Beschreibung = rs.getString("Auspr_Beschreibung");
				Auspobj.Auspr_Nr = rs.getString("Auspr_Nr");
				Ausparray.add(Auspobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Ausparray;
		
	}

	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}
	public static  String giveAusp(int r) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String Ausp_Beschreibung = "unbekannt";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Auspraegungen   WHERE Auspr_id = " + r);
			while (rs.next()) {
				//String Krit_id = rs.getString("Krit_id");
				//String Krit_nr = rs.getString("Krit_Nr");
				Ausp_Beschreibung = rs.getString("Auspr_Beschreibung");
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Ausp_Beschreibung;
		
	}

}
