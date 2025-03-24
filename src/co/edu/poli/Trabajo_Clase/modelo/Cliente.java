package co.edu.poli.Trabajo_Clase.modelo;

public class Cliente implements Cloneable {
	private long id;
	private String nombre;
	
	public Cliente(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	@Override
	public Cliente clone() {
		try {
			return (Cliente) super.clone();
		}catch (CloneNotSupportedException e) {
			throw new RuntimeException("Erro al clonar cliente", e);
		}
	}
	

}
