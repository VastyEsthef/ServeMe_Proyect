package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Trabajador;

@Named
public class TrabajadorRepository implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	
	private EntityManager em;
	
	
	//INSERTAR
		public int insert(Trabajador trabajador) throws Exception{
			em.persist(trabajador);
			return trabajador.getId();
		}
		
		
	//LISTAR
		public List<Trabajador> ListarTodo() throws Exception{
			List<Trabajador> trabajadores = new ArrayList<>();
			
			TypedQuery<Trabajador> query = em.createQuery("FROM Trabajador t", Trabajador.class);
			trabajadores = query.getResultList();
			return trabajadores;
		}
}
