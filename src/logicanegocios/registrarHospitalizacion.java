package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class registrarHospitalizacion {
	
	
	private String centroAtencion;
	private String idPaciente;
	private String nombrePaciente;
	private String diagnostico;
	private String fechaInicio;
	private String fechaFinalizacion;
	private String especialidad;
	private String idFuncionario;
	
	
	private daoRegistrarHospitalizacion action = new daoRegistrarHospitalizacion();


	public registrarHospitalizacion() {};
	
	

	public registrarHospitalizacion (String pCentroAtencion, String pIDPaciente, String pNombrePaciente, String pDiagnostico, String pFechaInicio, String pFechaFinalizacion, String pEspecialidad, String pIDFuncionario) {
		this.centroAtencion = pCentroAtencion;
		this.idPaciente = pIDPaciente;
		this.nombrePaciente = pNombrePaciente;
		this.diagnostico = pDiagnostico;
		this.fechaInicio = pFechaInicio;
		this.fechaFinalizacion = pFechaFinalizacion;
		this.especialidad = pEspecialidad;
		this.idFuncionario = pIDFuncionario;
	}
	
	public registrarHospitalizacion (String pFechhaInicio) {
		this.fechaInicio = pFechhaInicio;
	}
	

	public String getCentroAtencion() {
		return centroAtencion;
	}



	public void setCentroAtencion(String centroAtencion) {
		this.centroAtencion = centroAtencion;
	}



	public String getIdPaciente() {
		return idPaciente;
	}



	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}



	public String getNombrePaciente() {
		return nombrePaciente;
	}



	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}



	public String getDiagnostico() {
		return diagnostico;
	}



	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}



	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}



	public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



	public String getIdFuncionario() {
		return idFuncionario;
	}



	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}






	public void crearRegistrarHospitalizacion() {
		String query = "INSERT INTO Hospitalizaciones([CentroAtencion],[ID_Paciente],[Nombre_Paciente],[Diagnostico],[FechaInicio],[FechaFinalizacion],[Especialidad],[ID_Funcionario]) VALUES('"
				+ getCentroAtencion() + "','" + getIdPaciente()  + "','" + getNombrePaciente() + "','" + getDiagnostico() + "','" + getFechaInicio() + "','" + getFechaFinalizacion() + "','"  + getEspecialidad() + "','" + getIdFuncionario() + "')";
		action.insert(query);
	}
	
	public List<registrarHospitalizacion> getHospitalizacionesRegistradas(int pCedulaPaciente ) {
		String query = "SELECT TOP 1 * FROM Hospitalizaciones WHERE ID_Paciente = " + pCedulaPaciente + "ORDER BY ID_Hospitalizacion DESC" + ";";
		return action.getHospitalizacionesRegistradasDAO(query);
	}
	
	public List<registrarHospitalizacion> getHospitalizacionesRegistradasDiagnostico(int pCedulaPaciente ) {
		String query = "SELECT TOP 1 * FROM Hospitalizaciones WHERE ID_Paciente = " + pCedulaPaciente + "ORDER BY ID_Hospitalizacion DESC" + ";";
		return action.getHospitalizacionesRegistradasDiagnostico(query);
	}
	
	public List<registrarHospitalizacion> getIDHospitalizacion(String pFechaInicio) {
		String query = "SELECT TOP 1 * FROM Hospitalizaciones WHERE FechaInicio  = " + pFechaInicio+ ";";
		return action.getHospitalizacionesRegistradasBYID(query);
	}
	
	
	
	
	
	
	
}