package mcsv.izzi.usuarios.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mcsv.izzi.usuarios.entity.Usuarios;
import mcsv.izzi.usuarios.services.UsuarioService;

@RestController
@RequestMapping
public class UsuarioController {

	final private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
	public ResponseEntity<List<Usuarios>> listarUsuarios(){
		List<Usuarios> users = service.getAll();
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> obtenerUsers(@PathVariable("id") int id){
		Usuarios users = service.getUsersById(id);
		if(users == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(users);
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> guardarUsers(@RequestBody Usuarios users){
		Usuarios newUser = service.save(users);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("/users/{usuarioId}")
	public ResponseEntity<List<Usuarios>> listarUsuariosPorId(@PathVariable("usuarioId") int id){
		List<Usuarios> users = service.byUsuarioId(id);
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}
}