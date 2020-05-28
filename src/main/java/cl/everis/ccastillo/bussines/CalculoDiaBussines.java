package cl.everis.ccastillo.bussines;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import cl.everis.ccastillo.vo.BirthDay;
import cl.everis.ccastillo.vo.Registro;

@Service
@ConfigurationProperties(prefix = "formato")
public class CalculoDiaBussines {
	
	private String patronFecha;
	
	@Autowired
	PoemaClienteService poemaClienteService;
	
	public BirthDay procesarBirthday(Registro registro) {
		BirthDay birthDay = new BirthDay();
		String[] params = registro.getNombreCompleto().split(" ");
		if(params.length == 1)  {
			birthDay.setNombre(params[0]);
		}
		if(params.length == 2) {
			birthDay.setNombre(params[0]);
			birthDay.setApellido(params[1]);
		}
		else if(params.length > 2) {
			birthDay.setNombre(params[0]);
			birthDay.setApellido(params[2]);
		}
		LocalDate fechaNacimiento = LocalDate.parse(registro.getFechaNacimiento() , DateTimeFormatter.ofPattern( patronFecha ));
		
		Long diasFaltantes = 0L;
		Long edad = ChronoUnit.YEARS.between( fechaNacimiento , LocalDate.now() );
		LocalDate fechaHoy = LocalDate.now();
		if( fechaNacimiento.getYear() == fechaHoy.getYear() ) {
			LocalDate fechaActual = LocalDate.of(LocalDate.now().plusYears(1).getYear() , fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
			diasFaltantes = fechaHoy.until( fechaActual , ChronoUnit.DAYS); 
		}
		else {
			LocalDate fechaActual = LocalDate.of(fechaHoy.getYear() , fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
			diasFaltantes = fechaActual.until(fechaHoy  , ChronoUnit.DAYS);
			if(diasFaltantes < 0) {
				diasFaltantes = fechaHoy.until(fechaActual  , ChronoUnit.DAYS);
			}
		}
		if(diasFaltantes == 0) {
			birthDay.setPoemas(poemaClienteService.obtenerPoema());
		}
		birthDay.setEdad(edad.intValue());
		birthDay.setDiasFaltante(diasFaltantes.intValue());
		
		birthDay.setFecha(registro.getFechaNacimiento());
		return birthDay;
	}
	
	public static void main(String[] args) {
		Registro registro = new Registro();
		registro.setFechaNacimiento("21-04-1975");
		new CalculoDiaBussines().procesarBirthday(registro);
	}

	public void setPoemaClienteService(PoemaClienteService poemaClienteService) {
		this.poemaClienteService = poemaClienteService;
	}

	public void setPatronFecha(String patronFecha) {
		this.patronFecha = patronFecha;
	}
	
}
