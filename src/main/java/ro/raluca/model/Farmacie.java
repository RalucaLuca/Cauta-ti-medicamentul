package ro.raluca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Farmacie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_farmacie;
	private int CUI;
	private String nume_farmacie;
	private String site;
	//@Column(name="nume_farmacie") +import javax.persistence.Column;  daca sunt denumite diferit col din tabel cu cele din clasa


	public Farmacie() {
	}

	// Constructor cu parametrii
	public Farmacie(int id_farmacie, int CUI2, String nume2, String site2) {
		this.id_farmacie = id_farmacie;
		this.CUI = CUI2;
		this.nume_farmacie = nume2;
		this.site = site2;
	}

	// Getteri si Setteri
	public int getId_farmacie() {
		return id_farmacie;
	}
	public void setId_farmacie(int id_farmacie) {
		this.id_farmacie = id_farmacie;
	}
	public int getCUI() {
		return CUI;
	}
	public void setCUI(int cUI) {
		CUI = cUI;
	}
	public String getNume() {
		return nume_farmacie;
	}
	public void setNume(String nume) {
		this.nume_farmacie = nume;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}
	
	// Conexiunea cu DB
//	DB conex = DB.getInstance();
//	Connection con = conex.getConnection();

	// Afisare din DB
//	public void getDataFromFarmacie() throws SQLException {
//		Statement st = con.createStatement();
//		String query = "SELECT * FROM Farmacie";
//		ResultSet rs = st.executeQuery(query);
//
//		System.out.println("Farmacie: ");
//
//		while (rs.next()) {
//			id_farmacie = rs.getInt("id_farmacie");
//			CUI = rs.getInt("CUI");
//			nume = rs.getString("nume_farmacie");
//			site = rs.getString("site");
//
//			System.out.println("id_farmacie: " + id_farmacie + " CUI: " + CUI + " Nume:  " + nume + "site:  " + site);
//		}
//
//	}
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

