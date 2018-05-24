package ro.raluca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {	
	//http://localhost:8080/home/
	@RequestMapping("/")
	public String home() {
		return "Cauta-ti medicamentul";
	}
	
}
