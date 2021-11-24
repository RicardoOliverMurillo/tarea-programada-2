package logicanegocios;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public Cita(String pfecha, String phora) {
		this.fecha = pfecha;
		this.hora = phora;
	}
	
	public Cita(int pCedula) {
		this.cedula = pCedula;
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
	
	public void crearHorario() {		
		String query = "INSERT INTO Horario ([Fecha],[Hora]) VALUES ('"+getFecha()+"','"+getHora()+"');";
		action.insert(query);
	}
	
	public void eliminarHorario() {		
		String query = "DELETE FROM Horario WHERE Fecha = '"+getFecha()+"' AND Hora = '"+getHora()+"';";
		action.insert(query);
	}
	
	public boolean verificarHorario() throws SQLException {		
		String query = "SELECT * FROM Horario WHERE Fecha = '"+getFecha()+"' AND Hora = '"+getHora()+"';";
		return action.verificarFechaHora(query);
	}
	
	public boolean verificarIDCita(int IDCita) throws SQLException {		
		String query = "SELECT * FROM Citas WHERE ID_Cita = "+IDCita+" AND CedulaPaciente = "+getCedula()+";";
		return action.verificarCitaPacientea(query);
	}
	
	public List<Cita> getCitasHorarios() {
		String query = "SELECT * FROM Horario";
		return action.getCitaResgritada(query);
	}
	
	public List<Cita> getCitasHoras(String pfecha) {
		String query = "SELECT * FROM Horario WHERE Fecha = '"+pfecha+"';";
		return action.getHoraCita(query);
	}
	
	public List<Cita> getCitasRegistradas(int pcedula) {
		String query = "SELECT * FROM Citas WHERE Estado = 'Registrada' OR Estado = 'Asignada' AND CedulaPaciente ="+pcedula+";";
		return action.getCitaResgritada(query);
	}
	
	public List<Cita> getCitasCanceladas(int pcedula) {
		String query = "SELECT * FROM Citas WHERE Estado = 'Cancelada por centro medico' AND CedulaPaciente ="+pcedula+";";
		return action.getCitaResgritada(query);
	}
	
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
	
	public List<Cita> getCitas() {
		String query = "SELECT * FROM Citas;";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasFechaDoctor(Date fecha1, Date fecha2) {
		List<Cita> citasFiltradas = new ArrayList<Cita>();
		List<Cita> citas = getCitas();
		for (int i = 0; i<citas.size(); i++) {
			int result = fecha1.compareTo(dateFormat(citas.get(i).getFecha()))*dateFormat(citas.get(i).getFecha()).compareTo(fecha2);
			if(result >= 0) {
				citasFiltradas.add(citas.get(i));
			}
		}
		return citasFiltradas;
	}	
	public List<Cita> getCitasFechaPaciente(Date fecha1, Date fecha2, int pcedula) {
		List<Cita> citasFiltradas = new ArrayList<Cita>();
		List<Cita> citas = getCitasPaciente(pcedula);
		for (int i = 0; i<citas.size(); i++) {
			int result = fecha1.compareTo(dateFormat(citas.get(i).getFecha()))*dateFormat(citas.get(i).getFecha()).compareTo(fecha2);
			if(result >= 0) {
				citasFiltradas.add(citas.get(i));
			}
		}
		return citasFiltradas;
	}
	
	
	/* METODOS GET CITAS PARA PACIENTE */
	public List<Cita> getCitasPaciente(int pcedula) {
		String query = "SELECT * FROM Citas WHERE CedulaPaciente =" + pcedula + ";";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasEstado(String pestado) {
		String query = "SELECT * FROM Citas WHERE Estado ='"+pestado+"';";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasEstadoPaciente(String pestado, int pcedula) {
		String query = "SELECT * FROM Citas WHERE Estado ='"+pestado+ "' AND CedulaPaciente = "+pcedula+";";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasEspecialidad(String pespecialidad) {
		String query = "SELECT * FROM Citas WHERE Especialidad ='"+pespecialidad+"';";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasEspecialidadPaciente(String pespecialidad, int pcedula) {
		String query = "SELECT * FROM Citas WHERE Especialidad ='"+pespecialidad+"' AND CedulaPaciente = "+pcedula+";";
		return action.listCitas(query);
	}
	
	public List<Cita> getCitasFecha(String fecha1, String fecha2, int cedulaPaciente) {
		
		Date inicio = dateFormat(fecha1);
		Date fin = dateFormat(fecha2);
		
		List<Cita> citasFiltradas = new ArrayList<Cita>();
		List<Cita> citas = getCitasPaciente(cedulaPaciente);
		
		for (int i = 0; i<citas.size(); i++) {
			int result = inicio.compareTo(dateFormat(citas.get(i).getFecha()))*dateFormat(citas.get(i).getFecha()).compareTo(fin);
			if(result >= 0) {
				citasFiltradas.add(citas.get(i));
			}
		}
		return citasFiltradas;
	}
	

	public static Date dateFormat(String date) {
		Date dateFormated = new Date();
		SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateFormated = formatter1.parse(date);
			return dateFormated;
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return null;
	}
	
}
