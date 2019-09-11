package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.User;


public class PeticionesDB {
	private DBConector conector = DBConector.getDBConector();
	private Connection conn = DBConector.connect();
	
	
	public static ResultSet getPublicMessages() {
		return DBConector.query("SELECT mensajesgeneral.id,mensaje,fecha,idusuario,usuario FROM mensajesgeneral INNER JOIN usuarios ON mensajesgeneral.idusuario=usuarios.id ORDER BY fecha ASC;");	
	}
//	public static ResultSet getAllUserNames() {
//		return DBConector.query("SELECT usuario FROM usuarios;");
//	}
	public User login(String name, String password) {
		String sql = "SELECT id FROM usuarios WHERE usuario=? AND contraseña=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					return new User(rs.getInt("id"), name, password);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
