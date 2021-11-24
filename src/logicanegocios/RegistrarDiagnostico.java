package logicanegocios;

import java.sql.SQLException;
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
	
	
	
	
}