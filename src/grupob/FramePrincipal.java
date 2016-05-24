/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

/**
 *
 * @author USUARIO
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        BusquedaPartidos busq = new BusquedaPartidos(this);
        busq.setVisible(true);
        panelPrincipal.add(busq,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrarPartido = new javax.swing.JButton();
        instituciones = new javax.swing.JButton();
        distritos = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        regiones = new javax.swing.JButton();
        buscarPartido = new javax.swing.JButton();
        locales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 450));
        setPreferredSize(new java.awt.Dimension(750, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrarPartido.setText("Registrar Partido");
        registrarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPartidoActionPerformed(evt);
            }
        });
        getContentPane().add(registrarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        instituciones.setText("Instituciones");
        instituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institucionesActionPerformed(evt);
            }
        });
        getContentPane().add(instituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        distritos.setText("Distritos");
        distritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distritosActionPerformed(evt);
            }
        });
        getContentPane().add(distritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        panelPrincipal.setMinimumSize(new java.awt.Dimension(580, 400));
        panelPrincipal.setName(""); // NOI18N
        panelPrincipal.setPreferredSize(new java.awt.Dimension(580, 400));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 580, 380));
        panelPrincipal.getAccessibleContext().setAccessibleName("");

        regiones.setText("Regiones");
        getContentPane().add(regiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        buscarPartido.setText("Buscar Partido");
        buscarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPartidoActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        locales.setText("Locales");
        getContentPane().add(locales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void institucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institucionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institucionesActionPerformed

    private void registrarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPartidoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        RegistrarPartido part = new RegistrarPartido();
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_registrarPartidoActionPerformed

    private void buscarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPartidoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        BusquedaPartidos part = new BusquedaPartidos(this);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_buscarPartidoActionPerformed

    private void distritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distritosActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        TipoProceso part = new TipoProceso();
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_distritosActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }
    
    public void mostrarResultadoBusqueda(){
        panelPrincipal.removeAll();
        ResultadosBusqueda part = new ResultadosBusqueda(this);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    public void mostrarDetallePartido(){
        panelPrincipal.removeAll();
        DetallePartido part = new DetallePartido(this);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    public void mostrarAdherentes(){
        panelPrincipal.removeAll();
        VistaAdherentes part = new VistaAdherentes(this);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPartido;
    private javax.swing.JButton distritos;
    private javax.swing.JButton instituciones;
    private javax.swing.JButton locales;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton regiones;
    private javax.swing.JButton registrarPartido;
    // End of variables declaration//GEN-END:variables
}
