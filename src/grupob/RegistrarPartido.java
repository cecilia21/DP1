/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Distrito;
import model.Institucion;
import model.Local;
import model.PartidoPolitico;
import model.Region;
import model.TipoProcesoVotacion;
/**
 *
 * @author USUARIO
 */
public class RegistrarPartido extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarPartido
     */
    FramePrincipal padre;
    public RegistrarPartido(FramePrincipal parent) {
        padre = parent;
        initComponents();
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        ArrayList<TipoProcesoVotacion> procs = Manager.queryAllTipoProceso();
        registro_tipo_proceso.removeAllItems();
        for(int i=0; i<procs.size();i++){
            registro_tipo_proceso.addItem(procs.get(i).getNombre());
        }
        nombre_partido.setInputVerifier(new MyInputVerifier());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        registro_seleccione_lugar = new javax.swing.JLabel();
        registro_tipo_proceso = new javax.swing.JComboBox<String>();
        apellidos_rep = new javax.swing.JTextField();
        nombre_partido = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        nombres_rep = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        registro_lugar = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(470, 350));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(470, 351));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 440, 10));

        jPanel17.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel17.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Nombre del Partido:");
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel18.setText("Correo de contacto");
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel19.setText("DNI:");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel21.setText("Tipo de Proceso:");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        registro_seleccione_lugar.setText("Seleccione:");
        jPanel17.add(registro_seleccione_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        registro_tipo_proceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro_tipo_procesoActionPerformed(evt);
            }
        });
        jPanel17.add(registro_tipo_proceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 129, -1));
        jPanel17.add(apellidos_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 129, -1));

        nombre_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_partidoActionPerformed(evt);
            }
        });
        jPanel17.add(nombre_partido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 129, -1));

        jButton36.setText("Guardar");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jButton37.setText("Cancelar");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabel59.setText("Nombre del Representante:");
        jPanel17.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
        jPanel17.add(nombres_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 129, -1));

        jLabel60.setText("Apellidos del Representante:");
        jPanel17.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        jPanel17.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 129, -1));
        jPanel17.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 129, -1));
        jPanel17.add(registro_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 130, -1));

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 460, 300));
        jPanel17.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Registro de nuevo partido político");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void registro_tipo_procesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro_tipo_procesoActionPerformed
        // TODO add your handling code here:
        if(registro_tipo_proceso.getSelectedIndex()!=0){
            registro_lugar.setVisible(true);
            registro_seleccione_lugar.setVisible(true);
            int indice = registro_tipo_proceso.getSelectedIndex();
            registro_lugar.removeAllItems();
            if(indice == 1){
                ArrayList<Region> regiones = Manager.queryAllRegion();
                for(int i = 0; i<regiones.size(); i++){
                    registro_lugar.addItem(regiones.get(i));
                    //System.out.println("" + regiones.get(i).getNombre());
                }
            }
            if(indice == 2){
                ArrayList<Distrito> distritos = Manager.queryAllDistrito();                
                for(int i=0; i<distritos.size(); i++)
                    registro_lugar.addItem(distritos.get(i));
            }
            if(indice==3){
                ArrayList<Local> locales = Manager.queryAllLocales();
                for(int i = 0;i <  locales.size() ; i++)
                    registro_lugar.addItem(locales.get(i));
                
               
            }
            if(indice == 4){
                ArrayList<Institucion> inst = Manager.queryAllInstitucion();
                for(int i=0;i<inst.size();i++)
                    registro_lugar.addItem(inst.get(i).getNombre());
            }
        }
        else{
            registro_lugar.setVisible(false);
            registro_seleccione_lugar.setVisible(false);
        }
    }//GEN-LAST:event_registro_tipo_procesoActionPerformed

    private void nombre_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_partidoActionPerformed
        // TODO add your handling code here:
        MyInputVerifier inputVerifier = new MyInputVerifier();

            if (inputVerifier.verify(nombre_partido)){
                JOptionPane.showMessageDialog(null, "True Value");
            }
            else JOptionPane.showMessageDialog(null, "False Value");
    }//GEN-LAST:event_nombre_partidoActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        
        MyInputVerifier inputVerifier = new MyInputVerifier();

            if (!inputVerifier.verify(nombre_partido)){
                JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
                return;
            }
        
        String nombre, correoPartido, correoRep, nombreRep, dni_text, apellidosRep;
        nombreRep= nombres_rep.getText();
        apellidosRep = apellidos_rep.getText();
        nombre = nombre_partido.getText();
        dni_text = dni.getText();
        correoPartido = correo.getText();
        int tipo_proc = registro_tipo_proceso.getSelectedIndex()+1;
        
        int idLug = registro_lugar.getSelectedIndex()+1;
        PartidoPolitico part = new PartidoPolitico();
        part.setNombre(nombre);
        part.setApellidoRepresentante(apellidosRep);
        part.setNombreRepresentante(nombreRep);
        part.setDniRepresentante(dni_text);
        part.setIdTipoProceso(tipo_proc);
       
        part.setFechaRegistro(Calendar.getInstance());
        part.setEstado("Activo");
        part.setCantidadRegistrosValidos(0);
        part.setCorreoPartido(correoPartido);
        if(tipo_proc==2){
            
            Region region =   (Region ) registro_lugar.getSelectedItem();
            
            part.setIdRegion(region.getId());}
        if(tipo_proc==3){
        
            Distrito distrito =   (Distrito ) registro_lugar.getSelectedItem();
            part.setIdDistrito(distrito.getId());
        
            
        }
        if(tipo_proc==4){
            
            Local local =  (Local ) registro_lugar.getSelectedItem();
            part.setIdLocal(local.getId());
        }
        if(tipo_proc==5){
            
            Institucion institucion =   (Institucion ) registro_lugar.getSelectedItem();
            part.setIdInstitucion(institucion.getId());
        }
        Manager.addPartido(part);
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        cleanForm();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
           padre.mostrarBusqueda();
    }//GEN-LAST:event_jButton37ActionPerformed
    private void cleanForm(){
        nombres_rep.setText("");
        apellidos_rep.setText("");
        nombre_partido.setText("");
        dni.setText("");
        correo.setText("");
        registro_tipo_proceso.setSelectedIndex(0);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
    }
    
    public class MyInputVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            String text = ((JTextField) input).getText().trim();
            if (text.isEmpty()) return false;
            if (text.matches(".*\\d.*")) return false;
            if (text.contains("1")) return false;
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos_rep;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField dni;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombre_partido;
    private javax.swing.JTextField nombres_rep;
    private javax.swing.JComboBox registro_lugar;
    private javax.swing.JLabel registro_seleccione_lugar;
    private javax.swing.JComboBox<String> registro_tipo_proceso;
    // End of variables declaration//GEN-END:variables
}
