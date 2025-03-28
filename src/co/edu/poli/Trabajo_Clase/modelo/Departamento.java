package co.edu.poli.Trabajo_Clase.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements PatronComposite{
	private String nombre;
    private List<PatronComposite> elementos = new ArrayList<>();
    
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarElemento(PatronComposite elemento) {
        elementos.add(elemento);
    }
    
    public void eliminarElemento(PatronComposite elemento) {
        elementos.remove(elemento);
    }
    
    @Override
    public void mostrarInformacion(StringBuilder sb) {
        sb.append("Departamento: ").append(nombre).append("\n");
        for (PatronComposite elemento : elementos) {
            elemento.mostrarInformacion(sb);
        }
    }
}