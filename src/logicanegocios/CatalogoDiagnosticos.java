package logicanegocios;

import java.sql.SQLException;

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
	
	
}

