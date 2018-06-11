package pe.edu.upc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Cuenta;

@Repository
public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {

}
