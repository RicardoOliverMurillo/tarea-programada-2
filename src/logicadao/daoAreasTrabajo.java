package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	
	public ArrayList<String> listAreaTrabajo(String query) {
		ArrayList<String> areaTrabajo = new ArrayList<String>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				areaTrabajo.add(rs.getString("Nombre"));
			}
			return areaTrabajo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaTrabajo;
	}
	

}