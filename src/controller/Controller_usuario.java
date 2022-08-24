/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloTablaUsuario;
import modelo.Persona;
import modelo.PersonaJpaController;
import modelo.Usuario;
import modelo.UsuarioJpaController;
import proyecto_producto.ManageFactory;

import view.View_usuario;

/**
 *
 * @author User
 */
public class Controller_usuario {
    View_usuario vista;
    ManageFactory manage;
    UsuarioJpaController modeloUsuario;
    Usuario usuario;
    JDesktopPane panelEscritorio;
    ModeloTablaUsuario modelotabla;
    ListSelectionModel listaUsernaModel;
    
    public Controller_usuario(View_usuario vista, ManageFactory manage, UsuarioJpaController modeloUsuario,JDesktopPane panelEscritorio) {
        
        this.manage = manage;
        this.modeloUsuario = modeloUsuario;
        this.panelEscritorio=panelEscritorio;
         this.modelotabla = new ModeloTablaUsuario();
        this.modelotabla.setFilas(this.modeloUsuario.findUsuarioEntities());
        
        if (controller_admin.vu==null) {
            controller_admin.vu=new View_usuario();
            this.vista = controller_admin.vu;
             panelEscritorio.add(this.vista);
            this.vista.getTablausuario().setModel(modelotabla);
            controller_admin.vu.show();
            
           
            cargarCombobos();
            iniciarControl();
            
            
            Dimension desktopSize=this.panelEscritorio.getSize();
            Dimension FrameSize=this.vista.getSize();
            this.vista.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
        
        }else{
           controller_admin.vu.show();
        }
        
    }
    
    //ffvhbdfjvdfjvhdbfjvbdfvbjhdfvbhjdvjhdfbvhjdfvhdfvbdfvbhjdfvbhjdfvbhjdvhj
    
    public void iniciarControl() {
        this.vista.getGuardarUS().addActionListener(l -> guardarUsuario());
        this.vista.getBtactualizarUS().addActionListener(l -> editarUsuario());
        this.vista.getBteliminarUS().addActionListener(l -> eliminarUsuario());
        this.vista.getTablausuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUsernaModel = this.vista.getTablausuario().getSelectionModel();
        listaUsernaModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    usuarioSeleccionado();
                }
            }

        });

        this.vista.getBteliminarUS().setEnabled(false);
        this.vista.getBtactualizarUS().setEnabled(false);
        this.vista.getLimpFU().addActionListener(l -> limpiar());
        this.vista.getBtlimpiar().addActionListener(l -> limpiarbuscador());
        this.vista.getBotonbusqueda().addActionListener(l -> buscarusuario());
        this.vista.getCheckmos().addActionListener(l -> buscarusuario());
    }

    //GUARDAR PERSONA
    public void guardarUsuario() {
        usuario = new Usuario();
        usuario.setUsuario(this.vista.getUsuariotxt().getText());
        usuario.setClave(this.vista.getContraseñatxt().getText());
        usuario.setIdpersona((Persona) this.vista.getCmbopersona().getSelectedItem());

        modeloUsuario.create(usuario);
        modelotabla.agregar(usuario);
        Resources.success("Atención!!", "USUARIO GUARDADA CORECTAMENTE");
        //  JOptionPane.showMessageDialog(panelEscritorio, "PERSONA CREADA CORRECTAMENTE");
        limpiar();
    }

    //EDITAR PERSONA
    public void editarUsuario() {
        if (usuario != null) {
            usuario.setUsuario(this.vista.getUsuariotxt().getText());
            usuario.setClave(this.vista.getContraseñatxt().getText());
            usuario.setIdpersona((Persona) this.vista.getCmbopersona().getSelectedItem());
            Resources.success("Atención!!", "USUARIO EDITADA CORECTAMENTE");
            try {
                modeloUsuario.edit(usuario);
                modelotabla.eliminar(usuario);
                modelotabla.actualizar(usuario);
                limpiar();
            } catch (Exception ex) {

                Logger.getLogger(Controller_usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //ELIMINAR PERSONA
    public void eliminarUsuario() {
        if (usuario != null) {
            try {
                modeloUsuario.destroy(usuario.getIdusuario());
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Controller_usuario.class.getName()).log(Level.SEVERE, null, ex);
                limpiar();
            }
            modelotabla.eliminar(usuario);
            //  JOptionPane.showMessageDialog(panelEscritorio, "PERSONA ELIMINADA CORRECTAMENTE");
            Resources.success("ALERTA!!", "USUARIO ELIMINADO CORECTAMENTE");
        }
    }

    public void limpiar() {
        this.vista.getUsuariotxt().setText("");
        this.vista.getContraseñatxt().setText("");
        this.vista.getCmbopersona().setSelectedItem(0);

        this.vista.getBteliminarUS().setEnabled(false);
        this.vista.getBtactualizarUS().setEnabled(false);
        this.vista.getGuardarUS().setEnabled(true);
        this.vista.getTablausuario().getSelectionModel().clearSelection();
    }

    public void usuarioSeleccionado() {
        if (this.vista.getTablausuario().getSelectedRow() != -1) {
            usuario = modelotabla.getFilas().get(this.vista.getTablausuario().getSelectedRow());
            this.vista.getUsuariotxt().setText(usuario.getUsuario());
            this.vista.getContraseñatxt().setText(usuario.getClave());
            this.vista.getCmbopersona().setSelectedItem(usuario.getIdpersona());
            //
            this.vista.getBteliminarUS().setEnabled(true);
            this.vista.getBtactualizarUS().setEnabled(true);
            this.vista.getGuardarUS().setEnabled(false);
        }
    }

    public void limpiarbuscador() {
        this.vista.getBuscartxt().setText("");
        modelotabla.setFilas(modeloUsuario.findUsuarioEntities());
        modelotabla.fireTableDataChanged();
    }

    public void cargarCombobos() {
        try {
            Vector v = new Vector();
            v.addAll(new PersonaJpaController(manage.getEntityManagerFactory()).findPersonaEntities());
            this.vista.getCmbopersona().setModel(new DefaultComboBoxModel(v));

        } catch (ArrayIndexOutOfBoundsException ex) {

            System.out.println("ERROR");
        }
    }

    public void buscarusuario() {
        if (this.vista.getCheckmos().isSelected()) {
            modelotabla.setFilas(modeloUsuario.findUsuarioEntities());
            modelotabla.fireTableDataChanged();
            limpiarbuscador();
           // System.out.println("llego");
        } else {
            if (!this.vista.getBuscartxt().getText().equals("")) {
                modelotabla.setFilas(modeloUsuario.buscarUsuario1(this.vista.getBuscartxt().getText()));
                modelotabla.fireTableDataChanged();
              //  System.out.println("llego2");
            } else {

            }

        }

    }
    
    //xhbcsudhbcusbduycbsydcbsyudbcyusdbfysubfyudshiufhwidfhiuwehfuiwhefu
    
    
    
}
