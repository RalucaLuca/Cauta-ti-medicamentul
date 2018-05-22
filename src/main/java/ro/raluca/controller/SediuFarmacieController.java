package ro.raluca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.Sediu_Farmacie;
import ro.raluca.service.AutentificationRepositorySedii;

@RestController
@RequestMapping("/sediu")
public class SediuFarmacieController {
	
	@Autowired
	private AutentificationRepositorySedii autentificareRepository;
	
	@RequestMapping("/")
	public Sediu_Farmacie Home() {
		// TODO Auto-generated method stub
		Sediu_Farmacie connex = new Sediu_Farmacie();		
		return connex;
	}
	
	@GetMapping("/{id_sediu}")
	public Sediu_Farmacie get(@PathVariable("id_sediu") Integer id_sediu) {
		return autentificareRepository.getOne(id_sediu);
	}
}
