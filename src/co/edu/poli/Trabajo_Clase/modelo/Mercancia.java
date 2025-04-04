package co.edu.poli.Trabajo_Clase.modelo;

public class Mercancia implements TipoCarga {

	@Override
	public String procesarCarga(String destino) {
		return "Procesando envío de mercancía hacia " + destino + "\n";
	}

}
