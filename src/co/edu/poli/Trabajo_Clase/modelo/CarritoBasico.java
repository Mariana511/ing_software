package co.edu.poli.Trabajo_Clase.modelo;

public class CarritoBasico implements CarritoCompra {
	private double costo;
	private int cantidadArticulos;
		
	public CarritoBasico(double costo, int cantidadArticulos) {
		super();
		this.costo = costo;
		this.cantidadArticulos = cantidadArticulos;
	}
	@Override
	public int getCantidadArticulos() {
		return cantidadArticulos;
	}
	@Override
	public double getCosto() {
		return costo;
	}

}
