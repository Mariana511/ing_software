package co.edu.poli.Trabajo_Clase.modelo;

import java.util.List;

public class Alimento extends Producto{
	private int aporteCalorico;

	public Alimento(long idProducto, String descripcion, int aporteCalorico) {
		super(idProducto, descripcion);
		this.aporteCalorico = aporteCalorico;
	}

	public int getAporteCalorico() {
		return aporteCalorico;
	}

	public void setAporteCalorico(int aporteCalorico) {
		this.aporteCalorico = aporteCalorico;
	}

	@Override
	public String toString() {
		return "Alimentos [aporteCalorico=" + aporteCalorico + ", getAporteCalorico()=" + getAporteCalorico()
				+ ", getIdProducto()=" + getIdProducto() + ", getDescripcion()=" + getDescripcion() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void mostrarInfo() {
        System.out.println("Alimento: " + getDescripcion() + ", Calorías: " + aporteCalorico);
		
	}

	@Override
	public List<Producto> consultarPorTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto consultar_uno(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> consultar_varios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public Alimento clone() {
        return (Alimento) super.clone();
    }
	

}
