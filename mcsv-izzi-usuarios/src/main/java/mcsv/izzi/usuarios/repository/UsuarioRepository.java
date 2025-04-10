package mcsv.izzi.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mcsv.izzi.usuarios.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{

	List<Usuarios> findByUsuarioId(int usuarioId);
	
}
