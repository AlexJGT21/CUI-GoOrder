
package ModelosTabla;

import GoOrderDTO.ProductoDTO;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
    
    public ProductoDTO obtenerProductoAt(int index) {
        return listaProductos.get(index);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 5) {
            return ImageIcon.class;
        }
        return super.getColumnClass(columnIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductoDTO pDTO = listaProductos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> {
                yield pDTO.getId();
            }
            case 1 -> {
                yield pDTO.getNombre();
            } 
            case 2 -> {
                yield pDTO.getDescripcion();
            }
            case 3 -> {
                yield pDTO.getPrecio();
            }
            case 4 -> {
                if (pDTO.getCantidadT() == null) {
                    yield 1;
                }
                yield (pDTO.getCantidadT() <= 0)? 1: pDTO.getCantidadT();
            }
            case 5 -> {
                if (pDTO.getImagenP() != null && pDTO.getImagenP().length > 0 ) {
                    ImageIcon icono = new ImageIcon(pDTO.getImagenP());
                    Image imgEscalada = icono.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
                    yield new ImageIcon(imgEscalada);
                };
                yield null;
            }
            default -> {
                yield null;
            }
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