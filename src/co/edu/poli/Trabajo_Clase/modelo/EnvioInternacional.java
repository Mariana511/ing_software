package co.edu.poli.Trabajo_Clase.modelo;

public class EnvioInternacional extends Envio {

	public EnvioInternacional(Mercancia Mercancia) {
		super(Mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar(String destino) {
		// TODO Auto-generated method stub
		return "Envío Internacional:\n" + Mercancia.procesarCarga(destino);
	}

}
