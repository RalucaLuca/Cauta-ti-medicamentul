package ro.raluca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.raluca.model.Farmacie;

@Controller
public class FarmacieController {
	
//	@RequestMapping(value = "/rides", method = RequestMethod.GET)
//	public @ResponseBody List<Farmacie> getFarmacii() {
//		return farmacieService.getFarmacii();
//	}
//	
//	@RequestMapping(value = "/farmacie/{id_farmacie}", method = RequestMethod.GET)
//	public @ResponseBody Farmacie getFarmacie(@PathVariable(value="id_farmacie") Integer id_farmacie) {
//		return farmacieService.getFarmacie(id_farmacie);
//	}	

//	@Autowired
//	private FarmacieService farmacieService;
//	
//	@RequestMapping(value = "/farmacie", method = RequestMethod.POST)
//	public @ResponseBody Farmacie createRide(@RequestBody Farmacie farmacie) {
//		return farmacieService.createFarmacie(farmacie);
//	}
//	

//	
//	@RequestMapping(value = "/farmacie", method = RequestMethod.PUT)
//	public @ResponseBody Farmacie updateFarmacie(@RequestBody Farmacie farmacie) {
//		return farmacieService.updateFarmacie(farmacie);
//	}
//	
//	@RequestMapping(value = "/batch", method = RequestMethod.GET)
//	public @ResponseBody Object batch() {
//		farmacieService.batch();
//		return null;
//	}
//	
//	@RequestMapping(value = "/delete/{id_farmacie}", method = RequestMethod.DELETE)
//	public @ResponseBody Object delete(@PathVariable(value="id_farmacie") Integer id_farmacie) {
//		farmacieService.deleteFarmacie(id_farmacie);
//		return null;
//	}
//	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public @ResponseBody Object test() throws Exception {
//		throw new Exception("Testing exception thrown") {
//		};
//	}
//	
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
//		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
//		return new ResponseEntity<ServiceError>(error, HttpStatus.OK);
//	}
	
}
