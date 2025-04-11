package Actividad.software.modelo;

public class Cliente {

	 private String nombre;
	    private String email;
	    private String cedula;
	    private String telefono;

	   

	    public Cliente(String nombre, String email, String cedula, String telefono) {
			super();
			this.nombre = nombre;
			this.email = email;
			this.setCedula(cedula);
			this.setTelefono(telefono);
		}
		public String getNombre() { return nombre; }
	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
	}
