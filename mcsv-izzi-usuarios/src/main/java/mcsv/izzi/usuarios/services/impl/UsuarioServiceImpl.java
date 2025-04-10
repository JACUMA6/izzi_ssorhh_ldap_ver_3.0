package mcsv.izzi.usuarios.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import mcsv.izzi.usuarios.entity.Usuarios;
import mcsv.izzi.usuarios.repository.UsuarioRepository;
import mcsv.izzi.usuarios.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	final private UsuarioRepository repository;

	final private Environment environment;

    public UsuarioServiceImpl(UsuarioRepository repository, Environment environment) {
        this.repository = repository;
		this.environment = environment;
    }

    @Override
	public List<Usuarios> getAll(){
		return ((List<Usuarios>) repository.findAll()).stream().map(users ->{
			users.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return users;
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<Usuarios> getUsersById(int id) {
		return repository.findById(id).map(users -> {
			users.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return users;
		});
	}
	
	@Override
	public Usuarios save(Usuarios users) {
		Usuarios newUsers = repository.save(users);
		return newUsers;
	}

	@Override
	public List<Usuarios> byUsuarioId(int usuarioId){
		return repository.findByUsuarioId(usuarioId);
	}

}
