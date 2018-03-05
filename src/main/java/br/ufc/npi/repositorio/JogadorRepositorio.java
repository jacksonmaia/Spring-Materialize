package br.ufc.npi.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import br.ufc.npi.bean.Time;

@Repository
@Transactional


public interface JogadorRepositorio extends JpaRepository<Time, Integer> {
	
	Time findByNome(String nome);

}
