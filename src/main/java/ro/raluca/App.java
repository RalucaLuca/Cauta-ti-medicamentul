package ro.raluca;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // initializaeza si porneste spring boot
@Configuration
@EnableAutoConfiguration
@EnableSpringConfigured
@ServletComponentScan(basePackages={"ro.raluca"})
//@EntityScan
@EnableJpaRepositories
public class App {	
	
    public static void main( String[] args ) throws SQLException {  	
    	// SALVARE MEDICAMENTE IN BAZA DE DATE
    	//MetodeMedicament conexiuneMedicamente = new MetodeMedicament();
		//conexiuneMedicamente.conectareSiteNomenclator();
   
     	SpringApplication.run(App.class, args);       
    }
}
