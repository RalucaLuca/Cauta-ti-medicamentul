package ro.raluca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Farmacie;

@Repository
public interface FarmacieJpaRepository extends JpaRepository<Farmacie, Integer> {  // Integer este tipul ID-ului

//	@PersistenceContext 
//	EntityManager entityManager;

	//Cautare dupa nume
	Farmacie findFirstByNumeIgnoreCaseStartingWith(String nume_farmacie);	
	
	//Cautare dupa CUI
	Farmacie findFirstByCui(Integer CUI);
	
	@Query("SELECT nume from Farmacie")
	List<String> getListaFarmacii();
}
