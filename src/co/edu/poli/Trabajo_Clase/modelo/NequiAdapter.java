package co.edu.poli.Trabajo_Clase.modelo;

public class NequiAdapter implements Pago {
	private NequiPago nequi;

    public NequiAdapter(NequiPago nequi) {
        this.nequi = nequi;
    }

	@Override
	public String procesarPago(double monto) {
		return nequi.pagoNequi(monto);		
	}

}
