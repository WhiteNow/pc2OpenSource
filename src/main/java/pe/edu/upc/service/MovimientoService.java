package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IMovimientoDAO;
import pe.edu.upc.model.entity.Movimiento;

@Service
public class MovimientoService implements IMovimientoService {

	@Autowired
	private IMovimientoDAO dao;
	
	
	@Override
	@Transactional
	public void save(Movimiento movimiento) {
		// TODO Auto-generated method stub
		this.actualizarSaldo(movimiento);
		dao.save(movimiento);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Movimiento findMovimientoById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	private void actualizarSaldo(Movimiento movimiento) {
		if(movimiento.getTipo().equalsIgnoreCase("Retiro")) {
			double monto = movimiento.getMonto();
			double saldoAnterior = movimiento.getCuenta().getSaldo();
			movimiento.getCuenta().setSaldo(saldoAnterior - monto);
		}else {
			if(movimiento.getTipo().equalsIgnoreCase("Deposito")) {
				double monto = movimiento.getMonto();
				double saldoAnterior = movimiento.getCuenta().getSaldo();
				movimiento.getCuenta().setSaldo(saldoAnterior + monto);
			}
		}
	}

	@Override
	public List<Movimiento> listMovimientoByCuenta(Long id) {
		// TODO Auto-generated method stub
		return dao.listMovimientoByCuenta(id);
	}
}

