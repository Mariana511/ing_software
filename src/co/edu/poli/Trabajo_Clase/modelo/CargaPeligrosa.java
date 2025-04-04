package co.edu.poli.Trabajo_Clase.modelo;

public class CargaPeligrosa implements Mercancia {
	@Override
	public String procesarCarga(String destino) {
		return "Procesando carga peligrosa con precaución y advertencia hacia " + destino + "\n";
	}

}
