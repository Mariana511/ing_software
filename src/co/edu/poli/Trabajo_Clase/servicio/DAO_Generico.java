package co.edu.poli.Trabajo_Clase.servicio;
import java.util.List;

public interface DAO_Generico<T> {
	void insertar (T entidad);
    T consultar_uno (long id);
    List<T> consultar_varios();
    void actualizar (T entidad);
    void eliminar (long id);

}
