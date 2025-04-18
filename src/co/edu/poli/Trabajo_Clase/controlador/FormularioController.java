package co.edu.poli.Trabajo_Clase.controlador;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import co.edu.poli.Trabajo_Clase.modelo.CargaFragil;
import co.edu.poli.Trabajo_Clase.modelo.CarritoBasico;
import co.edu.poli.Trabajo_Clase.modelo.CarritoCompra;
import co.edu.poli.Trabajo_Clase.modelo.Certificacion;
import co.edu.poli.Trabajo_Clase.modelo.Cliente;
import co.edu.poli.Trabajo_Clase.modelo.Electronico;
import co.edu.poli.Trabajo_Clase.modelo.Evaluacion;
import co.edu.poli.Trabajo_Clase.modelo.Mercancia;
import co.edu.poli.Trabajo_Clase.modelo.NequiAdapter;
import co.edu.poli.Trabajo_Clase.modelo.NequiPago;
import co.edu.poli.Trabajo_Clase.modelo.Pago;
import co.edu.poli.Trabajo_Clase.modelo.PagoEfectivo;
import co.edu.poli.Trabajo_Clase.modelo.PayPalAdapter;
import co.edu.poli.Trabajo_Clase.modelo.PayPalPago;
import co.edu.poli.Trabajo_Clase.modelo.PoliticaEntrega;
import co.edu.poli.Trabajo_Clase.modelo.Producto;
import co.edu.poli.Trabajo_Clase.modelo.Proveedor;
import co.edu.poli.Trabajo_Clase.modelo.PuntosDecorator;
import co.edu.poli.Trabajo_Clase.modelo.CargaNormal;
import co.edu.poli.Trabajo_Clase.modelo.CargaPeligrosa;
import co.edu.poli.Trabajo_Clase.modelo.Departamento;
import co.edu.poli.Trabajo_Clase.modelo.DescuentoDecorator;
import co.edu.poli.Trabajo_Clase.modelo.Documentos;
import co.edu.poli.Trabajo_Clase.modelo.Empleado;
import co.edu.poli.Trabajo_Clase.modelo.Envio;
import co.edu.poli.Trabajo_Clase.modelo.EnvioExpress;
import co.edu.poli.Trabajo_Clase.modelo.EnvioGratisDecorator;
import co.edu.poli.Trabajo_Clase.modelo.EnvioInternacional;
import co.edu.poli.Trabajo_Clase.modelo.EnvioNacional;
import co.edu.poli.Trabajo_Clase.servicio.ClienteImplementacionDAO;
import co.edu.poli.Trabajo_Clase.servicio.ProductoImplementacionDAO;
import javafx.scene.control.TextArea;


public class FormularioController {
	
	private Producto producto1 = new Electronico(1, "Laptop Gamer", 220);
	private final ClienteImplementacionDAO clienteDAO = new ClienteImplementacionDAO();
	@FXML
    private Button bttActualizar;

    @FXML
    private Button bttAdapter;
    
    @FXML
    private Button bttBridge;

    @FXML
    private Button bttBuilder;

    @FXML
    private Button bttClonar;

    @FXML
    private Button bttComposite;

    @FXML
    private Button bttConsultaVarios;
    
    @FXML
    private Button bttDecorator;

    @FXML
    private Button bttEliminar;

    @FXML
    private Button bttIdConsulta;

    @FXML
    private Button bttInsertar;
    
    @FXML
    private CheckBox chkDescuento;
    
    @FXML
    private CheckBox chkEnvioGratis;
    
    @FXML
    private CheckBox chkPuntos;
    
    @FXML
    private TextArea txtAreaCliente;

    @FXML
    private TextArea txtAreaImp;

    @FXML
    private TextField txtId;
    
    @FXML
    private TextField txtIdClonar;

    @FXML
    private TextField txtIdConsulta;

    @FXML
    private TextField txtNombre;

    @FXML
    void clickActualizar(ActionEvent event) {
    	try {
            long id = Long.parseLong(txtId.getText());
            String nombre = txtNombre.getText();

            Cliente cliente = new Cliente(id, nombre);
            clienteDAO.actualizar(cliente);
            mostrarAlerta("Éxito", "Cliente actualizado correctamente", AlertType.INFORMATION);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido. Debe ser un número.", AlertType.ERROR);
        }

    }

    @FXML
    void clickAdapter(ActionEvent event) {
    	try {
            double monto = 100.0; // Puedes hacer que el usuario ingrese este monto en un TextField

            // Crear instancias de pago con Adapter
            Pago pagoNequi = new NequiAdapter(new NequiPago());
            Pago pagoPayPal = new PayPalAdapter(new PayPalPago());
            Pago pagoEfectivo = new PagoEfectivo();

            // Generar mensajes
            StringBuilder resultado = new StringBuilder("Procesando pagos...\n");
            resultado.append(pagoNequi.procesarPago(monto)).append("\n");
            resultado.append(pagoPayPal.procesarPago(monto)).append("\n");
            resultado.append(pagoEfectivo.procesarPago(monto)).append("\n");

            // Mostrar en el TextArea
            txtAreaImp.setText(resultado.toString());

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Monto inválido. Debe ser un número.", AlertType.ERROR);
        }
    }
    
    @FXML
    void clickBridge(ActionEvent event) {
    	Envio envio1 = new EnvioNacional(new CargaNormal());
        Envio envio2 = new EnvioInternacional(new CargaFragil());
        Envio envio3 = new EnvioNacional(new Documentos());
        Envio envio4= new EnvioExpress(new CargaPeligrosa());

        // Mostrar resultados en el TextArea
        String resultado = envio1.enviar("Bogotá") +
                           envio2.enviar("Madrid") +
                           envio3.enviar("Medellin") +
                           envio4.enviar("Madrid");

        txtAreaImp.setText(resultado);

    }

    @FXML
    void clickBuilder(ActionEvent event) {
    	Proveedor proveedor = new Proveedor.ProveedorBuilder("Proveedor ABC")
                .setEvaluacion(new Evaluacion("Aprobado"))
                .setCertificacion(new Certificacion("ISO 9001"))
                .setPoliticaEntrega(new PoliticaEntrega("Entrega en 5 días hábiles"))
                .build();
       
        txtAreaImp.setText(proveedor.toString());

    }   
    
    ProductoImplementacionDAO productoDAO = new ProductoImplementacionDAO();

    @FXML
    void clickClonar(ActionEvent event) {
    	try {
            // Validar que el texto no está vacío y convertirlo a long
            String idTexto = txtIdClonar.getText().trim();
            if (idTexto.isEmpty()) {
                mostrarAlerta("Error", "El campo ID está vacío.", Alert.AlertType.ERROR);
                return;
            }

            long id = Long.parseLong(idTexto); // Convertimos a long

            // Buscar el producto en la base de datos
            Producto productoOriginal = productoDAO.consultar_uno(id);

            if (productoOriginal != null) {
                Producto clon = productoOriginal.clone();
                txtAreaImp.setText("Producto Clonado:\n" + clon.toString());
            } else {
                txtAreaImp.setText("No se encontró un producto con el ID " + id);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El ID debe ser un número válido.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un problema al buscar el producto.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }

    @FXML
    void clickComposite(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        
        Departamento departamento = new Departamento("Desarrollo");
        departamento.agregarElemento(new Empleado("Juan Perez", "Ingeniero de Software"));
        departamento.agregarElemento(new Empleado("Ana Gómez", "Analista QA"));
        
        Departamento subDepartamento = new Departamento("Móvil");
        subDepartamento.agregarElemento(new Empleado("Carlos Ruiz", "Desarrollador Android"));
        subDepartamento.agregarElemento(new Empleado("María López", "Desarrolladora iOS"));
        
        departamento.agregarElemento(subDepartamento);
        
        departamento.mostrarInformacion(sb);
        
        txtAreaImp.setText(sb.toString());
    }


    @FXML
    void clickConsultaVarios(ActionEvent event) {
    	List<Cliente> clientes = clienteDAO.consultar_varios();

        if (!clientes.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Lista de clientes:\n");
            for (Cliente c : clientes) {
                resultado.append("ID: ").append(c.getId()).append(" - Nombre: ").append(c.getNombre()).append("\n");
            }
            txtAreaCliente.setText(resultado.toString());
        } else {
            txtAreaCliente.setText("No hay clientes registrados.");
        }

    }
    
    @FXML
    void clickDecorator(ActionEvent event) {
    	double costoInicial = 150;
        int cantidadArticulos = 4;
        double porcentajeDescuento = 0.10; 
        double valorEnvio = 20;
        double valorPuntos = 5;
        
    	CarritoCompra carrito1=new CarritoBasico(costoInicial, cantidadArticulos);
    	carrito1=new DescuentoDecorator(carrito1, porcentajeDescuento);
    	carrito1=new EnvioGratisDecorator(carrito1, valorEnvio);
    	carrito1=new PuntosDecorator(carrito1, valorPuntos);
    	
    	txtAreaImp.setText(
    	        "Resumen del Carrito:\n" +
    	        		"Costo inicial: $" + costoInicial + "\n" +
    	                "Descuento aplicado: -$" + porcentajeDescuento + "\n" +
    	                "Descuento por envío gratis: -$" + valorEnvio + "\n" +
    	                "Descuento por puntos: -$" + valorPuntos + "\n\n" +
    	                "Cantidad de artículos: " + cantidadArticulos + "\n" +
    	                "Costo final: $" + carrito1.getCosto());
    }

    @FXML
    void clickEliminar(ActionEvent event) {
    	try {
            long id = Long.parseLong(txtId.getText());
            clienteDAO.eliminar(id);
            mostrarAlerta("Éxito", "Cliente eliminado correctamente", AlertType.INFORMATION);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido. Debe ser un número.", AlertType.ERROR);
        }

    }

    @FXML
    void clickIdConsulta(ActionEvent event) {
    	try {
            long id = Long.parseLong(txtIdConsulta.getText());
            Cliente cliente = clienteDAO.consultar_uno(id);

            if (cliente != null) {
                txtAreaCliente.setText("Cliente encontrado:\nID: " + cliente.getId() + "\nNombre: " + cliente.getNombre());
            } else {
                txtAreaCliente.setText("No se encontró un cliente con ese ID.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido. Debe ser un número.", AlertType.ERROR);
        }
    	
    }

    @FXML
    void clickInsertar(ActionEvent event) {
    	try {
            long id = Long.parseLong(txtId.getText());
            String nombre = txtNombre.getText();

            Cliente cliente = new Cliente(id, nombre);
            clienteDAO.insertar(cliente);
            mostrarAlerta("Éxito", "Cliente insertado correctamente", AlertType.INFORMATION);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID inválido. Debe ser un número.", AlertType.ERROR);
        }

    }
    @FXML
    void clickdescuento(ActionEvent event) {
    	actualizarResumenCarrito();

    	
    }
    
    @FXML
    void clickenvio(ActionEvent event) {
    	actualizarResumenCarrito();

    	
    }
    @FXML
    void clickpuntos(ActionEvent event) {
 	actualizarResumenCarrito();
    	
    }
    
    private void actualizarResumenCarrito() {
        double costoInicial = 150;
        int cantidadArticulos = 4;
        double porcentajeDescuento = 0.10;
        double valorEnvio = 20;
        double valorPuntos = 5;

        CarritoCompra carrito = new CarritoBasico(costoInicial, cantidadArticulos);
        StringBuilder resumen = new StringBuilder("Resumen del Carrito:\n");
        resumen.append("Costo inicial: $").append(costoInicial).append("\n");

        if (chkDescuento.isSelected()) {
            carrito = new DescuentoDecorator(carrito, porcentajeDescuento);
            resumen.append("Descuento aplicado: -").append(porcentajeDescuento * 100).append("%\n");
        }
       
		if (chkEnvioGratis.isSelected()) {
            carrito = new EnvioGratisDecorator(carrito, valorEnvio);
            resumen.append("Descuento por envío gratis: -$").append(valorEnvio).append("\n");
        }
        if (chkPuntos.isSelected()) {
            carrito = new PuntosDecorator(carrito, valorPuntos);
            resumen.append("Descuento por puntos: -$").append(valorPuntos).append("\n");
        }

        resumen.append("\nCantidad de artículos: ").append(cantidadArticulos);
        resumen.append("\nCosto final: $").append(carrito.getCosto());

        txtAreaImp.setText(resumen.toString());
    }
    
    
    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.show();
    }

}
