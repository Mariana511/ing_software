module Actividad.software {
	
	exports Actividad.software.controlador;
	exports Actividad.software.modelo;
	exports Actividad.software.vista;


	requires java.desktop;
	requires java.sql;
	requires javafx.controls;
    requires javafx.fxml;
    
    opens Actividad.software.vista to javafx.fxml;
    opens Actividad.software.controlador to javafx.fxml;	   

}
