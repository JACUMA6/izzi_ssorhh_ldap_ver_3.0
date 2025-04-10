package mcsv.izzi.empleados.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mcsv.izzi.empleados.feignclients.UsuariosFeignClient;
import mcsv.izzi.empleados.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcsv.izzi.empleados.entity.Empleados;
import mcsv.izzi.empleados.repository.EmpleadoRepository;
import mcsv.izzi.empleados.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	final private EmpleadoRepository repository;

	@Autowired
	private UsuariosFeignClient feignClient;

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

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

	/********************Eventos con FeignClient*******************/

	public Usuarios saveUsers(int usuarioId, Usuarios users) {
		users.setUsuarioId(usuarioId);
		Usuarios newUsers = feignClient.save(users);
		return newUsers;
	}

	public Map<String, Object> getUsuarioAndEmpleados(int usuarioId){
		Map<String,Object> resultado = new HashMap<>();
		Empleados empleados = repository.findById(usuarioId).orElse(null);

		if(empleados == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}

		resultado.put("Empleados",empleados);
		List<Usuarios> users = feignClient.getUsers(usuarioId);
		if(users.isEmpty()) {
			resultado.put("Usuarios", "El empleado no tiene usuarios relacionados");
		}
		else {
			resultado.put("Usuarios", users);
		}

		return resultado;
	}

}
