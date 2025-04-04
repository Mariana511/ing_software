package co.edu.poli.Trabajo_Clase.modelo;

public class DescuentoDecorator extends CarritoDecorator {
	private double porcentaje;
		
	public DescuentoDecorator(CarritoCompra carrito, double porcentaje) {
		super(carrito);
		this.porcentaje = porcentaje;
	}

	@Override
	public double getCosto() {		
		double costoDescuento= carrito.getCosto() * (1-porcentaje);
		return Math.max(0, costoDescuento);
	}
}
