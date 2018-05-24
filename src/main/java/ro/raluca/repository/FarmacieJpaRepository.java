package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.raluca.model.Farmacie;

@Repository
public interface FarmacieJpaRepository extends JpaRepository<Farmacie, Integer>{
		
}

