
package Control;

import CUIInventario.ConsultarProductosFORM;
import CUIInventario.InventarioProductosEntradaFORM;
import CUIInventario.GestionProductosFORM;
import CUIInventario.HistorialProductosEntradaFORM;
import CUIInventario.HistorialProductosSalidaFORM;
import CUIInventario.InventarioProductosSalidaFORM;
import CUInterfaces.ICUIEntradaProducto;
import CUInterfaces.ICUIInventario;
import CUInterfaces.ICUIProducto;
import CUInterfaces.ICUISalidaProducto;
import GUI.*;
import GoOrderDTO.CarritoDTO;
import GoOrderDTO.DatosReporteEntradaDTO;
import GoOrderDTO.DatosReporteSalidaDTO;
import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.ProductoSeleccionadoDTO;
import GoOrderDTO.SalidaProductoDTO;
import GoOrderDTO.SucursalDTO;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.example.NegocioException;
import org.itson.realizarpedidocue.IRealizarPedidoCUE;

public class Control {
    
    public final Color COLOR_FONDO = new Color(18, 18, 18);
    public final Color COLOR_NEON = new Color(0, 255, 150);
    public final Color COLOR_TARJETA = new Color(35, 35, 35);
    public final Color COLOR_BOTON = new Color(35, 35, 35);
    public final Color COLOR_ERROR = new Color(255, 80, 80);
    public final Color COLOR_INPUT = new Color(25, 25, 25);
    public final Color COLOR_BORDE = new Color(60, 60, 60);
    private final String rutaImagenes = "Resources/";
    
    //Casos de uso
    private IRealizarPedidoCUE realizarPedido;
    private ICUIProducto casoProducto;
    private ICUIInventario casoInventario;
    private ICUIEntradaProducto casoEntrada;
    private ICUISalidaProducto casoSalida;
    
    
    List<ProductoDTO> listaProductos = new ArrayList<>();

    public Control(IRealizarPedidoCUE realizarPedido) {
        this.realizarPedido = realizarPedido;
        cargarMenuProductos();
    }
    
    public Control(ICUIProducto casoProducto, ICUIInventario casoInventario, ICUIEntradaProducto casoEntrada, ICUISalidaProducto casoSalida) {
        this.casoProducto = casoProducto;
        this.casoInventario = casoInventario;
        this.casoEntrada = casoEntrada;
        this.casoSalida = casoSalida;
    }

    public ImageIcon obtenerImagen(String nombreImagen) {
        String rutaCompleta = "Resources/" + nombreImagen;
        ImageIcon icono = new ImageIcon(rutaCompleta);
        return icono;
    }
    
    public List<ProductoDTO> buscarProducto(String nombreProducto) throws NegocioException {
        return realizarPedido.buscarProducto(nombreProducto);
    }
    
    public List<ProductoDTO> listarProductos() throws NegocioException {
        return realizarPedido.listarProductos();
    }

    private void cargarMenuProductos() {
    }

    public void agregarProducto(ProductoSeleccionadoDTO producto) throws NegocioException {
        realizarPedido.AgregarProductoCarrito(producto);
    }
    
    public void incrementarCantidad(ProductoSeleccionadoDTO producto) throws NegocioException {
        realizarPedido.IncrementarCantidad(producto);
    }
    
    public void decrementarCantidad(ProductoSeleccionadoDTO producto) throws NegocioException {
        realizarPedido.DescrementarCantidad(producto);
    }
    
    public void eliminarProducto(ProductoSeleccionadoDTO producto) throws NegocioException {
        realizarPedido.EliminarProductoCarrito(producto);
    }
    
    public CarritoDTO getCarrito() throws NegocioException {
        return realizarPedido.ObtenerCarrito();      
    }
    
    public void AplicarDescuento(String descuento) throws NegocioException {
        realizarPedido.AplicarDescuento(descuento);
    }
    
    public void CambiarEstadoDescuento(String descuento)throws NegocioException {
        realizarPedido.cambiarEstadoDescuento(descuento);
    }
    
    public void limpiarCarrito() throws NegocioException {
        realizarPedido.LimpiarCarrito();
    }

    //NAVEGACION DEL SISTEMA
    private JFrame ventanaActual = null;
    
    private void mostrarPantallas(JFrame nuevaVentana){
        if(ventanaActual != null){
            ventanaActual.dispose();
        }
        ventanaActual = nuevaVentana;
        ventanaActual.setVisible(true);
    }
    
    public boolean intentarPago(String cuenta, double totalAPagar) throws NegocioException {
        
        boolean exito = realizarPedido.finalizarCompra(cuenta, totalAPagar);
        
        if (exito) {
            return true;
        } else {
            return false;
        }
    }
    
    public void mostrarInicio(){
        mostrarPantallas(new Inicio(this));
    }
    
    public void mostrarProductosFORM() throws NegocioException, Exception{
        mostrarPantallas(new CatalogoProductosFORM(this));
    }
    
    public void mostrarSeleccionMetodoEntrega(){
        mostrarPantallas(new SeleccionMetodoEntrega(this));
    }
    
    public void mostrarCarrito(){
        mostrarPantallas(new Carrito(this));
    }
    
    public void mostrarSeleccionSucursalesDisponibles(){
        try {
            List<SucursalDTO>  sucursales = realizarPedido.consultarSucursales();
            mostrarPantallas(new SeleccionSucursalesDisponibles(this,sucursales));
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar sucursales: " + e.getMessage());
        }
    }
    public void mostrarDomicilioFORM(){
        mostrarPantallas(new DomicilioFORM(this));
    }
    public void mostrarAjustarDireccionMapa(){
        mostrarPantallas(new AjustarDireccionMapa(this));
    }
    public void mostrarTotalPrecioProductos(){
        
        mostrarPantallas(new TotalPrecioProductos(this));
    }
    public void mostrarSeleccionFormaPago(){
        mostrarPantallas(new SeleccionFormaPago(this));
    }
    public void mostrarCodigoDescuento() {
        mostrarPantallas(new CodigoDescuentoFORM(this));
    }
    public void mostrarPagoEfectivo(){
        mostrarPantallas(new PagoEfectivo(this));
    }
    public void mostrarPagoTarjeta(){
        mostrarPantallas(new PagoTarjeta(this));
    }
    public void mostrarPagoRechazado(){
        mostrarPantallas(new PagoRechazado(this));
    }
    public void mostrarPagoReferencia(){
        mostrarPantallas(new PagoReferencia(this));
    }
    public void mostrarAgradecimiento(){
        mostrarPantallas(new Agradecimiento(this));
    }
    public void mostrarCodigoDescuentoRechazado(){
        mostrarPantallas(new CodigoDescuentoRechazado(this));
    }    
    public void mostrarCatalogoProductos() {
        mostrarPantallas(new CatalogoProductosFORM(this));
    }
    public void mostrarDescripcionProducto(ProductoDTO productoSeleccionado){
        mostrarPantallas(new DescripcionProductoFORM(this, productoSeleccionado));
    }
    
    //----------------------------------------------------------------------------------
    
    public void mostrarGestionProductosFORM(){
        mostrarPantallas(new GestionProductosFORM(this));
    }  
    
    public void mostrarInventarioEntradaFORM() throws NegocioException{
        mostrarPantallas(new InventarioProductosEntradaFORM(this));
    }    
    
    public void mostrarInventarioSalidaFORM() throws NegocioException{
        mostrarPantallas(new InventarioProductosSalidaFORM(this));
    }
    
    public void mostrarConsultarProductosFORM() throws NegocioException {
        mostrarPantallas(new ConsultarProductosFORM(this));
    }
    
    public void mostrarHistorialEntradasFORM() throws NegocioException {
        mostrarPantallas(new HistorialProductosEntradaFORM(this));
    }
    
    public void mostrarHistorialSalidasFORM() throws NegocioException {
        mostrarPantallas(new HistorialProductosSalidaFORM(this));
    }
    
    //Producto
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException {
        return casoProducto.crearProducto(producto);
    }
    
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException {
        return casoProducto.actualizarProducto(producto);
    }
    
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException {
        return casoProducto.eliminarProducto(producto);
    }
    
    public List<ProductoDTO> obtenerProducto(String nombreProducto) throws NegocioException {
        return casoProducto.obtenerProducto(nombreProducto);
    }
    
    public List<ProductoDTO> listarProducto() throws NegocioException {
        return casoProducto.listarProductos();
    }
    
    //Inventario
    public ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException {
        return casoInventario.agregarProducto(producto);
    }
    
    public List<ProductoDTO> obtenerListaProductos() throws NegocioException {
        return casoInventario.obtenerListaProductos();
    }
    
    public List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException {
        return casoInventario.listarProductosFiltros(nombre, cantidad);
    }
    
    public ProductoDTO actualizarSumarProductoInventario(ProductoDTO producto) throws NegocioException {
        return casoInventario.actualizarSumarProductoInventario(producto);
    }
    
    public ProductoDTO actualizarRestarProductoInventario(ProductoDTO producto) throws NegocioException {
        return casoInventario.actualizarRestarProductoInventario(producto);
    }
    
    //Entrada producto
    public EntradaProductoDTO nuevaEntradaProducto(List<ProductoDTO> listaProductosEntrantes) throws NegocioException {
        return casoEntrada.nuevaEntradaProducto(listaProductosEntrantes);
    }

    public List<DatosReporteEntradaDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        return casoEntrada.listarHistorialEntradas(fechaInicio, fechaFin);
    }
    
    //Salida producto
    public SalidaProductoDTO nuevaSalidaProducto(List<ProductoDTO> listaProductosSalientes) throws NegocioException {
        return casoSalida.nuevaSalidaProducto(listaProductosSalientes);
    }
    
     public List<DatosReporteSalidaDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        return casoSalida.listarHistorialSalidas(fechaInicio, fechaFin);
    }    
}