package org.example.business;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Product;
import org.example.repository.ProductRepository;

@Named
public class ProductBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductRepository productRepository;
	
	//Por si falla
	@Transactional
	public Long insert(Product product) throws Exception{
		//1tambien se puede poner 
		//product.setProduct para
		//obtener el producto de acuerdo a las reglas del negocio
		return productRepository.insert(product);
	}
	
	//2
	
//	  private double obtenerProducto (Product product) { 
//	  double resultadoProducto,resultadox, resultadoy; 
//		if algo 
//	  }
		
	 
	
	
	@Transactional
	public Long update(Product product) throws Exception{
		return productRepository.update(product);
	}
	
	
	public List<Product> getAll() throws Exception{
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByName(String name) throws Exception{
		return productRepository.findByName(name);
	}
	
}
