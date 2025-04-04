package co.edu.poli.Trabajo_Clase.modelo;

public class Documentos implements TipoCarga{

	@Override
	public String procesarCarga(String destino) {
		// TODO Auto-generated method stub
		return "Procesando documentos hacia " + destino + "\n";
	}

}
