package co.edu.poli.Trabajo_Clase.modelo;

public class PagoEfectivo implements Pago {

	@Override
	public String procesarPago(double monto) {
		return "Pago efectivo de $" + monto + " realizado.";		
	}
	
    
}
