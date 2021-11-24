package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.*;


public class daoCatalogoDiagnostico {
	
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
	
	public List<CatalogoDiagnosticos> getDiagnosticoRegistrado(String query) {
		List<CatalogoDiagnosticos> diagnosticoRegistrado = new ArrayList<CatalogoDiagnosticos>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CatalogoDiagnosticos objDiagnostico = new CatalogoDiagnosticos(rs.getString("Nombre"));
				diagnosticoRegistrado.add(objDiagnostico);
			}
			return diagnosticoRegistrado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnosticoRegistrado;
	}
	
	public boolean verificarCatalogoDiagnostico(String query) throws SQLException {
		ArrayList<Integer> CatalogoDiagnostico = new ArrayList<Integer>();
		Connection conn = new Conexion().conexionBaseDatos();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CatalogoDiagnostico.add(rs.getInt("ID_Diagnostico"));
			}
			if (CatalogoDiagnostico.size() == 1) {
				return true;			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getIdDiagnostico(String nombreDiagnostico) {
		String query,temp;
		temp = "'" + nombreDiagnostico + "'";
		String resultado = "";
		query = "SELECT * FROM Diagnostico WHERE Nombre = " +temp+";";
		try
		{
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				resultado = rs.getString("ID_Diagnostico");
				}
			conn.close();
			return resultado;
			
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}
		return null;	
	}

	

}