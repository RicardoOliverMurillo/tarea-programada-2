package logicanegocios;

import java.sql.SQLException;

import logicadao.daoFuncionario;

public class Funcionario {
	
	private int cedula;
	private String nombre;
	private String tipo;
	private String fechaIngreso;// Puede ser de tipo Date
	private int area;
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
	
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, int parea) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.area = parea;
	}
	
	//Enfermero
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, int pexperienciaCargo, int pexperienciaCapacitacion) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		//this.area = parea;
		this.experienciaCargo = pexperienciaCargo;
		this.experienciaCapacitacion = pexperienciaCapacitacion;
	}
	
	//Doctor
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, int pcodigoDoctor, String pespecialidad) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.codigoDoctor = pcodigoDoctor;
		this.especialidad = pespecialidad;
	}
	
	public Funcionario(int pcedula, String pnombre, String ptipo, String pfechaIngreso, int parea, int pcodigoDoctor, String pespecialidad) {
		this.cedula = pcedula;
		this.nombre = pnombre;
		this.tipo = ptipo;
		this.fechaIngreso = pfechaIngreso;
		this.area = parea;
		this.codigoDoctor = pcodigoDoctor;
		this.especialidad = pespecialidad;
	}

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

	public int getArea() {
		return area;
	}

	public void setArea(int parea) {
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
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso]) VALUES('"+getCedula()+"','"
				+ getNombre() + "','" + getTipo() + "','" + getFechaIngreso() +"');";
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
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso],[Enfermero_PersonasACargo],[Enfermero_ExperienciaCapacitaciones]) VALUES('"
				+ getCedula() + "','" + getNombre() + "','" + getTipo() + "','" + getFechaIngreso() + "',"+ getExperienciaCargo()+","+getExperienciaCapacitacion()+");";
		action.insert(query);
	}
	
	//////////                     Metodo sin el atributo de area de trabajo                   //////////////////////////////////////
	public void crearDoctor() {
		String query = "INSERT INTO Funcionario([Cedula],[Nombre],[Tipo],[Fecha_Ingreso],[DR_CodigoMedico],[DR_Especialidades]) VALUES('"
				+ getCedula() + "','" + getNombre() + "','" + getTipo() + "','" + getFechaIngreso() + "',"+ getCodigoDoctor()+",'"+getEspecialidad()+"');";
		action.insert(query);
	}

}
