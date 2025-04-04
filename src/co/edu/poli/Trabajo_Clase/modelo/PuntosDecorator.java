package co.edu.poli.Trabajo_Clase.modelo;

public class PuntosDecorator extends CarritoDecorator {
	private double puntos;

	public PuntosDecorator(CarritoCompra carrito, double puntos) {
		super(carrito);
		this.puntos = puntos;
	}

	@Override
	public double getCosto() {
		double costoPuntos = carrito.getCosto()-puntos;
		return Math.max(0, costoPuntos);
	}
}
