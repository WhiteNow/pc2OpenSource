package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.entity.Cuenta;

public interface ICuentaService {
	
	public void save(Cuenta cuenta);
	public void deleteById(Long id);
	public List<Cuenta>findAll();
	public Cuenta findCuentaById(Long id);
	
}

