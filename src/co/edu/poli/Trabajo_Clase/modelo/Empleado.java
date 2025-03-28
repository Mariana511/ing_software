package co.edu.poli.Trabajo_Clase.modelo;

import co.edu.poli.Trabajo_Clase.servicio.PatronComposite;

public class Empleado implements PatronComposite {
	private String nombre;
    private String cargo;
    
    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }
    
    public void mostrarInformacion(StringBuilder sb) {
        sb.append("Empleado: ").append(nombre).append(", Cargo: ").append(cargo).append("\n");
    }
}