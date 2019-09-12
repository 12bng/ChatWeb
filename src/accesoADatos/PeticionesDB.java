package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Message;
import modelo.User;


public class PeticionesDB {
	private static DBConector conector = DBConector.getDBConector();
	private static Connection conn = conector.connect();
	
	
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
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void addPublicMessage(Message mensaje) {
		String sql = "INSERT INTO mensajesgeneral (mensaje, idusuario) VALUES (?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, mensaje.getMessage());
			ps.setInt(2, mensaje.getIdSender());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
