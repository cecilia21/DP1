/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Distrito;
import model.Local;
import model.Region;
import model.TipoProcesoVotacion;

/**
 *
 * @author USUARIO
 */
public class TipoProceso extends javax.swing.JPanel {

    /**
     * Creates new form TipoProceso
     */
    public static ArrayList<Region> listaRegiones=Manager.queryAllRegion();
    public static ArrayList<Distrito> listaDistritos=Manager.queryAllDistrito();
     public static ArrayList<Local> listaLocales;
    public TipoProceso() {
        initComponents();
//        listaRegiones.add(new Region(1,"Lima",15000));
//        listaRegiones.add(new Region(1,"Arequipa",10000));
//        listaRegiones.add(new Region(1,"Junin",12000));
        TipoProcesoVotacion tipoNacional=Manager.queryProcesoById(1);
        TipoProcesoVotacion tipoRegional=Manager.queryProcesoById(2);
        TipoProcesoVotacion tipoDistrital=Manager.queryProcesoById(3);
        Calendar cal = Calendar.getInstance();
        Date dateActual =cal.getTime();
        if(tipoNacional!=null && tipoNacional.getId()!=0){
            if(!tipoNacional.getFechaInicio2().after(dateActual)){
                jXDatePicker1.setDate(tipoNacional.getFechaInicio1().getTime());
                jXDatePicker2.setDate(tipoNacional.getFechaInicio2().getTime());
                jXDatePicker3.setDate(tipoNacional.getFechaFin1().getTime());
                jXDatePicker4.setDate(tipoNacional.getFechaFin2().getTime());
            }
            if((tipoNacional.getFechaInicio1().before(dateActual)) && (cal.before(tipoNacional.getFechaFin2()))){
                botonGuardarNacional.setEnabled(false);
            }
            if(tipoNacional.getFechaFin2().before(dateActual)){
                botonGuardarNacional.setEnabled(true);
            }
        }
        if(tipoRegional!=null && tipoRegional.getId()!=0){
            if(!tipoRegional.getFechaInicio2().after(dateActual)){
                jXDatePicker5.setDate(tipoRegional.getFechaInicio1().getTime());
                jXDatePicker6.setDate(tipoRegional.getFechaInicio2().getTime());
                jXDatePicker7.setDate(tipoRegional.getFechaFin1().getTime());
                jXDatePicker8.setDate(tipoRegional.getFechaFin2().getTime());
                porcentajeRegional.setText(""+tipoRegional.getPorcentajeMinimo()*100);
            }
            if((tipoRegional.getFechaInicio1().before(dateActual)) && (cal.before(tipoRegional.getFechaFin2()))){
                botonGuardarRegional.setEnabled(false);
                addRowRegional.setEnabled(false);
                jTable6.setEnabled(false);
            }
            if(tipoRegional.getFechaFin2().before(dateActual)){
                botonGuardarRegional.setEnabled(true);
                addRowRegional.setEnabled(true);
            }
        }
        agregarDatos();
        agregarDatosDistritos();
        if(listaRegiones!=null){
            jTable6.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable6.getColumn("Eliminar").setCellEditor(new ButtonEliminarRegiones(new JCheckBox()));
        }
        if(listaDistritos!=null){
            jTable7.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable7.getColumn("Eliminar").setCellEditor(new ButtonEliminarDistritos(new JCheckBox()));
        }
        
        TableColumn sColumn = jTable7.getColumnModel().getColumn(2);
        ArrayList<Region> lReg=Manager.queryAllRegion();
        JComboBox comboBox = new JComboBox();
        for(int i=0;i<lReg.size();i++){
            comboBox.addItem(lReg.get(i).getNombre());
        }
        sColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
          ChangeListener changeListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
          
                 JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                 int index = sourceTabbedPane.getSelectedIndex();
                switch(index){
                case 3: cargarDatosLocal();
                        return;
                default:
                        return;
                 }
                
            }
        };
        
        jTabbedPane4.addChangeListener(changeListener);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        botonGuardarNacional = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker4 = new org.jdesktop.swingx.JXDatePicker();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        porcentajeRegional = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addRowRegional = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        botonGuardarRegional = new javax.swing.JButton();
        jXDatePicker5 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker6 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker7 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker8 = new org.jdesktop.swingx.JXDatePicker();
        btnGuardarR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textRegiones = new javax.swing.JTextField();
        buscarRegiones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        porcentajeDistrital = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jXDatePicker9 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker10 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker11 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker12 = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        buscarDistritos = new javax.swing.JButton();
        textDistrito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jXDatePicker13 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker14 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker15 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker16 = new org.jdesktop.swingx.JXDatePicker();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton49 = new javax.swing.JButton();
        jXDatePicker17 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker18 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker19 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker20 = new org.jdesktop.swingx.JXDatePicker();

        jTabbedPane4.setPreferredSize(new java.awt.Dimension(470, 300));
        jTabbedPane4.setRequestFocusEnabled(false);

        jLabel51.setText("Fecha Inicio:");

        jLabel52.setText("1er Revision");

        jLabel53.setText("2do Revision");

        jLabel54.setText("Fecha Inicio:");

        botonGuardarNacional.setText("Guardar");
        botonGuardarNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarNacionalActionPerformed(evt);
            }
        });

        jLabel55.setText("Fecha Fin:");

        jLabel56.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                            .addComponent(botonGuardarNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(98, 98, 98))
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel54)
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel51)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel56)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jXDatePicker4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel55)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jXDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(55, 55, 55)))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel55)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(jLabel54)
                        .addComponent(jLabel56))
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58)
                .addGap(68, 68, 68)
                .addComponent(botonGuardarNacional)
                .addGap(78, 78, 78))
        );

        jTabbedPane4.addTab("Nacional", jPanel19);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Eliminar"
            }
        ));
        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable6KeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jLabel9.setText("Porcentaje: ");

        jLabel10.setText("%");

        addRowRegional.setText("+");
        addRowRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowRegionalActionPerformed(evt);
            }
        });

        jLabel27.setText("Fecha Inicio:");

        jLabel28.setText("1er Revision");

        jLabel29.setText("2do Revision");

        jLabel30.setText("Fecha Inicio:");

        jLabel31.setText("Fecha Fin:");

        jLabel32.setText("Fecha Fin:");

        botonGuardarRegional.setText("Guardar");
        botonGuardarRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarRegionalActionPerformed(evt);
            }
        });

        btnGuardarR.setText("Guardar");
        btnGuardarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        jLabel3.setText("Nombre:");

        buscarRegiones.setText("Buscar");
        buscarRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarRegionesActionPerformed(evt);
            }
        });

        jLabel1.setText("Proceso de Votacion Regional");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addRowRegional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarR)
                .addGap(62, 62, 62))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buscarRegiones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(porcentajeRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(120, 120, 120)
                                .addComponent(botonGuardarRegional))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(9, 9, 9)
                                .addComponent(jXDatePicker5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addGap(9, 9, 9)
                                .addComponent(jXDatePicker6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(porcentajeRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(botonGuardarRegional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jXDatePicker5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXDatePicker7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jXDatePicker6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXDatePicker8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(buscarRegiones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarR)
                    .addComponent(addRowRegional))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Regional", jPanel13);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Regiones", "Eliminar"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jButton28.setText("+");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel11.setText("%");

        jLabel12.setText("Porcentaje: ");

        jLabel33.setText("1er Revision");

        jLabel34.setText("Fecha Inicio:");

        jLabel35.setText("2do Revision");

        jLabel36.setText("Fecha Inicio:");

        jLabel37.setText("Fecha Fin:");

        jLabel38.setText("Fecha Fin:");

        jButton47.setText("Guardar");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");

        buscarDistritos.setText("Buscar");
        buscarDistritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDistritosActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre:");

        jLabel4.setText("Buscar");

        jLabel6.setText("Proceso de Votacion Distrital");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(63, 63, 63))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buscarDistritos))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(porcentajeDistrital, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(135, 135, 135)
                                .addComponent(jButton47))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jXDatePicker10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jXDatePicker12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel34)
                                    .addGap(9, 9, 9)
                                    .addComponent(jXDatePicker9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jXDatePicker11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(porcentajeDistrital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37)
                    .addComponent(jXDatePicker9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(jXDatePicker10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(buscarDistritos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton28))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Distrital", jPanel14);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Distritos", "Eliminar"
            }
        ));
        jScrollPane8.setViewportView(jTable8);

        jButton29.setText("+");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel13.setText("%");

        jLabel14.setText("Porcentaje: ");

        jLabel39.setText("1er Revision");

        jLabel40.setText("Fecha Inicio:");

        jLabel41.setText("2do Revision");

        jLabel42.setText("Fecha Inicio:");

        jLabel43.setText("Fecha Fin:");

        jLabel44.setText("Fecha Fin:");

        jButton48.setText("Guardar");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42)
                                .addGap(9, 9, 9)
                                .addComponent(jXDatePicker14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXDatePicker16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel40)
                                .addGap(9, 9, 9)
                                .addComponent(jXDatePicker13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXDatePicker15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton29)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton48)
                    .addComponent(jLabel14)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(jLabel43)
                    .addComponent(jXDatePicker13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44)
                    .addComponent(jXDatePicker14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Local", jPanel15);

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Locales", "Eliminar"
            }
        ));
        jScrollPane9.setViewportView(jTable9);

        jButton30.setText("+");

        jLabel15.setText("%");

        jLabel16.setText("Porcentaje: ");

        jLabel45.setText("1er Revision");

        jLabel46.setText("Fecha Inicio:");

        jLabel47.setText("2do Revision");

        jLabel48.setText("Fecha Inicio:");

        jLabel49.setText("Fecha Fin:");

        jLabel50.setText("Fecha Fin:");

        jButton49.setText("Guardar");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addGap(46, 46, 46)
                                .addComponent(jButton30)
                                .addGap(41, 41, 41)
                                .addComponent(jButton49))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jXDatePicker17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jXDatePicker19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel48)
                                        .addGap(9, 9, 9)
                                        .addComponent(jXDatePicker18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jXDatePicker20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jButton30)
                    .addComponent(jButton49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addComponent(jLabel49)
                    .addComponent(jXDatePicker17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel50)
                    .addComponent(jXDatePicker18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Institucional", jPanel16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarNacionalActionPerformed
        JFormattedTextField fechai1 = jXDatePicker1.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker2.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker3.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker4.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        if(datei1==null||datei2==null||datef1==null||datef2==null){
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos");
            return;
        }  
        TipoProcesoVotacion proceso=new TipoProcesoVotacion();
        proceso.setId(1);
        Calendar calA = Calendar.getInstance();
        calA.setTime(datei1);
        proceso.setFechaInicio1(calA);
        Date d=proceso.getFechaInicio1().getTime();
        Calendar calB = Calendar.getInstance();
        calB.setTime(datei2);
        proceso.setFechaInicio2(calB);
        Date d2=proceso.getFechaInicio2().getTime();
        Calendar calC = Calendar.getInstance();
        calC.setTime(datef1);        
        proceso.setFechaFin1(calC);
        Date d3=proceso.getFechaFin1().getTime();
        Calendar calD = Calendar.getInstance();
        calD.setTime(datef2);        
        proceso.setFechaFin2(calD);
        Date d4=proceso.getFechaFin2().getTime();
        proceso.setId(1);
        proceso.setNombre("Nacional");
        proceso.setPorcentajeMinimo((float) 0.10);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");        
        if(verificaFechas(datei1,datei2,datef1,datef2)){
                    Manager.updateProceso(proceso);
                    jLabel57.setText("1era Revision - Fecha Inicio: "+formatoDeFecha.format(datei1)+" Fecha Fin: "+formatoDeFecha.format(datef1));
                    jLabel58.setText("2da Revision - Fecha Inicio: "+formatoDeFecha.format(datei2)+" Fecha Fin: "+formatoDeFecha.format(datef2));
                    JOptionPane.showMessageDialog(null,"Se atualizo los datos del proceso nacional");
         }
    }//GEN-LAST:event_botonGuardarNacionalActionPerformed

    private void jTable6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyTyped

    }//GEN-LAST:event_jTable6KeyTyped

    private void addRowRegionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowRegionalActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        Vector row = new Vector();
        row.add("");
        row.add("");
        row.add("");
        model.addRow(row);
        Region r=new Region();
        r.setNombre("");
        listaRegiones.add(r);
        //        r.setCantidadVotantesRegistrados();
        //        agregarDatos();
    }//GEN-LAST:event_addRowRegionalActionPerformed

    private void botonGuardarRegionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarRegionalActionPerformed
        TipoProcesoVotacion proceso=null;   
        JFormattedTextField fechai1 = jXDatePicker5.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker6.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker7.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker8.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        if(datei1==null||datei2==null||datef1==null||datef2==null){
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos");
            return;
        }
        double por;
        Calendar cal = Calendar.getInstance();
        Date dateActual =cal.getTime();
        try{
            por=Double.parseDouble(porcentajeRegional.getText())/100;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: El porcentaje debe ser un valor numerico");
            return;
        }
        Calendar calA = Calendar.getInstance();                
        proceso=new TipoProcesoVotacion();
        proceso.setId(2);
        calA.setTime(datei1);
        proceso.setFechaInicio1(calA);                
        Calendar calB = Calendar.getInstance();                 
        calB.setTime(datei2);                
        proceso.setFechaInicio2(calB);                
        Calendar calC = Calendar.getInstance();                 
        calC.setTime(datef1);                
        proceso.setFechaFin1(calC);                
        Calendar calD = Calendar.getInstance();                 
        calD.setTime(datef2);                
        proceso.setFechaFin2(calD);
        proceso.setPorcentajeMinimo((float)por);
        proceso.setNombre("Regional"); 
        if(verificaFechas(datei1,datei2,datef1,datef2))                
        {                    
            Manager.updateProceso(proceso);                    
            JOptionPane.showMessageDialog(null,"Se Completo de actualizar los datos del Proceso de Votacion Regional");                
        }
    }//GEN-LAST:event_botonGuardarRegionalActionPerformed

    private boolean verificaFechas(Date datei1,Date datei2,Date datef1,Date datef2){
        Calendar cal = Calendar.getInstance();
        Date dateActual =cal.getTime();
        if(datei1.compareTo(dateActual)<0 || datei2.compareTo(dateActual)<0 || datef1.compareTo(dateActual)<0  || datef2.compareTo(dateActual)<0){
            JOptionPane.showMessageDialog(null,"Error: Los valores de la fecha deben ser superiores a hoy");
            return false;
        }                      
        if(datei1.compareTo(datef2)>0 || datei1.compareTo(datei2)>0 || datei1.compareTo(datef1)>0){
            JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
            return false;
        }
        if(datei2.compareTo(datei1)<0 || datei2.compareTo(datef1)<0 || datei2.compareTo(datef2)>0){
            JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
            return false;
        } 
        if(datef1.compareTo(datei1)<0 || datef1.compareTo(datei2)>0 || datef1.compareTo(datef2)>0){
            JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
            return false;
        }
        return true;
    }
    
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed

        
        
         DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        Vector row = new Vector();
        row.add("");
        row.add("");
        row.add("");
        row.add("");
        model.addRow(row);
        Local r=new Local();
        r.setNombre("");
        listaLocales.add(r);
        
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
      
              ArrayList<Local> listaLocalesPas = null;
        TipoProcesoVotacion proceso=null;
        JFormattedTextField fechai1 = jXDatePicker13.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker14.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker15.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker16.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        double por;
        
        Calendar cal = Calendar.getInstance();
        Date dateActual =cal.getTime();
        
        try{
            por=Double.parseDouble(jTextField8.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: El porcentaje debe ser un valor numerico");
            return;
        }
        if(datei1!=null&&datei2!=null&&datef1!=null&&datef2!=null){
            
            if(datei1.compareTo(dateActual) > 0 && datei2.compareTo(dateActual) > 0 && datef1.compareTo(dateActual)>0  && datef2.compareTo(dateActual)>0){
                if(datei1.compareTo(datef2)>0 || datei1.compareTo(datei2)>0 || datei1.compareTo(datef1)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados en las fechas");
                    return;
                }
                if(datei2.compareTo(datei1)<0 || datei2.compareTo(datef1)<0 || datei2.compareTo(datef2)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados en las fechas");
                    return;
                }
                if(datef1.compareTo(datei1)<0 || datef1.compareTo(datei2)>0 || datef1.compareTo(datef2)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados en las fechas");
                    return;
                }
                proceso=new TipoProcesoVotacion();
                
                
                proceso.setFechaInicio1(dateToCalendar(datei1));
                proceso.setFechaInicio2(dateToCalendar(datei2));
                proceso.setFechaFin1(dateToCalendar(datef1));
                proceso.setFechaFin2(dateToCalendar(datef2));
                proceso.setPorcentajeMinimo((float)por);
                DefaultTableModel modelo = (DefaultTableModel)jTable8.getModel();
                listaLocalesPas= listaLocales;
                for(int i=0;i<listaLocales.size();i++){
                    String a=modelo.getValueAt(i,1).toString(); //Cantidad
                    String n=modelo.getValueAt(i,0).toString(); // nombre
                    String dist = modelo.getValueAt(i, 2).toString(); // distrito
                    String pro = modelo.getValueAt(i, 3).toString(); //Proceso
                    
                    int num=-1;
                    int numDist = -1;
                    int numPro = -1;
                    try {
                        num=Integer.parseInt(a);
                        numDist  = Integer.parseInt(dist);
                        numPro = Integer.parseInt(pro);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,"Error: Ingreso un valor distinto de un numero en la fila: "+(i+1)+" columna: 2");
                        return;
                    }
                    if(num<0){
                        JOptionPane.showMessageDialog(null,"Error: Ingreso un numero negativo en la fila: "+(i+1)+" columna: 2");
                        return;
                    }
                   // Local s= listaLocales.get(i);
                      Local r= listaLocales.get(i);
                      r.setNombre(n);
                      r.setCantidadVotantesRegistrados(num);
                      r.setIdDistrito(numDist);
                      r.setIdProceso(numPro);
                     
                    
                    //listaLocalesPas.set(i, r);
                   
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error: Los valores de la fecha deben ser superiores a hoy");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos de las fechas");
            return;
        }
      //  listaRegiones=listaRegionesPas;
        Manager.updateProceso(proceso);
        /*for(int i=0;i<listaLocales.size();i++){
            Local rd=listaLocales.get(i);
            if(rd.getNombre()=="*******" && rd.getId()!=0){
                Manager.deleteRegion(rd.getId());
            }
        }*/
        for(int i=0;i<listaLocales.size();i++){
            Local rd=listaLocales.get(i);
            if(rd.getId()==0){
                Manager.addLocal(rd);
            }
        }
        
       
        for(int i=0;i<listaLocales.size();i++){
            Local rd=listaLocales.get(i);
            if( rd.getId()!=0){
                Manager.updateLocal(rd);
            }
        }
        JOptionPane.showMessageDialog(null,"Se Completo de actualizar los datos del Proceso de Votacion Regional");
  
        
        
        
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        Vector row = new Vector();
        row.add("");
        row.add("");
        row.add("");
        model.addRow(row);
        Distrito di=new Distrito();
        di.setNombre("");
        listaDistritos.add(di);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
                
        TipoProcesoVotacion proceso=null;
        JFormattedTextField fechai1 = jXDatePicker9.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker10.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker11.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker12.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        if(datei1==null||datei2==null||datef1==null||datef2==null){
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos");
            return;
        }
        double por;
        try{
            por=Double.parseDouble(porcentajeDistrital.getText())/100;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: El porcentaje debe ser un valor numerico");
            return;
        }
        Calendar calA = Calendar.getInstance();                
        proceso=new TipoProcesoVotacion();
                proceso.setId(3);
                proceso.setNombre("Distrital");
                calA.setTime(datei1);
                proceso.setFechaInicio1(calA);                
                Calendar calB = Calendar.getInstance();                 
                calB.setTime(datei2);                
                proceso.setFechaInicio2(calB);                
                 Calendar calC = Calendar.getInstance();                 
                calC.setTime(datef1);                
                proceso.setFechaFin1(calC);                
                 Calendar calD = Calendar.getInstance();                 
                calD.setTime(datef2);                
                proceso.setFechaFin2(calD);
                proceso.setPorcentajeMinimo((float)por);
        if(verificaFechas(datei1,datei2,datef1,datef2))
        {
            Manager.updateProceso(proceso);
            JOptionPane.showMessageDialog(null,"Se Completo de actualizar los datos del Proceso de Votacion Distrital");
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void buscarRegionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarRegionesActionPerformed
        ArrayList<Region> listaBuscada=new ArrayList<Region>();
        String busc=textRegiones.getText();
        if(busc.compareTo("")==0){
            listaBuscada=Manager.queryAllRegion();
        }else{
            listaBuscada=Manager.queryByNameRegion(busc);
        }

        DefaultTableModel modelo = (DefaultTableModel)jTable6.getModel();
        modelo.setRowCount(0);
        String datos[] = new String[3];
        for (int i = 0; i < listaBuscada.size(); i++) {
            datos[0] = listaBuscada.get(i).getNombre();
            if(listaBuscada.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaBuscada.get(i).getCantidadVotantesRegistrados());
            }
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable6.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = jTable6.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum3 = jTable6.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(40);
        colum3.setPreferredWidth(10);
        listaRegiones=listaBuscada;
    }//GEN-LAST:event_buscarRegionesActionPerformed

    private void buscarDistritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDistritosActionPerformed

        ArrayList<Distrito> listaBuscada=new ArrayList<Distrito>();
        String busc=textDistrito.getText();
        if(busc.compareTo("")==0){
            listaBuscada=Manager.queryAllDistrito();
        }else{
            listaBuscada=Manager.queryByNameDistrito(busc);
        }
        DefaultTableModel modelo2 = (DefaultTableModel)jTable7.getModel();
        modelo2.setRowCount(0);
        String datos[] = new String[3];
        for (int i = 0; i < listaBuscada.size(); i++) {
            datos[0] = listaBuscada.get(i).getNombre();
            if(listaBuscada.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaBuscada.get(i).getCantidadVotantesRegistrados());
            }
            Distrito s=listaBuscada.get(i);
            //            String co=modelo2.getValueAt(i,2).toString();
            //            ArrayList<Distrito> reg=Manager.queryByNameDistrito(co);
            datos[2]=s.getNombre()+"";
            modelo2.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable7.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = jTable7.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum3 = jTable7.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(40);
        TableColumn colum4 = null;
        colum4 = jTable7.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(40);
        colum4.setPreferredWidth(10);
        listaDistritos=listaBuscada;
    }//GEN-LAST:event_buscarDistritosActionPerformed

    private void btnGuardarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRActionPerformed
        
        ArrayList<Region> listaRegionesPas = listaRegiones;
        DefaultTableModel modelo = (DefaultTableModel)jTable6.getModel();
        for(int i=0;i<listaRegionesPas.size();i++){                    
            String a=modelo.getValueAt(i,1).toString();                    
            String n=modelo.getValueAt(i,0).toString();                    
            int num=-1;                    
            try {                        
                num=Integer.parseInt(a);                    
            } catch (NumberFormatException e) {                        
                JOptionPane.showMessageDialog(null,"Error: Ingreso un valor distinto de un numero en la fila: "+(i+1)+" columna: 2");                        
                return;                    
            }                    
            if(num<0){                        
                JOptionPane.showMessageDialog(null,"Error: Ingreso un numero negativo en la fila: "+(i+1)+" columna: 2");                        
                return;                    
            }                    
            Region s=listaRegionesPas.get(i);                    
            Region r=new Region(s.getId(),n,num);                    
            listaRegionesPas.set(i,r);
        }  
        for(int i=0;i<listaRegionesPas.size();i++){
            Region rd=listaRegionesPas.get(i);
            if(rd.getId()!=0){
                Manager.updateRegion(rd);
            }
        }
        JOptionPane.showMessageDialog(null,"Se completo de actualizar las regiones");
    }//GEN-LAST:event_btnGuardarRActionPerformed
    private void agregarDatos(){
        DefaultTableModel modelo = (DefaultTableModel)jTable6.getModel();
        modelo.setRowCount(0);
        String datos[] = new String[3];
        for (int i = 0; i < listaRegiones.size(); i++) {
            datos[0] = listaRegiones.get(i).getNombre();
            if(listaRegiones.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaRegiones.get(i).getCantidadVotantesRegistrados());
            }
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable6.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = jTable6.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum3 = jTable6.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(40);
        colum3.setPreferredWidth(10);        
    }
    
    private void agregarDatosDistritos(){
        DefaultTableModel modelo = (DefaultTableModel)jTable7.getModel();
        modelo.setRowCount(0);
        String datos[] = new String[3];
        for (int i = 0; i < listaDistritos.size(); i++) {
            datos[0] = listaDistritos.get(i).getNombre();
            if(listaDistritos.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaDistritos.get(i).getCantidadVotantesRegistrados());
            }
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable7.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = jTable7.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum2 = jTable7.getColumnModel().getColumn(2);
        colum2.setPreferredWidth(5);
        TableColumn colum4 = null;
        colum4 = jTable7.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(40);
        colum4.setPreferredWidth(10);        
    }
    
     private void cargarDatosLocal(){
    
        DefaultTableModel modelo = (DefaultTableModel)jTable8.getModel();
        
        listaLocales = Manager.queryAllLocales();
        modelo.setRowCount(0);
        
        String datos[] = new String[4];
        for (int i = 0; i < listaLocales.size(); i++) {
            datos[0] = listaLocales.get(i).getNombre();
            if(listaLocales.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaLocales.get(i).getCantidadVotantesRegistrados());
            }
            
            datos[2] = Integer.toString(listaLocales.get(i).getIdDistrito());
         //   datos[3] = Integer.toString(listaLocales.get(i).getIdTipo());
            
             
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable8.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(40);
        TableColumn colum2 = null;
        colum2 = jTable8.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        
        TableColumn colum3 = null;
        colum3 = jTable8.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(40);

        
        TableColumn colum4 = null;
        colum4 = jTable8.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(40);
        
        
        colum3.setPreferredWidth(10);     
    
      //  jTable8.getColumn("Region").setCellEditor(new ComboBoxEditor());
        
        
        if(listaLocales!=null){
            jTable8.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable8.getColumn("Eliminar").setCellEditor(new ButtonEliminarLocales(new JCheckBox()));
        }
    
    }
     
     private Calendar dateToCalendar(Date date){
     
         Calendar cal =  Calendar.getInstance();
         cal.setTime(date);
         return cal;
     
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowRegional;
    private javax.swing.JButton botonGuardarNacional;
    private javax.swing.JButton botonGuardarRegional;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardarR;
    private javax.swing.JButton buscarDistritos;
    private javax.swing.JButton buscarRegiones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker10;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker11;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker12;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker13;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker14;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker15;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker16;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker17;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker18;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker19;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker20;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker5;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker6;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker7;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker9;
    private javax.swing.JTextField porcentajeDistrital;
    private javax.swing.JTextField porcentajeRegional;
    private javax.swing.JTextField textDistrito;
    private javax.swing.JTextField textRegiones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
