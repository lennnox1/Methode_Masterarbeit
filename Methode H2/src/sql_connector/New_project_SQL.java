package sql_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Data.Projekte;

import java.sql.PreparedStatement;

public class New_project_SQL {
	public static PreparedStatement preStmt_Mont_Nr;
	public static PreparedStatement preStmt_Mont_Name;
	
	protected static Connection get_connection() throws SQLException {
	Connection conn;
	String connectionUrl = "jdbc:h2:~/Kriterienkatalog";
	String connectionUser = "root";
	String connectionPassword = "1234";
	conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	return conn;
}
	
	

	
	
	
	public static  String  createProject(String r) {
		Connection conn = null;
		Statement stmt = null;
		
		String query = " insert into projekte (Projekt_name)" + " values (?)"; 
		try {

			Class.forName("org.h2.Driver").newInstance();
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

	//public static  int set_Montage_Nr(int t, String r) {
		public static  int set_Montage_Nr(int anzMontOP) {
			Connection conn = null;
			Statement stmt = null;
		
			String query= "update  projekte  set Anz_Montageop = ? where idProjekte=?";
			
			try {

				
				Class.forName("org.h2.Driver").newInstance();
			    conn = get_connection();
			   
			    preStmt_Mont_Nr = conn.prepareStatement(query);
			    preStmt_Mont_Nr.setInt(1,anzMontOP);
			    preStmt_Mont_Nr.setInt(2,get_lastProjID());
			    preStmt_Mont_Nr.execute();
			   
			    
			    
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			return anzMontOP;
		
	}
	
		public static  int get_lastProjID() {
			int id=0;
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs   =null;
			
			String query= "SELECT max(idProjekte) FROM projekte ";
			
			try {

				Class.forName("org.h2.Driver").newInstance();
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
	
		public static  ArrayList<Projekte> giveAnzMOPZuLastID() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Projekte> Projectsarray= new ArrayList<Projekte>();
			try {
			
				Class.forName("org.h2.Driver").newInstance();
	
				conn = get_connection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM projekte where idProjekte= " + get_lastProjID());
				while (rs.next()) {
					Projekte Projektobj= new Projekte();
					Projektobj.idProjekte = rs.getInt("idProjekte");
					Projektobj.Projekt_name = rs.getString("Projekt_name");
					Projektobj.Anz_Montageop= rs.getInt("Anz_Montageop");
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
		
		
		/*public static  ArrayList<Projekte> giveMontage_Nr(String r) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Projekte> Projectsarray= new ArrayList<Projekte>();
			String query1= "SELECT * FROM projekte   WHERE Projekt_name =?";
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn = get_connection();
			    
			    preStmt_Mont_Nr = conn.prepareStatement(query1);
			    preStmt_Mont_Nr.setString(1, r);
			    preStmt_Mont_Nr.execute();
			     rs = preStmt_Mont_Nr.executeQuery();
			    while (rs.next()) {

			    	Projekte Projektobj= new Projekte();
					Projektobj.idProjekte = rs.getInt("idProjekte");
					Projektobj.Projekt_name = rs.getString("Projekt_name");
					Projektobj.Anz_Montageop= rs.getInt("Anz_Montageop");
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
			
		}*/
	
		
		
		public static  void set_katID(int idKat) {
			Connection conn = null;
			Statement stmt = null;
		
			String query1= "update  projekte  set idKriterienkataloge = ? where idProjekte=?";
			
			try {

				Class.forName("org.h2.Driver").newInstance();
			    conn = get_connection();
			   
			    preStmt_Mont_Nr = conn.prepareStatement(query1);
			    preStmt_Mont_Nr.setInt(1,idKat);
			    preStmt_Mont_Nr.setInt(2,get_lastProjID());
			    preStmt_Mont_Nr.execute();
			   
			    
			    
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}
			
		
	}	
		
	
		
		
		
		
}
