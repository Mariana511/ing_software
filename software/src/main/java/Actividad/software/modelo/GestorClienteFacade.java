package Actividad.software.modelo;

public class GestorClienteFacade{
    private final HistorialPedidos historialPedidos;
    private final GestionPagos gestionPagos;

    public GestorClienteFacade() {
        this.historialPedidos = new HistorialPedidos();
        this.gestionPagos = new GestionPagos();
    }

    public String mostrarInformacion(Cliente c) {
        return "Cliente: " + c.getNombre() + " - Email: " + c.getEmail();
    }

    public void actualizarInformacion(Cliente c, String nuevoEmail) {
        c.setEmail(nuevoEmail);
    }

    public String realizarPedido(Cliente c, String producto) {
        return historialPedidos.realizarPedido(c.getNombre(), producto);
    }

    public String mostrarHistorial(Cliente c) {
        return historialPedidos.mostrarHistorial(c.getNombre());
    }

    public String activarPago(String metodo) {
        return gestionPagos.activar(metodo);
    }

    public String bloquearPago(String metodo) {
        return gestionPagos.bloquear(metodo);
    }
}