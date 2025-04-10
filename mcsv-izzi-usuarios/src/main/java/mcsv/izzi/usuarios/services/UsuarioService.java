package mcsv.izzi.usuarios.services;

import java.util.List;

import mcsv.izzi.usuarios.entity.Usuarios;

public interface UsuarioService {
	List<Usuarios> getAll();
	Usuarios getUsersById(int id);
	Usuarios save(Usuarios users);
	List<Usuarios> byUsuarioId(int usuarioId);
}
