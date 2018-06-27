package ro.raluca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="Sediu_Farmacie") // in DB tabelul este numit Sediu_Farmacie
public class SediuFarmacie {

	@Id
	@Column(name="id_sediu")    // daca sunt denumite diferit col din tabel cu cele din clasa
	private int idSediu;
	
	private String adresa;
	private String telefon;
	private String judet;
	
	@Column(name="id_farmacie")
	private int idFarmacie;
	
	public SediuFarmacie() {
	}
	
	public SediuFarmacie(int id_sediu2, String adresa2, String telefon2, String judet2, int id_farmacie) {
		this.idSediu = id_sediu2;
		this.adresa = adresa2;
		this.telefon = telefon2;
		this.judet = judet2;
		this.idFarmacie = id_farmacie;
	}
	
	public int getIdSediu() {
		return idSediu;
	}
	public void setIdSediu(int id_sediu) {
		this.idSediu = id_sediu;
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
	public int getIdFarmacie() {
		return idFarmacie;
	}
	public void setIdFarmacie(int id_farmacie) {
		this.idFarmacie = id_farmacie;
	}
}