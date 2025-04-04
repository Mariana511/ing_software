package co.edu.poli.Trabajo_Clase.modelo;

public class EnvioNacional extends Envio{

	public EnvioNacional(TipoCarga tipoCarga) {
		super(tipoCarga);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar(String destino) {
		// TODO Auto-generated method stub
		return "Envío Nacional:\n" + tipoCarga.procesarCarga(destino);

	}
}
