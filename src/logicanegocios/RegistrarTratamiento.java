package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class RegistrarTratamiento {
	
	
	private String idTratamiento;
	private String idCita;
	private String dosis;
	private String tipoTratamiento;
	
	
	private daoRegistrarTratamiento action = new daoRegistrarTratamiento();


	public RegistrarTratamiento() {};
	
	

	public RegistrarTratamiento (String pIDtratamiento, String pIDcita, String pDosis, String pTipoTratamiento) {
		this.idTratamiento = pIDtratamiento;
		this.idCita = pIDcita;
		this.dosis = pDosis;
		this.tipoTratamiento = pTipoTratamiento;
	}
	


	public String getIdTratamiento() {
		return idTratamiento;
	}



	public void setIdTratamiento(String idTratamiento) {
		this.idTratamiento = idTratamiento;
	}



	public String getIdCita() {
		return idCita;
	}



	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}



	public String getDosis() {
		return dosis;
	}



	public void setDosis(String dosis) {
		this.dosis = dosis;
	}



	public String getTipoTratamiento() {
		return tipoTratamiento;
	}



	public void setTipoTratamiento(String tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}






	public void crearRegistrarDiagnostico() {
		String query = "INSERT INTO Cita_Tratamiento([ID_Tratamiento],[ID_Cita],[Dosis],[TipoTratamiento]) VALUES('"
				+ getIdTratamiento() + "','" + getIdCita()  + "','" + getDosis() + "','" + getTipoTratamiento() + "')";
		action.insert(query);
	}
	
	
	
	
}