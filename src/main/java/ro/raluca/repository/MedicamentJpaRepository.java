package ro.raluca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Medicament;

@Repository
public interface MedicamentJpaRepository extends JpaRepository<Medicament, Integer> {

	//Cautare dupa nume
	List<Medicament> findByNumeIgnoreCaseStartingWith(String nume);	
	
	//Cautare dupa substanta_activa
	List<Medicament> findBySubstantaActivaIgnoreCaseStartingWith(String substantaActiva);	
	
	@Query("SELECT nume FROM Medicament")
	List<String> getListaMedicamente();
	
	@Query("SELECT nume FROM Medicament WHERE nume_medicament = ?1")
	List<Medicament> getListaMedicamante(String nume_medicament);
//
//	void saveAndFlush(String str);

}
