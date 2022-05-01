package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.HorarioBusiness;
import org.example.entities.Horario;

@Named
@SessionScoped
public class HorarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private HorarioBusiness horarioBusiness;

	private Horario horario;
	private Horario horarioSeleccionado;
	private List<Horario> horarios;

	@PostConstruct
	public void init() {

		horario = new Horario();
		horarioSeleccionado = new Horario();
		horarios = new ArrayList<>();
		
		ObtenerTodosHorarios();
	}
	
	
	public void ObtenerTodosHorarios() {
		try {
			horarios = horarioBusiness.listarTodo();
		} catch (Exception e) {
			
		}
	}
	
	public int guardarHorario() {
		
		return 0;
		
	}
	
	
	
	public String editarHorario() {
		return "";
	}
	
	public List<Horario> getHorarios() {
		return horarios;
	}



	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}



	public HorarioBusiness getHorarioBusiness() {
		return horarioBusiness;
	}


	public void setHorarioBusiness(HorarioBusiness horarioBusiness) {
		this.horarioBusiness = horarioBusiness;
	}


	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Horario getHorarioSeleccionado() {
		return horarioSeleccionado;
	}

	public void setHorarioSeleccionado(Horario horarioSeleccionado) {
		this.horarioSeleccionado = horarioSeleccionado;
	}

}
