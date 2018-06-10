package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.raluca.model.Cont;
import ro.raluca.model.CreareCont;
import ro.raluca.repository.CreareContJpaRepository;

@RestController
@RequestMapping("/crearecont")
public class CreareContController {

	@Autowired
	private CreareContJpaRepository crearecontJpaRepository;
	
	@RequestMapping("/")
	public CreareCont Home() {
		CreareCont connex = new CreareCont();		
		return connex;
	}
	
	@GetMapping("/getLista}") 
	public List<CreareCont> getLista() {
		return crearecontJpaRepository.findAll();
	}
	
	@GetMapping("/getUtilizatori") 
	public List<String> getUtilizatori(@PathVariable("idCont") Integer idCont) {
		return crearecontJpaRepository.getListaUtilizatori();
	}
	@GetMapping("/getDateCont") 
	public List<Cont> getDateCont(@PathVariable("utilizator") String utilizator) {
		return crearecontJpaRepository.getDateCont(utilizator);
	}


}
