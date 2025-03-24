package co.edu.poli.Trabajo_Clase.modelo;

import java.util.List;

import co.edu.poli.Trabajo_Clase.servicio.DAO_Especializado;

public abstract class Producto implements DAO_Especializado, Cloneable{
	private long idProducto;
	private String descripcion;	
	
	public abstract void mostrarInfo();
	
	public Producto(long idProducto, String descripcion) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + "]";
	}
	
	@Override
    public Producto clone() {
        try {
            return (Producto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el producto", e);
        }
    }

	    
}
