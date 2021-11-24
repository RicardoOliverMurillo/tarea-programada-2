package logicanegocios;

import logicadao.daoLogin;

public class Usuario {
	
	private int cedula;
	private String contrasenna;
	private String rol;
	
	public Usuario() {}
	
	public Usuario(String pcontrasenna, int pcedula) {
		
		this.cedula = pcedula;
		this.contrasenna = pcontrasenna;
		this.rol = null;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Usuario login (Usuario user) {
		return new daoLogin().loginUser("SELECT * FROM Users WHERE [dbo].[Users].[Cedula] = "+  user.getCedula() + ";" );
	}
	
	public void registrarUsuario (Usuario user) {
		new daoLogin().createUser("INSERT INTO Users VALUES (" + user.getCedula() + ",'"+ user.getContrasenna() +"', ' "+ user.getRol() +"');");
	}
}
