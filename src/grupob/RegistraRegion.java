/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import javax.swing.JOptionPane;
import model.Region;

/**
 *
 * @author RAMON
 */
public class RegistraRegion extends javax.swing.JFrame {

    String message =  new String();
    boolean error = false;
    /**
     * Creates new form RegistraRegion
     */
    public RegistraRegion() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreRegistro = new javax.swing.JTextField();
        cantidadRegistro = new javax.swing.JTextField();
        btnRegistraRegion = new javax.swing.JButton();
        btnCancelarR = new javax.swing.JButton();
        txtRegionUbigeo = new javax.swing.JTextField();
        lblRegionUbigeo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("Registro de Region");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Cantidad de Votantes");

        btnRegistraRegion.setText("Registrar");
        btnRegistraRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraRegionActionPerformed(evt);
            }
        });

        btnCancelarR.setText("Cancelar");
        btnCancelarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRActionPerformed(evt);
            }
        });

        lblRegionUbigeo.setText("Ubigeo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnRegistraRegion))
                                            .addComponent(lblRegionUbigeo))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCancelarR)
                                            .addComponent(txtRegionUbigeo)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cantidadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(nombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cantidadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegionUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegionUbigeo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistraRegion)
                    .addComponent(btnCancelarR))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarRActionPerformed

    private void btnRegistraRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraRegionActionPerformed
       int cant = 0;
       String nombre=nombreRegistro.getText();
       nombre = nombre.trim();
       
        if(nombre.isEmpty()){
            
            message += "Error: Ingrese un nombre\n";
            error = true;
            /*
            
            JOptionPane.showMessageDialog(null,"Error: Ingrese un nombre");
            return;*/
        }  
      
       
       
       
        try{
            cant=Integer.parseInt(cantidadRegistro.getText());
            if(cant<0){
                
                message += "Error: La cantidad debe ser un numero positivo\n";
                error = true;
                /*
                JOptionPane.showMessageDialog(null,"Error: La cantidad debe ser un numero positivo");
                return;
                */
            }
        } catch (NumberFormatException e) {
            
            message += "Error: La cantidad debe ser un numero\n";
            error  = true;
            /*
            JOptionPane.showMessageDialog(null,"Error: La cantidad debe ser un numero");
            return;
            */
        }
        
        
        
           String ubigeo = txtRegionUbigeo.getText();
        ubigeo  =  ubigeo.trim();
        int codUbigeo = 0;
        
            try{
        
             codUbigeo = Integer.parseInt(ubigeo);
            if(codUbigeo == 0){
                message += "Numero de ubigeo  invalido\n";
                error = true;
            }
            
            
        }catch(Exception ex){
            
            message += "codigo ubigeo debe ser numerico";
            error = true;
        }
       
        if(error){
        
            JOptionPane.showMessageDialog(this,message,"Error",JOptionPane.WARNING_MESSAGE);
            message = "";
            error = false;
            return;
        
        
        }
        Region re=new Region(0,nombre,cant);
        re.setTipoProceso(1);
        re.setUbigeo(codUbigeo);
        Manager.addRegion(re);        
        this.setVisible(false);
        JOptionPane.showMessageDialog(null,"Region registrada\nahora puede buscarla en la lista de regiones");
    }//GEN-LAST:event_btnRegistraRegionActionPerformed

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
            java.util.logging.Logger.getLogger(RegistraRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistraRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistraRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistraRegion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraRegion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarR;
    private javax.swing.JButton btnRegistraRegion;
    private javax.swing.JTextField cantidadRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblRegionUbigeo;
    private javax.swing.JTextField nombreRegistro;
    private javax.swing.JTextField txtRegionUbigeo;
    // End of variables declaration//GEN-END:variables
}
