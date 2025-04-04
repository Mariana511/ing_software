package co.edu.poli.Trabajo_Clase.modelo;

public abstract class Envio {
	protected TipoCarga tipoCarga;

    public Envio(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public abstract String enviar(String destino);

}
