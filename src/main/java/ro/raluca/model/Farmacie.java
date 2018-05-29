package ro.raluca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Farmacie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_farmacie;
	
	private int CUI;
	
	@Column(name="nume_farmacie", columnDefinition = "TEXT")
	private String nume;
	
	@Column(columnDefinition = "TEXT")
	private String site;
	//@Column(name="nume_farmacie") +import javax.persistence.Column;  daca sunt denumite diferit col din tabel cu cele din clasa

	@OneToMany(cascade=CascadeType.ALL)	
	@JoinColumn(name="id_farmacie")	
	private List<SediuFarmacie> sediuFarmacie = new ArrayList<SediuFarmacie>();

	@SuppressWarnings("unused")
	public Farmacie() {
	}

	// Constructor cu parametrii
	public Farmacie( int CUI2, String nume2, String site2) {
		this.CUI = CUI2;
		this.nume = nume2;
		this.site = site2;
	}


	// Getteri si Setteri
	public List<SediuFarmacie> getSedii() {	
		return sediuFarmacie;
	}
	public void setSediuFarmacie(List<SediuFarmacie> sediuFarmacie) {		
		this.sediuFarmacie= sediuFarmacie;
	}
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
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}