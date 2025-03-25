package co.edu.poli.Trabajo_Clase.modelo;

public class Proveedor extends Unidad {
	
	private Evaluacion evaluacion;
    private Certificacion certificacion;
    private PoliticaEntrega politicaEntrega;
    
    private Proveedor(ProveedorBuilder builder) {
        super(builder.nombre);
        this.evaluacion = builder.evaluacion;
        this.certificacion = builder.certificacion;
        this.politicaEntrega = builder.politicaEntrega;
    }
    
    public static class ProveedorBuilder {
        private String nombre;
        private Evaluacion evaluacion;
        private Certificacion certificacion;
        private PoliticaEntrega politicaEntrega;
        
        public ProveedorBuilder(String nombre) {
            this.nombre = nombre;
        }
        
        public ProveedorBuilder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }
        
        public ProveedorBuilder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }
        
        public ProveedorBuilder setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }
        
        public Proveedor build() {
            return new Proveedor(this);
        }
    }
    
    @Override
    public String toString() {
        return "Proveedor: " + getNombre() + "\n" +
               "Evaluación: " + (evaluacion != null ? evaluacion.getResultado() : "No asignada") + "\n" +
               "Certificación: " + (certificacion != null ? certificacion.getTipo() : "No asignada") + "\n" +
               "Política de Entrega: " + (politicaEntrega != null ? politicaEntrega.getCondiciones() : "No asignada");
    }

}
