package ro.raluca;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ro.raluca.DB.DB;

public class Medicament {

	DB conex = DB.getInstance();
	Connection con = conex.getConnection();

	Document doc = null;

	private String nume1;
	private String forma_farmaceutica1;
	private String doza1;
	private String volum1;
	private String cantitate1;
	private String substanta_activa1;
	private String cod_ATC1;
	private String valabilitate1;
	private String inregistrare1;
	private String producator1;
	private String tara1;
	private String reteta1;
	private String original1;

	// Constructor fara parametrii, campurile au valorile default
	public Medicament() {
	}

	// Constructor cu parametrii (toti)
	public Medicament(String nume2, String forma_farmaceutica2, String doza2, String volum2, String cantitate2,
			String substanta_activa2, String cod_ATC2, String valabilitate2, String inregistrare2, String producator2,
			String tara2, String reteta2, String original2) {

		this.nume1 = nume2;
		this.forma_farmaceutica1 = forma_farmaceutica2;
		this.doza1 = doza2;
		this.volum1 = volum2;
		this.cantitate1 = cantitate2;
		this.substanta_activa1 = substanta_activa2;
		this.cod_ATC1 = cod_ATC2;
		this.valabilitate1 = valabilitate2;
		this.inregistrare1 = inregistrare2;
		this.producator1 = producator2;
		this.tara1 = tara2;
		this.reteta1 = reteta2;
		this.original1 = original2;
	}

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

	// Adaugare medicamente in DB de pe site NU MERGE ?
	public List<Medicament> getDataFromSite() {

		List<Medicament> medicament = new ArrayList<Medicament>();

		Elements site = doc.select(".dxgvDataRow");

		for (Element tabelMedicament : site) {

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

				medicament.add(new Medicament(nume, forma_farmaceutica, doza, volum, cantitate, substanta_activa,
						cod_ATC, valabilitate, inregistrare, producator, tara, reteta, original));
			}
		}

		return medicament;
	}

	// Afisare medicamente din DB
	public List<Medicament> getDateFromDB() throws SQLException {

		Statement st = con.createStatement();
		String query = "SELECT * FROM Medicament";
		ResultSet rs = st.executeQuery(query);

		System.out.println("Medicamente: ");

		List<Medicament> medicamente = new ArrayList<Medicament>();

		while (rs.next()) {
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

			medicamente.add(new Medicament(nume1, forma_farmaceutica1, doza1, volum1, cantitate1, substanta_activa1,
					cod_ATC1, valabilitate1, inregistrare1, producator1, tara1, reteta1, original1));

		}
		return medicamente;
	}

	// Afisare medicamente
	public void displayMedicamente(List<Medicament> medicamente) {
		for (Medicament medicament : medicamente) {
			System.out.println(medicament);
		}
	}

	// La println se iau elementele automat toString si se afiseaza
	public String toString() {
		return this.nume1 + "[" + this.forma_farmaceutica1 + ", " + this.doza1 + ", " + this.volum1 + ", "
				+ this.cantitate1 + ", " + this.substanta_activa1 + ", " + this.cod_ATC1 + ", " + this.valabilitate1
				+ ", " + this.inregistrare1 + ", " + this.producator1 + ", " + this.tara1 + ", " + this.reteta1 + ", "
				+ this.original1 + "]";

	}

	public String getNume1() {
		return nume1;
	}

	public void setNume1(String nume1) {
		this.nume1 = nume1;
	}

	public String getForma_farmaceutica1() {
		return forma_farmaceutica1;
	}

	public void setForma_farmaceutica1(String forma_farmaceutica1) {
		this.forma_farmaceutica1 = forma_farmaceutica1;
	}

	public String getDoza1() {
		return doza1;
	}

	public void setDoza1(String doza1) {
		this.doza1 = doza1;
	}

	public String getVolum1() {
		return volum1;
	}

	public void setVolum1(String volum1) {
		this.volum1 = volum1;
	}

	public String getCantitate1() {
		return cantitate1;
	}

	public void setCantitate1(String cantitate1) {
		this.cantitate1 = cantitate1;
	}

	public String getSubstanta_activa1() {
		return substanta_activa1;
	}

	public void setSubstanta_activa1(String substanta_activa1) {
		this.substanta_activa1 = substanta_activa1;
	}

	public String getCod_ATC1() {
		return cod_ATC1;
	}

	public void setCod_ATC1(String cod_ATC1) {
		this.cod_ATC1 = cod_ATC1;
	}

	public String getValabilitate1() {
		return valabilitate1;
	}

	public void setValabilitate1(String valabilitate1) {
		this.valabilitate1 = valabilitate1;
	}

	public String getInregistrare1() {
		return inregistrare1;
	}

	public void setInregistrare1(String inregistrare1) {
		this.inregistrare1 = inregistrare1;
	}

	public String getProducator1() {
		return producator1;
	}

	public void setProducator1(String producator1) {
		this.producator1 = producator1;
	}

	public String getTara1() {
		return tara1;
	}

	public void setTara1(String tara1) {
		this.tara1 = tara1;
	}

	public String getReteta1() {
		return reteta1;
	}

	public void setReteta1(String reteta1) {
		this.reteta1 = reteta1;
	}

	public String getOriginal1() {
		return original1;
	}

	public void setOriginal1(String original1) {
		this.original1 = original1;
	}

}
