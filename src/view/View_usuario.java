/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class View_usuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form View_usuario
     */
    public View_usuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        buscartxt = new javax.swing.JTextField();
        usuariotxt = new javax.swing.JTextField();
        contraseñatxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btlimpiar = new javax.swing.JButton();
        btactualizarUS = new javax.swing.JButton();
        bteliminarUS = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        guardarUS = new javax.swing.JButton();
        botonbusqueda = new javax.swing.JButton();
        checkmos = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        limpFU = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        cmbopersona = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("USUARIO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Criterio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel2.setText("Persona");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel4.setText("Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        Contraseña.setText("Contraseña");
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        buscartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscartxtActionPerformed(evt);
            }
        });
        jPanel1.add(buscartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 230, 30));

        usuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariotxtActionPerformed(evt);
            }
        });
        jPanel1.add(usuariotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, 30));

        contraseñatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñatxtActionPerformed(evt);
            }
        });
        jPanel1.add(contraseñatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, 30));

        jButton1.setText("Cancelar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 110, 40));
        jPanel1.add(btlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 70, 40));
        jPanel1.add(btactualizarUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 50, 40));
        jPanel1.add(bteliminarUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 50, 40));

        jLabel8.setText("Administracion de USUARIOS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel9.setText("lista de usuarios");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, 20));

        jLabel10.setText("Opciones de busqueda");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));
        jPanel1.add(guardarUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 50, 40));
        jPanel1.add(botonbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 100, 40));

        checkmos.setText("Mostrar todo");
        jPanel1.add(checkmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        jLabel11.setText("Busqueda de Usuarios");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, 20));

        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablausuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 620, 230));
        jPanel1.add(limpFU, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 50, 40));
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 50, 40));
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 50, 40));

        cmbopersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbopersonaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbopersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartxtActionPerformed

    private void usuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariotxtActionPerformed

    private void contraseñatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñatxtActionPerformed

    private void cmbopersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbopersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbopersonaActionPerformed

    public JComboBox<String> getCmbopersona() {
        return cmbopersona;
    }

    public void setCmbopersona(JComboBox<String> cmbopersona) {
        this.cmbopersona = cmbopersona;
    }

    public JLabel getContraseña() {
        return Contraseña;
    }

    public void setContraseña(JLabel Contraseña) {
        this.Contraseña = Contraseña;
    }

    public JButton getBotonbusqueda() {
        return botonbusqueda;
    }

    public void setBotonbusqueda(JButton botonbusqueda) {
        this.botonbusqueda = botonbusqueda;
    }

    public JButton getBtactualizarUS() {
        return btactualizarUS;
    }

    public void setBtactualizarUS(JButton btactualizarUS) {
        this.btactualizarUS = btactualizarUS;
    }

    public JButton getBteliminarUS() {
        return bteliminarUS;
    }

    public void setBteliminarUS(JButton bteliminarUS) {
        this.bteliminarUS = bteliminarUS;
    }

    public JButton getBtlimpiar() {
        return btlimpiar;
    }

    public void setBtlimpiar(JButton btlimpiar) {
        this.btlimpiar = btlimpiar;
    }

    public JTextField getBuscartxt() {
        return buscartxt;
    }

    public void setBuscartxt(JTextField buscartxt) {
        this.buscartxt = buscartxt;
    }

    public JCheckBox getCheckmos() {
        return checkmos;
    }

    public void setCheckmos(JCheckBox checkmos) {
        this.checkmos = checkmos;
    }

    public JTextField getContraseñatxt() {
        return contraseñatxt;
    }

    public void setContraseñatxt(JTextField contraseñatxt) {
        this.contraseñatxt = contraseñatxt;
    }

    public JButton getGuardarUS() {
        return guardarUS;
    }

    public void setGuardarUS(JButton guardarUS) {
        this.guardarUS = guardarUS;
    }

    public JButton getLimpFU() {
        return limpFU;
    }

    public void setLimpFU(JButton limpFU) {
        this.limpFU = limpFU;
    }

    public JTable getTablausuario() {
        return tablausuario;
    }

    public void setTablausuario(JTable tablausuario) {
        this.tablausuario = tablausuario;
    }

    public JTextField getUsuariotxt() {
        return usuariotxt;
    }

    public void setUsuariotxt(JTextField usuariotxt) {
        this.usuariotxt = usuariotxt;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton botonbusqueda;
    private javax.swing.JButton btactualizarUS;
    private javax.swing.JButton bteliminarUS;
    private javax.swing.JButton btlimpiar;
    private javax.swing.JTextField buscartxt;
    private javax.swing.JCheckBox checkmos;
    private javax.swing.JComboBox<String> cmbopersona;
    private javax.swing.JTextField contraseñatxt;
    private javax.swing.JButton guardarUS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpFU;
    private javax.swing.JTable tablausuario;
    private javax.swing.JTextField usuariotxt;
    // End of variables declaration//GEN-END:variables
}
