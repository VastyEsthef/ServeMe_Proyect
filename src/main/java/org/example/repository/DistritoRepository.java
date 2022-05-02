package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Distrito;



@Named
public class DistritoRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	
	private EntityManager em;
	
	
	public List<Distrito> ListarTodo()throws Exception{
		List<Distrito> distritos = new ArrayList<>();
		
		TypedQuery<Distrito> query = em.createQuery("FROM Distrito d", Distrito.class); 
		distritos = query.getResultList();
		return distritos;
	}

	public List<Distrito> buscarPorNombre(String nombre)throws Exception{
		List<Distrito> distritos = new ArrayList<>();
		
		TypedQuery<Distrito> query = em.createQuery("FROM Distrito d WHERE d.nombre LIKE ?1", Distrito.class); //class, tipo de dao que devuelve
		query.setParameter(1, "%"+nombre+"%");
		distritos = query.getResultList();
		return distritos;
	}
	
}
