/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.JSType.isNumber;
import model.Institucion;
import model.Local;

/**
 *
 * @author Raul
 */
public class AddInstitucional extends javax.swing.JFrame {

    /**
     * Creates new form AddInstitucional
     */
    String message = new String();
    boolean error = false;
    public static ArrayList<Local> listaLocal= Manager.queryAllLocales();
    
    public AddInstitucional() {
        initComponents();
        String lista [] =new String[listaLocal.size() + 1];
        lista[0] = "Seleccione Local";
	for(int i=0;i<listaLocal.size();i++){
            lista[i+1]=listaLocal.get(i).getNombre();
        }
	cboxLocal.setModel(new DefaultComboBoxModel(lista));
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCanVotantes = new javax.swing.JTextField();
        cboxLocal = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblRegistrarInstUbigeo = new javax.swing.JLabel();
        txtInstUbigeo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Institución");

        jLabel16.setText("Nombre:");

        jLabel17.setText("Cantidad de Votantes");

        jLabel18.setText("Local");

        cboxLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Local" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblRegistrarInstUbigeo.setText("Ubigeo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(btnGuardar)
                            .addGap(20, 20, 20)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRegistrarInstUbigeo)
                        .addGap(112, 112, 112)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar)
                    .addComponent(txtNombre)
                    .addComponent(cboxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanVotantes)
                    .addComponent(txtInstUbigeo))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCanVotantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrarInstUbigeo)
                    .addComponent(txtInstUbigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        String nombre =  txtNombre.getText();
        
        nombre = nombre.trim();
        
        if(nombre.isEmpty()){
            
            message += "Ingrese nombre\n";
            error =true;
            
            
        }
        
        if(!isNumber(txtCanVotantes.getText())){
        
            message += "El campo cantidad de votantes no es numerico\n";
            error=true;
        
        }
        
       
     
        
        
        
        if (isNumber(txtCanVotantes.getText()) && (txtCanVotantes.getText().contains("."))){
            
            
            message += "El campo cantidad de votantes debe ser numerico entero\n";
            error = true;
           // JOptionPane.showMessageDialog(null,"El campo cantidad de votantes debe ser numerico entero");   
        }
        
            if(cboxLocal.getSelectedIndex() == 0){
                
                message += "Seleccione un local";
                error = true;
              
            }
            
            
            
              String ubigeo = txtInstUbigeo.getText();
        ubigeo  =  ubigeo.trim();
          int codUbigeo = 0;
        
            try{
        
           codUbigeo = Integer.parseInt(ubigeo);
            if(codUbigeo == 0){
                message += "Numero de ubigeo  invalido\n";
                error = true;
            }
            
            
        }catch(Exception ex){
             if(ubigeo.isEmpty()) message += "Codigo ubigeo esta vacio";
             else  message += "codigo ubigeo debe ser numerico";
            error = true;
        }
            
                    
          
        if(error){
        
            JOptionPane.showMessageDialog(this,message,"Error",JOptionPane.WARNING_MESSAGE);
            message = "";
            error = false;
            return;
        }
        
           Institucion institucion = new Institucion();
        
            institucion.setNombre(txtNombre.getText());
            institucion.setCantidadVotantesRegistrados(Integer.parseInt(txtCanVotantes.getText()));

            institucion.setIdLocal(listaLocal.get(cboxLocal.getSelectedIndex() - 1).getId());
        
            institucion.setTipoProceso(5);
            institucion.setUbigeo(codUbigeo);
            Manager.addInstitucion(institucion);
            JOptionPane.showMessageDialog(this,"Institucion registrada");
           
             dispose();
            
            
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AddInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInstitucional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInstitucional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboxLocal;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel lblRegistrarInstUbigeo;
    private javax.swing.JTextField txtCanVotantes;
    private javax.swing.JTextField txtInstUbigeo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
