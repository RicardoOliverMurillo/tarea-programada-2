package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.*;


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
	
	public List<CatalogoDiagnosticos> getListaDiagnosticos() {
		List<CatalogoDiagnosticos> catalogoDiagnosticos = new ArrayList<CatalogoDiagnosticos>();
		String query = "SELECT * FROM Diagnostico";
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString("Nombre"));
				CatalogoDiagnosticos diagnostico = new CatalogoDiagnosticos(rs.getString("Nombre"));
				catalogoDiagnosticos.add(diagnostico);
			}
			return catalogoDiagnosticos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalogoDiagnosticos;
	}

	

}