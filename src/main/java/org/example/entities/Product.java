package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long category;
	
	//Columno por tiene mas de una palabra
	@Column(name = "unit_price", nullable = false) //no soporta valores nulos
	private double unitPrice;
	@Column(name = "units_stock", nullable = false)
	private double unitsStock;

	// relacion muchos a uno
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	// vinculo entre las clases
	private Supplier supplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitsStock() {
		return unitsStock;
	}

	public void setUnitsStock(double unitsStock) {
		this.unitsStock = unitsStock;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
