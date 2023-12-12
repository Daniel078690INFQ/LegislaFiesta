package ifsul.lp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsul.lp.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	List<Evento> findAllById(int id);

}
