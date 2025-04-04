package co.edu.poli.Trabajo_Clase.modelo;

public class CargaFragil implements Mercancia {

	@Override
	public String procesarCarga(String destino) {
		return "Procesando carga frágil con precaución hacia " + destino + "\n";
	}

}
