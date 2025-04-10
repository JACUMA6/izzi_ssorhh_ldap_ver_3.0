package mcsv.izzi.usuarios.services.impl;

import java.util.List;

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
	public Usuarios getUsersById(int id) {
		return repository.findById(id).orElse(null);
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
