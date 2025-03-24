module Trabajo_Clase {
	exports co.edu.poli.Trabajo_Clase.controlador;
	exports co.edu.poli.Trabajo_Clase.modelo;
	exports co.edu.poli.Trabajo_Clase.servicio;
	exports co.edu.poli.Trabajo_Clase.vista;

	requires java.desktop;
	requires java.sql;
	requires javafx.controls;
    requires javafx.fxml;
    
    opens co.edu.poli.Trabajo_Clase.vista to javafx.fxml;
    opens co.edu.poli.Trabajo_Clase.controlador to javafx.fxml;
    
    
}