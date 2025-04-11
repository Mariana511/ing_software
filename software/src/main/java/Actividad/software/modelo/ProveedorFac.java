package Actividad.software.modelo;

import java.util.HashMap;

public class ProveedorFac {
    private static final HashMap<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor obtenerProveedor(String nombre) {
        proveedores.putIfAbsent(nombre, new Proveedor(nombre));
        return proveedores.get(nombre);
    }
}