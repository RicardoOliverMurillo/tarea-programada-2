package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.CatalogoDiagnosticos;
import logicanegocios.CentroAtencion;


public class daoCentroAtencion {
	
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
	
	public List<CentroAtencion> getCentroAtencionRegistrado(String query) {
		int capacidad;
		List<CentroAtencion> diagnosticoRegistrado = new ArrayList<CentroAtencion>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				capacidad = Integer.parseInt(rs.getString("Capacidad_Max_Pacientes"));  
				CentroAtencion objDiagnostico = new CentroAtencion(rs.getString("Nombre_CentroAtencion"),rs.getString("Lugar_CentroAtencion"),capacidad,rs.getString("Tipo_CentroAtencion"));
				diagnosticoRegistrado.add(objDiagnostico);
			}
			return diagnosticoRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnosticoRegistrado;
	}
	
	
	public boolean verificarCentroAtencion(String query) throws SQLException {
		ArrayList<Integer> centroAtencion = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				centroAtencion.add(rs.getInt("Codigo_CentroAtencion"));
			}
			if (centroAtencion.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getIdCentroAtencion(String nombreCentroAtencion) {
		String query,temp;
		temp = "'" + nombreCentroAtencion + "'";
		String resultado = "";
		query = "SELECT * FROM CentroAtencion WHERE Nombre_CentroAtencion = " +temp+";";
		try
		{
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				resultado = rs.getString("Codigo_CentroAtencion");
				}
			conn.close();
			return resultado;
			
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}
		return null;	
	}

}
