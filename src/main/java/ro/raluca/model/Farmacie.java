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
	@Column(name="id_farmacie")
	private int idFarmacie;	
	
	@Column(name="CUI")
	private int cui;
	
	@Column(name="nume_farmacie", columnDefinition = "TEXT")
	private String nume;
	
	@Column(columnDefinition = "TEXT")
	private String site;
	
	@OneToMany(cascade=CascadeType.ALL)	 // Tipul legaturii dintre tabele
	@JoinColumn(name="id_farmacie")	     // variabila de legatura intre tabelul Farmacie si SediuFarmacie
	private List<SediuFarmacie> sediuFarmacie = new ArrayList<SediuFarmacie>();

	@SuppressWarnings("unused")
	public Farmacie() {
	}

	// Constructor cu parametrii
	public Farmacie( int CUI2, String nume2, String site2) {
		this.cui = CUI2;
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
	public int getIdFarmacie() {
		return idFarmacie;
	}
	public void setIdFarmacie(int id_farmacie) {
		this.idFarmacie = id_farmacie;
	}
	public int getCui() {
		return cui;
	}
	public void setCui(int cUI) {
		cui = cUI;
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