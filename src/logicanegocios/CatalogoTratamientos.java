package logicanegocios;

import java.sql.SQLException;
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
	
	



	
	
	
}

