package ro.raluca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.Farmacie;
import ro.raluca.service.AutentificationRepositoryFarm;

@RestController
@RequestMapping("/farmacie")
public class FarmacieController {
	
	@Autowired
	private AutentificationRepositoryFarm autentificareRepository;
	
	@RequestMapping("/")
	public Farmacie Home() {
		// TODO Auto-generated method stub
		Farmacie connex = new Farmacie();		
		return connex;
	}
	
	@GetMapping("/{id_farmacie}")
	public Farmacie get(@PathVariable("id_farmacie") Integer id_farmacie) {
		return autentificareRepository.getOne(id_farmacie);
	}
}
