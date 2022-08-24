/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 59399
 */
public class ModeloTablaProducto extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Cantidad", "Precio"};
    public static List<Producto> filas;
    private Producto productoselecionado;
    private int indice;

    public ModeloTablaProducto() {
        filas = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override 
    public Object getValueAt(int rowIndex, int columnIndex) {
        productoselecionado = filas.get(rowIndex);
        this.indice = rowIndex;
        switch (columnIndex) {
            case 0:
                return productoselecionado.getNombre();
            case 1:
                return productoselecionado.getCantidad();
            case 2:
                return productoselecionado.getPrecio();
            
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return Long.class;
            
            default:
                return Object.class;
        }
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public List<Producto> getFilas() {
        return filas;
    }

    public void setFilas(List<Producto> filas) {
        this.filas = filas;
    }

    public Producto getProductoSelecionado() {
        return productoselecionado;
    }

    public void setProductoSelecionado(Producto productoselecionado) {
        this.productoselecionado = productoselecionado;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void actualizar(Producto p) {
        setProductoSelecionado(null);
        if (p != null) {
            filas.add(indice, p);
            fireTableDataChanged();
        }
    }

    public void agregar(Producto p) {
        if (p != null) {
            filas.add(p);
            fireTableDataChanged();
        }
    }

    public void eliminar(Producto p) {
        if (p != null) {
            filas.remove(p);
            fireTableDataChanged();
        }

    }
}

