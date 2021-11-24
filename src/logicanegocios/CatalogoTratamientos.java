package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class CatalogoTratamientos {
	
	
	private String nombre;
	
	private String idDiagnosticoAsociado;
	
	
	private daoCatalogoTratamientos action = new daoCatalogoTratamientos();


	public CatalogoTratamientos() {};
	
	

	public CatalogoTratamientos(String pnombre, String pIDdiagnosticoAsociado) {
		this.nombre = pnombre;
		this.idDiagnosticoAsociado = pIDdiagnosticoAsociado;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}
	
	public String getIdDiagnosticoAsociado() {
		return idDiagnosticoAsociado;
	}



	public void setIdDiagnosticoAsociado(String idDiagnosticoAsociado) {
		this.idDiagnosticoAsociado = idDiagnosticoAsociado;
	}


	public void crearTratamiento() {
		String query = "INSERT INTO Tratamientos([ID_Diagnostico], [Nombre]) VALUES('"
				+ getIdDiagnosticoAsociado() + "','" + getNombre()  + "')";
		action.insert(query);
	}
	
	//AÚN NO SE HA HECHO
	public boolean verificarDiagnostico(String pnombreDiagnostico) throws SQLException {
		String query = "SELECT * FROM Diagnostico WHERE Nombre = '"+ pnombreDiagnostico+"';";
		return action.verificarCatalogoTratamientos(query);
	}
	
	public List<CatalogoTratamientos> getTratamientosRegistrados(String pIdDiagnostico) {
		String query = "SELECT * FROM Tratamientos WHERE ID_Diagnostico = '"+ pIdDiagnostico+"';";
		return action.getTratamientoRegistrado(query);
	}
	
	
	
}
