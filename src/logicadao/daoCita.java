package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicanegocios.Cita;


public class daoCita {
	
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
	
	public List<Cita> getCitaResgritada(String query) {
		List<Cita> citaRegistrada = new ArrayList<Cita>();
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cita cita = new Cita(rs.getString("Fecha"));
				citaRegistrada.add(cita);
			}
			return citaRegistrada;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citaRegistrada;
	}
	

}
