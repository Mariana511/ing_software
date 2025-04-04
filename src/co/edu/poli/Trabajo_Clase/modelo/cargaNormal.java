package co.edu.poli.Trabajo_Clase.modelo;

public class cargaNormal implements Mercancia {

	@Override
	public String procesarCarga(String destino) {
		return "Procesando envío de carga normal hacia " + destino + "\n";
	}

}
