package ro.raluca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // initializaeza si porneste spring boot
@ServletComponentScan(basePackages={"ro.raluca"})

public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);       
    }
}
