package Actividad.software.modelo;

public class ProductoProxy implements Producto {
	
    private ProductoReal real;
    private final String nombre;
    private final int nivelUsuario;

    public ProductoProxy(String nombre, int nivelUsuario) {
        this.nombre = nombre;
        this.nivelUsuario = nivelUsuario;
    }

    @Override
    public void mostrarDetalles(StringBuilder salida) {
        if (nivelUsuario >= 2) {
            if (real == null) real = new ProductoReal(nombre);
            real.mostrarDetalles(salida);
        } else {
            salida.append("Acceso denegado al producto: ").append(nombre).append("\n");
        }
    }
}