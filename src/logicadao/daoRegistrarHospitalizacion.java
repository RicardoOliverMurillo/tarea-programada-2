package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.*;


public class daoRegistrarHospitalizacion {
	
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
	
	public List<registrarHospitalizacion> getHospitalizacionesRegistradasDAO(String query) {
		List<registrarHospitalizacion> diagnosticoRegistrado = new ArrayList<registrarHospitalizacion>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				registrarHospitalizacion objDiagnostico = new registrarHospitalizacion((Integer.toString(rs.getInt("ID_Hospitalizacion"))));
				System.out.println("Get Fecha de Inicio: " + objDiagnostico.getIdFuncionario());
				diagnosticoRegistrado.add(objDiagnostico);
			}
			return diagnosticoRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnosticoRegistrado;
	}
	
	public List<registrarHospitalizacion> getHospitalizacionesRegistradasBYID(String query) {
		List<registrarHospitalizacion> diagnosticoRegistrado = new ArrayList<registrarHospitalizacion>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				registrarHospitalizacion objDiagnostico = new registrarHospitalizacion(rs.getString("ID_Paciente"));
				diagnosticoRegistrado.add(objDiagnostico);
			}
			return diagnosticoRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnosticoRegistrado;
	}
	
	

	

}