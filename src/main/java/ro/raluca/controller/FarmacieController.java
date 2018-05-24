package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ro.raluca.model.Farmacie;
import ro.raluca.repository.FarmacieRepository;

@RestController
@RequestMapping("/farmacie")
public class FarmacieController {
	
	@Autowired
	private FarmacieRepository farmacieRepository;
	
	@RequestMapping("/")
	public Farmacie Home() {
		// TODO Auto-generated method stub
		Farmacie connex = new Farmacie();		
		return connex;
	}
	
	@GetMapping("/{id_farmacie}")
	public List<Farmacie> get(@PathVariable("id_farmacie") Integer id_farmacie) {
		return farmacieRepository.getFarmacieById(id_farmacie);
	}
	
//	@GetMapping("/{nume_farmacie}")
//	public List<Farmacie> get(@PathVariable("nume_farmacie") String nume_farmacie) {
//		return farmacieRepository.getFarmacieByName(nume_farmacie);
//	}
}
