package mcsv.izzi.empleados.controller;

import java.util.List;
import java.util.Map;

import mcsv.izzi.empleados.models.Usuarios;
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

	final private EmpleadoServiceImpl service;

    public EmpleadoController(EmpleadoServiceImpl service) {
        this.service = service;
    }

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

	@PostMapping("/usuario/{usuarioId}")
	public ResponseEntity<Usuarios> guardarUsers(@PathVariable("usuarioId") int usuarioId, @RequestBody Usuarios users){
		Usuarios nuevoCarro = service.saveUsers(usuarioId, users);
		return ResponseEntity.ok(nuevoCarro);
	}


	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosUsuarios(@PathVariable("usuarioId") int usuarioId){
		Map<String,Object> resultado = service.getUsuarioAndEmpleados(usuarioId);
		return ResponseEntity.ok(resultado);
	}

}