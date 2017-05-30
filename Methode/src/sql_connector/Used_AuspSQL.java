package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Auspraegungen;
import Data.Used_auspr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Used_AuspSQL {

		private static PreparedStatement preStmt_usedAusp;
	
	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:mysql://localhost:3306/Kriterienkatalog?useSSL=false";
		String connectionUser = "root";
		String connectionPassword = "test1";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}
	
	public static  void set_usedAusp(int t, int x) {
		Connection conn = null;
		Statement stmt = null;
	
		//String query1= "update kriterienkatalog.mont_op  set montOP_name = ? where idProjekte=?";
		String query1= "insert kriterienkatalog.used_auspr  (idMonOP,idAuspr) values(?,?)";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		   // preStmt_Mont_Name.setString(1,t);
		   // preStmt_usedAusp.setInt(1,Mont_OPSQL.get_lastMontOPID());
		    preStmt_usedAusp.setInt(1,x);
		    preStmt_usedAusp.setInt(2,t);
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	}
	public static  int get_lastusedAuspID() {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		
		String query= "SELECT max(idused_Auspr) FROM kriterienkatalog.used_auspr ";
		
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
	
	
	
	public static  void delete_lastRow() {
		Connection conn = null;
		Statement stmt = null;
	
		
		String query1= "DELETE  FROM kriterienkatalog.used_auspr  WHERE idused_Auspr=?";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		    preStmt_usedAusp.setInt(1,get_lastusedAuspID());
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		
	
	}
	
	public static  void update_usedAusp(int t) {
		Connection conn = null;
		Statement stmt = null;
	
		String query1= "update kriterienkatalog.used_auspr set Auspr_id =? where idused_Auspr=?;";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		    
		    preStmt_usedAusp.setInt(1,t);
		    preStmt_usedAusp.setInt(2,get_lastusedAuspID());
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	}

	public static  void update_usedAusp(int t,double ratingFM, double ratingFR,boolean relevant ,int usedAusPrId) {
		Connection conn = null;
		Statement stmt = null;
	
		String query1= "update kriterienkatalog.used_auspr set idAuspr =? ,ratingFM=? ,ratingFR=?, relevant=? where idused_Auspr=?;";
		try {
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		    
		    preStmt_usedAusp.setInt(1,t);
		    preStmt_usedAusp.setDouble(2,ratingFM);
		    preStmt_usedAusp.setDouble(3,ratingFR);
		    preStmt_usedAusp.setBoolean(4,relevant);
		    preStmt_usedAusp.setInt(5,usedAusPrId);
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	}

	public static  int get_minAuspID(int opID) {
		int id=0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs   =null;
		
		String query= "SELECT min(idused_Auspr) FROM kriterienkatalog.used_auspr where idMonOP=?;";
		
		try {
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query);
		    preStmt_usedAusp.setInt(1,opID);
		    preStmt_usedAusp.execute();
		 
		    rs =preStmt_usedAusp.getResultSet();
		    
		 
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
	
	public static  ArrayList<Used_auspr> giveRelevant(int opID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query= "SELECT * FROM kriterienkatalog.used_auspr where relevant=1 and idMonOP=?;";
		ArrayList<Used_auspr> Used_ausprarray= new ArrayList<Used_auspr>();
		try {
		
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);*/
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query);
		    preStmt_usedAusp.setInt(1,opID);
		    preStmt_usedAusp.execute();
		 
		    rs =preStmt_usedAusp.getResultSet();
			
			
			while (rs.next()) {
				Used_auspr Used_ausprobj= new Used_auspr();
				Used_ausprobj.idused_Auspr= rs.getInt("idused_Auspr");
				Used_ausprobj.idMonOP= rs.getInt("idMonOP");
				Used_ausprobj.idAuspr= rs.getInt("idAuspr");
				Used_ausprobj.ratingFM= rs.getDouble("ratingFM");
				Used_ausprobj.ratingFR= rs.getDouble("ratingFR");
				Used_ausprobj.relevant= rs.getBoolean("relevant");
				Used_ausprobj.gewichtung=rs.getInt("gewichtung");
				Used_ausprarray.add(Used_ausprobj);
			}
		    
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return Used_ausprarray;
		
	}
	
	public static  void update_Relevant(boolean relevant ,int usedAusPrId) {
		Connection conn = null;
		Statement stmt = null;
	
		String query1= "update kriterienkatalog.used_auspr set relevant=? where idused_Auspr=?;";
		try {
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		    
		 
		    preStmt_usedAusp.setBoolean(1,relevant);
		    preStmt_usedAusp.setInt(2,usedAusPrId);
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	}
	public static  void update_Gewichtung(int weight ,int usedAusPrId) {
		Connection conn = null;
		Statement stmt = null;
	
		String query1= "update kriterienkatalog.used_auspr set gewichtung=? where idused_Auspr=?  and relevant=1;";
		try {
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = get_connection();
		   
		    preStmt_usedAusp = conn.prepareStatement(query1);
		    
		 
		    preStmt_usedAusp.setInt(1,weight);
		    preStmt_usedAusp.setInt(2,usedAusPrId);
		    preStmt_usedAusp.execute();
		   
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
	}
	
	
	
}
