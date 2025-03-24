package co.edu.poli.Trabajo_Clase.servicio;

import java.util.List;

import co.edu.poli.Trabajo_Clase.controlador.ConnectionController;
import co.edu.poli.Trabajo_Clase.modelo.Alimento;
import co.edu.poli.Trabajo_Clase.modelo.Cliente;
import co.edu.poli.Trabajo_Clase.modelo.Electronico;
import co.edu.poli.Trabajo_Clase.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoImplementacionDAO implements DAO_Especializado{

	@Override
	public void insertar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto consultar_uno(long id) {		
		String sql = "SELECT * FROM producto WHERE id_producto = ?";
	    try (Connection conn = ConnectionDB.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setLong(1, id); // Aquí se usa setLong para que sea tratado como número
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            System.out.println("Producto encontrado: " + rs.getString("nombre"));
	            String nombre = rs.getString("nombre");
	            String tipo = rs.getString("tipo");
	            int valor = rs.getInt("calorias_o_voltaje");

	            if (tipo.equals("Electronico")) {
	                return new Electronico(id, nombre, valor);
	            } else if (tipo.equals("Alimento")) {
	                return new Alimento(id, nombre, valor);
	            }
	        } else {
	            System.out.println("No se encontró el producto con ID: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public List<Producto> consultar_varios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public List<Producto> consultarPorTipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
