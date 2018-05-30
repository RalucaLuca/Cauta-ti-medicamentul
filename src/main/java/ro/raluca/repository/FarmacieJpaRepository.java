package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Farmacie;

@Repository
public interface FarmacieJpaRepository extends JpaRepository<Farmacie, Integer> {  // Integer este tipul ID-ului
	
	//Cautare dupa nume
	Farmacie findFirstByNumeIgnoreCaseStartingWith(String nume_farmacie);	
//	List<Farmacie> findByNumeIgnoreCaseStartingWith(String nume_farmacie);	
//	List<Farmacie> findByNumeNot(String nume_farmacie);
	
	//Cautare dupa CUI
	Farmacie findFirstByCui(Integer CUI);
}
