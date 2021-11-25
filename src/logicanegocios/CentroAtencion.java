package logicanegocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicadao.daoCentroAtencion;


/**
 * Esta clase permite modelar la creaci�n de los distintos centros de atenci�n que estar�n registrados en el sistema. 
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
	 * M�todo constructor de la clase Centro de atenci�n, no recibe par�metros.
	 */
	public CentroAtencion() {};
	
	
	/**
	 * M�todo constructor de la clase Centro de atenci�n, recibe los siguientes par�metros.
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
	 * M�todo que permite registrar un centro de atenci�n en la base de datos. 
	 */
	public void crearCentroAtencion() {
		String query = "INSERT INTO CentroAtencion([Nombre_CentroAtencion],[Lugar_CentroAtencion],[Capacidad_Max_Pacientes],[Tipo_CentroAtencion]) VALUES('"
				+ getNombre() + "','" + getUbicacion() + "'," + getCantidadPacientes() + ",'"
				+ getTipoCentroAtencion() + "')";
		action.insert(query);
	}
	
	/**
	 * M�todo que permite verificar la existencia de un centro de atenci�n en la base de datos, recibe los siguientes par�metros. 
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
	 * M�todo que permite obtener todos los centros de atenci�n reguistrados en la base de datos. 
	 * @return
	 */
	public List<CentroAtencion> getCentrosDeAtencionRegistrados() {
		String query = "SELECT * FROM CentroAtencion";
		return action.getCentroAtencionRegistrado(query);
	}
	
}
