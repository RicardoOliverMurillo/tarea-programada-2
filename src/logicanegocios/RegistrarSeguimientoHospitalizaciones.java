package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class RegistrarSeguimientoHospitalizaciones {
	
	
	private String ID_Hospitalizacion;
	private String FechaSeguimiento;
	private String ID_Funcionario;
	private String Observacion;
	private String IDTratamiento;
	
	
	
	private daoRegistrarSeguimientoHospitalizaciones action = new daoRegistrarSeguimientoHospitalizaciones();


	public RegistrarSeguimientoHospitalizaciones() {};
	
	

	public RegistrarSeguimientoHospitalizaciones(String pID_Hospitalizacion, String pFechaSeguimiento, String pID_Funcionario, String pObervacion, String pIDTratamiento) {
		this.ID_Hospitalizacion = pID_Hospitalizacion;
		this.FechaSeguimiento = pFechaSeguimiento;
		this.ID_Funcionario = pID_Funcionario;
		this.Observacion = pObervacion;
		this.IDTratamiento = pIDTratamiento;
	}



	public String getID_Hospitalizacion() {
		return ID_Hospitalizacion;
	}



	public void setID_Hospitalizacion(String iD_Hospitalizacion) {
		ID_Hospitalizacion = iD_Hospitalizacion;
	}



	public String getFechaSeguimiento() {
		return FechaSeguimiento;
	}



	public void setFechaSeguimiento(String fechaSeguimiento) {
		FechaSeguimiento = fechaSeguimiento;
	}



	public String getID_Funcionario() {
		return ID_Funcionario;
	}



	public void setID_Funcionario(String iD_Funcionario) {
		ID_Funcionario = iD_Funcionario;
	}



	public String getObservacion() {
		return Observacion;
	}



	public void setObservacion(String observacion) {
		Observacion = observacion;
	}



	public String getIDTratamiento() {
		return IDTratamiento;
	}



	public void setIDTratamiento(String iDTratamiento) {
		IDTratamiento = iDTratamiento;
	}



	public void crearRegistrarHospitalizacion() {
		String query = "INSERT INTO Seguimientos_Hospitalizaciones([ID_Hospitalizacion],[FechaSeguimiento],[ID_Funcionario],[Observacion],[IDTratamiento]) VALUES('"
				+ getID_Hospitalizacion() + "','" + getFechaSeguimiento()  + "','" + getID_Funcionario() + "','" + getObservacion() + "','" + getIDTratamiento()  + "')";
		action.insert(query);
	}
	

	
	
}
