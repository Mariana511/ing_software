package co.edu.poli.Trabajo_Clase.modelo;

public abstract class CarritoDecorator implements CarritoCompra {
	protected CarritoCompra carrito;

	public CarritoDecorator(CarritoCompra carrito) {
		super();
		this.carrito = carrito;
	}

	@Override
	public int getCantidadArticulos() {
		return carrito.getCantidadArticulos();
	}
	
}
