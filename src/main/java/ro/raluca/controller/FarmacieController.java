package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.Farmacie;
import ro.raluca.repository.FarmacieJpaRepository;

@RestController
@RequestMapping("/farmacie")
public  class FarmacieController {
	
	@Autowired
	private FarmacieJpaRepository farmacieJpaRepository;
	
	@RequestMapping("/")
	public Farmacie Home() {
		Farmacie connex = new Farmacie();		
		return connex;
	}
	
	// Lista farmaciilor
	@GetMapping("/getLista") 
	public List<String> getLista() {
		return farmacieJpaRepository.getListaFarmacii();
	}
	
	// Lista farmaciilor cu toate datele + sediile acestora
	@GetMapping("/getListaFarmacii")  // calea pe localhost nume_farmacie este numele atributului din tabel
	public List<Farmacie> getListaFarmacii() {
		return farmacieJpaRepository.findAll();
	}
	
	//Informatii despra farmaci cautata; numele nu trebuie sa fie scris in intregime
	@GetMapping("/getFarmacieByNume/{nume_farmacie}")  
	public Farmacie getFarmacieByNume(@PathVariable("nume_farmacie") String nume_farmacie) {
		return farmacieJpaRepository.findFirstByNumeIgnoreCaseStartingWith(nume_farmacie);
	}
	
	//Afisarea informatiilor despre farmacia care are CUI-ul respectiv
	@GetMapping("/getFarmacieByCui/{CUI}") 
	public Farmacie getFarmacieByCui(@PathVariable("CUI") Integer cui) {
		return farmacieJpaRepository.findFirstByCui(cui);
	}
	

	
}