package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Time;
import br.ufc.npi.repositorio.TimeRepositorio;

@Service
public class TimeService {
	
	@Autowired
	TimeRepositorio rep;
	
	
	public Time salvarTime(String nome){
		Time time = new Time();
		time.setNome(nome);
		rep.save(time);
		return time;
	}
	public List<Time> getTodosTimes(){
		return rep.findAll();
	}

}
