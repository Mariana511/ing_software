module Actividad.software {
    requires javafx.controls;
    requires javafx.fxml;

    opens Actividad.software.vista to javafx.fxml;
    exports Actividad.software.vista;
    
}
