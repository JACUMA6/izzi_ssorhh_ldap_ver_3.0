package mcsv.izzi.empleados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcsv.izzi.empleados.entity.Empleados;
import mcsv.izzi.empleados.repository.EmpleadoRepository;
import mcsv.izzi.empleados.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository repository;

	@Override
	@Transactional(readOnly = false)
	public List<Empleados> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Empleados getUsuarioById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Empleados save(Empleados empleados) {
		Empleados nuevoEmpleado = repository.save(empleados);
		return nuevoEmpleado;
	}

}
