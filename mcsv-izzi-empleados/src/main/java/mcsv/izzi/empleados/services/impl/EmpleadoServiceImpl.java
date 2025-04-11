package mcsv.izzi.empleados.services.impl;

import java.util.*;

import mcsv.izzi.empleados.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcsv.izzi.empleados.entity.Empleados;
import mcsv.izzi.empleados.repository.EmpleadoRepository;
import mcsv.izzi.empleados.services.EmpleadoService;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	final private EmpleadoRepository repository;

	final private WebClient.Builder client;

    public EmpleadoServiceImpl(EmpleadoRepository repository, Builder client) {
        this.repository = repository;
		this.client = client;
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

	/*******************Eventos con WebClient*******************/


	public List<Empleados> findAll() {
        return this.client.build()
                .get()
				.uri("http://mcsv-izzi-usuarios")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Usuarios.class)
                .map(users -> new Empleados())
                .collectList()
                .block();
    }

	public Optional<Empleados> findById(Long id) {
	Map<String, Long> params = new HashMap<>();
	params.put("id", id);
	try {
		return Optional.of(Objects.requireNonNull(client.build().get().uri("http://mcsv-izzi-usuarios/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Usuarios.class)
                .map(users -> new Empleados())
                .block()));
		} catch (WebClientResponseException e) {
			return Optional.empty();
		}
    }
}
