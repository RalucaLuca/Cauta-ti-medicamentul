package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raluca.model.SediuFarmacie;

public interface SediuRepository extends JpaRepository<SediuFarmacie, Integer>{
	
}
