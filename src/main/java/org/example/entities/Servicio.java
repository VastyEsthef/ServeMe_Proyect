package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double precio;
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "tiposervicio_id", nullable = false)
	private TipoServicio tipoServicioCodigo;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public TipoServicio getTipoServicioCodigo() {
		return tipoServicioCodigo;
	}

	public void setTipoServicioCodigo(TipoServicio tipoServicioCodigo) {
		this.tipoServicioCodigo = tipoServicioCodigo;
	}

	

}