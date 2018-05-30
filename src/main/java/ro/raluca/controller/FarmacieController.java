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
public class FarmacieController {
	
	@Autowired
	private FarmacieJpaRepository farmacieJpaRepository;
	
	@RequestMapping("/")
	public Farmacie Home() {
		// TODO Auto-generated method stub
		Farmacie connex = new Farmacie();		
		return connex;
	}
	
	//@GetMapping("/getFarmacieByNume/{nume_farmacie}") --> calea pe localhost nume_farmacie este numele atributului din tabel
	@GetMapping("/getListaFarmacii") // Lista farmaciilor cu toate datele + sediile acestora
	public List<Farmacie> getListaFarmaciiSiSedii() {
		return farmacieJpaRepository.findAll();
	}
	
	@GetMapping("/getFarmacieByNume/{nume_farmacie}")  //informatii despre farmacie + sediile acesteia ; nu trebuie sa fie scris numele intreg
	public Farmacie getFarmacieByNume(@PathVariable("nume_farmacie") String nume_farmacie) {
		return farmacieJpaRepository.findFirstByNumeIgnoreCaseStartingWith(nume_farmacie);
	}
	
	@GetMapping("/getFarmacieByCui/{CUI}") ////informatii despre farmacia care are CUI-ul respectiv + sediile acesteia
	public Farmacie getFarmacieByCui(@PathVariable("CUI") Integer cui) {
		return farmacieJpaRepository.findFirstByCui(cui);
	}
	
}