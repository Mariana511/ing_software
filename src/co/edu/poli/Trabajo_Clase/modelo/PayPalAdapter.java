package co.edu.poli.Trabajo_Clase.modelo;

public class PayPalAdapter implements Pago {
	 private PayPalPago paypal;

	    public PayPalAdapter(PayPalPago paypal) {
	        this.paypal = paypal;
	    }

	@Override
	public String procesarPago(double monto) {
		return paypal.pagoPayPal(monto);		
	}
	

}
