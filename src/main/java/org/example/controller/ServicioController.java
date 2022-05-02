package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.ServicioBusiness;
import org.example.entities.Servicio;

@Named
@SessionScoped
public class ServicioController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioBusiness servicioBusiness;

	private Servicio comentario;
	private List<Servicio> comentarios;

	@PostConstruct
	public void init() {
		comentario = new Servicio();
		comentarios = new ArrayList<>();

		getAllServicios();
	}

	public String getAllServicios() {
		try {
			comentarios = servicioBusiness.getAll();

		} catch (Exception e) {

		}
		return null;
	}

	public String newServicio() {
		try {
			this.comentarios = servicioBusiness.getAll();
			this.resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "Boton.xhtml";
	}

	public void resetForm() {
		comentario = new Servicio();
	}

	public String listServicio() {
		return "Boton.xhtml";
	}

	public ServicioBusiness getServicioBusiness() {
		return servicioBusiness;
	}

	public void setServicioBusiness(ServicioBusiness servicioBusiness) {
		this.servicioBusiness = servicioBusiness;
	}

	public Servicio getComentario() {
		return comentario;
	}

	public void setComentario(Servicio comentario) {
		this.comentario = comentario;
	}

	public List<Servicio> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Servicio> comentarios) {
		this.comentarios = comentarios;
	}

}