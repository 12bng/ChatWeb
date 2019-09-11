package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConector {
	private static final String NOMBRE_DB = "chat";
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/"+NOMBRE_DB+"?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    // init connection object
    private static Connection conn;
    // init properties object
    private static Properties properties;

    private DBConector() {
    	connect();
   }
    
    //singleton
    private static DBConector connector= null;
    
    public static DBConector getDBConector() {
    	if(connector==null) {
    		connector = new DBConector();
    		//connect();
    	}
    	return connector;
    }
    // create properties
    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public static Connection connect() {
        if (conn == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                conn = DriverManager.getConnection(DATABASE_URL, getProperties());
                System.out.println("Conexion hecha");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    // disconnect database
    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static ResultSet query(String request) {
		ResultSet rs = null;
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(request);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public static boolean update(String request) {
		java.sql.Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(request);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	
	
	

}

	
