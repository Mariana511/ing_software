package co.edu.poli.Trabajo_Clase.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.Trabajo_Clase.controlador.ConnectionController;
import co.edu.poli.Trabajo_Clase.modelo.Cliente;

public class ClienteImplementacionDAO implements DAO_Generico<Cliente>{

	private List<Cliente> clientes = new ArrayList<>();
	
	@Override
	public void insertar(Cliente entidad) {
		 String sql = "INSERT INTO cliente (id, nombre) VALUES (?, ?)";
		    try (Connection conn = ConnectionDB.conectar();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        //conn.setAutoCommit(false); 
		        pstmt.setLong(1, entidad.getId());
		        pstmt.setString(2, entidad.getNombre());
		        int rowsAffected = pstmt.executeUpdate();
		        //conn.commit();       		        
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public Cliente consultar_uno(long id) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
	    try (Connection conn = ConnectionDB.conectar();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setLong(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return new Cliente(rs.getLong("id"), rs.getString("nombre"));
	            }
	        }
	    } catch (SQLException e) {
	        ConnectionController.getInstance().manejarError("Error al consultar cliente: " + e.getMessage());
	    }
	    return null;
	}

	@Override
	public List<Cliente> consultar_varios() {
		List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConnectionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getLong("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            ConnectionController.getInstance().manejarError("Error al consultar clientes: " + e.getMessage());
        }
        return clientes;
	}

	@Override
	public void actualizar(Cliente entidad) {
		String sql = "UPDATE cliente SET nombre = ? WHERE id = ?";
        try (Connection conn = ConnectionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	//conn.setAutoCommit(false);            
        	pstmt.setString(1, entidad.getNombre());
            pstmt.setLong(2, entidad.getId());
            pstmt.executeUpdate();
            //conn.commit();
        } catch (SQLException e) {
            ConnectionController.getInstance().manejarError("Error al actualizar cliente: " + e.getMessage());
        }
	}

	@Override
	public void eliminar(long id) {
		String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = ConnectionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            ConnectionController.getInstance().manejarError("Error al eliminar cliente: " + e.getMessage());
        }	
	}
	

}
