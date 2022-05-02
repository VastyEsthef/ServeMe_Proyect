package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Servicio;

@Named
public class ServicioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="demoWeb")
	private EntityManager em;
	
	public String  insert(Servicio servicio)throws Exception{
		em.persist(servicio);
		return servicio.getComentario();
	}
	
	public String  update(Servicio servicio)throws Exception{
		em.persist(servicio);
		return servicio.getComentario();
	}
	
	
	
	public List<Servicio>findAll()throws Exception{
		List<Servicio> servicios=new ArrayList<>();
		TypedQuery<Servicio> query=em.createQuery("SELECT s From Servicio s",Servicio.class);
		servicios=query.getResultList();
		
		return servicios;
	}
	
	public List<Servicio>findByName(String nombre) throws Exception{
		List<Servicio> servicios=new ArrayList<>();
		TypedQuery<Servicio> query=em.createQuery("FROM Servicio s WHERE s.nombre LIKE ?1",Servicio.class);
		query.setParameter(1, "%"+nombre+"%");
		servicios=query.getResultList();
		
		return servicios;
	}

	public List<Servicio>findByComentario(String comentario) throws Exception{
		List<Servicio> servicios=new ArrayList<>();
		TypedQuery<Servicio> query=em.createQuery("FROM Servicio s WHERE s.comentario ",Servicio.class);
		servicios=query.getResultList();
		
		return servicios;
	}
}

	
