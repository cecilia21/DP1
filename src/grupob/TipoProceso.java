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
import model.Institucion;
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
    public static ArrayList<Local> listaLocalesI= Manager.queryAllLocales();
    public static ArrayList<Institucion> listaInstituciones= new ArrayList<Institucion>();
    LocalTableModel tableModel = null;
    public static ArrayList<Local> listaLocales;
    public TipoProceso() {
        initComponents();
        initInstitucional();
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
            }
            if(tipoRegional.getFechaFin2().before(dateActual)){
                botonGuardarRegional.setEnabled(true);
            }
        }
        if(tipoDistrital!=null && tipoDistrital.getId()!=0){
            if(!tipoRegional.getFechaInicio2().after(dateActual)){
                jXDatePicker9.setDate(tipoDistrital.getFechaInicio1().getTime());
                jXDatePicker10.setDate(tipoDistrital.getFechaInicio2().getTime());
                jXDatePicker11.setDate(tipoDistrital.getFechaFin1().getTime());
                jXDatePicker12.setDate(tipoDistrital.getFechaFin2().getTime());
                porcentajeDistrital.setText(""+tipoDistrital.getPorcentajeMinimo()*100);
            }
            if((tipoDistrital.getFechaInicio1().before(dateActual)) && (cal.before(tipoDistrital.getFechaFin2()))){
                botonGuardarDistrital.setEnabled(false);
//                addRowRegional.setEnabled(false);
//                jTable6.setEnabled(false);
            }
            if(tipoDistrital.getFechaFin2().before(dateActual)){
                botonGuardarDistrital.setEnabled(true);
//                addRowRegional.setEnabled(true);
            }
        }
        agregarDatos();
        agregarDatosDistritos();
        if(listaRegiones!=null){
            jTable6.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable6.getColumn("Eliminar").setCellEditor(new botonEliminarRegiones());
        }
        if(listaDistritos!=null){
            jTable7.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable7.getColumn("Eliminar").setCellEditor(new botonEliminarDistritos());
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
    
    void initInstitucional(){
        TipoProcesoVotacion tipoInstitucional=Manager.queryProcesoById(5);
        Calendar cal = Calendar.getInstance();
        Date dateActual =cal.getTime();
        if(tipoInstitucional!=null && tipoInstitucional.getId()!=0){
            if(!tipoInstitucional.getFechaInicio2().after(dateActual)){
                btn1FIInstitucional.setDate(tipoInstitucional.getFechaInicio1().getTime());
                btn2FIInstitucional.setDate(tipoInstitucional.getFechaInicio2().getTime());
                btn1FFInstitucional.setDate(tipoInstitucional.getFechaFin1().getTime());
                btn2FFInstitucional.setDate(tipoInstitucional.getFechaFin2().getTime());
                txtPorInstitucional.setText(""+tipoInstitucional.getPorcentajeMinimo()*100);
            }
            if((tipoInstitucional.getFechaInicio1().before(dateActual)) && (cal.before(tipoInstitucional.getFechaFin2()))){
                btnGuardarInstitucionalTP.setEnabled(false);
            }
            if(tipoInstitucional.getFechaFin2().before(dateActual)){
                btnGuardarInstitucionalTP.setEnabled(true);
            }
        }
        
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
        jLabel3 = new javax.swing.JLabel();
        textRegiones = new javax.swing.JTextField();
        buscarRegiones = new javax.swing.JButton();
        btnGuardarRegiones = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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
        botonGuardarDistrital = new javax.swing.JButton();
        jXDatePicker9 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker10 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker11 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker12 = new org.jdesktop.swingx.JXDatePicker();
        buscarDistritos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        textDistrito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        txtBuscar = new javax.swing.JTextField();
        jPanelInstitucional = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblInstitucional = new javax.swing.JTable();
        btnAddInstitucional = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtPorInstitucional = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnGuardarInstitucional = new javax.swing.JButton();
        btn1FIInstitucional = new org.jdesktop.swingx.JXDatePicker();
        btn2FIInstitucional = new org.jdesktop.swingx.JXDatePicker();
        btn1FFInstitucional = new org.jdesktop.swingx.JXDatePicker();
        btn2FFInstitucional = new org.jdesktop.swingx.JXDatePicker();
        btnBuscarInstitucional = new javax.swing.JButton();
        txtNombreInstitucional = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardarInstitucionalTP = new javax.swing.JButton();

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

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

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

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel13.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 445, 134));

        jLabel9.setText("Porcentaje: ");
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 31, -1, -1));
        jPanel13.add(porcentajeRegional, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 28, 37, -1));

        jLabel10.setText("%");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 31, -1, -1));

        addRowRegional.setText("+");
        addRowRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowRegionalActionPerformed(evt);
            }
        });
        jPanel13.add(addRowRegional, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jLabel27.setText("Fecha Inicio:");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel28.setText("1er Revision");
        jPanel13.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel29.setText("2do Revision");
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel30.setText("Fecha Inicio:");
        jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel31.setText("Fecha Fin:");
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel32.setText("Fecha Fin:");
        jPanel13.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        botonGuardarRegional.setText("Guardar");
        botonGuardarRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarRegionalActionPerformed(evt);
            }
        });
        jPanel13.add(botonGuardarRegional, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));
        jPanel13.add(jXDatePicker5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));
        jPanel13.add(jXDatePicker6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));
        jPanel13.add(jXDatePicker7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));
        jPanel13.add(jXDatePicker8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel3.setText("Buscar por Nombre:");
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));
        jPanel13.add(textRegiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, -1));

        buscarRegiones.setText("Buscar");
        buscarRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarRegionesActionPerformed(evt);
            }
        });
        jPanel13.add(buscarRegiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        btnGuardarRegiones.setText("Guardar");
        btnGuardarRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegionesActionPerformed(evt);
            }
        });
        jPanel13.add(btnGuardarRegiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel4.setText("Proceso de Votacion Regional");
        jPanel13.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jTabbedPane4.addTab("Regional", jPanel13);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Regiones", "Eliminar"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jPanel14.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 430, 133));

        jButton28.setText("+");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jLabel11.setText("%");
        jPanel14.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));
        jPanel14.add(porcentajeDistrital, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 37, -1));

        jLabel12.setText("Porcentaje: ");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel33.setText("1er Revision");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel34.setText("Fecha Inicio:");
        jPanel14.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 20));

        jLabel35.setText("2do Revision");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel36.setText("Fecha Inicio:");
        jPanel14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel37.setText("Fecha Fin:");
        jPanel14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel38.setText("Fecha Fin:");
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        botonGuardarDistrital.setText("Guardar");
        botonGuardarDistrital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarDistritalActionPerformed(evt);
            }
        });
        jPanel14.add(botonGuardarDistrital, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));
        jPanel14.add(jXDatePicker9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        jPanel14.add(jXDatePicker10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));
        jPanel14.add(jXDatePicker11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));
        jPanel14.add(jXDatePicker12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        buscarDistritos.setText("Buscar");
        buscarDistritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDistritosActionPerformed(evt);
            }
        });
        jPanel14.add(buscarDistritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 299, -1, -1));
        jPanel14.add(textDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 195, -1));

        jLabel5.setText("Buscar por Nombre:");
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel6.setText("Proceso de Votacion Distrital");
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

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
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(jButton48)
                        .addGap(31, 31, 31))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton48)
                    .addComponent(jLabel14)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
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

        jPanelInstitucional.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInstitucional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Locales", "Eliminar"
            }
        ));
        tblInstitucional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstitucionalMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblInstitucional);

        jPanelInstitucional.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 450, 140));

        btnAddInstitucional.setText("+");
        btnAddInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInstitucionalActionPerformed(evt);
            }
        });
        jPanelInstitucional.add(btnAddInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel15.setText("%");
        jPanelInstitucional.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));
        jPanelInstitucional.add(txtPorInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 37, -1));

        jLabel16.setText("Porcentaje: ");
        jPanelInstitucional.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel45.setText("1er Revision");
        jPanelInstitucional.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel46.setText("Fecha Inicio:");
        jPanelInstitucional.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel47.setText("2do Revision");
        jPanelInstitucional.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel48.setText("Fecha Inicio:");
        jPanelInstitucional.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel49.setText("Fecha Fin:");
        jPanelInstitucional.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel50.setText("Fecha Fin:");
        jPanelInstitucional.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        btnGuardarInstitucional.setText("Guardar");
        btnGuardarInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInstitucionalActionPerformed(evt);
            }
        });
        jPanelInstitucional.add(btnGuardarInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));
        jPanelInstitucional.add(btn1FIInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));
        jPanelInstitucional.add(btn2FIInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));
        jPanelInstitucional.add(btn1FFInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));
        jPanelInstitucional.add(btn2FFInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        btnBuscarInstitucional.setText("Buscar");
        btnBuscarInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInstitucionalActionPerformed(evt);
            }
        });
        jPanelInstitucional.add(btnBuscarInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, -1));
        jPanelInstitucional.add(txtNombreInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, 20));

        jLabel1.setText("Proceso de Votacion Institucional");
        jPanelInstitucional.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Buscar por Nombre:");
        jPanelInstitucional.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        btnGuardarInstitucionalTP.setText("Guardar");
        btnGuardarInstitucionalTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInstitucionalTPActionPerformed(evt);
            }
        });
        jPanelInstitucional.add(btnGuardarInstitucionalTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jTabbedPane4.addTab("Institucional", jPanelInstitucional);

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
        RegistraRegion window=new RegistraRegion();
        window.setVisible(true);
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
        RegistrarDistrito window=new RegistrarDistrito();
        window.setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void botonGuardarDistritalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarDistritalActionPerformed
        
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
    }//GEN-LAST:event_botonGuardarDistritalActionPerformed

    public void paneSelect(int n){
        jTabbedPane4.setSelectedIndex(n);
    }
    
    private void btnAddInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInstitucionalActionPerformed
        // TODO add your handling code here:
        AddInstitucional addInstitucional = new AddInstitucional();
        addInstitucional.setVisible(true);
    }//GEN-LAST:event_btnAddInstitucionalActionPerformed

    private void btnBuscarInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarInstitucionalActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(!txtNombreInstitucional.getText().isEmpty()){
            listaInstituciones.clear();
            listaInstituciones=Manager.queryByNameInstitucion(txtNombreInstitucional.getText());            
            
            DefaultTableModel modelo = (DefaultTableModel)tblInstitucional.getModel();
            modelo.setRowCount(0);
            String datos[] = new String[4];
            for (int i = 0; i < listaInstituciones.size(); i++) {
                datos[0] = listaInstituciones.get(i).getNombre();
                if(listaInstituciones.get(i).getCantidadVotantesRegistrados() == 0){
                    datos[1] ="0";
                }else{
                    datos[1] = Integer.toString(listaInstituciones.get(i).getCantidadVotantesRegistrados());
                }
                datos[2] = Manager.queryLocalById(listaInstituciones.get(i).getIdLocal()).getNombre();
                datos[3]="ELIMINAR";
                modelo.addRow(datos);
            }
            
        }
        else
            JOptionPane.showMessageDialog(null,"El campo buscar no puede estar vacio");      
              
        
        
        
        
        
    }//GEN-LAST:event_btnBuscarInstitucionalActionPerformed

    private void tblInstitucionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstitucionalMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel)tblInstitucional.getModel();
        
        int row = tblInstitucional.rowAtPoint(evt.getPoint());
        int col = tblInstitucional.columnAtPoint(evt.getPoint());
        if(col==3){
            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
                            if(n==JOptionPane.YES_OPTION){                                
                                String nombre=tblInstitucional.getValueAt(row, 0).toString();
                                //Buscar el id en la lista
                                for (int i = 0; i < listaInstituciones.size(); i++) {
                                    if (listaInstituciones.get(i).getNombre().equals(nombre)){                                        
                                        Manager.deleteInstitucion(listaInstituciones.get(i).getId()); 
                                        listaInstituciones.remove(i);//Ver si es correcto esto
                                        break;
                                    }                                                                          
                                }                                                               
                            }            
            modelo.removeRow(tblInstitucional.getSelectedRow());
        }

        
        
        
        
    }//GEN-LAST:event_tblInstitucionalMouseClicked

    private void btnGuardarInstitucionalTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInstitucionalTPActionPerformed
        // TODO add your handling code here:
        TipoProcesoVotacion proceso=null;   
        JFormattedTextField fechai1 = btn1FIInstitucional.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = btn2FIInstitucional.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = btn1FFInstitucional.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = btn2FFInstitucional.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        if(datei1==null||datei2==null||datef1==null||datef2==null){
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos");
            return;
        }
        double por;
        Calendar cal = Calendar.getInstance();
        try{
            por=Double.parseDouble(txtPorInstitucional.getText())/100;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: El porcentaje debe ser un valor numerico");
            return;
        }
        Calendar calA = Calendar.getInstance();                
        proceso=new TipoProcesoVotacion();
        proceso.setId(5);
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
        proceso.setNombre("Institucional"); 
        if(verificaFechas(datei1,datei2,datef1,datef2))                
        {                    
            Manager.updateProceso(proceso);                    
            JOptionPane.showMessageDialog(null,"Se Completo de actualizar los datos del Proceso de Votacion Regional");                
        }
        
        
    }//GEN-LAST:event_btnGuardarInstitucionalTPActionPerformed

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
    
    private void btnGuardarInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInstitucionalActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel)tblInstitucional.getModel();
        if(0 < modelo.getRowCount()){
            modelo.getColumnCount();
            Institucion institucion= new Institucion();
            for(int i=0;i<modelo.getRowCount();i++){            
                institucion.setId(listaInstituciones.get(i).getId());
                institucion.setNombre(tblInstitucional.getValueAt(i, 0).toString());
                institucion.setCantidadVotantesRegistrados(Integer.parseInt(tblInstitucional.getValueAt(i, 1).toString()));
                institucion.setTipoProceso(5);//Tipo de proceso 5
                for(int j=0;i<listaLocalesI.size();j++){
                    if(listaLocalesI.get(j).getNombre().equals(tblInstitucional.getValueAt(i, 2).toString())){
                        institucion.setIdLocal(listaLocalesI.get(j).getId());
                        break;
                    }                
                }            
                Manager.updateInstitucion(institucion);
    //            System.out.println(listaInstituciones.get(i).getId());
    //            System.out.println(tblInstitucional.getValueAt(i, 0).toString());
    //            System.out.println(tblInstitucional.getValueAt(i, 1).toString());
    //            System.out.println(tblInstitucional.getValueAt(i, 2).toString());        

            }
        
//            
        }
        
        
    }//GEN-LAST:event_btnGuardarInstitucionalActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void btnGuardarRegionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegionesActionPerformed
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
        
    }//GEN-LAST:event_btnGuardarRegionesActionPerformed

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
            String n=Manager.queryByIdRegion(s.getIdRegion()).getNombre();
            datos[2]=""+n;
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
        colum3.setPreferredWidth(5);
        TableColumn colum4 = null;
        colum4 = jTable7.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(40);
        colum4.setPreferredWidth(10);
        listaDistritos=listaBuscada;
    }//GEN-LAST:event_buscarDistritosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel modelo = (DefaultTableModel)jTable7.getModel();
        ArrayList<Distrito> listaDistritosPas = listaDistritos;
        for(int i=0;i<listaDistritosPas.size();i++){
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
            Distrito s=listaDistritosPas.get(i);
            String co=modelo.getValueAt(i,2).toString();
            ArrayList<Region> reg=Manager.queryByNameRegion(co);
            Distrito r=new Distrito(s.getId(),reg.get(0).getId(),n,num);
            listaDistritosPas.set(i,r);

        }
        for(int i=0;i<listaDistritosPas.size();i++){
            Distrito rd=listaDistritosPas.get(i);
            if(rd.getId()!=0){
                Manager.updateDistrito(rd);
            }
        }
        JOptionPane.showMessageDialog(null,"Se Completo de actualizar los distritos");
    }//GEN-LAST:event_jButton1ActionPerformed

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
        String datos[] = new String[4];
        for (int i = 0; i < listaDistritos.size(); i++) {
            datos[0] = listaDistritos.get(i).getNombre();
            if(listaDistritos.get(i).getCantidadVotantesRegistrados() == 0){
                datos[1] ="";
            }else{
                datos[1] = Long.toString(listaDistritos.get(i).getCantidadVotantesRegistrados());
            }
            String n=Manager.queryByIdRegion(listaDistritos.get(i).getIdRegion()).getNombre();
            datos[2]=""+n;
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = jTable7.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = jTable7.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum3 = jTable7.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(5);
        TableColumn colum4 = null;
        colum4 = jTable7.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(40);
        colum4.setPreferredWidth(10);           
    }
    
     private void cargarDatosLocal(){
    
         tableModel = new LocalTableModel();
         jTable8.setModel(tableModel);
         /*
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
    */
      //  jTable8.getColumn("Region").setCellEditor(new ComboBoxEditor());
        
           TableColumn column =  jTable8.getColumnModel().getColumn(2);
           
           DistritoComboBox dist = new DistritoComboBox();
           column.setCellEditor(dist );
        
        if(listaLocales!=null){
         //   TableColumn column =  jTable8.getColumnModel().getColumn(2);
         //  column.setCellEditor(new DistritoComboBox());
           /* jTable8.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable8.getColumn("Eliminar").setCellEditor(new ButtonEliminarLocales(new JCheckBox()));*/
        }
    
    }
     
     private Calendar dateToCalendar(Date date){
     
         Calendar cal =  Calendar.getInstance();
         cal.setTime(date);
         return cal;
     
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowRegional;
    private javax.swing.JButton botonGuardarDistrital;
    private javax.swing.JButton botonGuardarNacional;
    private javax.swing.JButton botonGuardarRegional;
    private org.jdesktop.swingx.JXDatePicker btn1FFInstitucional;
    private org.jdesktop.swingx.JXDatePicker btn1FIInstitucional;
    private org.jdesktop.swingx.JXDatePicker btn2FFInstitucional;
    private org.jdesktop.swingx.JXDatePicker btn2FIInstitucional;
    private javax.swing.JButton btnAddInstitucional;
    private javax.swing.JButton btnBuscarInstitucional;
    private javax.swing.JButton btnGuardarInstitucional;
    private javax.swing.JButton btnGuardarInstitucionalTP;
    private javax.swing.JButton btnGuardarRegiones;
    private javax.swing.JButton buscarDistritos;
    private javax.swing.JButton buscarRegiones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton48;
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
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanelInstitucional;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker10;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker11;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker12;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker13;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker14;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker15;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker16;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker5;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker6;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker7;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker9;
    private javax.swing.JTextField porcentajeDistrital;
    private javax.swing.JTextField porcentajeRegional;
    private javax.swing.JTable tblInstitucional;
    private javax.swing.JTextField textDistrito;
    private javax.swing.JTextField textRegiones;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombreInstitucional;
    private javax.swing.JTextField txtPorInstitucional;
    // End of variables declaration//GEN-END:variables
}
