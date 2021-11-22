package logicanegocios;

import java.sql.SQLException;

import logicadao.daoFuncionario;
import logicadao.daoPaciente;

public class Paciente {
	
	private int cedula;
	private String nombre;
	private String fechaNacimiento;
	private String tipoSangre;
	private String nacionalidad;
	private String lugarResidencia;
	private int telefono;
	
	private daoPaciente action = new daoPaciente();

	
	
	public Paciente() {};
	
	public Paciente(int pcedula, String pnombre, String pfechaNacimiento,String ptipoSangre, String pnacionalidad, String plugarResidencia, int ptelefono) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.fechaNacimiento = pfechaNacimiento;
		this.tipoSangre = ptipoSangre;
		this.nacionalidad = pnacionalidad;
		this.lugarResidencia = plugarResidencia;
		this.telefono = ptelefono;
	}
	
	public Paciente(int pcedula, int ptelefono) {
		this.cedula = pcedula;
		this.telefono = ptelefono;
	}
	
	public Paciente(int pcedula) {
		this.cedula = pcedula;
	}
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int pcedula) {
		this.cedula = pcedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String pfechaNacimiento) {
		this.fechaNacimiento = pfechaNacimiento;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String ptipoSangre) {
		this.tipoSangre = ptipoSangre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String pnacionalidad) {
		this.nacionalidad = pnacionalidad;
	}

	public String getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(String plugarResidencia) {
		this.lugarResidencia = plugarResidencia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int ptelefono) {
		this.telefono = ptelefono;
	}
	
	

	public void crearPaciente() {		
		String query = "INSERT INTO Paciente([Cedula],[Nombre],[FechaNacimiento],[TipoSangre],[Nacionalidad],[LugarResidencia]) VALUES("+
				getCedula()+",'"+getNombre()+"','"+getFechaNacimiento()+"','"+getTipoSangre()+"','"+getNacionalidad()+"','"+getLugarResidencia()+"');";
		action.insert(query);
	}
	
	public void crearPacienteTelefono() {		
		String query = "INSERT INTO TelefonoPaciente([NumeroTelefono],[CedulaPaciente]) VALUES("+ getTelefono()+"," +getCedula()+");";
		action.insert(query);
	}
	
	public boolean verificarPaciente() throws SQLException {
		String query = "SELECT * FROM Paciente WHERE Cedula = " +getCedula()+";";
		return action.verificarPaciente(query);
	}
	
	public boolean verificarNumero() throws SQLException {
		String query = "SELECT * FROM TelefonoPaciente WHERE NumeroTelefono = " +getTelefono()+" AND CedulaPaciente = " +getCedula()+";";
		return action.verificarTelefonoPaciente(query);
	}

}
