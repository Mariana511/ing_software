package co.edu.poli.Trabajo_Clase.servicio;

import co.edu.poli.Trabajo_Clase.modelo.Pago;

public class PagoEfectivo implements Pago {

	@Override
	public void procesarPago(double monto) {
		System.out.println("Pago efectivo de $" + monto + " realizado.");		
	}
	
    
}
