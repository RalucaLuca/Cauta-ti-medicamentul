package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raluca.model.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer>{
	
}
