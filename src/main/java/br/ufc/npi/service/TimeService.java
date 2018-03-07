package br.ufc.npi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;
import br.ufc.npi.repositorio.JogadorRepositorio;
import br.ufc.npi.repositorio.TimeRepositorio;

@Service
public class TimeService {
	
	@Autowired
	TimeRepositorio repTime;
	@Autowired
	JogadorRepositorio repJogador;
	
	public Time salvarTime(String nome){
		Time time = new Time();
		time.setNome(nome);
		repTime.save(time);
		return time;
	}
	public void excluirTime(Integer idTime){
		repTime.delete(repTime.findOne(idTime));
	}
	public List<Time> getTodosTimes(){
		return repTime.findAll();
	}
	public Time getTime(Integer id){
		return repTime.findOne(id);
	}

	public boolean addJogadorAoTime(Integer idTime, Integer jogadorSemTimeID) {

	  Time time = repTime.findOne(idTime);
	  if(time.getJogadores().size()==7){
	    return false;
	  }else {
	    Jogador jogador = repJogador.findOne(jogadorSemTimeID);
	    time.getJogadores().add(jogador);
	    jogador.setTime(time);
	    repTime.save(time);
	    repJogador.save(jogador);
	    return true;
	  }
	}
	
	public void delJogadorTime(Integer idTime,Integer idJogador){
		Time time = repTime.findOne(idTime);
		Jogador jogador = repJogador.findOne(idJogador);
		time.getJogadores().remove(jogador);
		jogador.setTime(null);
		
		repTime.save(time);
		repJogador.save(jogador);
	}
	public void delTodosOsJogadoresDoTime(Integer idTime){
		Time time = repTime.findOne(idTime);
		for( Jogador i : time.getJogadores() ){
			Integer idJogador = i.getId();
			this.delJogadorTime(idTime, idJogador);
		}
	}

}
