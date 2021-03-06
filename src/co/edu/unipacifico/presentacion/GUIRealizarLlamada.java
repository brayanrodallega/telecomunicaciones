/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipacifico.presentacion;

import co.edu.unipacifico.controlador.*;
import co.edu.unipacifico.modelo.*;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class GUIRealizarLlamada extends javax.swing.JFrame {

    private final IControladorLinea controladorLinea = new ControladorLinea();

    /**
     * Creates new form EnviarMensaje
     */
    public GUIRealizarLlamada() {
        initComponents();
        setLocationRelativeTo(null);
        llenarCombox();
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
        textoRealizarLlamada = new javax.swing.JLabel();
        comboxLineas = new javax.swing.JComboBox<>();
        textoSeleccionarLinea = new javax.swing.JLabel();
        textoDuracionLlamada = new javax.swing.JLabel();
        textoNumeroReceptor = new javax.swing.JLabel();
        campoReceptor = new javax.swing.JTextField();
        botonLlamar = new javax.swing.JButton();
        campoDuracionLlamada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoRealizarLlamada.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        textoRealizarLlamada.setText("REALIZAR LLAMADA");
        jPanel1.add(textoRealizarLlamada, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 10, -1, -1));

        comboxLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxLineasActionPerformed(evt);
            }
        });
        jPanel1.add(comboxLineas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        textoSeleccionarLinea.setBackground(new java.awt.Color(204, 204, 204));
        textoSeleccionarLinea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textoSeleccionarLinea.setText("Seleccione la linea emisora:");
        jPanel1.add(textoSeleccionarLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        textoDuracionLlamada.setBackground(new java.awt.Color(204, 204, 204));
        textoDuracionLlamada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textoDuracionLlamada.setText("Duracion de la llamada:");
        jPanel1.add(textoDuracionLlamada, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 170, -1, -1));

        textoNumeroReceptor.setBackground(new java.awt.Color(204, 204, 204));
        textoNumeroReceptor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textoNumeroReceptor.setText("Escriba el numero receptor:");
        jPanel1.add(textoNumeroReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel1.add(campoReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 140, -1));

        botonLlamar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonLlamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unipacifico/imagenes/phone-call-regular-48.png"))); // NOI18N
        botonLlamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLlamarActionPerformed(evt);
            }
        });
        jPanel1.add(botonLlamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 70, 50));

        campoDuracionLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDuracionLlamadaActionPerformed(evt);
            }
        });
        jPanel1.add(campoDuracionLlamada, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLlamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLlamarActionPerformed

        String emisor = comboxLineas.getSelectedItem().toString();
        String receptor = campoReceptor.getText();
        double duracionLlamada = Double.parseDouble(campoDuracionLlamada.getText());
        
        if (emisor.isBlank() || receptor.isBlank() || campoDuracionLlamada.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos!");
        } else if (receptor.length() < 10) {
            JOptionPane.showMessageDialog(null, "El numero del receptor es inferior a 10 digitos!");
        } else if (receptor.length() > 10) {
            JOptionPane.showMessageDialog(null, "El numero del receptor es superior a 10 digitos!");
        } else {
            try {
                controladorLinea.realizarLlamada(emisor, receptor, duracionLlamada);
                JOptionPane.showMessageDialog(null, "La llamada fue un exito!", "Llamada", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar llamada:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_botonLlamarActionPerformed

    public void llenarCombox() {
        try {
            for (LineaTelefonica linea : controladorLinea.listarLineasTelefonicas()) {
                comboxLineas.addItem(linea.getNumeroLinea());
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar lineas:\n" + ex.getMessage());
        }
    }

    private void comboxLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxLineasActionPerformed

    }//GEN-LAST:event_comboxLineasActionPerformed

    private void campoDuracionLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDuracionLlamadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDuracionLlamadaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLlamar;
    private javax.swing.JTextField campoDuracionLlamada;
    private javax.swing.JTextField campoReceptor;
    private javax.swing.JComboBox<String> comboxLineas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel textoDuracionLlamada;
    private javax.swing.JLabel textoNumeroReceptor;
    private javax.swing.JLabel textoRealizarLlamada;
    private javax.swing.JLabel textoSeleccionarLinea;
    // End of variables declaration//GEN-END:variables
}
