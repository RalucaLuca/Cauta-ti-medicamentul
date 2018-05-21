package ro.raluca;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import ro.raluca.model.Farmacie;
import ro.raluca.model.Medicament;
import ro.raluca.model.SediuFarmacie;

@SpringBootApplication // initializaeza si porneste spring boot
@ServletComponentScan(basePackages={"ro.raluca"})

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	       // Afisare farmacii
    			Farmacie conexiuneFarmacii = new Farmacie();
    			conexiuneFarmacii.getDataFromFarmacie();
    			System.out.println();

    			// Afisare sediile unei farmacii
    			// conex_farmacii.SediileUneiFarmacii("catena");

    			// AFISARE SEDIU_FARMACIE
    			SediuFarmacie conexiuneSediiFarmacie = new SediuFarmacie();
    			conexiuneSediiFarmacie.getDataFromSediuFarmacie();
    			System.out.println();
//
//    			Medicament conexiuneMedicamente = new Medicament();
//    			// Afisare medicamente din DB
//    			// conex_medicament.conectareDB();
//    			// List<Medicament> medicamenteFromDB = conexiuneMedicamente.getDateFromDB();
//    			// conexiuneMedicamente.displayMedicamente(medicamenteFromDB);
//
//    			// AFISARE MEDICAMENTE DE PE SITE
//    			conexiuneMedicamente.conectareSiteNomenclator();
//    			List<Medicament> medicamenteFromSite = conexiuneMedicamente.getDataFromSite();
    			//conexiuneMedicamente.displayMedicamente(medicamenteFromSite);    	
    	
    			SpringApplication.run(App.class, args);
        
    }
}
