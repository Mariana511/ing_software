package co.edu.poli.Trabajo_Clase.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import co.edu.poli.Trabajo_Clase.controlador.ConnectionController;

public class ConnectionDB {
	
	
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    
    public static Connection conectar() throws SQLException{
    	String url=resourceBundle.getString("db.url");
    	String usuario=resourceBundle.getString("db.user");
    	String password=resourceBundle.getString("db.password");
    	
    	Connection conn = DriverManager.getConnection(url, usuario, password);
        conn.setAutoCommit(true); // Habilita auto-commit por si estaba desactivado
        return conn;
    	//return DriverManager.getConnection(url, usuario, password);
    }

}
/*
 * 
 *private ConnectionDB() {}
 * private static ConnectionDB instance;
private Connection connection;
public static synchronized ConnectionDB getInstance() {
    if (instance == null) {
        instance = new ConnectionDB();
    }
    return instance;
}

public Connection getConnection() {
    try {
        if (connection == null || connection.isClosed()) {
            String url = resourceBundle.getString("db.url");
            String user = resourceBundle.getString("db.user");
            String password = resourceBundle.getString("db.password");

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }
    } catch (ClassNotFoundException | SQLException e) {
        ConnectionController.getInstance().manejarError("Error de conexión: " + e.getMessage());
    }
    return connection;
}

public void closeConnection() {
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            ConnectionController.getInstance().manejarError("Error al cerrar la conexión: " + e.getMessage());
        } finally {
            connection = null;
            instance = null;
        }
    }
}



private static ConnectionDB instance;
private Connection connection;
private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
     
public static synchronized ConnectionDB getInstance() throws SQLException, ClassNotFoundException {
    if (instance == null) {
        instance = new ConnectionDB();
    }
    return instance;
}

public Connection getConnection() {
	return connection;
}

private ConnectionDB() throws SQLException, ClassNotFoundException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            resourceBundle.getString("db.url"),
            resourceBundle.getString("db.user"),
            resourceBundle.getString("db.password")
        );
    } catch (ClassNotFoundException | SQLException e) {
        // Enviamos automáticamente el error al controlador
        ConnectionController.getInstance().mostrarErrorEnVista("Error en la conexión: " + e.getMessage());
        throw e; // Lanza la excepción para que no pase desapercibida
    }
}

public Connection getConnection() throws ClassNotFoundException, SQLException {
	if (connection == null || connection.isClosed()) {
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        Class.forName("org.postgresql.Driver"); // o el driver correspondiente si cambias de DB
        connection = DriverManager.getConnection(url, user, password);
    }
    return connection;
}

public  void closeConnection() {
    if (connection != null) {
        try {
            connection.close();	                
        } catch (SQLException e) {
            ConnectionController.getInstance().mostrarErrorEnVista("Error al cerrar la conexión: " + e.getMessage());
        }finally {
            connection = null;
            instance = null;	              
           
        }
    }
}
        
public static String getProperty(String Key) {
	return resourceBundle.getString(Key);
}*/
