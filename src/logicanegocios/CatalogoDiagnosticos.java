package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class CatalogoDiagnosticos {
	
	
	private String nombre;
	
	
	private daoCatalogoDiagnostico action = new daoCatalogoDiagnostico();


	public CatalogoDiagnosticos() {};
	
	

	public CatalogoDiagnosticos(String pnombre) {
		this.nombre = pnombre;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}



	public void crearDiagnostico() {
		String query = "INSERT INTO Diagnostico([Nombre]) VALUES('"
				+ getNombre()  + "')";
		action.insert(query);
	}
	
	public boolean verificarDiagnostico(String pnombreDiagnostico) throws SQLException {
		String query = "SELECT * FROM Diagnostico WHERE Nombre = '"+ pnombreDiagnostico+"';";
		return action.verificarCatalogoDiagnostico(query);
	}
	
	public List<CatalogoDiagnosticos> getDiagnosticosRegistrados() {
		String query = "SELECT * FROM Diagnostico";
		return action.getDiagnosticoRegistrado(query);
	}
	
	
}