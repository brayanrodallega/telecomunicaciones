/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipacifico.presentacion;

import co.edu.unipacifico.controlador.*;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class GUIConsultarBitacoraOperaciones extends javax.swing.JFrame {

    private final IControladorLinea controladorLinea = new ControladorLinea();

    /**
     * Creates new form ConsultarBitacora
     */
    public GUIConsultarBitacoraOperaciones() {
        initComponents();
        setLocationRelativeTo(null);
        llenarTablaMesaje();
        llenarTablaLlamada();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoNegro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBitacoraOperacionesLlamada = new javax.swing.JTable();
        fondoNegro2 = new javax.swing.JPanel();
        textoBitacoraDeOperaciones = new javax.swing.JLabel();
        textoMensaje = new javax.swing.JLabel();
        textoLlamadas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBitacoraOperacionesMensaje = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondoNegro.setBackground(new java.awt.Color(51, 51, 51));
        fondoNegro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBitacoraOperacionesLlamada.setBackground(new java.awt.Color(214, 217, 223));
        tablaBitacoraOperacionesLlamada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Emisor", "Receptor", "Duracion", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBitacoraOperacionesLlamada);

        fondoNegro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 850, 200));

        fondoNegro2.setBackground(new java.awt.Color(51, 51, 51));
        fondoNegro2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoBitacoraDeOperaciones.setBackground(new java.awt.Color(204, 204, 204));
        textoBitacoraDeOperaciones.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        textoBitacoraDeOperaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoBitacoraDeOperaciones.setText("BITACORA DE OPERACIONES");
        fondoNegro2.add(textoBitacoraDeOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 930, 70));

        fondoNegro.add(fondoNegro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 90));

        textoMensaje.setBackground(new java.awt.Color(204, 204, 204));
        textoMensaje.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        textoMensaje.setText("MENSAJES:");
        fondoNegro.add(textoMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        textoLlamadas.setBackground(new java.awt.Color(204, 204, 204));
        textoLlamadas.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        textoLlamadas.setText("LLAMADAS:");
        fondoNegro.add(textoLlamadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        tablaBitacoraOperacionesMensaje.setBackground(new java.awt.Color(214, 217, 223));
        tablaBitacoraOperacionesMensaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Emisor", "Receptor", "Mensaje", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBitacoraOperacionesMensaje.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(tablaBitacoraOperacionesMensaje);

        fondoNegro.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 850, 200));

        getContentPane().add(fondoNegro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarTablaMesaje() {
        String[] titulos = new String[]{
            "Emisor", "Receptor", "Mensaje", "Fecha", "Hora"
        };
        String[][] datos = null;
        try {
            List<String> lista = controladorLinea.consultarBitacoraOperaciones();
            datos = new String[lista.size()][5];
            int cont = 0;
            for (String datico : lista) {
                String datoCorto[] = datico.split(";");
                if (datoCorto[5].equals("Mensaje")) {
                    datos[cont][0] = datoCorto[0];
                    datos[cont][1] = datoCorto[1];
                    datos[cont][2] = datoCorto[2];
                    datos[cont][3] = datoCorto[3];
                    datos[cont][4] = datoCorto[4];
                    cont++;
                }
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "error:" + error.getMessage());
        }
        DefaultTableModel modeloDatos = new DefaultTableModel(datos, titulos);
        tablaBitacoraOperacionesMensaje.setModel(modeloDatos);
    }
    
    public void llenarTablaLlamada() {
        String[] titulos = new String[]{
            "Emisor", "Receptor", "Duracion", "Fecha", "Hora"
        };
        String[][] datos = null;
        try {
            List<String> lista = controladorLinea.consultarBitacoraOperaciones();
            datos = new String[lista.size()][5];
            int cont = 0;
            for (String datico : lista) {
                String datoCorto[] = datico.split(";");
                if (datoCorto[5].equals("Llamada")) {
                    datos[cont][0] = datoCorto[0];
                    datos[cont][1] = datoCorto[1];
                    datos[cont][2] = datoCorto[2];
                    datos[cont][3] = datoCorto[3];
                    datos[cont][4] = datoCorto[4];
                    cont++;
                }
            }
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "error:" + error.getMessage());
        }
        DefaultTableModel modeloDatos = new DefaultTableModel(datos, titulos);
        tablaBitacoraOperacionesLlamada.setModel(modeloDatos);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoNegro;
    private javax.swing.JPanel fondoNegro2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBitacoraOperacionesLlamada;
    private javax.swing.JTable tablaBitacoraOperacionesMensaje;
    private javax.swing.JLabel textoBitacoraDeOperaciones;
    private javax.swing.JLabel textoLlamadas;
    private javax.swing.JLabel textoMensaje;
    // End of variables declaration//GEN-END:variables
}
