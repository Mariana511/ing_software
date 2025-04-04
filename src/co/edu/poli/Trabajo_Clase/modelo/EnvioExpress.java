package co.edu.poli.Trabajo_Clase.modelo;

public class EnvioExpress extends Envio {
	
	public EnvioExpress(Mercancia Mercancia) {
		super(Mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar(String destino) {
		// TODO Auto-generated method stub
		return "Envío Express:\n" + Mercancia.procesarCarga(destino);

	}

}
