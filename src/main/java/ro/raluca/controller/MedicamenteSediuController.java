package ro.raluca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.raluca.model.MedicamenteSediu;
import ro.raluca.repository.MedicamenteSediuJpaRepository;

@RestController
@RequestMapping("/medicamentesediu")
public class MedicamenteSediuController {
		
		@Autowired
		private MedicamenteSediuJpaRepository medicamenteSediuJpaRepository;
		
		@RequestMapping("/")
		public MedicamenteSediu Home() {
			MedicamenteSediu connex = new MedicamenteSediu();		
			return connex;
		}
		
		@GetMapping("/getLista") 
		public List<MedicamenteSediu> getLista() {
			return medicamenteSediuJpaRepository.findAll();
		}
}
