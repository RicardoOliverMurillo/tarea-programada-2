package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.CatalogoDiagnosticos;
import logicanegocios.CatalogoTratamientos;


public class daoCatalogoTratamientos {
	
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
	
	public boolean verificarCatalogoTratamientos(String query) throws SQLException {
		ArrayList<Integer> CatalogoTratamientos = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CatalogoTratamientos.add(rs.getInt("ID_Tratamiento"));
			}
			if (CatalogoTratamientos.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<CatalogoTratamientos> getTratamientoRegistrado(String query) {
		List<CatalogoTratamientos> tratamientosRegistrado = new ArrayList<CatalogoTratamientos>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CatalogoTratamientos objTratamiento = new CatalogoTratamientos(rs.getString("Nombre"),rs.getString("ID_Diagnostico"));
				tratamientosRegistrado.add(objTratamiento);
			}
			return tratamientosRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tratamientosRegistrado;
	}
	
	public String getIdTratamiento(String nombreDiagnostico) {
		String query,temp;
		temp = "'" + nombreDiagnostico + "'";
		String resultado = "";
		query = "SELECT * FROM Tratamientos WHERE Nombre = " +temp+";";
		try
		{
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				resultado = rs.getString("ID_Tratamiento");
				}
			conn.close();
			return resultado;
			
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}
		return null;	
	}
	
	

	

}