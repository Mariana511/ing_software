package co.edu.poli.Trabajo_Clase.servicio;
import java.util.List;

import co.edu.poli.Trabajo_Clase.modelo.Producto;

public interface DAO_Especializado extends DAO_Generico<Producto> {
	List<Producto> consultarPorTipo();
}
