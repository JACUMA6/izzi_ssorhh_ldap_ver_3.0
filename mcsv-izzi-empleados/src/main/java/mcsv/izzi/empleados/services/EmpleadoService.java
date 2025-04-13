package mcsv.izzi.empleados.services;

import java.util.*;

import mcsv.izzi.empleados.entity.Empleados;

public interface EmpleadoService {
	List<Empleados> getAll();
	Optional<Empleados> getUsuarioById(int id);
	Empleados save(Empleados empleados);
}
