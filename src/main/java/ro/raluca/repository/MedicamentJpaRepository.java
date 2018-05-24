package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raluca.model.Medicament;

public interface MedicamentJpaRepository extends JpaRepository<Medicament, Integer> {

}
