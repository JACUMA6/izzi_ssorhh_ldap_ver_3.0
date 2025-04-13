package mcsv.izzi.usuarios.services;

import java.util.*;

import mcsv.izzi.usuarios.entity.Usuarios;

public interface UsuarioService {
	List<Usuarios> getAll();
	Optional<Usuarios> getUsersById(int id);
	Usuarios save(Usuarios users);
	List<Usuarios> byUsuarioId(int usuarioId);
}
