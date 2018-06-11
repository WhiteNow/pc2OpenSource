package pe.edu.upc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Movimiento;

@Repository
public interface IMovimientoDAO extends JpaRepository<Movimiento, Long> {

}
