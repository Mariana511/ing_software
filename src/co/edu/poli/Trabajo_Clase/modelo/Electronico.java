package co.edu.poli.Trabajo_Clase.modelo;

import java.util.List;

public class Electronico extends Producto{
	private int voltajeEntrada;

	public Electronico(long idProducto, String descripcion, int voltajeEntrada) {
		super(idProducto, descripcion);
		this.voltajeEntrada = voltajeEntrada;
	}

	public int getVoltajeEntrada() {
		return voltajeEntrada;
	}

	public void setVoltajeEntrada(int voltajeEntrada) {
		this.voltajeEntrada = voltajeEntrada;
	}

	@Override
	public String toString() {
		return "Electronicos [voltajeEntrada=" + voltajeEntrada + ", getVoltajeEntrada()=" + getVoltajeEntrada()
				+ ", getIdProducto()=" + getIdProducto() + ", getDescripcion()=" + getDescripcion() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void mostrarInfo() {
        System.out.println("Electrónico: " + getDescripcion() + ", Voltaje: " + voltajeEntrada);
		
	}

	@Override
	public List<Producto> consultarPorTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto consultar_uno(long id) {
		// TODO Auto-generated method stub
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
    public Electronico clone() {
        return (Electronico) super.clone();
    }
	
		

}
