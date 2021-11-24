package logicanegocios;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logicadao.*;

public class CatalogoTratamientos {
	
	
	private String nombre;
	
	private int idDiagnosticoAsociado;
	
	
	private daoCatalogoTratamientos action = new daoCatalogoTratamientos();


	public CatalogoTratamientos() {};
	
	

	public CatalogoTratamientos(String pnombre) {
		this.nombre = pnombre;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}
	
	public int getIdDiagnosticoAsociado() {
		return idDiagnosticoAsociado;
	}



	public void setIdDiagnosticoAsociado(int idDiagnosticoAsociado) {
		this.idDiagnosticoAsociado = idDiagnosticoAsociado;
	}


	public void crearTratamiento() {
		String query = "INSERT INTO Tratamientos([ID_Diagnostico], [Nombre]) VALUES('"
				+ getIdDiagnosticoAsociado() + "','" + getNombre()  + "')";
		action.insert(query);
	}
	
	public List<CatalogoDiagnosticos> getDiagnosticos() {
		String query = "SELECT * FROM Diagnostico";
		return action.getListaDiagnosticos();
	}
	
	public List<String> getNombreTratamiento() {
		String query = "SELECT DISTINCT Nombre FROM Tratamientos";
		return action.getListaTratamiento(query);
	}
	
	public List<String> getTipoTratamiento() {
		String query = "SELECT DISTINCT TipoTratamiento FROM Cita_Tratamiento";
		return action.getTipoTratamiento(query);
	}
	
	public List<List<String>> getTipoTratamiento(String ptipo){
		String query = "SELECT Tratamientos.ID_Tratamiento, Tratamientos.Nombre, Cita_Tratamiento.Dosis, Cita_Tratamiento.TipoTratamiento, Citas.CedulaPaciente, Citas.Fecha FROM Tratamientos JOIN Cita_Tratamiento ON Cita_Tratamiento.ID_Tratamiento = Tratamientos.ID_Tratamiento JOIN Citas ON Citas.ID_Cita = Cita_Tratamiento.ID_Cita WHERE Cita_Tratamiento.TipoTratamiento = '"+ptipo+"';";
		return action.listTratamiento(query);
	}
	
	public List<List<String>> getNombreTratamiento(String pnombre){
		String query = "SELECT Tratamientos.ID_Tratamiento, Tratamientos.Nombre, Cita_Tratamiento.Dosis, Cita_Tratamiento.TipoTratamiento, Citas.CedulaPaciente, Citas.Fecha FROM Tratamientos JOIN Cita_Tratamiento ON Cita_Tratamiento.ID_Tratamiento = Tratamientos.ID_Tratamiento JOIN Citas ON Citas.ID_Cita = Cita_Tratamiento.ID_Cita WHERE  Tratamientos.Nombre = '"+pnombre+"';";
		return action.listTratamiento(query);
	}
	
	public List<List<String>> getTratamientos(){
		String query = "SELECT Tratamientos.ID_Tratamiento, Tratamientos.Nombre, Cita_Tratamiento.Dosis, Cita_Tratamiento.TipoTratamiento, Citas.CedulaPaciente, Citas.Fecha FROM Tratamientos JOIN Cita_Tratamiento ON Cita_Tratamiento.ID_Tratamiento = Tratamientos.ID_Tratamiento JOIN Citas ON Citas.ID_Cita = Cita_Tratamiento.ID_Cita ";
		return action.listTratamiento(query);
	}
	
	
	public List<List<String>> getFechaTratamiento(Date inicio, Date fin) {
		List<List<String>> listDiagnostico = new CatalogoTratamientos().getTratamientos();
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
	
	
}

