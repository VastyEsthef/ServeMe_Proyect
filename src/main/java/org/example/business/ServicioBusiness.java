package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Servicio;
import org.example.repository.ServicioRepository;

@Named
public class ServicioBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioRepository servicioRepositorio;
	
	

	public List<Servicio> getAll() throws Exception {
		return servicioRepositorio.findAll();
	}
	
	
	@Transactional
	public String insert (Servicio servicio) throws Exception{
		return servicioRepositorio.insert(servicio);
	} 

	@Transactional
	public String update (Servicio servicio) throws Exception{
		return servicioRepositorio.update(servicio);
	}
	
	/*
	 * @Transactional public String delete (Servicio servicio) throws Exception{
	 * return servicioRepositorio.delete(servicio); }
	 */

	

	public List<Servicio> getServiciosByName(String nombre) throws Exception {
		return servicioRepositorio.findByName(nombre);
	}
	
	public List<Servicio> getServicioByComentario(String comentario) throws Exception{
		return servicioRepositorio.findByComentario(comentario);
	}
	
}