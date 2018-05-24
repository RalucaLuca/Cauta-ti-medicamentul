package ro.raluca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ro.raluca.model.Farmacie;

@Repository
public class FarmacieRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;

//	public Farmacie find( ) {		
//		return entityManager.findAll(Farmacie.class);
//	}
	
	//AFISEAZA TOATE FARMACIILE !!
	public List<Farmacie> getFarmacieById(int id_farmacie) {	
		@SuppressWarnings("unchecked")	
		List<Farmacie> farm = entityManager.createQuery("SELECT f.nume_farmacie FROM Farmacie f Where f.id_farmacie = id_farmacie").getResultList();
		
		return farm;
	}
	
//	public List<Farmacie> getFarmacieById(Integer id_farmacie) {	
//		@SuppressWarnings("unchecked")	
//		List<Farmacie> farm = entityManager.createQuery("SELECT l FROM Farmacie f Where f.nume_farmacie like :nume_farmacie").setParameter("farmacia: ", id_farmacie + "%").getResultList();
//		
//		return farm;
//	}
}

	



	

