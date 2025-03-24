package co.edu.poli.Trabajo_Clase.modelo;

import java.util.ArrayList;

public class Pedido {
	private int numero;
	private String fecha;
	private Cliente cliente;
	private ArrayList<Producto> listaproducto;
	
	public Pedido(int numero, String fecha, Cliente cliente, ArrayList<Producto> listaproducto) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		this.listaproducto = listaproducto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Producto> getListaproducto() {
		return listaproducto;
	}

	public void setListaproducto(ArrayList<Producto> listaproducto) {
		this.listaproducto = listaproducto;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", listaproducto="
				+ listaproducto + "]";
	}
	

}
