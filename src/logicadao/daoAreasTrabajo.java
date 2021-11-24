package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.*;


public class daoAreasTrabajo {
	
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
	
	public List<AreasTrabajo> getAreasAtrabajoRegistrado(String query) {
		int capacidad;
		List<AreasTrabajo> diagnosticoRegistrado = new ArrayList<AreasTrabajo>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				AreasTrabajo objDiagnostico = new AreasTrabajo(rs.getString("Nombre"));
				diagnosticoRegistrado.add(objDiagnostico);
			}
			return diagnosticoRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnosticoRegistrado;
	}
	
	public boolean verificarAreasTrabajoX(String query) throws SQLException {
		ArrayList<Integer> AreasHospital = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				AreasHospital.add(rs.getInt("ID_AreaHospital"));
			}
			if (AreasHospital.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getIdAreasTrabajo(String nombreAreaTrabajo) {
		String query,temp;
		temp = "'" + nombreAreaTrabajo + "'";
		String resultado = "";
		query = "SELECT * FROM AreasHospital WHERE Nombre = " +temp+";";
		try
		{
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				resultado = rs.getString("ID_AreaHospital");
				}
			conn.close();
			return resultado;
			
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}
		return null;	
	}

}