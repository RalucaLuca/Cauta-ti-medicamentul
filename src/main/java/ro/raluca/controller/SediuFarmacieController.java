package ro.raluca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raluca.model.SediuFarmacie;
import ro.raluca.repository.SediuRepository;

@RestController
@RequestMapping("/sediu")
public class SediuFarmacieController {
	
	@Autowired
	private SediuRepository autentificareRepository;
	
	@RequestMapping("/")
	public SediuFarmacie Home() {
		// TODO Auto-generated method stub
		SediuFarmacie connex = new SediuFarmacie();		
		return connex;
	}
	
	@GetMapping("/{id_sediu}")
	public SediuFarmacie get(@PathVariable("id_sediu") Integer id_sediu) {
		return autentificareRepository.getOne(id_sediu);
	}
}
