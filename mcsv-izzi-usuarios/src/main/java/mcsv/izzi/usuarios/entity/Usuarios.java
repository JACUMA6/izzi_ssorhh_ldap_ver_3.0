package mcsv.izzi.usuarios.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String eMail;
	private String password;
	private String fecAlta;
	private String estatus;
	private String mtdoInicio;
	private String tpoUsuario;
	private int usuarioId;

	public Usuarios() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getMtdoInicio() {
		return mtdoInicio;
	}

	public void setMtdoInicio(String mtdoInicio) {
		this.mtdoInicio = mtdoInicio;
	}

	public String getTpoUsuario() {
		return tpoUsuario;
	}

	public void setTpoUsuario(String tpoUsuario) {
		this.tpoUsuario = tpoUsuario;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

}
