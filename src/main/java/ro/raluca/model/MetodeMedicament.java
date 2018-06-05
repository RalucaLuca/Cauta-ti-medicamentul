package ro.raluca.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class MetodeMedicament extends Medicament {

	
	
	// Conexiunea cu SITE-UL Nomenclator
	public void conectareSiteNomenclator() {
		try {
			// Conectare la site-ul cu medicamente
			Document prepDoc = (Document) Jsoup.connect("http://nomenclator.amed.md/").get();

			org.jsoup.nodes.Element eventValidation = prepDoc.select("input[name=__EVENTVALIDATION]").first();
			org.jsoup.nodes.Element viewState = prepDoc.select("input[name=__VIEWSTATE]").first();
			org.jsoup.nodes.Element viewStateGen = prepDoc.select("input[name=__VIEWSTATEGENERATOR]").first();

			Document doc = Jsoup.connect("http://nomenclator.amed.md/").data("__VIEWSTATE", viewState.attr("value"))
					.data("__VIEWSTATEGENERATOR", viewStateGen.attr("value"))
					.data("__EVENTVALIDATION", eventValidation.attr("value"))
					.data("__EVENTTARGET", "grid$StatusBar$PageSizeDropDownList")
					.data("grid$StatusBar$PageSizeDropDownList", "500") // Selecteaza 500 de medicamente pe pagina
					.post();
			// ???????? grid_tcStatusBar div
			String displayedRecords = doc.select("#grid_tcStatusBar div").text(); // selectam elementele din div de
																					// tipul #grid_tcStatusBar ???

			// numarul de elemente de pe o pagina
			String lastRecordDisplayed = displayedRecords.substring(displayedRecords.indexOf("-") + 1, // +1 pt ca se porneste indexarea de la 0
					displayedRecords.indexOf(" din")).trim(); // .trim - > se sterg toate spatiile (stanga, dreapta)

			// Numarul maxim de elemente
			String recordsCount = displayedRecords.substring(displayedRecords.indexOf(" din") + 4, // se ia in calcul si " din" -> 4 caractere
					displayedRecords.indexOf("medicamente")).trim();

			//Schimbare pagina
			 List<Medicament> medicamente = getDataFromSite(doc);
			 
//			 while (Integer.parseInt(lastRecordDisplayed) < Integer.parseInt(recordsCount)) {
//				 doc = Jsoup.connect("http://nomenclator.amed.md/")
//				    .data("__VIEWSTATE", viewState.attr("value"))
//					.data("__VIEWSTATEGENERATOR", viewStateGen.attr("value"))
//					.data("__EVENTVALIDATION", eventValidation.attr("value"))
//					.data("__EVENTTARGET", "grid$StatusBar$PageSizeDropDownList")
//					.data("grid$StatusBar$PageSizeDropDownList", "500") // Selecteaza 500 de medicamente pe pagina
//				    .data("__CALLBACKID", "grid")
//					.data("__CALLBACKPARAM", "c0:GB|10;8|NEXTPAGE;")
//					.post();
//				 
//				  lastRecordDisplayed = displayedRecords.substring(displayedRecords.indexOf("-") + 1, // +1 pt ca se porneste indexarea de la 0
//							displayedRecords.indexOf(" din")).trim(); // .trim - > se sterg toate spatiile (stanga, dreapta)
//				  
//				  getDataFromSite(doc);
//				 
//			 }
			 
			 System.out.println(medicamente);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Adaugare medicamente in DB de pe site NU MERGE !!
	public List<Medicament> getDataFromSite(Document doc) {

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
}
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

