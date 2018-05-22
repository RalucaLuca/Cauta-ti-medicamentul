package ro.raluca.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raluca.model.Sediu_Farmacie;

public interface AutentificationRepositorySedii extends JpaRepository<Sediu_Farmacie, Integer>{
	
}
