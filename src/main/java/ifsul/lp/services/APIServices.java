package ifsul.lp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIServices {
	
	@Autowired
	private RestTemplate restTemplate;

	public String getData() {
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String responseBody = responseEntity.getBody();

		return responseBody;

	}

	public String getDataEventos() {
		String url = "https://dadosabertos.camara.leg.br/api/v2/eventos?ordem=ASC&ordenarPor=id";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String responseBody = responseEntity.getBody();

		return responseBody;

	}
}