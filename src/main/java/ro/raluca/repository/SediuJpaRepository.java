package ro.raluca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.raluca.model.SediuFarmacie;

@Repository
public interface SediuJpaRepository extends JpaRepository <SediuFarmacie, Integer>{
	
	//Cautare dupa adresa
	List<SediuFarmacie> findByAdresaIgnoreCaseStartingWith(String adresa);	
//	SediuFarmacie findFirstByAdresaIgnoreCaseStartingWith(String adresa);	
//	List<SediuFarmacie> findByAdresaNot(String adresa);
	
	//Cautare dupa id_farmacie
	List<SediuFarmacie> findAllByIdFarmacieEquals(Integer id_farmacie);

}
