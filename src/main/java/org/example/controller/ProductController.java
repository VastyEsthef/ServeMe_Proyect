package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.ProductBusiness;
import org.example.business.SupplierBusiness;
import org.example.entities.Product;
import org.example.entities.Supplier;

@Named
@SessionScoped //usado para actualizar, mantener valores
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductBusiness productBusiness;

	@Inject
	private SupplierBusiness supplierBusiness;
	
	//definiendo una clase, representa al formulario
	private Product product;
	
	//Aqui se representa la vista del listado
	private List<Product> products;
	
	
	private Supplier supplier;
	private List<Supplier> suppliers;
	
	//Despues de que se ejecute el constructor pasara lo demas
	@PostConstruct //Carga el form y se muestra la lista de golpe
	public void init() { //Primero se ejecuta el constructor y luego el init
		
		product = new Product();
		products = new ArrayList<>();
		
		supplier = new Supplier();
		suppliers = new ArrayList<>();
		
		getAllProducts();
	}
	
	
	public void getAllProducts() {
		try {
			products=productBusiness.getAll();
		} catch (Exception e) {
			
		}
	}
	
	//INSERT
	/*
	 * public String newProduct() { 
	 * try { this.suppliers =
	 * 		supplierBusiness.getAllSuppliers(); product = new Product(); 
	 * } catch
	 * 		(Exception e) {
	 * 
	 * }
	 * 
	 * return "insert.xhtml"; 
	 * }
	 */
	
	
	  public String newProduct() {
	  
		  return "insert.xhtml"; 
	  }
	 
	
	
	//agregado
	private String saveProduct() {
		return "";
	}
	
	private String listProduct() {
		return "";
	}


	public ProductBusiness getProductBusiness() {
		return productBusiness;
	}


	public void setProductBusiness(ProductBusiness productBusiness) {
		this.productBusiness = productBusiness;
	}


	public SupplierBusiness getSupplierBusiness() {
		return supplierBusiness;
	}


	public void setSupplierBusiness(SupplierBusiness supplierBusiness) {
		this.supplierBusiness = supplierBusiness;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public List<Supplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	
	
	
	
	
	
}
