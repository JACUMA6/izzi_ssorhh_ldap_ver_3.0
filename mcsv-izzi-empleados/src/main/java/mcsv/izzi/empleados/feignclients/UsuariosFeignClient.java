package mcsv.izzi.empleados.feignclients;


import mcsv.izzi.empleados.models.Usuarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "mcsv-izzi-usuarios-service",url = "http://localhost:8003")
public interface UsuariosFeignClient {

	@PostMapping()
	Usuarios save(@RequestBody Usuarios users);
	
	@GetMapping("/users/{usuarioId}")
	List<Usuarios> getUsers(@PathVariable("usuarioId") int usuarioId);
}
