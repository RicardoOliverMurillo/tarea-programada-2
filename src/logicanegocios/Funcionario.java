package logicanegocios;

import java.sql.SQLException;

import logicadao.daoFuncionario;

public class Funcionario {
	
	private int cedula;
	private String nombre;
	private String tipo;
	private String fechaIngreso;// Puede ser de tipo Date
	private String area;
	private int experienciaCargo;
	private int experienciaCapacitacion;
	private int codigoDoctor;
	private String especialidad;
	
	private daoFuncionario action = new daoFuncionario();
	
	public Funcionario() {};
	
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
	}
	
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, String parea) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.area = parea;
	}
	
	//Enfermero
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, String parea, int pexperienciaCargo, int pexperienciaCapacitacion) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.area = parea;
		this.experienciaCargo = pexperienciaCargo;
		this.experienciaCapacitacion = pexperienciaCapacitacion;
	}
	
	//Doctor
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, String pArea, int pcodigoDoctor, String pespecialidad) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.codigoDoctor = pcodigoDoctor;
		this.especialidad = pespecialidad;
		this.area = pArea;
	}
	
	/*
	 * public Funcionario(int pcedula, String pnombre, String ptipo, String
	 * pfechaIngreso, String pArea, int pcodigoDoctor, String pespecialidad) {
	 * this.cedula = pcedula; this.nombre = pnombre; this.tipo = ptipo;
	 * this.fechaIngreso = pfechaIngreso; this.area = pArea; this.codigoDoctor =
	 * pcodigoDoctor; this.especialidad = pespecialidad; }
	 */

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int pcedula) {
		this.cedula = pcedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String ptipo) {
		this.tipo = ptipo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String pfechaIngreso) {
		this.fechaIngreso = pfechaIngreso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String parea) {
		this.area = parea;
	}

	public int getExperienciaCargo() {
		return experienciaCargo;
	}

	public void setExperienciaCargo(int pexperienciaCargo) {
		this.experienciaCargo = pexperienciaCargo;
	}

	public int getExperienciaCapacitacion() {
		return experienciaCapacitacion;
	}

	public void setExperienciaCapacitacion(int pexperienciaCapacitacion) {
		this.experienciaCapacitacion = pexperienciaCapacitacion;
	}

	public int getCodigoDoctor() {
		return codigoDoctor;
	}

	public void setCodigoDoctor(int pcodigoDoctor) {
		this.codigoDoctor = pcodigoDoctor;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String pespecialidad) {
		this.especialidad = pespecialidad;
	}
	
	//////////                     Metodo sin el atributo de area de trabajo                   //////////////////////////////////////
	public void crearSecretario() {
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso],[Area_Trabajo]) VALUES('"+getCedula()+"','"
				+ getNombre() + "','" + getTipo() + "','" + getFechaIngreso() + "','" + getArea()+"');";
		action.insert(query);
	}
	
	public boolean verificarFuncionario(int pcedula) throws SQLException {
		String query = "SELECT * FROM Funcionario WHERE Cedula = " +pcedula+";";
		return action.verificarFuncionario(query);
	}
	
	public boolean verificarCodigoDoctor(int pcodigo) throws SQLException  {
		String query = "SELECT * FROM Funcionario WHERE DR_CodigoMedico = " +pcodigo+";";
		return action.verificarDoctor(query);
	}
	
	//////////                     Metodo sin el atributo de area de trabajo                   //////////////////////////////////////
	public void crearEnfermero() {
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso],[Area_Trabajo],[Enfermero_PersonasACargo],[Enfermero_ExperienciaCapacitaciones]) VALUES('"
				+ getCedula() + "','" + getNombre() + "','" + getTipo() + "','" + getFechaIngreso() + "', '"+ getArea() + "',"+ "',"+ getExperienciaCargo()+","+getExperienciaCapacitacion()+");";
		action.insert(query);
	}
	
	//////////                     Metodo sin el atributo de area de trabajo                   //////////////////////////////////////
	public void crearDoctor() {
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso],[Area_Trabajo],[DR_CodigoMedico],[DR_Especialidades]) VALUES('"
				+ getCedula() + "','" + getNombre() + "','" + getTipo() + "','" + getFechaIngreso() + "','"+ getArea() + "',"+ getCodigoDoctor()+",'"+getEspecialidad()+"');";
		action.insert(query);
	}

}
