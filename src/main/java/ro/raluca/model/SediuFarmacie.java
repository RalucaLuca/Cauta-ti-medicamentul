package ro.raluca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="Sediu_Farmacie") // in DB tabelul este numit Sediu_Farmacie
public class SediuFarmacie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_sediu;	 	//@Column(name="cod_sediu") + import javax.persistence.Column; daca sunt denumite diferit col din tabel cu cele din clasa
	private String adresa;
	private String telefon;
	private String judet;
	

	private int id_farmacie;
	
	public SediuFarmacie() {
	}
	

	public SediuFarmacie(int id_sediu2, String adresa2, String telefon2, String judet2, int id_farmacie) {
		this.id_sediu = id_sediu2;
		this.adresa = adresa2;
		this.telefon = telefon2;
		this.judet = judet2;
		this.id_farmacie = id_farmacie;
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
	public int getId_farmacie() {
		return id_farmacie;
	}
	public void setId_farmacie(int id_farmacie) {
		this.id_farmacie = id_farmacie;
	}
}