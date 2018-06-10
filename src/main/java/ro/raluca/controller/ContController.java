package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.raluca.model.Cont;
import ro.raluca.repository.ContJpaRepository;

@RestController
@RequestMapping("/cont")
public class ContController {

	@Autowired
	private ContJpaRepository contJpaRepository;
	
	@RequestMapping("/")
	public Cont Home() {
		Cont connex = new Cont();		
		return connex;
	}
	
	@GetMapping("/getNote/{idCont}") 
	public List<String> getNote(@PathVariable("idCont") Integer idCont) {
		return contJpaRepository.getNoteCont(idCont);
	}

}
