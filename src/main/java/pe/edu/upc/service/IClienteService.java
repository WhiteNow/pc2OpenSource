package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.entity.Cliente;

public interface IClienteService {
	
	public void save(Cliente cliente);
	public void deleteById(Long id);
	public List<Cliente>findAll();
	public Cliente findClienteById(Long id);
	
}
