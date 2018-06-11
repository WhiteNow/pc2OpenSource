package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.entity.Movimiento;

public interface IMovimientoService {
	
	public void save(Movimiento movimiento);
	public void deleteById(Long id);
	public List<Movimiento>findAll();
	public Movimiento findMovimientoById(Long id);
	public List<Movimiento> listMovimientoByCuenta(Long id);
}

