package co.edu.poli.Trabajo_Clase.modelo;

public class EnvioGratisDecorator extends CarritoDecorator {
	private double costoEnvio;
		
	public EnvioGratisDecorator(CarritoCompra carrito, double costoEnvio) {
		super(carrito);
		this.costoEnvio = costoEnvio;
	}

	@Override
	public double getCosto() {
		double costoEnvioG = carrito.getCosto()-costoEnvio;
		return Math.max(0, costoEnvioG);
	}
}
