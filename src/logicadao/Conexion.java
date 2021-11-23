package logicadao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conexionBaseDatos() throws SQLException {
		String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String myUrl = "jdbc:sqlserver://localhost:1433;databaseName=Prueba;";
		Connection con;
		con = DriverManager.getConnection(myUrl, "sa", "ligaBARCA230");
		return con;
	}

}
