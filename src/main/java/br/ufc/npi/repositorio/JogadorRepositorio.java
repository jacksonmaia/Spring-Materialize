package br.ufc.npi.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import br.ufc.npi.bean.Jogador;

@Repository
@Transactional


public interface JogadorRepositorio extends JpaRepository<Jogador, Integer> {
	
	Jogador findByNome(String nome);
	@Query("from Jogador j  WHERE j.time is null")
	List<Jogador> buscarJogadoresSemTime();

}
