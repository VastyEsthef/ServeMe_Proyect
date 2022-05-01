package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Product;

@Named
public class ProductRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demoWeb")
	
	private EntityManager em;
	
	//INSERTAR
	public Long insert(Product product) throws Exception{
		em.persist(product);
		return product.getId();
	}
	
	//ACTUALIZAR
	public Long update(Product product) throws Exception{
		em.merge(product);
		return product.getId();
	}
	
	//LISTAR
	public List<Product> findAll() throws Exception{
		List<Product> products = new ArrayList<>();
		//FROM Product p ==> JPQL Java Persistence Query Language
		TypedQuery<Product> query = em.createQuery("FROM Product p", Product.class);
		products = query.getResultList();
		return products;
	}
	
	//LISTAR POR NOMBRE (nombre completo o parcial, busca coincidencias -> LIKE ?Posicion del unico parametro que ingresas   )
	public List<Product> findByName(String name)throws Exception{
		List<Product> products = new ArrayList<>();
		//FROM Product p ==> JPQL Java Persistence Query Language
		TypedQuery<Product> query = em.createQuery("FROM Product p WHERE p.name LIKE ?1", Product.class); //class, tipo de dao que devuelve
		query.setParameter(1, "%"+name+"%");
		products = query.getResultList();
		return products;
	}
	
}
