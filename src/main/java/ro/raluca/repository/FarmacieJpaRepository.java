package ro.raluca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.raluca.model.Farmacie;

@Repository
public interface FarmacieJpaRepository extends JpaRepository<Farmacie, Integer> {
	
	List<Farmacie> findByNumeIgnoreCaseStartingWith(String nume_farmacie);	
	Farmacie findFirstByNumeIgnoreCaseStartingWith(String nume_farmacie);	
//	List<Farmacie> findByNume_farmacieNotLikeOrderByStateAsc(String nume_farmacie);		
	List<Farmacie> findByNumeNot(String nume_farmacie);
	
}
