package ro.raluca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.raluca.model.MedicamenteSediu;

@Repository
public interface MedicamenteSediuJpaRepository  extends JpaRepository<MedicamenteSediu, Integer> {
	
}
