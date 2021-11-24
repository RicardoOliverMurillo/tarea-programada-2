package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.*;


public class daoRegistrarDiagnostico {
	
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
	
	public List<List<String>> listDiagnostico(String query) {
		List<List<String>> listDiagnostico = new ArrayList<List<String>>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				List<String> diagnostico = new ArrayList<String>();

				diagnostico.add(Integer.toString(rs.getInt("ID_Diagnostico")));
				diagnostico.add(rs.getString("Nombre"));
				diagnostico.add(rs.getString("Nivel"));
				diagnostico.add(rs.getString("Observaciones"));
				diagnostico.add(Integer.toString(rs.getInt("CedulaPaciente")));
				diagnostico.add(rs.getString("Fecha"));
				
				listDiagnostico.add(diagnostico);
			}
			return listDiagnostico;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDiagnostico;
	}
	
	
	

	

}