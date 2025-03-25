package co.edu.poli.Trabajo_Clase.modelo;

public abstract class Unidad {
	private String nombre;
    
    public Unidad(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

}
