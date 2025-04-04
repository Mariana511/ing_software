package co.edu.poli.Trabajo_Clase.modelo;

public class EnvioNacional extends Envio{

	public EnvioNacional(Mercancia Mercancia) {
		super(Mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar(String destino) {
		// TODO Auto-generated method stub
		return "Envío Nacional:\n" + Mercancia.procesarCarga(destino);

	}
}
