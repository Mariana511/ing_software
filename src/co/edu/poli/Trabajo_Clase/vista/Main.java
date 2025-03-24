package co.edu.poli.Trabajo_Clase.vista;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	TabPane root =(TabPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/Trabajo_Clase/vista/Formulario.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIENDA");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
	
}
