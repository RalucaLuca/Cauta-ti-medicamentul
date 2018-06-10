package ro.raluca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.raluca.model.Cont;
import ro.raluca.model.CreareCont;

@Repository
public interface CreareContJpaRepository extends JpaRepository<CreareCont, Integer>{
		
		@Query("SELECT utilizator FROM CreareCont")
		List<String> getListaUtilizatori();
		
		@Query("SELECT cont FROM CreareCont WHERE utilizator = ?1")
		List<Cont> getDateCont(String utilizator);
}
