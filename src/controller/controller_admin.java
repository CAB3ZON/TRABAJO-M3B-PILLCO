/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import modelo.PersonaJpaController;
import modelo.ProductoJpaController;
import modelo.UsuarioJpaController;
import proyecto_producto.ManageFactory;
import view.View_admin;
import view.View_persona;
import view.View_producto;
import view.View_usuario;


/**
 *
 * @author User
 */
public class controller_admin extends javax.swing.JFrame{
    View_admin vista;
    ManageFactory manage;
    public static View_persona vp;
    public static View_usuario vu;
    public static View_producto vpro;

    public controller_admin(View_admin vista, ManageFactory manage) {
        this.vista = vista;
        this.manage = manage;
        this.vista.setExtendedState(MAXIMIZED_BOTH);
        controlevento();
    }
    
    public void controlevento(){
        vista.getMenu_personas().addActionListener(l->cargavistapersona());
        vista.getMenu_usuario().addActionListener(l->cargavistausuario());
        vista.getMenu_productos().addActionListener(l->cargavistaproducto());
    }
     public void cargavistausuario(){
       new Controller_usuario(vu, manage, new UsuarioJpaController(manage.getEntityManagerFactory()),this.vista.getEscritorio());
    }
    public void cargavistapersona(){
       new Controller_persona(vp, manage, new PersonaJpaController(manage.getEntityManagerFactory()),this.vista.getEscritorio());
    }
    public void cargavistaproducto(){
       new Controller_producto(vpro, manage, new ProductoJpaController(manage.getEntityManagerFactory()),this.vista.getEscritorio());
    }
}
    