/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmContactos extends javax.swing.JFrame {

    ArbolBinario ab;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField txtBusqueda;

    public FrmContactos() {
        initComponents();
        ab = new ArbolBinario();
        String nombreArchivo=System.getProperty("user.dir")+"/src/datos/contactos.csv";
        
        ab.desdeArchivo(nombreArchivo);
        ab.mostrar(tblContactos);
        //Inicia Mis cambios Yijana   
        // Se crea el campo de busqueda y el botón buscar
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        txtBusqueda.setToolTipText("Buscar por nombre");
        jToolBar1.add(txtBusqueda);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // Cambia la ruta según tus iconos
        btnBuscar.setToolTipText("Buscar Contacto");
        btnBuscar.setFocusable(true);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);
        
        
    }
    
     private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String parteDelNombre = txtBusqueda.getText();
        if (!parteDelNombre.isEmpty()) {
            Nodo encontrado = ab.buscarContacto(parteDelNombre);
            if (encontrado != null) {
                //Se obtiene el modelo de la tabla
            DefaultTableModel dtm = (DefaultTableModel) tblContactos.getModel();

            // Se busca la fila correspondiente al contacto encontrado
            for (int fila = 0; fila < dtm.getRowCount(); fila++) {
                if (dtm.getValueAt(fila, 0).equals(encontrado.nombre)) {
                    // Seleccionar la fila encontrada
                    tblContactos.setRowSelectionInterval(fila, fila);
                    
                    // Hacer que la fila sea visible en la vista
                    tblContactos.scrollRectToVisible(tblContactos.getCellRect(fila, 0, true));

                    break;
                  }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún contacto que coincida", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un contacto para buscar", "Búsqueda", JOptionPane.WARNING_MESSAGE);
        }
    }

     //Termina mis cambios Yijana
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar Contacto");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Retirar Contacto");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar Cambios");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnGuardar);

        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblContactos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Nodo n=new Nodo("", "", "", "", "");
        ab.insertarNodo(n);
        ab.mostrar(tblContactos);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblContactos.getSelectedRow()>=0){
            ab.eliminarNodo(ab.obtenerNodoPosicion(tblContactos.getSelectedRow()));
            ab.mostrar(tblContactos);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblContactos;
    // End of variables declaration//GEN-END:variables
}

