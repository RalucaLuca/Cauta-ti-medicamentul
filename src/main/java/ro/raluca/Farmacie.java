package ro.raluca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ro.raluca.DB.DB;

public class Farmacie {

	// Conexiunea cu DB
	DB conex = DB.getInstance();
	Connection con = conex.getConnection();

	// DECLARERE VARIABILE
	private int CUI1;
	private String nume1;
	private String site1;

	public Farmacie() {
	}

	// Constructor cu parametrii
	public Farmacie(int CUI2, String nume2, String site2) {
		this.CUI1 = CUI2;
		this.nume1 = nume2;
		this.site1 = site2;
	}

	// Getteri si Setteri
	public int getCUI1() {
		return CUI1;
	}

	public void setCUI1(int cUI1) {
		CUI1 = cUI1;
	}

	public String getNume1() {
		return nume1;
	}

	public void setNume1(String nume1) {
		this.nume1 = nume1;
	}

	public String getSite1() {
		return site1;
	}

	public void setSite1(String site1) {
		this.site1 = site1;
	}

	// Afisare din DB
	public void getDataFromFarmacie() throws SQLException {
		Statement st = con.createStatement();
		String query = "SELECT * FROM Farmacie";
		ResultSet rs = st.executeQuery(query);

		System.out.println("Farmacie: ");

		while (rs.next()) {
			CUI1 = rs.getInt("CUI");
			nume1 = rs.getString("nume_farmacie");
			site1 = rs.getString("site");

			System.out.println("CUI: " + CUI1 + "Nume:  " + nume1 + "site:  " + site1);
		}

	}
	// Procedura Stocata
	/*
	 * public void SediileUneiFarmacii(String farmacie) throws SQLException {
	 * //Apelarea unei proceduri stocate - Afisarea sediilor unei farmacii alese
	 * CallableStatement cs =
	 * con.prepareCall("{call dbo.SediiFarmacieAleasa('catena')}"); ResultSet rs =
	 * cs.executeQuery();
	 * 
	 * System.out.println( "Sediile farmaciei " + farmacie + " sunt: ");
	 * 
	 * while (rs.next()) { System.out.println("Judetul: " + rs.getString("judet"));
	 * System.out.println("Adresa: " + rs.getString("adresa"));
	 * if(rs.getString("telefon")!=null) System.out.println("Numarul de telefon: 0"
	 * + rs.getString("telefon")); else System.out.println("Numarul de telefon: ");
	 * System.out.println(); } }
	 */
}
