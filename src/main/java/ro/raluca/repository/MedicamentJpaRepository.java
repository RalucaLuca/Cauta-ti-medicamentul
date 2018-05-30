package ro.raluca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Medicament;

@Repository
public interface MedicamentJpaRepository extends JpaRepository<Medicament, Integer> {

	//Cautare dupa nume
	List<Medicament> findByNumeIgnoreCaseStartingWith(String nume);	
	Medicament findFirstByNumeIgnoreCaseStartingWith(String nume);	
	List<Medicament> findByNumeNot(String nume);
	
	//Cautare dupa substanta_activa
	List<Medicament> findBySubstantaActivaIgnoreCaseStartingWith(String substantaActiva);	
	Medicament findFirstBySubstantaActivaIgnoreCaseStartingWith(String substantaActiva);	
	List<Medicament> findBySubstantaActivaNot(String substantaActiva);
}
