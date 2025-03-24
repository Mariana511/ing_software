package co.edu.poli.Trabajo_Clase.vista;

import javax.swing.JOptionPane;

import co.edu.poli.Trabajo_Clase.controlador.ConnectionController;

public class ErrorView_Connection {
	public ErrorView_Connection() {
        // Suscribir la vista al controlador para recibir errores automáticamente
        ConnectionController.getInstance().agregarObservador(this);
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
