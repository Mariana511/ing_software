module Actividad.software {
    requires javafx.controls;
    requires javafx.fxml;

    opens Actividad.software to javafx.fxml;
    exports Actividad.software;
}
