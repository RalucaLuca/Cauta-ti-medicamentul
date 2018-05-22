package ro.raluca.service;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raluca.model.Medicament;

public interface AutentificationRepositoryMed extends JpaRepository<Medicament, Integer>{
	
}
