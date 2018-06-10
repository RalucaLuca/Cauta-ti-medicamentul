package ro.raluca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.raluca.model.Cont;

@Repository
public interface ContJpaRepository extends JpaRepository<Cont, Integer>{

	@Query("SELECT note, data FROM Cont WHERE idCont= ?1")
	List<String> getNoteCont(Integer idCont);
}
