package logicanegocios;

import java.sql.SQLException;
import java.util.ArrayList;

import logicadao.daoCentroAtencion;



public class CentroAtencion {
	
	private int codigo;
	private String nombre;
	private String ubicacion;
	private int cantidadPacientes;
	private String tipoCentroAtencion;
	
	private daoCentroAtencion action = new daoCentroAtencion();


	public CentroAtencion() {};
	
	

	public CentroAtencion(String pnombre, String pubicacion, int pcantidadPacientes, String ptipoCentroAtencion) {
		this.nombre = pnombre;
		this.ubicacion = pubicacion;
		this.cantidadPacientes = pcantidadPacientes;
		this.tipoCentroAtencion = ptipoCentroAtencion;

	}
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int pcodigo) {
		this.codigo = pcodigo;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String pubicacion) {
		this.ubicacion = pubicacion;
	}


	public int getCantidadPacientes() {
		return cantidadPacientes;
	}


	public void setCantidadPacientes(int pcantidadPacientes) {
		this.cantidadPacientes = pcantidadPacientes;
	}


	public String getTipoCentroAtencion() {
		return tipoCentroAtencion;
	}


	public void setTipoCentroAtencion(String ptipoCentroAtencion) {
		this.tipoCentroAtencion = ptipoCentroAtencion;
	}

	public void crearCentroAtencion() {
		String query = "INSERT INTO CentroAtencion([Nombre_CentroAtencion],[Lugar_CentroAtencion],[Capacidad_Max_Pacientes],[Tipo_CentroAtencion]) VALUES('"
				+ getNombre() + "','" + getUbicacion() + "'," + getCantidadPacientes() + ",'"
				+ getTipoCentroAtencion() + "')";
		action.insert(query);
	}
	
	public boolean verificarCentroAtencion(String pnombreCentro, String pubicacionCentro) throws SQLException {
		String query = "SELECT * FROM CentroAtencion WHERE Nombre_CentroAtencion = '"+ pnombreCentro + "' AND Lugar_CentroAtencion ='"+pubicacionCentro+"';";
		return action.verificarCentroAtencion(query);
	}
	
}
