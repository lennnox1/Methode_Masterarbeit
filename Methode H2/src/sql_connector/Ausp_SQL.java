package sql_connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Auspraegungen;




public class Ausp_SQL {

	/*protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}*/
	
	protected static Connection get_connection() throws SQLException {
	Connection conn;
	String connectionUrl = "jdbc:h2:~/Kriterienkatalog";
	String connectionUser = "root";
	String connectionPassword = "1234";
	conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	return conn;
}
	
	
	
	
	public static  Auspraegungen giveAusp(int r) {
		Auspraegungen retAusp = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM auspraegungen   WHERE idAuspr = " + r);
			while (rs.next()) {
				retAusp = new Auspraegungen();
				retAusp.idKrit  = rs.getInt("idKrit");
				retAusp.idAuspr = rs.getInt("idAuspr");
				retAusp.Auspr_Nr = rs.getString("Auspr_Nr");
				retAusp.Auspr_Beschreibung = rs.getString("Auspr_Beschreibung");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}
		return retAusp;

	}

	
	
	
	public static  ArrayList<Auspraegungen> giveAuspraegungenZuKrit(int krit_nr) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Auspraegungen> Ausparray= new ArrayList<Auspraegungen>();
		try {
			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM auspraegungen where idKrit=" + krit_nr );
			while (rs.next()) {
				Auspraegungen Auspobj= new Auspraegungen();
				Auspobj.idKrit = rs.getInt("idKrit");
				Auspobj.idAuspr = rs.getInt("idAuspr");
				Auspobj.Auspr_Beschreibung = rs.getString("Auspr_Beschreibung");
				Auspobj.Auspr_Nr = rs.getString("Auspr_Nr");
				Auspobj.ratingFM = rs.getDouble("ratingFM");
				Auspobj.ratingFR = rs.getDouble("ratingFR");
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

}
