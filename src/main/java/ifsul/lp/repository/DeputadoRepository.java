package ifsul.lp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsul.lp.entities.Deputado;

public interface DeputadoRepository extends JpaRepository<Deputado, Integer> {

    List<Deputado> findAllById(int id);

}
