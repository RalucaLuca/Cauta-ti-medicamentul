package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.SediuFarmacie;
import ro.raluca.repository.SediuJpaRepository;

@RestController
@RequestMapping("/sediu")
public class SediuFarmacieController {
	
	@Autowired
	private SediuJpaRepository sediuJpaRepository;
	
	@RequestMapping("/")
	public SediuFarmacie Home() {
		SediuFarmacie connex = new SediuFarmacie();		
		return connex;
	}
	
	@GetMapping("/getSediiByAdresa/{adresa}") // afisarea sediilor care sunt pe adresa respectiva
	public List<SediuFarmacie> getSediiByAdresa(@PathVariable("adresa") String adresa) {
		return sediuJpaRepository.findByAdresaIgnoreCaseStartingWith(adresa);
	}
	
	@GetMapping("/getSediiByIdFarmacie/{id_farmacie}") //informatii despre farmacia care are CUI-ul respectiv + sediile acesteia
	public List<SediuFarmacie> getSediiByIdFarmacie(@PathVariable("id_farmacie") Integer idFarmacie) {
		return sediuJpaRepository.findAllByIdFarmacieEquals(idFarmacie);
	}
}
