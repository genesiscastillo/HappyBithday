package cl.everis.ccastillo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.everis.ccastillo.vo.BirthDay;
import cl.everis.ccastillo.vo.Registro;

public class HappyBirthdayTest extends AbstractTest {

	private static String uri = "/happyBirthday/calcularDias";
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void antesFechaActual1() throws Exception {
		Registro registro = new Registro();
		registro.setNombreCompleto("Cesar Castillo");
		registro.setFechaNacimiento("21-04-1975");
		String inputJson = super.mapToJson(registro);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		BirthDay birthDay =	objectMapper.readValue(content, BirthDay.class);
		assertEquals(birthDay.getEdad().intValue(), 45);
	}

	@Test
	public void antesFechaActual2() throws Exception {
		Registro registro = new Registro();
		registro.setNombreCompleto("Yamilet Castillo");
		registro.setFechaNacimiento("30-05-2012");
		String inputJson = super.mapToJson(registro);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		BirthDay birthDay =	objectMapper.readValue(content, BirthDay.class);
		assertEquals(birthDay.getEdad().intValue(), 7);
	}

}
