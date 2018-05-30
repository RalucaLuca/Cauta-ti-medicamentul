package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.Medicament;
import ro.raluca.repository.MedicamentJpaRepository;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
	
	@Autowired
	private MedicamentJpaRepository medicamentJpaRepository;
	
	@RequestMapping("/")
	public Medicament Home() {
		// TODO Auto-generated method stub
		Medicament connex = new Medicament();		
		return connex;
	}
	
	@GetMapping("/getLista")
	public List<Medicament> getLista() {
		return medicamentJpaRepository.findAll();
	}
	
	@GetMapping("/getListaByNume/{nume}")
	public List<Medicament> getListaByNume(@PathVariable("nume") String nume) {
		return medicamentJpaRepository.findByNumeIgnoreCaseStartingWith(nume);
	}
	
	@GetMapping("/getListaBySubstanta/{substanatActiva}")
	public List<Medicament> getListaBySubstanta(@PathVariable("substanta_activa") String substantaActiva) {
		return medicamentJpaRepository.findBySubstantaActivaNot(substantaActiva);
	}
}