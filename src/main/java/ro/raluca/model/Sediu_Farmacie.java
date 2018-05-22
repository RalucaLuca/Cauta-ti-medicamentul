package ro.raluca.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Sediu_Farmacie {

	@Id
	//@Column(name="cod_sediu") + import javax.persistence.Column; daca sunt denumite diferit col din tabel cu cele din clasa
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_sediu;	
	private String adresa;
	private String telefon;
	private String judet;

	public Sediu_Farmacie() {
	}

	public Sediu_Farmacie(int id_sediu2, String adresa2, String telefon2, String judet2) {
		this.id_sediu = id_sediu2;
		this.adresa = adresa2;
		this.telefon = telefon2;
		this.judet = judet2;
	}

	
	public int getId_sediu() {
		return id_sediu;
	}
	public void setId_sediu(int id_sediu) {
		this.id_sediu = id_sediu;
	}

	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getJudet() {
		return judet;
	}
	public void setJudet(String judet) {
		this.judet = judet;
	}
}

/*
	// Conexiune la db + Afisarea tuturo sediilor (toate farmaciile)
	public void getDataFromSediuFarmacie() throws SQLException {
		Statement st = con.createStatement();
		String query = "SELECT * FROM SediuFarmacie";
		ResultSet rs = st.executeQuery(query);

		System.out.println("Sedii: ");

		while (rs.next()) {
			id_sediu = rs.getString("id_sediu");
			CUI = rs.getInt("CUI");
			adresa = rs.getString("adresa");
			telefon = rs.getString("telefon");
			judet = rs.getString("judet");

			System.out.println("Id sediu: " + id_sediu + "CUI: " + CUI + " Adresa: " + adresa + "Telefon: "
					+ telefon + "Judet: " + judet);
		}
	}
*/

 
 /*
	//Conexiunea la DB
	DB conex = DB.getInstance();
	Connection con = conex.getConnection();
 */
