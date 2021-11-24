package logicanegocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicadao.daoCita;
import logicadao.daoFuncionario;
import logicadao.daoPaciente;
import logicadao.daoVacuna;

public class Cita {
	
	private String estado;
	private String especialidad;
	private String fecha;
	private String hora;
	private String observacion;
	private int cedula;
	
	private daoCita action = new daoCita();

	
	public Cita() {};
	
	
	public Cita(String pestado, String pespecialidad, String pfecha, String phora, String pobservacion, int pcedula) {
		this.estado = pestado;
		this.especialidad = pespecialidad;
		this.fecha = pfecha;
		this.hora = phora;
		this.observacion = pobservacion;
		this.cedula = pcedula;
	}
	
	public Cita(String pfecha) {
		this.fecha = pfecha;
	}
	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public void crearCita() {		
		String query = "INSERT INTO Citas([Estado],[Especialidad],[Fecha],[Hora],[Observacion],[CedulaPaciente]) "
				+ "VALUES('"+getEstado()+"','"+getEspecialidad()+"','"+getFecha()+"','"+getHora()+"','"+getObservacion()+"',"+getCedula()+");";
		action.insert(query);
	}
	
	public List<Cita> getCitasRegistradas(int pcedula) {
		String query = "SELECT * FROM Citas WHERE Estado = 'Registrada' AND CedulaPaciente ="+pcedula+";";
		return action.getCitaResgritada(query);
	}
	
	public List<Cita> getCitasCanceladas(int pcedula) {
		String query = "SELECT * FROM Citas WHERE Estado = 'Cancelada por centro medico' AND CedulaPaciente ="+pcedula+";";
		return action.getCitaResgritada(query);
	}
	
//BETSY REP SEC
	public List<Cita> getCitasEstado(String pestado) {
		String query = "SELECT * FROM Citas WHERE Estado ="+pestado+";";
		return action.getCitaResgritada(query);
	}
	
	public List<Cita> getCitasEspecialidad(String pespecialidad) {
		String query = "SELECT * FROM Citas WHERE Especialidad ="+pespecialidad+";";
		return action.getCitaResgritada(query);
	}
	
	public List<Cita> getCitasPaciente(int pcedula) {
		String query = "SELECT * FROM Citas WHERE CedulaPaciente ="+pcedula+";";
		return action.getCitaResgritada(query);
	}
		
	public List<Cita> getCitasFecha(String fecha1, String fecha2) {
		String query = "SELECT * FROM Citas WHERE Fecha BETWEEN"+fecha1+"AND"+fecha2+";";
		return action.getCitaResgritada(query);
	}
//BETSY REP SEC

	
	public void cancelarCitaPaciente(String fechaCancelada) {		
		String query = "UPDATE Citas SET Estado = 'Cancelada por paciente' WHERE Fecha = '"+fechaCancelada+"';";
		action.insert(query);
	}
	
	public void cancelarCitaCentroMedico(String fechaCancelada) {		
		String query = "UPDATE Citas SET Estado = 'Cancelada por centro medico' WHERE Fecha = '"+fechaCancelada+"';";
		action.insert(query);
	}
	
	public void asignarCitaCentroMedico(String fechaCancelada) {		
		String query = "UPDATE Citas SET Estado = 'Asignada' WHERE Fecha = '"+fechaCancelada+"';";
		action.insert(query);
	}
	
	public void realizarCitaCentroMedico(String fechaCancelada) {		
		String query = "UPDATE Citas SET Estado = 'Realizada' WHERE Fecha = '"+fechaCancelada+"';";
		action.insert(query);
	}
	
}
