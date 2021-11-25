package logicanegocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicadao.daoCentroAtencion;


/**
 * Esta clase permite modelar la creación de los distintos centros de atención que estarán registrados en el sistema. 
 * @author joseo
 *
 */
public class CentroAtencion {
	
	private int codigo;
	private String nombre;
	private String ubicacion;
	private int cantidadPacientes;
	private String tipoCentroAtencion;
	
	private daoCentroAtencion action = new daoCentroAtencion();

	/**
	 * Método constructor de la clase Centro de atención, no recibe parámetros.
	 */
	public CentroAtencion() {};
	
	
	/**
	 * Método constructor de la clase Centro de atención, recibe los siguientes parámetros.
	 * @param pnombre
	 * @param pubicacion
	 * @param pcantidadPacientes
	 * @param ptipoCentroAtencion
	 */
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
	
	/**
	 * Método que permite registrar un centro de atención en la base de datos. 
	 */
	public void crearCentroAtencion() {
		String query = "INSERT INTO CentroAtencion([Nombre_CentroAtencion],[Lugar_CentroAtencion],[Capacidad_Max_Pacientes],[Tipo_CentroAtencion]) VALUES('"
				+ getNombre() + "','" + getUbicacion() + "'," + getCantidadPacientes() + ",'"
				+ getTipoCentroAtencion() + "')";
		action.insert(query);
	}
	
	/**
	 * Método que permite verificar la existencia de un centro de atención en la base de datos, recibe los siguientes parámetros. 
	 * @param pnombreCentro
	 * @param pubicacionCentro
	 * @return
	 * @throws SQLException
	 */
	public boolean verificarCentroAtencion(String pnombreCentro, String pubicacionCentro) throws SQLException {
		String query = "SELECT * FROM CentroAtencion WHERE Nombre_CentroAtencion = '"+ pnombreCentro + "' AND Lugar_CentroAtencion ='"+pubicacionCentro+"';";
		return action.verificarCentroAtencion(query);
	}
	
	/**
	 * Método que permite obtener todos los centros de atención reguistrados en la base de datos. 
	 * @return
	 */
	public List<CentroAtencion> getCentrosDeAtencionRegistrados() {
		String query = "SELECT * FROM CentroAtencion";
		return action.getCentroAtencionRegistrado(query);
	}
	
}
