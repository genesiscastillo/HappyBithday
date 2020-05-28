package cl.everis.ccastillo.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.everis.ccastillo.bussines.CalculoDiaBussines;
import cl.everis.ccastillo.vo.BirthDay;
import cl.everis.ccastillo.vo.Registro;

@RestController
@RequestMapping("/happyBirthday")
public class RestCalculoDias {

	private static final Logger LOGGER = Logger.getLogger(RestCalculoDias.class.getName());
	
	@Autowired
	CalculoDiaBussines calculoDiaBussines; 
	
	@RequestMapping(value = "/calcularDias", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<BirthDay> registrarUsuario(@RequestBody Registro registro) {
		LOGGER.info(registro);
		BirthDay birthDay = new BirthDay();
		birthDay = calculoDiaBussines.procesarBirthday(registro);
		LOGGER.info(birthDay);
		return ResponseEntity.ok().body(birthDay);
	}

	public void setCalculoDiaBussines(CalculoDiaBussines calculoDiaBussines) {
		this.calculoDiaBussines = calculoDiaBussines;
	}
	
}
