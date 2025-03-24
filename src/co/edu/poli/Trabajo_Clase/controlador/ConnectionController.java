package co.edu.poli.Trabajo_Clase.controlador;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.Trabajo_Clase.vista.ErrorView_Connection;

public class ConnectionController {
	private static ConnectionController instance;
    private final List<ErrorView_Connection> observadores;

    private ConnectionController() {
        this.observadores = new ArrayList<>();
    }

    public static synchronized ConnectionController getInstance() {
        if (instance == null) {
            instance = new ConnectionController();
        }
        return instance;
    }
    //vistas que mostrarán errores
    public void agregarObservador(ErrorView_Connection vista) {
        observadores.add(vista);
    }

    //automatic a todas las vistas
    private void notificarError(String mensaje) {
        for (ErrorView_Connection vista : observadores) {
            vista.mostrarMensajeError(mensaje);
        }
    } 
    
    
    
    // Método que usa ConnectionDB para mostrar errores automáticamente
    public void manejarError(String mensaje) {
        notificarError(mensaje);
    }
	
}
/*private static ConnectionController instance;
private mostrarMain vistaError;

private ConnectionController() {
    vistaError = new mostrarMain();
}

public static synchronized ConnectionController getInstance() {
    if (instance == null) {
        instance = new ConnectionController();
    }
    return instance;
}

public void mostrarErrorEnVista(String mensaje) {
    vistaError.mostrarMensajeError(mensaje);
}*/
