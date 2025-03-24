package co.edu.poli.Trabajo_Clase.modelo;

public interface ProductoFactory {
	
	Producto crearProducto(long idProducto, String descripcion);

}
