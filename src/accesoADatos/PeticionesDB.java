package accesoADatos;

import java.sql.Connection;
import java.sql.ResultSet;


public class PeticionesDB {
	private DBConector conector = DBConector.getDBConector();
	private Connection conn = DBConector.connect();
	
	
	public static ResultSet getPublicMessages() {
		return DBConector.query("select mensajesgeneral.id,mensaje,fecha,idusuario,usuario from mensajesgeneral inner join usuarios on mensajesgeneral.idusuario=usuarios.id;");	
	}
}
