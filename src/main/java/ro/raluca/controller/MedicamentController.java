package ro.raluca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.Medicament;
import ro.raluca.service.AutentificationRepositoryMed;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
	
	@Autowired
	private AutentificationRepositoryMed autentificareRepository;
	
	@RequestMapping("/")
	public Medicament Home() {
		// TODO Auto-generated method stub
		Medicament connex = new Medicament();		
		return connex;
	}
	
	@GetMapping("/{id_medicament}")
	public Medicament get(@PathVariable("id_medicament") Integer id_medicament) {
		return autentificareRepository.getOne(id_medicament);
	}
}
