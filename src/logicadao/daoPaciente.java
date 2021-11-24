package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.Paciente;

public class daoPaciente {
	
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
	
	public boolean verificarPaciente(String query) throws SQLException {
		ArrayList<Integer> pacientes = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				pacientes.add(rs.getInt("Cedula"));
			}
			if (pacientes.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificarTelefonoPaciente(String query) throws SQLException {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				numeros.add(rs.getInt("NumeroTelefono"));
			}
			if (numeros.size() >= 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Paciente> listPacientes(String query) {
		ArrayList<Paciente> pacientesRegistrados = new ArrayList<Paciente>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setCedula(rs.getInt("Cedula"));
				paciente.setNombre(rs.getString("Nombre"));
				paciente.setFechaNacimiento(rs.getString("FechaNacimiento"));
				paciente.setTipoSangre(rs.getString("TipoSangre"));
				paciente.setNacionalidad(rs.getString("Nacionalidad"));
				paciente.setNacionalidad(rs.getString("CorreoElectronico"));
				paciente.setLugarResidencia(rs.getString("LugarResidencia"));
				pacientesRegistrados.add(paciente);
			}
			return pacientesRegistrados;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientesRegistrados;
	}

}
