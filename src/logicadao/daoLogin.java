package logicadao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logicanegocios.Usuario;

public class daoLogin {
	private Statement stmt;
	ResultSet rs;
	
	public void createUser(String query) {
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
	
	public Usuario loginUser(String query){
		Usuario user = new Usuario();
		
		try {
			Connection conn = new Conexion().conexionBaseDatos();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				user.setCedula(rs.getInt("Cedula"));
				user.setContrasenna(rs.getString("contrasenna"));
				user.setRol(rs.getString("rol"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
