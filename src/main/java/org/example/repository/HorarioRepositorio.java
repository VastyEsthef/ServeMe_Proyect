package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Horario;


@Named
public class HorarioRepositorio implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	
	private EntityManager em;
	
	
	//INSERTAR
	public int insert(Horario horario) throws Exception{
		em.persist(horario);
		return horario.getId();
	}
	
	
	//ACTUALIZAR
	public int actualizar(Horario horario) throws Exception{
		em.merge(horario);
		return horario.getId();
	}
		
	//LISTAR
	public List<Horario> listarTodo() throws Exception{
		List<Horario> horarios = new ArrayList<>();
		TypedQuery<Horario> query = em.createQuery("FROM Horario h", Horario.class);
		horarios = query.getResultList();
		return horarios;
	}
	
}
