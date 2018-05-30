package ro.raluca.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_medicament;
	private String nume;
	private String formaFarmaceutica;
	private String doza;
	private String volum;
	private String cantitate;
	private String substantaActiva;
	private String codATC;
	private String valabilitate;
	private String inregistrare;
	private String producator;
	private String tara;
	private String reteta;
	private String original;

	// Constructor fara parametrii, campurile au valorile default
	public Medicament() {
	}

	// Constructor cu parametrii (toti)
	public Medicament(int id_medicament,String nume2, String forma_farmaceutica2, String doza2, String volum2, String cantitate2,
			String substanta_activa2, String cod_ATC2, String valabilitate2, String inregistrare2, String producator2,
			String tara2, String reteta2, String original2) {
		this.id_medicament=id_medicament;
		this.nume = nume2;
		this.formaFarmaceutica = forma_farmaceutica2;
		this.doza = doza2;
		this.volum = volum2;
		this.cantitate = cantitate2;
		this.substantaActiva = substanta_activa2;
		this.codATC = cod_ATC2;
		this.valabilitate = valabilitate2;
		this.inregistrare = inregistrare2;
		this.producator = producator2;
		this.tara = tara2;
		this.reteta = reteta2;
		this.original = original2;
	}

	// Afisare medicamente
	public void displayMedicamente(List<Medicament> medicamente) {
		for (Medicament medicament : medicamente) {
			System.out.println(medicament);
		}
	}

	// La println se iau elementele automat toString si se afiseaza
	public String toString() {
		return this.id_medicament + "[" + this.nume + "[" + this.formaFarmaceutica + ", " + this.doza + ", " + this.volum + ", "
				+ this.cantitate + ", " + this.substantaActiva + ", " + this.codATC + ", " + this.valabilitate
				+ ", " + this.inregistrare + ", " + this.producator + ", " + this.tara + ", " + this.reteta + ", "
				+ this.original + "]";
	}

	public int getId_medicament() {
		return id_medicament;
	}
	public void setId_medicament(int id_medicament) {
		this.id_medicament = id_medicament;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}
	public void setFormaFarmaceutica(String forma_farmaceutica) {
		this.formaFarmaceutica = forma_farmaceutica;
	}
	public String getDoza() {
		return doza;
	}
	public void setDoza(String doza) {
		this.doza = doza;
	}
	public String getVolum() {
		return volum;
	}
	public void setVolum(String volum) {
		this.volum = volum;
	}
	public String getCantitate() {
		return cantitate;
	}
	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
	}
	public String getSubstantaActiva() {
		return substantaActiva;
	}
	public void setSubstantaActiva(String substanta_activa) {
		this.substantaActiva = substanta_activa;
	}
	public String getCodATC() {
		return codATC;
	}
	public void setCodATC(String codATC) {
		this.codATC = codATC;
	}
	public String getValabilitate() {
		return valabilitate;
	}
	public void setValabilitate(String valabilitate) {
		this.valabilitate = valabilitate;
	}
	public String getInregistrare() {
		return inregistrare;
	}
	public void setInregistrare(String inregistrare) {
		this.inregistrare = inregistrare;
	}
	public String getProducator() {
		return producator;
	}
	public void setProducator(String producator) {
		this.producator = producator;
	}
	public String getTara() {
		return tara;
	}
	public void setTara(String tara) {
		this.tara = tara;
	}
	public String getReteta() {
		return reteta;
	}
	public void setReteta(String reteta) {
		this.reteta = reteta;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}	
}