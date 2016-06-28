/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import algoritmos.Recorte;
import controlador.Manager;
import java.awt.Frame;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import model.PartidoPolitico;

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
         
         
         cargarConfiguracion();
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

        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        buscarPartido = new javax.swing.JButton();
        registrarPartido = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        instituciones = new javax.swing.JButton();
        regiones = new javax.swing.JButton();
        locales = new javax.swing.JButton();
        distritos = new javax.swing.JButton();
        nacional = new javax.swing.JButton();
        configuracion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(980, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setMinimumSize(new java.awt.Dimension(580, 500));
        panelPrincipal.setName(""); // NOI18N
        panelPrincipal.setPreferredSize(new java.awt.Dimension(680, 500));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 700, 500));
        panelPrincipal.getAccessibleContext().setAccessibleName("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidos Políticos"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarPartido.setText("Buscar Partido");
        buscarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPartidoActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        registrarPartido.setText("Registrar Partido");
        registrarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPartidoActionPerformed(evt);
            }
        });
        jPanel1.add(registrarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 110));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de procesos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instituciones.setText("Instituciones");
        instituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institucionesActionPerformed(evt);
            }
        });
        jPanel2.add(instituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        regiones.setText("Regiones");
        regiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionesActionPerformed(evt);
            }
        });
        jPanel2.add(regiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        locales.setText("Locales");
        locales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localesActionPerformed(evt);
            }
        });
        jPanel2.add(locales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        distritos.setText("Distritos");
        distritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distritosActionPerformed(evt);
            }
        });
        jPanel2.add(distritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        nacional.setText("Nacional");
        nacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacionalActionPerformed(evt);
            }
        });
        jPanel2.add(nacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        configuracion.setText("Configuracion");
        configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionActionPerformed(evt);
            }
        });
        jPanel2.add(configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void institucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institucionesActionPerformed
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(4);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_institucionesActionPerformed

    private void registrarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPartidoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        RegistrarPartido part = new RegistrarPartido(this);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_registrarPartidoActionPerformed

    private void buscarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPartidoActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        BusquedaPartidos part = new BusquedaPartidos(this);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_buscarPartidoActionPerformed

    private void distritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distritosActionPerformed
        // TODO add your handling code here:
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(2);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_distritosActionPerformed

    private void regionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionesActionPerformed
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(1);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        
    }//GEN-LAST:event_regionesActionPerformed

    private void nacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacionalActionPerformed
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(0);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_nacionalActionPerformed

    private void localesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localesActionPerformed
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(3);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_localesActionPerformed

    private void configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionActionPerformed
        panelPrincipal.removeAll();
        repaint();
        TipoProceso part = new TipoProceso();
        part.paneSelect(5);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }//GEN-LAST:event_configuracionActionPerformed

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
    
    public void mostrarResultadoBusqueda(String name, int indiceTipo, int indiceLugar){
        ArrayList<PartidoPolitico> resultados = Manager.queryPartidoByNombTipoLug(name, indiceTipo, indiceLugar);
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        ResultadosBusqueda part = new ResultadosBusqueda(this);
        part.listarResultados(resultados);
        panelPrincipal.add(part,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    public void mostrarDetallePartido(PartidoPolitico partido){
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        DetallePartido part = new DetallePartido(this);
        part.showDetail(partido);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    public void mostrarAdherentes(PartidoPolitico p, int tipoProc){
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        VistaAdherentes part = new VistaAdherentes(this);
        part.showDetail(p, tipoProc);
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    public void mostrarBusqueda(){
        panelPrincipal.removeAll();
        repaint();
        panelPrincipal.setVisible(false);
        BusquedaPartidos part = new BusquedaPartidos(this);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
        panelPrincipal.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panelPrincipal.setVisible(true);
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));
        pack();
    }
    
    
      private  void  cargarConfiguracion(){
         
      File archivo = new File ("./config/conf.txt");
      
       if(!archivo.exists()) generaConfig();      
      Scanner s = null;
        try {
            s = new Scanner (archivo);
           
          int valor = 0;
            
            while(s.hasNextLine()){
            
                String cadena =   s.nextLine();
              
              
               if(cadena.contains(":")){
                 
                   String subcad[] = cadena.split(":");
                   String ruta  = subcad[1].trim()+":"+subcad[2].trim();
                   if (subcad[0].contains("huellas")) Recorte.rutaHuella = ruta; //temp.ruta = ruta; 
                   if (subcad[0].contains("firmas")) Recorte.rutaFirma  = ruta; //temp.ruta1 = ruta;
                   if (subcad[0].contains("excel")) Recorte.rutaGeneral = ruta; //temp.ruta2 = ruta;
                          
               }
 
            }
         
           
        }catch(Exception ex){
            
 
        }
        

     
     }
      
      public void generaConfig(){
      
             File file = new File("./config");
         if(!file.exists())
             file.mkdir();
         
         FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            
           
            fichero = new FileWriter("./config/conf.txt");
            pw = new PrintWriter(fichero);

              pw.println("dir_huellas:   /home/temp"  );
              
              pw.println("dir_firmas:  /home/temp");
              
              pw.println("dir_excel: /home/temp");
              
              
              pw.close();
              
     fichero.close();
        }catch(Exception ex){
        
        
        }
      
      
      
      }
      
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPartido;
    private javax.swing.JButton configuracion;
    private javax.swing.JButton distritos;
    private javax.swing.JButton instituciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton locales;
    private javax.swing.JButton nacional;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton regiones;
    private javax.swing.JButton registrarPartido;
    // End of variables declaration//GEN-END:variables
}
