package ro.raluca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ro.raluca.DB.DB;

public class SediuFarmacie {

	DB conex = DB.getInstance();
	Connection con = conex.getConnection();

	private String cod_sediu1;
	private int CUI1;
	private String adresa1;
	private String telefon1;
	private String judet1;

	public SediuFarmacie() {
	}

	public SediuFarmacie(String cod_sediu2, int CUI2, String adresa2, String telefon2, String judet2) {
		this.cod_sediu1 = cod_sediu2;
		this.CUI1 = 0;
		this.adresa1 = adresa2;
		this.telefon1 = telefon2;
		this.judet1 = judet2;
	}

	// Conexiune la db + Afisarea tuturo sediilor (toate farmaciile)
	public void getDataFromSediuFarmacie() throws SQLException {

		Statement st = con.createStatement();
		String query = "SELECT * FROM Sediu_farmacie";
		ResultSet rs = st.executeQuery(query);

		System.out.println("Sedii: ");

		while (rs.next()) {
			cod_sediu1 = rs.getString("cod_sediu");
			CUI1 = rs.getInt("CUI");
			adresa1 = rs.getString("adresa");
			telefon1 = rs.getString("telefon");
			judet1 = rs.getString("judet");

			System.out.println("Cod sediu: " + cod_sediu1 + "CUI: " + CUI1 + " Adresa: " + adresa1 + "Telefon: "
					+ telefon1 + "Judet" + judet1);
		}
	}

	public String getCod_sediu1() {
		return cod_sediu1;
	}

	public void setCod_sediu1(String cod_sediu1) {
		this.cod_sediu1 = cod_sediu1;
	}

	public int getCUI1() {
		return CUI1;
	}

	public void setCUI1(int cUI1) {
		CUI1 = cUI1;
	}

	public String getAdresa1() {
		return adresa1;
	}

	public void setAdresa1(String adresa1) {
		this.adresa1 = adresa1;
	}

	public String getTelefon1() {
		return telefon1;
	}

	public void setTelefon1(String telefon1) {
		this.telefon1 = telefon1;
	}

	public String getJudet1() {
		return judet1;
	}

	public void setJudet1(String judet1) {
		this.judet1 = judet1;
	}

}
