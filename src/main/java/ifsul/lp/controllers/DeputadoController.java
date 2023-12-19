package ifsul.lp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ifsul.lp.DTO.*;
import ifsul.lp.entities.*;
import ifsul.lp.services.*;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {

	@Autowired
	private DeputadoServices depSer;

	@GetMapping("/listar")
	public List<DeputadoDTO> listar() {
		return depSer.listar();
	}

	@GetMapping("/listar/{id}")
	public Deputado listarPorId(@PathVariable int id) {
		return depSer.listarPorId(id);
	}

	@PutMapping("/inscricao/{dep}/{eve}")
	public ResponseEntity<?> fazerInscricao(@PathVariable int dep, @PathVariable int eve) {
		return depSer.fazerInscricao(dep, eve);
	}

	@PutMapping("/excluir/inscricao/{dep}/{eve}")
	public ResponseEntity<?> excluirInscricao(@PathVariable int dep, @PathVariable int eve) {
		return depSer.excluirInscricao(dep, eve);
	}

	@GetMapping("/inscricoes/{id}")
	public List<EventoDTO> listarInscricoes(@PathVariable int id) {
		return depSer.listarInscricoes(id);
	}

	@PutMapping("/editar/inscricao/{dep}/{eve}/{eveNovo}")
	public ResponseEntity<?> editarInscricao(@PathVariable int dep, @PathVariable int eve, @PathVariable int eveNovo) {
		return depSer.editarInscricao(dep, eve, eveNovo);
	}

}