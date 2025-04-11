package Actividad.software.modelo;

public class ProductoReal implements Producto {
    private final String nombre;

    public ProductoReal(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarDetalles(StringBuilder salida) {
        salida.append("Detalles del producto: ").append(nombre).append("\n");
    }
}