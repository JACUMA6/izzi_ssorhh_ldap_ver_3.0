package mcsv.izzi.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mcsv.izzi.empleados.entity.Empleados;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer>{

}
