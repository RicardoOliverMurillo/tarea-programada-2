package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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

	

}