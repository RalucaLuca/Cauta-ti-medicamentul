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
	
	public Farmacie create(Farmacie farm) {
		entityManager.persist(farm);	
		entityManager.flush();		
		return farm;
	}
	
	public Farmacie find(Long id) {
		
		return entityManager.find(Farmacie.class, id);
	}
	
	public List<Farmacie> getFarmacieByNume_farmacie(String nume_farmacie) {
		@SuppressWarnings("unchecked")		
		List<Farmacie> farms = entityManager
				.createQuery("select f from Farmacie f where f.nume like :nume_farmacie")
				.setParameter("nume_farmacie", nume_farmacie+ "%").getResultList();	
		return farms;
	}

//	public List<Farmacie> getOne(Integer id_farmacie) {
//		@SuppressWarnings("unchecked")		
//		List<Farmacie> farm = entityManager
//				.createQuery("select f from Farmacie f where f.id_farmacie like :id_farmacie")
//				.setParameter("nume_farmacie", id_farmacie + "%").getResultList();	
//		return farm;
//	}
}
