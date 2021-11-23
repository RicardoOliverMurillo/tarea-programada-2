package logicanegocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicadao.*;


public class LOGCitas {
	
	private String estado;
	private String fecha;
	private String hora;
	private String idUsuario;
	private String idCita;
	
	private daoLOGCitas action = new daoLOGCitas();

	
	public LOGCitas() {};
	
	
	public LOGCitas(String pestado, String idUsuario, String idCita) {
		this.estado = pestado;
		setFecha();
		setHora();
		this.idUsuario = idUsuario;
		this.idCita = idCita;
		
		
	}
	
	
	public String getEstado() {
		return this.estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getIDUsuario() {
		return this.idUsuario;
	}


	public void setIDUsuario(String idusuario) {
		this.idUsuario = idusuario;
	}
	
	public String getidCita() {
		return this.idCita;
	}


	public void setidCita(String idcita) {
		this.idCita = idcita;
	}


	public String getFecha() {
		return this.fecha;
	}


	public void setFecha() {
		this.fecha = java.time.LocalDate.now().toString();
	}


	public String getHora() {
		return hora;
	}


	public void setHora() {
		this.hora = java.time.LocalTime.now().toString();
	}
	
	
	public void logRealizarCitaDR() {
		
		System.out.println(this.fecha);
		System.out.println(this.hora);
		System.out.println(this.idCita);
		System.out.println(this.idUsuario);
		
		String query = "INSERT INTO LOGCitas([Estado],[Fecha],[Hora],[IDUsuario],[IDCita]) VALUES('"+getEstado()+"','"+getFecha()+"','"+getHora()+"','"+getIDUsuario()+"','"+getidCita()+"');";
		action.insert(query);
		
		
		
		
		
	}
	
	
	
	
}
