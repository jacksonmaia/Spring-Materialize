package br.ufc.npi.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;

@Repository
@Transactional

public interface TimeRepositorio  extends JpaRepository<Time, Integer> {

	Jogador findByNome(String nome);

}
