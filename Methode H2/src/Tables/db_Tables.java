package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_Tables {

	protected static Connection get_connection() throws SQLException {
		Connection conn;
		String connectionUrl = "jdbc:h2:~/Kriterienkatalog";
		String connectionUser = "root";
		String connectionPassword = "1234";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		return conn;
	}


	public static  void table_Kriterienkataloge() {

		Connection conn = null;
		Statement stmt = null;


		String table = "CREATE TABLE `kriterienkataloge` ( "
				+ "`idKriterienkataloge` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`katalog_Name` varchar(500) DEFAULT NULL,"
				+ "`anz_Krit` int(11) DEFAULT NULL,"
				+ "PRIMARY KEY (`idKriterienkataloge`)"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;";
		
		String insert= "INSERT INTO `kriterienkataloge` VALUES "
				+ "(1,'Katalog_LPS4',4),(2,'Beumelburg',22);";
		boolean tabellevorhanden = false;
		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
		} catch (Exception e) {
			tabellevorhanden = true;
		} finally {
			
			if (!tabellevorhanden)
				try {
					stmt.executeUpdate(insert);
					stmt.close();
					conn.close();

				}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}

	}


	public static  void table_Kriterien() {

		Connection conn = null;
		Statement stmt = null;


		String table = "CREATE TABLE  `kriterien` ("
				+ "`idKrit` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`Krit_Nr` varchar(500) DEFAULT NULL,"
				+ "`Krit_Beschreibung` varchar(500) DEFAULT NULL,"
				+ " `idKriterienkataloge` int(11) DEFAULT NULL,"
				+ "PRIMARY KEY (`idKrit`))";

		String insert= "INSERT INTO `kriterien` VALUES "
				+ "(1,'K1','Möglichkeit des Verhakens beim Fügen',1),"
				+ "(2,'K2','Während des Fügens Parallelprozess sichern',1),"
				+ "(3,'K3','Sichern nach dem Fügen',1),"
				+ "(4,'K4','Kontakt Werkstück / Fügeteile (einzelne Bauteile sollen zueinander "
				+ "eine möglichst geringe Anzahl Fügestellen haben)',1),(5,'K1','Möglichkeit "
				+ "des Verhakens beim Fügen',2),(6,'K2','Während des Fügens "
				+ "Parallelprozess sichern',2),(7,'K3','Sichern nach dem Fügen',2),"
				+ "(8,'K4','Kontakt Werkstück / Fügeteile (einzelne Bauteile sollen "
				+ "zueinander eine möglichst geringe Anzahl Fügestellen haben)',2),"
				+ "(9,'K5','Zusätzliche Prozessschritte durch Anpassarbeiten "
				+ "(z.B. Durch mangelnde Bauteilqualität)',2),(10,'K6','Prozesskontrolle,"
				+ " sensorische',2),(11,'K7','Umrüstaufwand für Prozesseinrichtung',2),"
				+ "(12,'K8','Fügebewegung (möglichst einfach)',2),(13,'K9','Fügepassungen',2),"
				+ "(14,'K10','Sensorische Unterstützung des Prozesses Fähigkeiten',2),"
				+ "(15,'K11','Hilfs-/ Betriebs-/ Werkstoffe gesundheitsschädlich',2),"
				+ "(16,'K12','Schadstoffeinwirkung von Luftinhaltsstoffen "
				+ "( Stäube, Rauche, Nebel, Gase, Dämpfe,…)',2),(17,'K13','Bauteiltemperatur',2),"
				+ "(18,'K14','Physiologische Dauerbelastung des Menschen bei schwerer "
				+ "dynamischer Muskelarbeit',2),(19,'K15','Lärmbelästigung am Arbeitsplatz',2)"
				+ ",(20,'K16','Zugänglichkeit des Fügeorts',2),(21,'K17','Greif- und/oder "
				+ "Zentriermöglichkeiten der Bauteile',2),(22,'K18','Oberflächenempfindlichkeit"
				+ " des Bauteils',2),(23,'K19','Steifigkeit des Fügeteils',2),"
				+ "(24,'K20','Steifigkeit des Basisteils',2),"
				+ "(25,'K21','Prozessanpassung aufgrund der Bauteiltoleranz',2),"
				+ "(26,'K22','Bereitstellung der Basis- /Fügeteile',2)";
		boolean tabellevorhanden = false;
		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
		
		} catch (Exception e) {
			tabellevorhanden = true;
		} finally {
			
			if (!tabellevorhanden)
				try {
					stmt.executeUpdate(insert);
					stmt.close();
					conn.close();

				}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}


	}

	public static  void table_projekte() {

		Connection conn = null;
		Statement stmt = null;


		String table="CREATE TABLE IF NOT EXISTS `projekte` ("
				+ "`idProjekte` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`Projekt_name` varchar(200) DEFAULT NULL,"
				+ "`Anz_Montageop` int(11) DEFAULT NULL,"
				+ "`idKriterienkataloge` int(11) DEFAULT NULL,"
				+ "PRIMARY KEY (`idProjekte`))";



		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}

	}

	public static  void table_auspraegungen() {

		Connection conn = null;
		Statement stmt = null;


		String table= "CREATE TABLE `auspraegungen` ("
				+ " `idAuspr` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`Auspr_Nr` varchar(200) NOT NULL,"
				+ "`Auspr_Beschreibung` varchar(200) DEFAULT NULL,"
				+ "`idKrit` int(11) DEFAULT NULL,"
				+ "`ratingFM` double DEFAULT NULL,"
				+ "`ratingFR` double DEFAULT NULL,"
				+ "PRIMARY KEY (`idAuspr`))";

		String insert="INSERT INTO `auspraegungen` VALUES (1,'A11','Ja',1),"
				+ "(2,'A12','Nein',1),(3,'A21','Nötig',2),"
				+ "(4,'A22','Nicht nötig',2),(5,'A31','Nötig',3),"
				+ "(6,'A32','Nicht nötig',3),(7,'A41','Einstellenkontakt',4),"
				+ "(8,'A42','Mehrstellenkontakt: Ausrichten mehrerer Einzelelemente erforderlich',4)"
				+ ",(9,'A43','Mehrstellenkontakt: System starr, Fügepassung > Werkstücktoleranz',4),"
				+ "(10,'A11','Ja',5),(11,'A12','Nein',5),"
				+ "(12,'A21','Nötig',6),(13,'A22','Nicht nötig',6),"
				+ "(14,'A31','Nötig',7),(15,'A32','Nicht nötig',7),"
				+ "(16,'A41','Einstellenkontakt',8),(17,'A42','Mehrstellenkontakt: "
				+ "Ausrichten mehrerer Einzelelemente erforderlich',8),"
				+ "(18,'A43','Mehrstellenkontakt: System starr, "
				+ "Fügepassung > Werkstücktoleranz',8),"
				+ "(19,'A51','nicht erforderlich',9),("
				+ "20,'A52','teilweise erforderlich',9),"
				+ "(21,'A61','nicht nötig',10),(22,'A62','von Mensch "
				+ "und Roboter durchführbar',10),(23,'A63','vom Menschen durchführbar,"
				+ " Robotersysteme benötigen Zusatzinvest',10),(24,'A64',"
				+ "'vom Roboter durchführbar, Mensch benötigt Zusatzinvest',10),"
				+ "(25,'A71','kein Umrüstaufwand',11),"
				+ "(26,'A72','Umrüstaufwand nur bei Automatisierung',11),"
				+ "(27,'A73','Umrüstaufwand automatisiert < manuell',11),"
				+ "(28,'A74','Umrüstaufwand automatisiert > manuell',11),"
				+ "(29,'A75','Umrüstaufwand automatisiert = manuell',11),"
				+ "(30,'A81','durch Bauteilgeometrie erzwungen',12),"
				+ "(31,'A82','durch Führung Fügewerkzeug',12),"
				+ "(32,'A91','Spielpassung',13),(33,'A92','Grenzpassung',13),"
				+ "(34,'A93','Übernaßpassung "
				+ "(ist jeweils nur durch Einlegen in eine Pressvorrichtung möglich)',13)"
				+ ",(35,'A101','nicht nötig',14),(36,'A102','visuelle Unterstützung nötig',14),"
				+ "(37,'A103','taktile Unterstützung nötig',14),(38,'A111','unschädlich',15),"
				+ "(39,'A112','bei Berührung',15),(40,'A113','bei Gegenwart',15),"
				+ "(41,'A121','aktuelle zulässige MAK-Werte nicht überschritten',16),"
				+ "(42,'A122','aktuelle zulässige MAK-Werte  überschritten',16),"
				+ "(43,'A131','T < 0 °C',17),(44,'A132','0 °C <  T <  44 °C',17),"
				+ "(45,'A133','T >= 44 °C',17),(46,'A141','gering',18),(47,'A142','mittel',18),"
				+ "(48,'A143','hoch',18),(49,'A151','LR < 85 dB(A)',19),"
				+ "(50,'A152','85 dB(A) < LR < 90 dB(A)',19),(51,'A153','LR > 90 dB(A)',19),"
				+ "(52,'A161','Sichtkontrolle und Werkzeugfreiräume gegeben',20),"
				+ "(53,'A162','keine Sichtkontrolle möglich, Werkzeugfreiräume gegeben',20),"
				+ "(54,'A163','Sichtkontrolle gegeben, keine Werkzeugfreiräume vorhanden',20),"
				+ "(55,'A164','keine Sichtkontrolle möglich, keine Werkzeugfreiräume vorhanden',20),"
				+ "(56,'A171','gegeben',21),(57,'A172','nicht gegeben',21),"
				+ "(58,'A181','Material unempfindlich',22),"
				+ "(59,'A182','Material kratz-, bruch-, formempfindlich',22),"
				+ "(60,'A191','starr',23),(61,'A192','elastisch',23),"
				+ "(62,'A193','biegeschlaff',23),(63,'A201','starr',24),"
				+ "(64,'A202','elastisch',24),(65,'A203','biegeschlaff',24),"
				+ "(66,'A211','ja ( Korrektur von Bauteilposition, Bauteilorientierung, "
				+ "Fügeposition, Fügeorientierung)',25),(67,'A212','nein',25),"
				+ "(68,'A221','positioniert und orientiert bereitgestellt',26),"
				+ "(69,'A222','einfach und prozesssicher automatisierbar',26),";
		
		String insert1 = "INSERT INTO `auspraegungen` VALUES "
				+ "(1,'A11','Ja',1,1,0),(2,'A12','Nein',1,0,1),"
				+ "(3,'A21','Nötig',2,1,0),(4,'A22','Nicht nötig',2,0,1),"
				+ "(5,'A31','Nötig',3,1,0),(6,'A32','Nicht nötig',3,0,1),"
				+ "(7,'A41','Einstellenkontakt',4,0.5,0.5),"
				+ "(8,'A42','Mehrstellenkontakt: Ausrichten mehrerer "
				+ "Einzelelemente erforderlich',4,1,0),"
				+ "(9,'A43','Mehrstellenkontakt: System starr, "
				+ "Fügepassung > Werkstücktoleranz',4,0,1),"
				+ "(10,'A11','Ja',5,1,0),(11,'A12','Nein',5,0,1),"
				+ "(12,'A21','Nötig',6,1,0),(13,'A22','Nicht nötig',6,0,1),"
				+ "(14,'A31','Nötig',7,1,0),(15,'A32','Nicht nötig',7,0,1),"
				+ "(16,'A41','Einstellenkontakt',8,0.5,0.5),"
				+ "(17,'A42','Mehrstellenkontakt: Ausrichten mehrerer "
				+ "Einzelelemente erforderlich',8,1,0),"
				+ "(18,'A43','Mehrstellenkontakt: System starr, "
				+ "Fügepassung > Werkstücktoleranz',8,0,1),"
				+ "(19,'A51','nicht erforderlich',9,0,1),"
				+ "(20,'A52','teilweise erforderlich',9,1,0),"
				+ "(21,'A61','nicht nötig',10,0.5,0.5),"
				+ "(22,'A62','von Mensch und Roboter durchführbar',"
				+ "10,0.5,0.5),(23,'A63','vom Menschen durchführbar,"
				+ " Robotersysteme benötigen Zusatzinvest',10,1,0),"
				+ "(24,'A64','vom Roboter durchführbar, Mensch benötigt "
				+ "Zusatzinvest',10,0,1),(25,'A71','kein Umrüstaufwand',11,0.5,0.5),"
				+ "(26,'A72','Umrüstaufwand nur bei Automatisierung',11,1,0),"
				+ "(27,'A73','Umrüstaufwand automatisiert < manuell',11,0,1),"
				+ "(28,'A74','Umrüstaufwand automatisiert > manuell',11,1,0),"
				+ "(29,'A75','Umrüstaufwand automatisiert = manuell',11,0.5,0.5),"
				+ "(30,'A81','durch Bauteilgeometrie erzwungen',12,0,1),"
				+ "(31,'A82','durch Führung Fügewerkzeug',12,1,0),"
				+ "(32,'A91','Spielpassung',13,0.5,0.5),"
				+ "(33,'A92','Grenzpassung',13,0.5,0.5),"
				+ "(34,'A93','Übernaßpassung (ist jeweils nur durch "
				+ "Einlegen in eine Pressvorrichtung möglich)',13,0.5,0.5),"
				+ "(35,'A101','nicht nötig',14,0.5,0.5),"
				+ "(36,'A102','visuelle Unterstützung nötig',14,0.5,0.5),"
				+ "(37,'A103','taktile Unterstützung nötig',14,0.5,0.5),"
				+ "(38,'A111','unschädlich',15,0.5,0.5),"
				+ "(39,'A112','bei Berührung',15,0.5,0.5),"
				+ "(40,'A113','bei Gegenwart',15,0.5,0.5),"
				+ "(41,'A121','aktuelle zulässige MAK-Werte nicht "
				+ "überschritten',16,0.5,0.5),(42,'A122','aktuelle"
				+ " zulässige MAK-Werte  überschritten',16,0,1),"
				+ "(43,'A131','T < 0 °C',17,0.5,0.5),"
				+ "(44,'A132','0 °C <  T <  44 °C',17,0.5,0.5),"
				+ "(45,'A133','T >= 44 °C',17,0.5,0.5),"
				+ "(46,'A141','gering',18,1,0),"
				+ "(47,'A142','mittel',18,0.5,0.5),"
				+ "(48,'A143','hoch',18,0,1),"
				+ "(49,'A151','LR < 85 dB(A)',19,0.5,0.5),"
				+ "(50,'A152','85 dB(A) < LR < 90 dB(A)',19,0.5,0.5),"
				+ "(51,'A153','LR > 90 dB(A)',19,0.5,0.5),"
				+ "(52,'A161','Sichtkontrolle und Werkzeugfreiräume gegeben',20,1,0),"
				+ "(53,'A162','keine Sichtkontrolle möglich, Werkzeugfreiräume gegeben',20,0,1),"
				+ "(54,'A163','Sichtkontrolle gegeben, keine Werkzeugfreiräume vorhanden',20,1,0),"
				+ "(55,'A164','keine Sichtkontrolle möglich, "
				+ "keine Werkzeugfreiräume vorhanden',20,0.5,0.5),"
				+ "(56,'A171','gegeben',21,0,1),(57,'A172','nicht gegeben',21,1,0),"
				+ "(58,'A181','Material unempfindlich',22,0,1),"
				+ "(59,'A182','Material kratz-, bruch-, formempfindlich',22,1,0),"
				+ "(60,'A191','starr',23,0,1),(61,'A192','elastisch',23,0.5,0.5),"
				+ "(62,'A193','biegeschlaff',23,1,0),(63,'A201','starr',24,0,1),"
				+ "(64,'A202','elastisch',24,0.5,0.5),(65,'A203','biegeschlaff',24,1,0),"
				+ "(66,'A211','ja ( Korrektur von Bauteilposition, Bauteilorientierung, "
				+ "Fügeposition, Fügeorientierung)',25,1,0),(67,'A212','nein',25,0,1),"
				+ "(68,'A221','positioniert und orientiert bereitgestellt',26,0,1),"
				+ "(69,'A222','einfach und prozesssicher automatisierbar',26,0.5,0.5),";
		
		
		boolean tabellevorhanden = false;
		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
		}
		catch (Exception e) {
			tabellevorhanden = true;
		}
		finally {

			if (!tabellevorhanden)
				try {
					stmt.executeUpdate(insert1);
					stmt.close();
					conn.close();

				}
			catch (Exception e) {
				e.printStackTrace();
			}
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}

	}

	public static  void mont_op() {

		Connection conn = null;
		Statement stmt = null;


		String table= "CREATE TABLE IF NOT EXISTS `mont_op` ("
				+ "`idmontOP` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`montOP_name` varchar(200) DEFAULT NULL,"
				+ "`idProjekte` int(11) DEFAULT NULL,"
				+ "`FM` double DEFAULT NULL,"
				+ "`FR` double DEFAULT NULL,"
				+ "PRIMARY KEY (`idmontOP`))";


		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}

	}

	public static  void used_auspr() {

		Connection conn = null;
		Statement stmt = null;


		String table="CREATE TABLE IF NOT EXISTS `used_auspr` ("
				+ " `idused_Auspr` int(11) NOT NULL AUTO_INCREMENT,"
				+ "`idMontOP` int(11) NOT NULL,"
				+ "`idAuspr` int(11) NOT NULL,"
				+ "`ratingFM` double DEFAULT NULL,"
				+ "`ratingFR` double DEFAULT NULL,"
				+ "`relevant` tinyint(4) DEFAULT NULL,"
				+ "`gewichtung` int(11) DEFAULT NULL,"
				+ " PRIMARY KEY (`idused_Auspr`))";


		try {

			Class.forName("org.h2.Driver").newInstance();
			conn = get_connection();
			stmt = conn.createStatement();
			stmt.executeUpdate(table);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }

		}

	}




}
