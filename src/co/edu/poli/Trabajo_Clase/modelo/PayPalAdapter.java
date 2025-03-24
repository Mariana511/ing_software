package co.edu.poli.Trabajo_Clase.modelo;

import co.edu.poli.Trabajo_Clase.servicio.PayPalPago;

public class PayPalAdapter implements Pago {
	 private PayPalPago paypal;

	    public PayPalAdapter(PayPalPago paypal) {
	        this.paypal = paypal;
	    }

	@Override
	public void procesarPago(double monto) {
		paypal.pagoPayPal(monto);		
	}
	

}
