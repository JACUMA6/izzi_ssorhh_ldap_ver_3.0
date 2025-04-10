package mcsv.izzi.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mcsv.izzi.empleados.entity.Empleados;
import mcsv.izzi.empleados.services.impl.EmpleadoServiceImpl;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoServiceImpl service;


	@GetMapping
	public ResponseEntity<List<Empleados>> listarUsuarios(){
		List<Empleados> empleados = service.getAll();
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(empleados);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleados> obtenerUsuario(@PathVariable("id") int id){
		Empleados empleados = service.getUsuarioById(id);
		if(empleados == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleados);
	}
	
	@PostMapping
	public ResponseEntity<Empleados> guardarUsuario(@RequestBody Empleados empleados){
		Empleados nuevoEmpleado = service.save(empleados);
		return ResponseEntity.ok(nuevoEmpleado);
	}


}