/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioJpaController;
import proyecto_producto.ManageFactory;
import view.View_Login;
import view.View_admin;


/**
 *
 * @author User
 */
public class ControllerLogin {
    private ManageFactory manager;
    private View_Login vista;
    private UsuarioJpaController modelo;

    public ControllerLogin(ManageFactory manager, View_Login vista, UsuarioJpaController modelo) {
        this.manager = manager;
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        iniciarcontrol();
    }
    public void iniciarcontrol(){
            vista.getBtnentrar().addActionListener(l->controlLogin());
            vista.getBtnsalir().addActionListener(l->exit());
            
    }
    public void exit(){
        System.exit(0);
    }
    public void controlLogin(){
        String usuario=vista.getTxtusuario().getText();
        String clave=vista.getTxtcontraseña().getText();
        
        
        
        
        try{
            Usuario user=modelo.buscarUsuario(usuario, clave);
            if (user!=null) {   
                
            JOptionPane.showMessageDialog(vista,"usuario correcto a ingresado: "+user.getIdpersona().getNombre()+";;;;"+user.getIdpersona().getCorreo());
            vista.setVisible(false);
            View_admin va=new View_admin();
            va.setVisible(true);
            new controller_admin(va, manager);
            
        }else{
                JOptionPane.showMessageDialog(vista, "Usuario Incorrecto");
        }  
        }catch(PersistenceException e ){
            JOptionPane.showMessageDialog(vista, "XAMPP APAGADO");
        }
        
      
    }
}
