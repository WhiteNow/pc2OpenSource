package pe.edu.upc.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Movimiento;

@Repository
public interface IMovimientoDAO extends JpaRepository<Movimiento, Long> {

	@Query("select m from Movimiento m join fetch m.cuenta c where c.id=?1")
	public List<Movimiento> listMovimientoByCuenta(Long id);
}
