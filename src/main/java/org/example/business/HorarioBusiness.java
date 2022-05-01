package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Horario;
import org.example.repository.HorarioRepositorio;

@Named
public class HorarioBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HorarioRepositorio horariorepositorio;
	
	
	@Transactional
	public int insertar (Horario horario) throws Exception{
		return horariorepositorio.insert(horario);
	}
	
	
	@Transactional
	public int actualizar(Horario horario) throws Exception{
		return horariorepositorio.actualizar(horario);
	}
	
	
	public List<Horario> listarTodo() throws Exception{
		return horariorepositorio.listarTodo();
	}
}
