package Actividad.software.modelo;

public class HistorialPedidos {
	
	public String mostrarHistorial(String cliente) {
        return "Historial de pedidos de " + cliente + ":\n- Producto X\n- Producto Y\n- Producto Z";
    }

    public String realizarPedido(String cliente, String producto) {
        return cliente + " ha pedido: " + producto;
    }
}
