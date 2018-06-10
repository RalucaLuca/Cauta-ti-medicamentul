package ro.raluca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class MedicamenteSediu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMedicamentSediu;
	private int exista;
	private String site;
	private int idMedicament;
	private int idSediu;
	
	@OneToMany(cascade=CascadeType.ALL)	 
	@JoinColumn(name="id_medicament")
	private List<Medicament> medicament = new ArrayList<Medicament>();

	
	@OneToMany(cascade=CascadeType.ALL)	 
	@JoinColumn(name="id_sediu")
	private List<SediuFarmacie> sediu = new ArrayList<SediuFarmacie>();

	@SuppressWarnings("unused")	
	public MedicamenteSediu() {		
	}
	
	public MedicamenteSediu(int exista, String site, int ids, int idm) {
		this.exista=exista;
		this.site=site;
		this.idSediu=ids;
		this.idMedicament=idm;
	}
	
	

	public List<Medicament> getMedicament() {
		return medicament;
	}
	public void setMedicament(List<Medicament> medicament) {
		this.medicament = medicament;
	}
	public List<SediuFarmacie> getSediu() {
		return sediu;
	}
	public void setSediu(List<SediuFarmacie> sediu) {
		this.sediu = sediu;
	}
	public int getIdMedicamentSediu() {
		return idMedicamentSediu;
	}
	public void setIdMedicamentSediu(int idMedicamentSediu) {
		this.idMedicamentSediu = idMedicamentSediu;
	}
	public int getExista() {
		return exista;
	}
	public void setExista(int exista) {
		this.exista = exista;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getIdMedicament() {
		return idMedicament;
	}
	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
	public int getIdSediu() {
		return idSediu;
	}
	public void setIdSediu(int idSediu) {
		this.idSediu = idSediu;
	}
}
