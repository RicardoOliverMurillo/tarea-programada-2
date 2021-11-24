package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.Cita;


public class daoCita {
	
	private Statement stmt;
	ResultSet rs;
	
	public void insert(String query) {
		try
		{
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
			
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}	
	}
	
	public List<Cita> getCitaResgritada(String query) {
		List<Cita> citaRegistrada = new ArrayList<Cita>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cita cita = new Cita(rs.getString("Fecha"));
				citaRegistrada.add(cita);
			}
			return citaRegistrada;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citaRegistrada;
	}
	
	public List<Cita> getHoraCita(String query) {
		List<Cita> citaRegistrada = new ArrayList<Cita>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cita cita = new Cita(rs.getString("Hora"));
				citaRegistrada.add(cita);
			}
			return citaRegistrada;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citaRegistrada;
	}
	
	public boolean verificarFechaHora(String query) throws SQLException {
		ArrayList<String> horarios = new ArrayList<String>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				horarios.add(rs.getString("Fecha"));
			}
			if (horarios.size() >= 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificarCitaPacientea(String query) throws SQLException {
		ArrayList<String> horarios = new ArrayList<String>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				horarios.add(rs.getString("Estado"));
			}
			if (horarios.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Cita> listCitas(String query) {
		List<Cita> citaRegistrada = new ArrayList<Cita>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cita cita = new Cita();
				cita.setCedula(rs.getInt("CedulaPaciente"));
				cita.setEspecialidad(rs.getString("Especialidad"));
				cita.setEstado(rs.getString("Estado"));
				cita.setFecha(rs.getString("Fecha"));
				cita.setHora(rs.getString("Hora"));
				cita.setObservacion(rs.getString("Observacion"));
				citaRegistrada.add(cita);
			}
			return citaRegistrada;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citaRegistrada;
	}
	

}
