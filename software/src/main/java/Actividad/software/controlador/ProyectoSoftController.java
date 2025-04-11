package Actividad.software.controlador;
import Actividad.software.modelo.Cliente;
import Actividad.software.modelo.GestorClienteFacade;
import Actividad.software.modelo.Producto;
import Actividad.software.modelo.ProductoProxy;
import Actividad.software.modelo.Proveedor;
import Actividad.software.modelo.ProveedorFac;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProyectoSoftController {
	private static final String ProveedorFactory = null;

	@FXML
    private Button bttActivarPago;

    @FXML
    private Button bttActualizarCliente;

    @FXML
    private Button bttAsignarProvProducto;

    @FXML
    private Button bttFormasPago;

    @FXML
    private Button bttHistorialPedidos;

    @FXML
    private Button bttMostrarCliente;

    @FXML
    private Button bttMostrarProvProd;

    @FXML
    private Button bttRealizarPedido;

    @FXML
    private Button bttVerDetalles;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblNivelAcceso;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblProducto;

    @FXML
    private Label lblProveedor;

    @FXML
    private Label lblTelefono;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtNivelAcceso;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtNombreProveedor;

    @FXML
    private TextArea txtSalidaCliente;
    
    @FXML
    private TextArea txtSalidaFly;

    @FXML
    private TextArea txtSalidaProxy;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    void clickActivarPago(ActionEvent event) {
    	GestorClienteFacade gestor = new GestorClienteFacade();
        String resultado = gestor.activarPago("Visa");
        txtSalidaCliente.setText(resultado);
    }

    @FXML
    void clickActualizarCliente(ActionEvent event)  {
        String nombre = txtNombreCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String nuevoCorreo = txtCorreoCliente.getText();

        Cliente cliente = new Cliente(nombre, "correo@anterior.com", cedula, telefono); // Correo anterior simulado
        GestorClienteFacade gestor = new GestorClienteFacade();

        gestor.actualizarInformacion(cliente, nuevoCorreo);

        String salida = "Información actualizada:\n"
                      + "Nombre: " + cliente.getNombre() + "\n"
                      + "Cédula: " + cedula + "\n"
                      + "Teléfono: " + telefono + "\n"
                      + "Nuevo Correo: " + cliente.getEmail();

        txtSalidaCliente.setText(salida);
    }

    @FXML
    void clickAsignarProvProducto(ActionEvent event)  {
        String nombreProducto = txtNombreProducto.getText();
        String nombreProveedor = txtNombreProveedor.getText();
        StringBuilder salida = new StringBuilder();

        if (nombreProducto == null || nombreProducto.isEmpty() || 
            nombreProveedor == null || nombreProveedor.isEmpty()) {
            salida.append("Debe ingresar el nombre del producto y del proveedor.\n");
        } else {
            Proveedor proveedor = ProveedorFac.obtenerProveedor(nombreProveedor);
            salida.append("Producto '").append(nombreProducto)
                  .append("' asignado al proveedor compartido: ")
                  .append(proveedor.getNombre()).append("\n");
        }

        txtSalidaFly.setText(salida.toString());
    }
  

    @FXML
    void clickFormasPago(ActionEvent event) {

    	GestorClienteFacade gestor = new GestorClienteFacade();
        String activar = gestor.activarPago("Mastercard");
        String bloquear = gestor.bloquearPago("Paypal");
        txtSalidaCliente.setText(activar + "\n" + bloquear);
    }

    @FXML
    void clickHistorialPedidos(ActionEvent event) {

    	Cliente cliente = new Cliente(txtNombreCliente.getText(), txtCorreoCliente.getText(),txtCedulaCliente.getText(),txtTelefonoCliente.getText());
        GestorClienteFacade gestor = new GestorClienteFacade();
        String historial = gestor.mostrarHistorial(cliente);
        txtSalidaCliente.setText(historial);
    }

    @FXML
    void clickMostrarCliente(ActionEvent event) {
        String nombre = txtNombreCliente.getText();
        String cedula = txtCedulaCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String correo = txtCorreoCliente.getText();

        
        Cliente cliente = new Cliente(nombre, correo, cedula, telefono);

        
        String salida = "Información del cliente:\n"
                      + "Nombre: " + cliente.getNombre() + "\n"
                      + "Cédula: " + cliente.getCedula() + "\n"
                      + "Teléfono: " + cliente.getTelefono() + "\n"
                      + "Correo: " + cliente.getEmail();

        txtSalidaCliente.setText(salida);
    }
    

    @FXML
    void clickMostrarProvProd(ActionEvent event)  {
        String nombreProveedor = txtNombreProveedor.getText();
        String nombreProducto = txtNombreProducto.getText();

        Proveedor proveedor = ProveedorFac.obtenerProveedor(nombreProveedor);

        StringBuilder sb = new StringBuilder();
        sb.append("Producto: ").append(nombreProducto).append("\n");
        sb.append("Proveedor: ").append(proveedor.getNombre()).append("\n");

        txtSalidaFly.setText(sb.toString());
    }
    
    
    @FXML
    void clickRealizarPedido(ActionEvent event) {

    	   Cliente cliente = new Cliente(txtNombreCliente.getText(), txtCorreoCliente.getText(),txtCedulaCliente.getText(),txtTelefonoCliente.getText());
           GestorClienteFacade gestor = new GestorClienteFacade();
           String pedido = gestor.realizarPedido(cliente, txtNombreProducto.getText());
           txtSalidaCliente.setText(pedido);
    }

    @FXML
    void clickVer(ActionEvent event) {
        String nombreProducto = txtNombreProducto.getText();
        String nivelStr = txtNivelAcceso.getText();
        StringBuilder salida = new StringBuilder();

        if (nombreProducto == null || nombreProducto.isEmpty()) {
            salida.append("Debe ingresar un nombre de producto.\n");
        } else {
            try {
                int nivel = Integer.parseInt(nivelStr);
                ProductoProxy proxy = new ProductoProxy(nombreProducto, nivel);
                proxy.mostrarDetalles(salida);
            } catch (NumberFormatException e) {
                salida.append("Nivel de acceso inválido. Debe ser un número.\n");
            }
        }

        txtSalidaProxy.setText(salida.toString());
    }
    


}
