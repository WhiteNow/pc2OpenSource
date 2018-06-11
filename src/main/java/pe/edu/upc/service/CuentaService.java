package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.ICuentaDAO;
import pe.edu.upc.model.entity.Cuenta;

@Service
public class CuentaService implements ICuentaService {

	@Autowired
	private ICuentaDAO dao;
	
	
	@Override
	@Transactional
	public void save(Cuenta Cuenta) {
		// TODO Auto-generated method stub
		dao.save(Cuenta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cuenta findCuentaById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}


