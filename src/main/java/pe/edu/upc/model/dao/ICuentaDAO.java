package pe.edu.upc.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Cuenta;

@Repository
public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {
	
	@Query("select c from Cuenta c where c.cliente.id =?1")
	public List<Cuenta> listCuentaByCliente(Long id);
}
