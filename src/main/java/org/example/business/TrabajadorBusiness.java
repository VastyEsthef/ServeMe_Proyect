package org.example.business;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;


import org.example.entities.Trabajador;
import org.example.repository.TrabajadorRepositorio;

@Named
public class TrabajadorBusiness {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TrabajadorRepositorio trabajadorepositorio;
	
	@Transactional
	public int insertar (Trabajador trabajador) throws Exception{
		return trabajadorepositorio.insert(trabajador);
	}
	
}
