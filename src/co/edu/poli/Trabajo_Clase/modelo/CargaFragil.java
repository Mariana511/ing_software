package co.edu.poli.Trabajo_Clase.modelo;

public class CargaFragil implements TipoCarga {

	@Override
	public String procesarCarga(String destino) {
		return "Procesando carga frágil con precaución hacia " + destino + "\n";
	}

}
