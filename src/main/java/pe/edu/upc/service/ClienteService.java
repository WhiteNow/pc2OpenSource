package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IClienteDAO;
import pe.edu.upc.model.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO dao;
	
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findClienteById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
