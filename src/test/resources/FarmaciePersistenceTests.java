//package com.guitar.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNotSame;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.guitar.Main;
//import com.guitar.model.Location;
//import com.guitar.repository.LocationJpaRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Main.class)
//@WebAppConfiguration
//
//public class FarmaciePersistenceTests {
//	@Autowired
//	private FarmacieJpaRepository farmacieJpaRepository;
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Test
//	public void testJpaFind() {
//		List<Farmacie> farmacii = farmacieJpaRepository.findAll();
//		assertNotNull(farmacii);
//	}
//	
//	@Test
//	public void testJpaAnd() {
//		List<Farmacie> farmacii = farmacieJpaRepository.findByName("catena");
//		assertNotNull(farmacii);
//		
//		assertNotSame("catena", farmacii.get(0).getNume_farmacie());
//	}
//
//	@Test
//	@Transactional
//	public void testSaveAndGetAndDelete() throws Exception {
//		Farmacie farmacie = new Farmacie();
//		farmacie.setNume_farmacie("Drogherie");
//		farmacie = farmacieJpaRepository.saveAndFlush(farmacie);
//		
//		// clear the persistence context so we don't return the previously cached location object
//		// this is a test only thing and normally doesn't need to be done in prod code
//		entityManager.clear();
//
//		Farmacie otherFarmacie = farmacieJpaRepository.findOne(farmacie.getId_farmacie());
////		assertEquals("Canada", otherLocation.getCountry());
////		assertEquals("British Columbia", otherFarmacie.getState());
//		
//		//delete BC location now
//		farmacieJpaRepository.delete(otherFarmacie);
//	}
//
//	@Test
//	public void testFindWithLike() throws Exception {
//		List<Farmacie> farms = farmacieJpaRepository.findByNumeIgnoreCaseStartingWith("catena");
//		assertEquals(10, farms.size());
//
//		farms = farmacieJpaRepository.findByNumeNotLikeOrderByStateAsc("catena%");
//		assertEquals(46, farms.size());
//		
//		farms.forEach((farmacie) -> {
//			System.out.println(farmacie.getNume_Farmacie());
//		});
//		
//		Farmacie farm = farmacieJpaRepository.findFirstByNumeIgnoreCaseStartingWith("c");
//		assertEquals("catena", farm.getNume_farmacie());
//	}
//
////	@Test
////	@Transactional  //note this is needed because we will get a lazy load exception unless we are in a tx
////	public void testFindWithChildren() throws Exception {
////		Location arizona = locationJpaRepository.findOne(3L);
////		assertEquals("United States", arizona.getCountry());
////		assertEquals("Arizona", arizona.getState());
////		
////		assertEquals(1, arizona.getManufacturers().size());
////		
////		assertEquals("Fender Musical Instruments Corporation", arizona.getManufacturers().get(0).getName());
////	}
//}
