/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_producto;

import controller.ControllerLogin;
import modelo.UsuarioJpaController;
import view.View_Login;

/**
 *
 * @author User
 */
public class PRINCIPAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      ManageFactory manager=new ManageFactory();
     View_Login vista=new View_Login();
    UsuarioJpaController modelo=new UsuarioJpaController(manager.getEntityManagerFactory());
    ControllerLogin controlador=new ControllerLogin(manager,vista,modelo);
    }
    
}
