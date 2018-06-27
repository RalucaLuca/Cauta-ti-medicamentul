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
		Medicament connex = new Medicament();		
		return connex;
	}
	
	// Lista medicamentelor
	@GetMapping("/getLista") 
	public List<String> getLista() {
		return medicamentJpaRepository.getListaMedicamente();
	}
	
	//Lista medicamentelor cu toate informatiile
	@GetMapping("/getListaMedicamente")
	public List<Medicament> getListaMedicamente() {
		return medicamentJpaRepository.findAll();
	}
	
	// Medicamentele cu acelasi nume
	@GetMapping("/getMedicamente/{nume_medicament}")  
	public List<Medicament> getMedicamente(@PathVariable("nume_medicament") String nume_medicament) {
		return medicamentJpaRepository.getListaMedicamante(nume_medicament);
	}
	
	//Medicamentul cautat ( medicamente)
	@GetMapping("/getListaByNume/{nume}")
	public List<Medicament> getListaByNume(@PathVariable("nume") String nume) {
		return medicamentJpaRepository.findByNumeIgnoreCaseStartingWith(nume);
	}
	
	//Lista medicamentelor cu o anumita substanta activa
	@GetMapping("/getListaBySubstanta/{substantaActiva}")
	public List<Medicament> getListaBySubstanta(@PathVariable("substantaActiva") String substanta_activa) {
		return medicamentJpaRepository.findBySubstantaActivaIgnoreCaseStartingWith(substanta_activa);
	}
	
}