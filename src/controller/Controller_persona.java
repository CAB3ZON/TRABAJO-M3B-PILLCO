/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloTablaPersona;
import modelo.Persona;
import modelo.PersonaJpaController;
import modelo.exceptions.NonexistentEntityException;
import proyecto_producto.ManageFactory;
import view.View_persona;


/**
 *
 * @author User
 */
public class Controller_persona {
    ModeloTablaPersona modelotabla;
      View_persona vista;
    ManageFactory manage;
PersonaJpaController modeloPersona;
Persona persona;
    JDesktopPane panelEscritorio;
    ListSelectionModel listapersonamodel;
    public Controller_persona(View_persona vista, ManageFactory manage, PersonaJpaController modeloPersona,JDesktopPane panelEscritorio) {
        
        this.manage = manage;
        this.modeloPersona = modeloPersona;
        this.panelEscritorio=panelEscritorio;
        this.modelotabla=new ModeloTablaPersona();
        this.modelotabla.setFilas(modeloPersona.findPersonaEntities());
        if (controller_admin.vp==null) {
            controller_admin.vp=new View_persona();
            this.vista = controller_admin.vp;
            panelEscritorio.add(this.vista);
             this.vista.getTabla_personas().setModel(modelotabla);
            this.vista.show();
            iniciar();
            Dimension desktopSize=this.panelEscritorio.getSize();
            Dimension FrameSize=this.vista.getSize();
            this.vista.setLocation((desktopSize.width - FrameSize.width)/2,(desktopSize.height - FrameSize.height)/2);
            this.vista.getTabla_personas().setModel(modelotabla);
            controller_admin.vp.show();
         
        }else{
            controller_admin.vp.show();
            
        }
        
    }

    
    
    //rfggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggMETODOS
    public void guardarPersona() {
        persona = new Persona();
        persona.setNombre(this.vista.getNombre().getText());
        persona.setApellido(this.vista.getApellido().getText());
        persona.setCedula(this.vista.getCedula().getText());
        persona.setCelular(this.vista.getCelular().getText());
        persona.setCorreo(this.vista.getCoreo().getText());
        persona.setDireccion(this.vista.getDireccio().getText());
       
       //fgfdgdgdfg
//       Validaciones vx=new Validaciones();
//       boolean valido_cedula =vx.validarCedula(this.vista.getCedula().getText());
//       boolean valido_nombre=vx.ValidarTextoConEspacio(this.vista.getNombre().getText());
//       boolean valido_apellido=vx.ValidarTextoConEspacio(this.vista.getApellido().getText());
//       boolean valido_correo=vx.validarEmail(this.vista.getCoreo().getText());
//       boolean valido_celular=vx.validarCelu(this.vista.getCelular().getText());
//       boolean valido_direccion=vx.validarDirec(this.vista.getDireccio().getText());
//       
//      
       
//        if (valido_cedula==false||valido_nombre==false||valido_apellido==false||valido_correo==false||valido_celular==false||valido_direccion==false) {
//           JOptionPane.showMessageDialog(panelEscritorio, "Datos invalidos reviselos"); 
//        }else{
       //dfgfdgdfgdgfd
        modeloPersona.create(persona);
       modelotabla.agregar(persona);
        JOptionPane.showMessageDialog(panelEscritorio, "PERSONA CREADA CORRECTAMENTE");
//        }
        limpiar();
    }
    
    public void editarPersona(){
        if (persona != null) {
            persona.setNombre(this.vista.getNombre().getText());
            persona.setApellido(this.vista.getApellido().getText());
            persona.setCedula(this.vista.getCedula().getText());
            persona.setCelular(this.vista.getCelular().getText());
            persona.setCorreo(this.vista.getCoreo().getText());
            persona.setDireccion(this.vista.getDireccio().getText());
            try {
                modeloPersona.edit(persona);
               modelotabla.eliminar(persona);
               modelotabla.actualizar(persona);
               limpiar();
            } catch (Exception ex) {
               Logger.getLogger(Controller_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public void eliminarPersona(){
        if (persona != null) {
            try {
                modeloPersona.destroy(persona.getIdpersona());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Controller_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            modelotabla.eliminar(persona);
            
               JOptionPane.showMessageDialog(panelEscritorio, "PERSONA ELIMINADA CORRECTAMENTE");
        }
    }

public void iniciar(){
    this.vista.getGuardar().addActionListener(l->guardarPersona());
    this.vista.getEditar().addActionListener(l->editarPersona());
    this.vista.getEliminar().addActionListener(l->eliminarPersona());
    this.vista.getTabla_personas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listapersonamodel=this.vista.getTabla_personas().getSelectionModel();
    listapersonamodel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                personaSeleccionada();
            }
        }
    });
    this.vista.getEliminar().setEnabled(false);
    this.vista.getEditar().setEnabled(false);
    this.vista.getLimpiar1().addActionListener(l->limpiar());
    this.vista.getLimpiar2().addActionListener(l->limpiarbuscador());
    this.vista.getBuscar().addActionListener(l -> buscarpersona());
    
        this.vista.getCriterio().addActionListener(l -> buscarpersona());
}

  public void buscarpersona() {
        if (this.vista.getCriterio().isSelected()) {
            modelotabla.setFilas(modeloPersona.findPersonaEntities());
            modelotabla.fireTableDataChanged();

        } else { if (!this.vista.getTxtbuscar().getText().equals("")) {
                modelotabla.setFilas(modeloPersona.buscarPersona(this.vista.getTxtbuscar().getText()));
                modelotabla.fireTableDataChanged();
            } else {
                limpiarbuscador();
            }

        }

    }
public void limpiar() {
        this.vista.getNombre().setText("");
        this.vista.getApellido().setText("");
        this.vista.getCedula().setText("");
        this.vista.getCelular().setText("");
        this.vista.getCoreo().setText("");
        this.vista.getDireccio().setText("");
        this.vista.getEliminar().setEnabled(false);
        this.vista.getEditar().setEnabled(false);
        this.vista.getGuardar().setEnabled(true);
        this.vista.getTabla_personas().getSelectionModel().clearSelection();
    }

public void personaSeleccionada(){
    if (this.vista.getTabla_personas().getSelectedRow()!=-1) {
        persona=modelotabla.getFilas().get(this.vista.getTabla_personas().getSelectedRow());
        this.vista.getNombre().setText(persona.getNombre());
        this.vista.getApellido().setText(persona.getApellido());
        this.vista.getCedula().setText(persona.getCedula());
        this.vista.getCelular().setText(persona.getCelular());
        this.vista.getCoreo().setText(persona.getCorreo());
        this.vista.getDireccio().setText(persona.getDireccion());
          this.vista.getEliminar().setEnabled(true);
            this.vista.getEditar().setEnabled(true);
            this.vista.getGuardar().setEnabled(false);
    }
}



public void limpiarbuscador() {
        this.vista.getTxtbuscar().setText("");
        modelotabla.setFilas(modeloPersona.findPersonaEntities());
        modelotabla.fireTableDataChanged();
    }


}
    //dccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdcccc
    

