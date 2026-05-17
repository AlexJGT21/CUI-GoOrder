
package ModelosTabla;

import GoOrderDTO.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 
 */
public class InventarioProductosTabla extends AbstractTableModel {

    private final String[] columnas = {"ID", "Nombre", "Descripción", "Precio", "Cantidad", "Imagen"};
    private List<ProductoDTO> listaProductos = new ArrayList<>();
    
    public InventarioProductosTabla(List<ProductoDTO> producto) {
        this.listaProductos = producto;
    }
    
    @Override
    public int getRowCount() {
        return listaProductos.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }        

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }   

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductoDTO pDTO = listaProductos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> pDTO.getId();
            case 1 -> pDTO.getNombre();
            case 2 -> pDTO.getDescripcion();
            case 3 -> pDTO.getPrecio();
            case 4 -> pDTO.getCantidad();
            case 5 -> pDTO.getImagenP();
            default -> null;
        };
    }
    
    public void actualizarDatos(List<ProductoDTO> nuevosDatos) {
        this.listaProductos = nuevosDatos;
        this.fireTableDataChanged();
    }
    
    public void agregarFila(ProductoDTO nuevaFila) {
        listaProductos.add(nuevaFila);
        int nuevaFilaIndex = listaProductos.size() -1;
        fireTableRowsInserted(nuevaFilaIndex, nuevaFilaIndex);
    }
}