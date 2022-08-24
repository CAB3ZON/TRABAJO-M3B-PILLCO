/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.math.BigInteger;
import java.util.logging.Level;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloTablaProducto;

import modelo.Producto;
import modelo.ProductoJpaController;
import modelo.exceptions.NonexistentEntityException;
import proyecto_producto.ManageFactory;
import view.View_producto;


/**
 *
 * @author User
 */
public class Controller_producto {
     View_producto vista;
    ManageFactory manage;
     ProductoJpaController modeloProducto;
     Producto producto;
     ModeloTablaProducto modeloTablaProducto;
     ListSelectionModel listaproductomodel;


    JDesktopPane panelEscritorio;
    public Controller_producto(View_producto vista, ManageFactory manage, ProductoJpaController modeloProducto,JDesktopPane panelEscritorio) {
        
        this.manage = manage;
        this.modeloProducto = modeloProducto;
        this.panelEscritorio=panelEscritorio;
        this.modeloTablaProducto = new ModeloTablaProducto();
        this.modeloTablaProducto.setFilas(this.modeloProducto.findProductoEntities());
        
        
        if (controller_admin.vpro==null) {
            controller_admin.vpro=new View_producto();
            this.vista = controller_admin.vpro;
             this.panelEscritorio.add(this.vista);
             this.vista.getTablaproducto().setModel(modeloTablaProducto);
            controller_admin.vpro.show();
            iniciar();
           
            
            Dimension desktopSize=this.panelEscritorio.getSize();
            Dimension FrameSize=this.vista.getSize();
            this.vista.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
        
        }else{
            controller_admin.vpro.show(); 
        }
        
    }
     public void guardarProducto() {
        producto = new Producto();
        producto.setNombre(this.vista.getNombrePRTXT().getText());
        BigInteger precio = new BigInteger(this.vista.getPrecioPRtxr().getText());
         
        producto.setPrecio(precio);
        Integer cantidad = Integer.parseInt(this.vista.getCantidadPrtxt().getText());
        producto.setCantidad(cantidad);

        modeloProducto.create(producto);
        modeloTablaProducto.agregar(producto);
        Resources.success("ALERTA!!", "PRODUCTO GUARDADA CORECTAMENTE");
        JOptionPane.showMessageDialog(panelEscritorio, "PRODUCTO CREADO CORRECTAMENTE");
        limpiar();
    }
    //fjrsrkfjhjskdjfkdnjklfmnskdlmflksdmklfmsdklmfklsdmflksdmklfmsdklmfklsdmflksdmklfmdklfmskldfmsklfmklds
        public void editarProducto() {
        if (producto != null) {
            producto.setNombre(this.vista.getNombrePRTXT().getText());
            
            BigInteger precio=new BigInteger(this.vista.getPrecioPRtxr().getText());
            producto.setPrecio(precio);
            Integer cantidad = Integer.parseInt(this.vista.getCantidadPrtxt().getText());
            producto.setCantidad(cantidad);
            Resources.success("ALERTA!!", "PERSONA ACTUALIZAD CORECTAMENTE");
            try {
                modeloProducto.edit(producto);
                modeloTablaProducto.eliminar(producto);
                modeloTablaProducto.actualizar(producto);
                limpiar();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Controller_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarProducto() {
        if (producto != null) {
            try {
                modeloProducto.destroy(producto.getIdproducto());
                limpiar();
            } catch (NonexistentEntityException ex) {
                java.util.logging.Logger.getLogger(Controller_producto.class.getName()).log(Level.SEVERE, null, ex);
            }
            modeloTablaProducto.eliminar(producto);
            JOptionPane.showMessageDialog(panelEscritorio, "PERSONA ELIMINADA CORRECTAMENTE");
            Resources.success("ALERTA!!", "PERSONA ELIMINADA CORECTAMENTE");
        }
    }

    public void iniciar() {
        this.vista.getBtguardarPR().addActionListener(l -> guardarProducto());
        this.vista.getEditarPR().addActionListener(l -> editarProducto());
        this.vista.getEliminarPR().addActionListener(l -> eliminarProducto());
        this.vista.getTablaproducto().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaproductomodel = this.vista.getTablaproducto().getSelectionModel();
        listaproductomodel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    productoSeleccionada();
                }
            }

        });
        this.vista.getEliminarPR().setEnabled(false);
        this.vista.getEditarPR().setEnabled(false);
        this.vista.getLimpiar1PR().addActionListener(l -> limpiar());
        this.vista.getLimpiarbuscadorPR().addActionListener(l -> limpiarbuscador());
        this.vista.getBuscarPR().addActionListener(l -> buscarproducto());
        this.vista.getMostrarPR().addActionListener(l -> buscarproducto());
    }

    public void limpiar() {
        this.vista.getNombrePRTXT().setText("");
        this.vista.getPrecioPRtxr().setText("");
        this.vista.getCantidadPrtxt().setText("");

        this.vista.getEliminarPR().setEnabled(false);
        this.vista.getEditarPR().setEnabled(false);
        this.vista.getBtguardarPR().setEnabled(true);
        this.vista.getTablaproducto().getSelectionModel().clearSelection();
    }

    public void productoSeleccionada() {
        if (this.vista.getTablaproducto().getSelectedRow() != -1) {
            producto = modeloTablaProducto.getFilas().get(this.vista.getTablaproducto().getSelectedRow());
            this.vista.getNombrePRTXT().setText(producto.getNombre());
            String precio = String.valueOf(producto.getPrecio());
            this.vista.getPrecioPRtxr().setText(precio);
            String cantidad = String.valueOf(producto.getCantidad());
            this.vista.getCantidadPrtxt().setText(cantidad);
            ////
            this.vista.getEliminarPR().setEnabled(true);
            this.vista.getEditarPR().setEnabled(true);
            this.vista.getBtguardarPR().setEnabled(false);
        }

    }

    public void buscarproducto() {
        if (this.vista.getMostrarPR().isSelected()) {
            modeloTablaProducto.setFilas(modeloProducto.findProductoEntities());
            modeloTablaProducto.fireTableDataChanged();

        } else {
            if (!this.vista.getTxtbuscarPR().getText().equals("")) {
                modeloTablaProducto.setFilas(modeloProducto.buscarProducto(this.vista.getTxtbuscarPR().getText()));
                modeloTablaProducto.fireTableDataChanged();
                
            } else {
                limpiarbuscador();
            }

        }

    }

    public void limpiarbuscador() {
        this.vista.getTxtbuscarPR().setText("");
        modeloTablaProducto.setFilas(modeloProducto.findProductoEntities());
        modeloTablaProducto.fireTableDataChanged();
    }

}
            
    
    //fsdfsdfsdfsdfmnsdkfjnsdkjfjskdfnkjsdhnfjksdhnfjshdjkfhskdjfhsdjkfhskdjfhdsjkfhkdsjfhkjsdfhsjdkfhksdj
    
    
    
    
