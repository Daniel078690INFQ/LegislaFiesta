package ifsul.lp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ifsul.lp.DTO.*;
import ifsul.lp.entities.*;
import ifsul.lp.repository.*;

@Service
public class DeputadoServices {

	@Autowired
	private DeputadoRepository depRepo;

	public List<DeputadoDTO> list() {
		return depRepo.findAll()
				.stream()
				.map(deputado-> {
					return DeputadoDTO.builder().
							id(deputado.getId()).
							nome(deputado.getNome()).
							siglaPartido(deputado.getSiglaPartido()).
							siglaUf(deputado.getSiglaUf()).
							build();
				})
				.collect(Collectors.toList());
	}

	public Deputado create(Deputado deputado) {
		return depRepo.save(deputado);
	}

	public DeputadoDTO getDeputadoById(Long id) {
		Deputado deputado = depRepo.findById(id).get();
		return DeputadoDTO.builder().
				id(deputado.getId()).
				nome(deputado.getNome()).
				siglaPartido(deputado.getSiglaPartido()).
				siglaUf(deputado.getSiglaUf()).
				build();
	}
}
