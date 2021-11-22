package logicanegocios;

import java.sql.SQLException;

import logicadao.daoFuncionario;
import logicadao.daoPaciente;
import logicadao.daoVacuna;

public class Vacuna {
	
	private String fechaAplicacion;
	private String nombre;
	private String farmaceutica;
	private int cedula;
	private int lote;
	
	private daoVacuna action = new daoVacuna();

	
	public Vacuna() {};
	
	
	public Vacuna(String pfechaAplicacion, String pnombre, String pfarmaceutuica, int plote, int pcedula) {
		this.fechaAplicacion = pfechaAplicacion;
		this.nombre = pnombre;
		this.farmaceutica = pfarmaceutuica;
		this.lote = plote;
		this.cedula = pcedula;
	}
	
	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public String getFechaAplicacion() {
		return fechaAplicacion;
	}


	public void setFechaAplicacion(String fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFarmaceutica() {
		return farmaceutica;
	}


	public void setFarmaceutica(String farmaceutica) {
		this.farmaceutica = farmaceutica;
	}


	public int getLote() {
		return lote;
	}


	public void setLote(int lote) {
		this.lote = lote;
	}
	
	public void crearVacuna() {		
		String query = "INSERT INTO VacunaPaciente([FechaAplicacion],[NombreVacuna],[Farmaceutica],[NumeroLote],[CedulaPaciente]) "
				+ "VALUES('"+getFechaAplicacion()+"','"+getNombre()+"','"+getFarmaceutica()+"',"+getLote()+","+getCedula()+");";
		action.insert(query);
	}
	
	
}
