package ro.raluca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Farmacie;
import ro.raluca.model.SediuFarmacie;

@Repository
public interface FarmacieJpaRepository extends JpaRepository<Farmacie, Integer> {  // Integer este tipul ID-ului

//	@PersistenceContext 
//	EntityManager entityManager;

	//Cautare dupa nume
	Farmacie findFirstByNumeIgnoreCaseStartingWith(String nume_farmacie);	
	
	//Cautare dupa CUI
	Farmacie findFirstByCui(Integer CUI);
	
	@Query("SELECT nume FROM Farmacie")
	List<String> getListaFarmacii();
	
	@Query("SELECT sediuFarmacie FROM Farmacie WHERE nume_farmacie = ?1")
	List<SediuFarmacie> getListaSediiFarmacie(String nume_farmacie);
}
