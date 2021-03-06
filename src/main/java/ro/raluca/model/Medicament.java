package ro.raluca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medicament")
	private int idMedicament;
	
	@Column(name="nume_medicament")
	private String nume;
	
	@Column(name="forma_farmaceutica")
	private String formaFarmaceutica;
	private String doza;
	private String volum;
	private String cantitate;
	
	@Column(name="substanta_activa")
	private String substantaActiva;
	
	@Column(name="cod_ATC")
	private String codATC;
	
	private String valabilitate;
	private String inregistrare;
	private String producator;
	private String tara;
	private String reteta;
	private String original;
	//private MedicamentJpaRepository medRepo;

	// Constructor fara parametrii, campurile au valorile default
	public Medicament() {
	}

	// Constructor cu parametrii (toti)
	public Medicament(String nume2, String forma_farmaceutica2, String doza2, String volum2, String cantitate2,
			String substanta_activa2, String cod_ATC2, String valabilitate2, String inregistrare2, String producator2,
			String tara2, String reteta2, String original2) {
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
		return this.nume + "[" + this.formaFarmaceutica + ", " + this.doza + ", " + this.volum + ", "
				+ this.cantitate + ", " + this.substantaActiva + ", " + this.codATC + ", " + this.valabilitate
				+ ", " + this.inregistrare + ", " + this.producator + ", " + this.tara + ", " + this.reteta + ", "
				+ this.original + "]";
	}

	public int getId_medicament() {
		return idMedicament;
	}
	public void setId_medicament(int id_medicament) {
		this.idMedicament = id_medicament;
		//medRepo.saveAndFlush(id_medicament);
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
//		medRepo.saveAndFlush(nume);
	}
	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}
	public void setFormaFarmaceutica(String forma_farmaceutica) {
		this.formaFarmaceutica = forma_farmaceutica;
//		medRepo.saveAndFlush(forma_farmaceutica);
	}
	public String getDoza() {
		return doza;
	}
	public void setDoza(String doza) {
		this.doza = doza;
//		medRepo.saveAndFlush(doza);
	}
	public String getVolum() {
		return volum;
	}
	public void setVolum(String volum) {
		this.volum = volum;
//		medRepo.saveAndFlush(volum);
	}
	public String getCantitate() {
		return cantitate;
	}
	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
//		medRepo.saveAndFlush(cantitate);
	}
	public String getSubstantaActiva() {
		return substantaActiva;
	}
	public void setSubstantaActiva(String substanta_activa) {
		this.substantaActiva = substanta_activa;
//		medRepo.saveAndFlush(substanta_activa);
	}
	public String getCodATC() {
		return codATC;
	}
	public void setCodATC(String codATC) {
		this.codATC = codATC;
//		medRepo.saveAndFlush(codATC);
	}
	public String getValabilitate() {
		return valabilitate;
	}
	public void setValabilitate(String valabilitate) {
		this.valabilitate = valabilitate;
//		medRepo.saveAndFlush(valabilitate);
	}
	public String getInregistrare() {
		return inregistrare;
	}
	public void setInregistrare(String inregistrare) {
		this.inregistrare = inregistrare;
//		medRepo.saveAndFlush(inregistrare);
	}
	public String getProducator() {
		return producator;
	}
	public void setProducator(String producator) {
		this.producator = producator;
//		medRepo.saveAndFlush(producator);
	}
	public String getTara() {
		return tara;
	}
	public void setTara(String tara) {
		this.tara = tara;
//		medRepo.saveAndFlush(tara);
	}
	public String getReteta() {
		return reteta;
	}
	public void setReteta(String reteta) {
		this.reteta = reteta;
//		medRepo.saveAndFlush(reteta);
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
//		medRepo.saveAndFlush(original);
	}	
}