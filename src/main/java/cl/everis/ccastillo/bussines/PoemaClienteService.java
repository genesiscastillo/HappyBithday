package cl.everis.ccastillo.bussines;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.everis.ccastillo.vo.Poema;

@Service
@ConfigurationProperties(prefix = "url")
public class PoemaClienteService {
	private static final Logger LOGGER = Logger.getLogger(PoemaClienteService.class.getName());
	private String urlpoemist = "https://www.poemist.com/api/v1/randompoems";

	public List<Poema> obtenerPoema() {
		List<Poema> poemas = new ArrayList<Poema>();
		try {
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(urlpoemist);
			javax.ws.rs.core.Response response = webTarget.request().get();
			String jsonData = response.readEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			poemas = mapper.readValue(jsonData, new TypeReference<List<Poema>>() {});
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage() , exception );
		}
		return poemas;
	}

	public static void main(String[] args) throws Exception {
		new PoemaClienteService().obtenerPoema();
	}

	public void setUrlpoemist(String urlpoemist) {
		this.urlpoemist = urlpoemist;
	}

}
