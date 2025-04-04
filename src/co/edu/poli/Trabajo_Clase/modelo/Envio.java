package co.edu.poli.Trabajo_Clase.modelo;

public abstract class Envio {
	protected Mercancia Mercancia;

    public Envio(Mercancia tipoCarga) {
        this.Mercancia = tipoCarga;
    }

    public abstract String enviar(String destino);

}
