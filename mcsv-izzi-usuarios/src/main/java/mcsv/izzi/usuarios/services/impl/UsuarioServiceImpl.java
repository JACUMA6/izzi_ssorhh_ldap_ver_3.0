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

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
	public List<Usuarios> getAll(){
		return repository.findAll();
	}

	@Override
	public Optional<Usuarios> getUsersById(int id) {
		return repository.findById(id);
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
