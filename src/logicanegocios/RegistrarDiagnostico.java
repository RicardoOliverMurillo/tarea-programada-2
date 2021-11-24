package logicanegocios;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logicadao.*;

public class RegistrarDiagnostico {
	
	
	private String idDiagnostico;
	private String idCita;
	private String nivel;
	private String obervaciones;
	
	
	private daoRegistrarDiagnostico action = new daoRegistrarDiagnostico();


	public RegistrarDiagnostico() {};
	
	

	public RegistrarDiagnostico (String pIDdiagnostico, String pIDcita, String pNivel, String pObervaciones) {
		this.idDiagnostico = pIDdiagnostico;
		this.idCita = pIDcita;
		this.nivel = pNivel;
		this.obervaciones = pObervaciones;
	}
	

	public String getIdDiagnostico() {
		return idDiagnostico;
	}



	public void setIdDiagnostico(String idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}



	public String getIdCita() {
		return idCita;
	}



	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}



	public String getNivel() {
		return nivel;
	}



	public void setNivel(String nivel) {
		this.nivel = nivel;
	}



	public String getObervaciones() {
		return obervaciones;
	}



	public void setObervaciones(String obervaciones) {
		this.obervaciones = obervaciones;
	}



	public void crearRegistrarDiagnostico() {
		String query = "INSERT INTO Cita_Diagnostico([ID_Diagnostico],[ID_Cita],[Nivel],[Observaciones]) VALUES('"
				+ getIdDiagnostico() + "','" + getIdCita()  + "','" + getNivel() + "','" + getObervaciones() + "')";
		action.insert(query);
	}
	
	public List<List<String>> getDiagnostico(){
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita ;";
		return action.listDiagnostico(query);
	}
	
	public List<List<String>> getNivelDiagnostico(String pnivel) {
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita WHERE Cita_Diagnostico.Nivel = '"+pnivel+"';";
		return action.listDiagnostico(query);
	}
	
	public List<List<String>> getNivelDiagnostico(String pnivel, int pcedula) {
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita WHERE Cita_Diagnostico.Nivel = '"+pnivel+"' And Citas.CedulaPaciente = '"+pcedula+"';";
		return action.listDiagnostico(query);
	}
	
	public List<List<String>> getNombrelDiagnostico(String pnombre){
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita WHERE Diagnostico.Nombre = '"+pnombre+"';";
		return action.listDiagnostico(query);
	}
	
	public List<List<String>> getNombrelDiagnostico(String pnombre, int pcedula){
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita WHERE Diagnostico.Nombre = '"+pnombre+"' And Citas.CedulaPaciente = '"+pcedula+"';";
		return action.listDiagnostico(query);
	}
	
	
	public List<List<String>> getDiagnostico(int pcedula){
		String query = "SELECT Diagnostico.ID_Diagnostico, Diagnostico.Nombre, Cita_Diagnostico.Nivel, Cita_Diagnostico.Observaciones,Citas.CedulaPaciente, Citas.Fecha FROM Diagnostico JOIN Cita_Diagnostico ON Diagnostico.ID_Diagnostico = Cita_Diagnostico.ID_Diagnostico JOIN Citas ON Citas.ID_Cita = Cita_Diagnostico.ID_Cita WHERE Citas.CedulaPaciente = '"+pcedula+"';";
		return action.listDiagnostico(query);
	}
		
	public static Date dateFormat(String date) {
		Date dateFormated = new Date();
		SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateFormated = formatter1.parse(date);
			return dateFormated;
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	public List<List<String>> getDiagnosticosFecha(Date inicio, Date fin) {
		List<List<String>> listDiagnostico = new RegistrarDiagnostico().getDiagnostico();
		List<List<String>> result = new ArrayList<List<String>>();
		
		for (int i = 0; i< listDiagnostico.size(); i++) {
			for (int j = 0; j< listDiagnostico.get(i).size(); j++) {
				if(j == 5) {
					int diagnostico = inicio.compareTo(dateFormat(listDiagnostico.get(i).get(j)))*dateFormat(listDiagnostico.get(i).get(j)).compareTo(fin);
					if(diagnostico >= 0) {
						result.add(listDiagnostico.get(i));
					}		
				}
			}
		}
		return result;
	}
	
	public List<List<String>> getDiagnosticosFecha(Date inicio, Date fin, int pcedula) {
		List<List<String>> listDiagnostico = new RegistrarDiagnostico().getDiagnostico(pcedula);
		List<List<String>> result = new ArrayList<List<String>>();
		
		for (int i = 0; i< listDiagnostico.size(); i++) {
			for (int j = 0; j< listDiagnostico.get(i).size(); j++) {
				if(j == 5) {
					int diagnostico = inicio.compareTo(dateFormat(listDiagnostico.get(i).get(j)))*dateFormat(listDiagnostico.get(i).get(j)).compareTo(fin);
					if(diagnostico >= 0) {
						result.add(listDiagnostico.get(i));
					}		
				}
			}
		}
		return result;
	}
	
	
	
	
}