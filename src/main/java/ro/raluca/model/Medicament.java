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
	private String forma_farmaceutica;
	private String doza;
	private String volum;
	private String cantitate;
	private String substanta_activa;
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
		this.forma_farmaceutica = forma_farmaceutica2;
		this.doza = doza2;
		this.volum = volum2;
		this.cantitate = cantitate2;
		this.substanta_activa = substanta_activa2;
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
		return this.id_medicament + "[" + this.nume + "[" + this.forma_farmaceutica + ", " + this.doza + ", " + this.volum + ", "
				+ this.cantitate + ", " + this.substanta_activa + ", " + this.codATC + ", " + this.valabilitate
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
	public String getForma_farmaceutica() {
		return forma_farmaceutica;
	}
	public void setForma_farmaceutica(String forma_farmaceutica) {
		this.forma_farmaceutica = forma_farmaceutica;
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
	public String getSubstanta_activa() {
		return substanta_activa;
	}
	public void setSubstanta_activa(String substanta_activa) {
		this.substanta_activa = substanta_activa;
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
/*
	//Conexiunea le DB
	DB conex = DB.getInstance();
	Connection con = conex.getConnection();
	Document doc = null;
*/
	
/*
	// Conexiunea cu SITE-UL Nomenclator
	public void conectareSiteNomenclator() {
		try {
			// Conectare la site-ul cu medicamente
			Document prepDoc = Jsoup.connect("http://nomenclator.amed.md/").get();

			Element eventValidation = prepDoc.select("input[name=__EVENTVALIDATION]").first();
			Element viewState = prepDoc.select("input[name=__VIEWSTATE]").first();
			Element viewStateGen = prepDoc.select("input[name=__VIEWSTATEGENERATOR]").first();

			doc = Jsoup.connect("http://nomenclator.amed.md/").data("__VIEWSTATE", viewState.attr("value"))
					.data("__VIEWSTATEGENERATOR", viewStateGen.attr("value"))
					.data("__EVENTVALIDATION", eventValidation.attr("value"))
					.data("__EVENTTARGET", "grid$StatusBar$PageSizeDropDownList")
					.data("grid$StatusBar$PageSizeDropDownList", "500") // Selecteaza 500 de medicamente pe pagina
					.post();
			// ???????? grid_tcStatusBar div
			String displayedRecords = doc.select("#grid_tcStatusBar div").text(); // selectam elementele din div de
																					// tipul #grid_tcStatusBar ???

			// numarul de elemente de pe o pagina
			String lastRecordDisplayed = displayedRecords.substring(displayedRecords.indexOf("-") + 1, // +1 pt ca se
																										// porneste
																										// indexarea de
																										// la 0
					displayedRecords.indexOf(" din")).trim(); // .trim - > se sterg toate spatiile (stanga, dreapta)

			// Numarul maxim de elemente
			String recordsCount = displayedRecords.substring(displayedRecords.indexOf(" din") + 4, // se ia in calcul si
																									// " din" -> 4
																									// caractere
					displayedRecords.indexOf("medicamente")).trim();

			// while (lastRecordDisplayed != recordsCount) {
			//
			// lastRecordDisplayed=displayedRecords.substring(
			// displayedRecords.indexOf("__CALLBACKID grid") + 1,
			// displayedRecords.indexOf("__CALLBACKPARAM c0:GB|10;8|NEXTPAGE;")   
			// ).trim();
			//
			// doc.body().appendTo(doc.body());
			// // get next page
			// //"__CALLBACKID grid)
			// //"__CALLBACKPARAM c0:GB|10;8|NEXTPAGE;");
			// // append next page's body to first page body
			//
			// }
			//
			// System.out.println();

			// DE FACUT PENTRU FIECARE PAGINA!!!
			// while lastRecordDisplayed != recordsCount
			// get next page
			// __CALLBACKID grid
			// __CALLBACKPARAM c0:GB|10;8|NEXTPAGE;
			// append next page's body to first page body
			// doc.body().appendTo(doc.body());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
*/

/*
	// Adaugare medicamente in DB de pe site NU MERGE ?
	public List<Medicament> getDataFromSite() {

		List<Medicament> medicament = new ArrayList<Medicament>();

		Elements site = doc.select(".dxgvDataRow");
		int id=0;
		for (Element tabelMedicament : site) {
			id++;
			String nume = tabelMedicament.select("td:nth-child(1)").text();
			String forma_farmaceutica = tabelMedicament.select("td:nth-child(2)").text();
			String doza = tabelMedicament.select("td:nth-child(3)").text();
			String volum = tabelMedicament.select("td:nth-child(4)").text();
			String cantitate = tabelMedicament.select("td:nth-child(5)").text();
			String substanta_activa = tabelMedicament.select("td:nth-child(6)").text();
			String cod_ATC = tabelMedicament.select("td:nth-child(7)").text();
			String valabilitate = tabelMedicament.select("td:nth-child(8)").text();
			String inregistrare = tabelMedicament.select("td:nth-child(10)").text();
			String producator = tabelMedicament.select("td:nth-child(11)").text();
			String tara = tabelMedicament.select("td:nth-child(12)").text();
			String reteta = tabelMedicament.select("td:nth-child(16)").text();
			String original = tabelMedicament.select("td:nth-child(17)").text();

			if (nume != null && !nume.trim().isEmpty()) {

				medicament.add(new Medicament(id,nume, forma_farmaceutica, doza, volum, cantitate, substanta_activa,
						cod_ATC, valabilitate, inregistrare, producator, tara, reteta, original));
			}
		}

		return medicament;
	}
	
*/

/*
	// Afisare medicamente din DB
	public List<Medicament> getDateFromDB() throws SQLException {

		Statement st = con.createStatement();
		String query = "SELECT * FROM Medicament";
		ResultSet rs = st.executeQuery(query);

		System.out.println("Medicamente: ");

		List<Medicament> medicamente = new ArrayList<Medicament>();
		int id=0;
		while (rs.next()) {
			id++;
			String nume1 = rs.getString("nume");
			String forma_farmaceutica1 = rs.getString("forma_farmaceutica");
			String doza1 = rs.getString("doza");
			String volum1 = rs.getString("volum");
			String cantitate1 = rs.getString("cantitate");
			String substanta_activa1 = rs.getString("subtanta_activa");
			String cod_ATC1 = rs.getString("cod_ATC");
			String valabilitate1 = rs.getString("valabilitate");
			String inregistrare1 = rs.getString("inregistrare");
			String producator1 = rs.getString("producator");
			String tara1 = rs.getString("tara");
			String reteta1 = rs.getString("reteta");
			String original1 = rs.getString("original");

			medicamente.add(new Medicament(id,nume1, forma_farmaceutica1, doza1, volum1, cantitate1, substanta_activa1,
					cod_ATC1, valabilitate1, inregistrare1, producator1, tara1, reteta1, original1));

		}
		return medicamente;
	}
*/

