package ro.raluca.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.nodes.Document;

public class DB {

	private static DB conexiune = null;

	Document doc = null;

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	private DB() {
		if (conexiune != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}

	public static DB getInstance() {
		if (conexiune == null) {
			conexiune = new DB();
		}
		return conexiune;
	}

	// Conexiunea cu Baza de date
	public Connection getConnection() {
		if (con == null) {
			// synchronized(DbSingleton.class) {
			try {
				// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(
						"jdbc:sqlserver://RALU;instanceName=RALUSQL;databaseName=DB;integratedSecurity=true;");
				// st = con.createStatement();
				// SERVER: RALU ; INSTANTA: RALUSQL
				System.out.println("Succes1!!");

			} catch (SQLException e) {
				System.out.println("Eroare:" + e.getMessage());
				e.printStackTrace();
			} catch (Exception ex) {
				System.out.println("Eroare:" + ex.getMessage());
			}
		}

		// }
		return con;
	}
}
