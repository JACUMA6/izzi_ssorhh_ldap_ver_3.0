package mcsv.izzi.empleados.services;

import java.util.List;

import mcsv.izzi.empleados.entity.Empleados;

public interface EmpleadoService {
	List<Empleados> getAll();
	Empleados getUsuarioById(int id);
	Empleados save(Empleados empleados);
}
