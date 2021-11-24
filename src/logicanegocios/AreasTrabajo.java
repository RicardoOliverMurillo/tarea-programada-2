package logicanegocios;

import java.sql.SQLException;
import java.util.List;

import logicadao.*;

public class AreasTrabajo {
	
	
	private String nombre;
	
	
	private daoAreasTrabajo action = new daoAreasTrabajo();


	public AreasTrabajo() {};
	
	

	public AreasTrabajo(String pnombre) {
		this.nombre = pnombre;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}



	public void crearAreasTrabajo() {
		String query = "INSERT INTO AreasHospital([Nombre]) VALUES('"
				+ getNombre()  + "')";
		action.insert(query);
	}
	
	public boolean verificarAreasTrabajo(String pnombreAreaTrabajo) throws SQLException {
		String query = "SELECT * FROM AreasHospital WHERE Nombre = '"+ pnombreAreaTrabajo+"';";
		return action.verificarAreasTrabajoX(query);
	}
	
	public List<AreasTrabajo> getAreasTrabajo() {
		String query = "SELECT * FROM AreasHospital";
		return action.getAreasAtrabajoRegistrado(query);
	}
	
	
}

