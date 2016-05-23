/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.PartidoPolitico;
import model.Region;
import model.TipoProcesoVotacion;


/**
 *
 * @author RAMON
 */
public class Inicio extends javax.swing.JDialog {

    /**
     * Creates new form Inicio
     */
    private String fileName;
//    public static ArrayList<Region> listaRegiones=new ArrayList<Region>();
    public static ArrayList<Region> listaRegiones=Manager.queryAllRegion();
    
    public Inicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        listaRegiones.add(new Region(1,"Lima",15000));
//        listaRegiones.add(new Region(1,"Arequipa",10000));
//        listaRegiones.add(new Region(1,"Junin",12000));
        agregarDatos();
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);        
        panelRegistroPartidos.setVisible(false);
        panelRegistroPartidos1.setVisible(false);
        jPanel18.setVisible(false);
        TableColumn sColumn = jTable7.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Region1");
        comboBox.addItem("Region2");
        comboBox.addItem("Region3");
        sColumn.setCellEditor(new DefaultCellEditor(comboBox));
        TableColumn sColumn2 = jTable8.getColumnModel().getColumn(2);
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("Distrito1");
        comboBox2.addItem("Distrito2");
        comboBox2.addItem("Distrito3");
        sColumn2.setCellEditor(new DefaultCellEditor(comboBox2));
        TableColumn sColumn3 = jTable9.getColumnModel().getColumn(2);
        JComboBox comboBox3 = new JComboBox();
        comboBox3.addItem("Local1");
        comboBox3.addItem("Local2");
        comboBox3.addItem("Local3");
        sColumn3.setCellEditor(new DefaultCellEditor(comboBox3));
        imP1.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP2.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP3.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP4.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP5.setImage(new ImageIcon(getClass().getResource("/Imagenes/gf2.jpg")).getImage());
        imP6.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP7.setImage(new ImageIcon(getClass().getResource("/Imagenes/huella1.jpg")).getImage());
        imP5.setVisible(false);
        jTable2.getColumn("Validar Nuevos").setCellRenderer(new ButtonRenderer());
        jTable2.getColumn("Validar Nuevos").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable2.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable2.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable3.getColumn("Validar Nuevos").setCellRenderer(new ButtonRenderer());
        jTable3.getColumn("Validar Nuevos").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable3.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable3.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable4.getColumn("Validar Nuevos").setCellRenderer(new ButtonRenderer());
        jTable4.getColumn("Validar Nuevos").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable4.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable4.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable5.getColumn("Validar Nuevos").setCellRenderer(new ButtonRenderer());
        jTable5.getColumn("Validar Nuevos").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable5.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable5.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable6.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable6.getColumn("Eliminar").setCellEditor(new ButtonEditor4(new JCheckBox()));        
        jTable7.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable7.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable8.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable8.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        jTable9.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable9.getColumn("Eliminar").setCellEditor(new ButtonEditor3(new JCheckBox()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        imP4 = new gui.ImagePanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
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
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton46 = new javax.swing.JButton();
        jXDatePicker5 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker6 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker7 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker8 = new org.jdesktop.swingx.JXDatePicker();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
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
        panelRegistroPartidos = new javax.swing.JPanel();
        imP6 = new gui.ImagePanel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        registro_seleccione_lugar = new javax.swing.JLabel();
        registro_tipo_proceso = new javax.swing.JComboBox<>();
        registro_lugar = new javax.swing.JComboBox<>();
        apellidos_rep = new javax.swing.JTextField();
        nombre_partido = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        nombres_rep = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        panelRegistroPartidos1 = new javax.swing.JPanel();
        imP8 = new gui.ImagePanel();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        apellidos_rep1 = new javax.swing.JTextField();
        nombre_partido1 = new javax.swing.JTextField();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        nombres_rep1 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        correo1 = new javax.swing.JTextField();
        dni1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        imP1 = new gui.ImagePanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        imP7 = new gui.ImagePanel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        imP3 = new gui.ImagePanel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        imP5 = new gui.ImagePanel();
        jButton18 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        imP2 = new gui.ImagePanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP4Layout = new javax.swing.GroupLayout(imP4);
        imP4.setLayout(imP4Layout);
        imP4Layout.setHorizontalGroup(
            imP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        imP4Layout.setVerticalGroup(
            imP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel11.add(imP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jButton22.setText("Registrar Nuevo Partido");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jButton23.setText("Regiones");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jButton24.setText("Distritos");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, -1));

        jButton25.setText("Locales");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, -1));

        jButton26.setText("Instituciones");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, -1));

        jLabel51.setText("Fecha Inicio:");

        jLabel52.setText("1er Revision");

        jLabel53.setText("2do Revision");

        jLabel54.setText("Fecha Inicio:");

        jButton50.setText("Guardar");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jLabel55.setText("Fecha Fin:");

        jLabel56.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58)
                .addGap(68, 68, 68)
                .addComponent(jButton50)
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

        jButton27.setText("+");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel27.setText("Fecha Inicio:");

        jLabel28.setText("1er Revision");

        jLabel29.setText("2do Revision");

        jLabel30.setText("Fecha Inicio:");

        jLabel31.setText("Fecha Fin:");

        jLabel32.setText("Fecha Fin:");

        jButton46.setText("Guardar");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addGap(9, 9, 9)
                        .addComponent(jXDatePicker6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePicker8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(46, 46, 46)
                                .addComponent(jButton27)
                                .addGap(33, 33, 33)
                                .addComponent(jButton46))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(9, 9, 9)
                                .addComponent(jXDatePicker5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(95, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButton27)
                    .addComponent(jButton46))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Regional", jPanel13);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad de Votantes", "Regiones", "Eliminar"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jButton28.setText("+");

        jLabel11.setText("%");

        jLabel12.setText("Porcentaje: ");

        jLabel33.setText("1er Revision");

        jLabel34.setText("Fecha Inicio:");

        jLabel35.setText("2do Revision");

        jLabel36.setText("Fecha Inicio:");

        jLabel37.setText("Fecha Fin:");

        jLabel38.setText("Fecha Fin:");

        jButton47.setText("Guardar");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(46, 46, 46)
                        .addComponent(jButton28)
                        .addGap(48, 48, 48)
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
                            .addComponent(jXDatePicker11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton28)
                    .addComponent(jButton47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel13.setText("%");

        jLabel14.setText("Porcentaje: ");

        jLabel39.setText("1er Revision");

        jLabel40.setText("Fecha Inicio:");

        jLabel41.setText("2do Revision");

        jLabel42.setText("Fecha Inicio:");

        jLabel43.setText("Fecha Fin:");

        jLabel44.setText("Fecha Fin:");

        jButton48.setText("Guardar");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(46, 46, 46)
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
                        .addComponent(jXDatePicker15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(46, 46, 46)
                        .addComponent(jButton29)
                        .addGap(48, 48, 48)
                        .addComponent(jButton48)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton29)
                    .addComponent(jButton48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
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
                        .addGap(0, 94, Short.MAX_VALUE)))
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

        jPanel11.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 500, 350));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        panelRegistroPartidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP6MouseClicked(evt);
            }
        });
        imP6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRegistroPartidos.add(imP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jButton31.setText("Registrar Nuevo Partido");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        panelRegistroPartidos.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jButton32.setText("Regiones");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        panelRegistroPartidos.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jButton33.setText("Distritos");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        panelRegistroPartidos.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, -1));

        jButton34.setText("Locales");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        panelRegistroPartidos.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, -1));

        jButton35.setText("Instituciones");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        panelRegistroPartidos.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Nombre del Partido:");
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel18.setText("Correo de contacto");
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel19.setText("DNI:");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel21.setText("Tipo de Proceso:");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        registro_seleccione_lugar.setText("Seleccione:");
        jPanel17.add(registro_seleccione_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        registro_tipo_proceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nacional", "Distrital", "Regional", "Local", "Institucional" }));
        registro_tipo_proceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro_tipo_procesoActionPerformed(evt);
            }
        });
        jPanel17.add(registro_tipo_proceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 129, -1));

        registro_lugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Villa Maria del Triunfo", "Nuevo Chimbote" }));
        jPanel17.add(registro_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 129, -1));
        jPanel17.add(apellidos_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 129, -1));

        nombre_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_partidoActionPerformed(evt);
            }
        });
        jPanel17.add(nombre_partido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 129, -1));
        nombre_partido.getAccessibleContext().setAccessibleName("nombre_partido");

        jButton36.setText("Guardar");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 278, -1, -1));

        jButton37.setText("Cancelar");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 278, -1, -1));

        jLabel59.setText("Nombre del Representante:");
        jPanel17.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));
        jPanel17.add(nombres_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 129, -1));

        jLabel60.setText("Apellidos del Representante:");
        jPanel17.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        jPanel17.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 129, -1));
        jPanel17.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 129, -1));

        panelRegistroPartidos.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 420, 360));

        getContentPane().add(panelRegistroPartidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        panelRegistroPartidos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP8Layout = new javax.swing.GroupLayout(imP8);
        imP8.setLayout(imP8Layout);
        imP8Layout.setHorizontalGroup(
            imP8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        imP8Layout.setVerticalGroup(
            imP8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        panelRegistroPartidos1.add(imP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jButton51.setText("Registrar Nuevo Partido");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        panelRegistroPartidos1.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jButton52.setText("Regiones");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        panelRegistroPartidos1.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jButton53.setText("Distritos");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        panelRegistroPartidos1.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, -1));

        jButton54.setText("Locales");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        panelRegistroPartidos1.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, -1));

        jButton55.setText("Instituciones");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        panelRegistroPartidos1.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setText("Nombre del Partido:");
        jPanel20.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel62.setText("Correo de contacto");
        jPanel20.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel63.setText("DNI:");
        jPanel20.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel64.setText("Tipo de Proceso:");
        jPanel20.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel22.setText("Seleccione:");
        jPanel20.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Distrito", "Region", "Local", "Instituciones" }));
        jPanel20.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 129, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Villa Maria del Triunfo", "Nuevo Chimbote" }));
        jPanel20.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 129, -1));
        jPanel20.add(apellidos_rep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 129, -1));

        nombre_partido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_partidoActionPerformed(evt);
            }
        });
        jPanel20.add(nombre_partido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 129, -1));
        nombre_partido1.getAccessibleContext().setAccessibleName("nombre_partido");

        jButton56.setText("Guardar");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 278, -1, -1));

        jButton57.setText("Cancelar");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 278, -1, -1));

        jLabel65.setText("Nombre del Representante:");
        jPanel20.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));
        jPanel20.add(nombres_rep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 129, -1));

        jLabel66.setText("Apellidos del Representante:");
        jPanel20.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        jPanel20.add(correo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 129, -1));
        jPanel20.add(dni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 129, -1));

        panelRegistroPartidos1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 420, 360));

        getContentPane().add(panelRegistroPartidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("Nombre del Partido:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Tipo  de Proceso:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nacional", "Distrital", "Regional", "Local", "Instituciones" }));

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("Limpiar");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setText("Seleccione:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Villa Maria del Triunfo", "Nuevo Chimbote" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(99, 99, 99))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, 129, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(jButton4)
                    .addContainerGap(341, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(36, 36, 36)))
        );

        jTabbedPane1.addTab("Busqueda de Partidos", jPanel1);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 510, 350));

        imP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP1Layout = new javax.swing.GroupLayout(imP1);
        imP1.setLayout(imP1Layout);
        imP1Layout.setHorizontalGroup(
            imP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        imP1Layout.setVerticalGroup(
            imP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(imP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 50));

        jButton2.setText("Instituciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 110, -1));

        jButton5.setText("Regiones");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, -1));

        jButton6.setText("Distritos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, -1));

        jButton7.setText("Locales");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, -1));

        jButton13.setText("Registrar Nuevo Partido");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 80, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP7Layout = new javax.swing.GroupLayout(imP7);
        imP7.setLayout(imP7Layout);
        imP7Layout.setHorizontalGroup(
            imP7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        imP7Layout.setVerticalGroup(
            imP7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel18.add(imP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jButton38.setText("Registrar Nuevo Partido");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, -1));

        jButton39.setText("Regiones");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 110, -1));

        jButton40.setText("Distritos");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 110, -1));

        jButton41.setText("Locales");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 110, -1));

        jButton42.setText("Instituciones");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 110, -1));

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel23.setText("Adherentes en Estado de Revision");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel24.setText("Partido:");
        jPanel18.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel25.setText("Tipo de Proceso:");
        jPanel18.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel26.setText("Lugar:");
        jPanel18.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jTextField13.setEnabled(false);
        jPanel18.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 130, -1));

        jTextField15.setEnabled(false);
        jPanel18.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 130, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nacional", "Regional", " " }));
        jComboBox5.setEnabled(false);
        jPanel18.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 90, -1));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Nombre del JPG", "Marcar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable10);

        jPanel18.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 440, 170));

        jButton43.setText("Validar");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        jButton44.setText("Invalidar");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jButton45.setText("Cancelar");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, -1, -1));

        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP3Layout = new javax.swing.GroupLayout(imP3);
        imP3.setLayout(imP3Layout);
        imP3Layout.setHorizontalGroup(
            imP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        imP3Layout.setVerticalGroup(
            imP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel4.add(imP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jButton14.setText("Registrar Nuevo Partido");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jButton15.setText("Regiones");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jButton16.setText("Distritos");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, -1));

        jButton17.setText("Locales");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, -1));

        javax.swing.GroupLayout imP5Layout = new javax.swing.GroupLayout(imP5);
        imP5.setLayout(imP5Layout);
        imP5Layout.setHorizontalGroup(
            imP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        imP5Layout.setVerticalGroup(
            imP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel4.add(imP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 400, 240));

        jButton18.setText("Instituciones");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Estado Actual:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 41, 93, 22));
        jPanel6.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 42, 134, -1));

        jButton20.setText("Validar nuevos Adherentes");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 81, 245, -1));

        jButton21.setText("Eliminar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 110, -1, -1));

        jLabel8.setText("Cantidad de Adherentes faltantes: ");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 160, -1, -1));
        jPanel6.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 157, 38, -1));

        jTabbedPane3.addTab("Nacional", jPanel6);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Region", "Estado Activo", "Cant. Adhs Faltantes", "Validar Nuevos", "Eliminar"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Regional", jPanel7);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Distrito", "Estado Activo", "Cant. Adhs Faltantes", "Validar Nuevos", "Eliminar"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Distrital", jPanel8);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Local", "Estado Activo", "Cant. Adhs Faltantes", "Validar Nuevos", "Eliminar"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Local", jPanel9);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Institucional", "Estado Activo", "Cant. Adhs Faltantes", "Validar Nuevos", "Eliminar"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Institucional", jPanel10);

        jPanel4.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 500, 290));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setText("Nombre del Partido");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 240, 40));

        jLabel5.setText("Nombre del Representante:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel6.setText("Dni del Representante:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 180, -1));
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 180, -1));

        jButton19.setText("Adherentes en Revision");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imP2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imP2Layout = new javax.swing.GroupLayout(imP2);
        imP2.setLayout(imP2Layout);
        imP2Layout.setHorizontalGroup(
            imP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        imP2Layout.setVerticalGroup(
            imP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel3.add(imP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jButton8.setText("Registrar Nuevo Partido");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, -1));

        jButton9.setText("Regiones");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, -1));

        jButton10.setText("Distritos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, -1));

        jButton11.setText("Locales");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, -1));

        jButton12.setText("Instituciones");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 110, -1));

        jTabbedPane2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Resultados", jPanel5);

        jPanel3.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, 350));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP1MouseClicked
        jPanel2.setVisible(true);
        
    }//GEN-LAST:event_imP1MouseClicked

    private void imP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP2MouseClicked
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_imP2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jPanel2.setVisible(false);
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        jPanel11.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void imP3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP3MouseClicked
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_imP3MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(true);
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jTabbedPane3.setVisible(false);
        imP5.setVisible(true);
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
//            System.out.println(selectedFile.getName());
        } 
        try{
//            System.out.println("hola");
            Thread.sleep(2000);
            jTabbedPane3.setVisible(true);
            imP5.setVisible(false); 
            Terminado2 dialog = new Terminado2(new javax.swing.JFrame(), true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
//            System.out.println("hola");
        }catch(Exception e){
            
        }
//        jTabbedPane3.setVisible(true);
//        imP5.setVisible(false); 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void imP4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP4MouseClicked
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_imP4MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void imP6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP6MouseClicked
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_imP6MouseClicked

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        String nombre, correoPartido, correoRep, nombreRep, dni_text, apellidosRep;
        nombreRep= nombres_rep.getText();
        apellidosRep = apellidos_rep.getText();
        nombre = nombre_partido.getText();
        dni_text = dni.getText();
        correoPartido = correo.getText();
        int tipo_proc = registro_tipo_proceso.getSelectedIndex();
        int idLug = registro_lugar.getSelectedIndex();
        PartidoPolitico part = new PartidoPolitico();
        part.setNombre(nombre);
        part.setApellidoRepresentante(apellidosRep);
        part.setNombreRepresentante(nombreRep);
        part.setDniRepresentante(dni_text);
        part.setIdTipoProceso(tipo_proc);
        part.setFechaRegistro(Calendar.getInstance());
        part.setEstado("Activo");
        part.setCantidadRegistrosValidos(0);
        Manager.addPartido(part);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void imP7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imP7MouseClicked
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_imP7MouseClicked

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(true);
        registro_lugar.setVisible(false);
        registro_seleccione_lugar.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(true);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel11.setVisible(false);
        panelRegistroPartidos.setVisible(false);
        jPanel18.setVisible(false);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas validar estos registros?","Advertencia",dialogButton);
        if(n == JOptionPane.YES_OPTION){
            jPanel2.setVisible(false);
            jPanel3.setVisible(false);
            jPanel4.setVisible(true);
            jPanel11.setVisible(false);
            panelRegistroPartidos.setVisible(false);
            jPanel18.setVisible(false);
        }
        else {
            
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas invalidar estos registros?","Advertencia",dialogButton);
        if(n == JOptionPane.YES_OPTION){
            jPanel2.setVisible(false);
            jPanel3.setVisible(false);
            jPanel4.setVisible(true);
            jPanel11.setVisible(false);
            panelRegistroPartidos.setVisible(false);
            jPanel18.setVisible(false);
        }
        else {
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        
        JFormattedTextField fechai1 = jXDatePicker1.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker2.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker3.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker4.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        TipoProcesoVotacion proceso=new TipoProcesoVotacion();
        proceso.setId(1);
        proceso.setFechaInicio1(datei1);
        proceso.setFechaInicio2(datei2);
        proceso.setFechaFin1(datef1);
        proceso.setFechaFin2(datef2);
        proceso.setPorcentajeMinimo(10);
        Calendar cal = Calendar.getInstance(); 
        Date dateActual =cal.getTime();
//        System.out.println(""+dateActual);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        if(datei1!=null&&datei2!=null&&datef1!=null&&datef2!=null){
            if(datei1.compareTo(dateActual)>0 && datei2.compareTo(dateActual)>0 && datef1.compareTo(dateActual)>0  && datef2.compareTo(dateActual)>0){
                if(datei1.compareTo(datef2)>0 || datei1.compareTo(datei2)>0 || datei1.compareTo(datef1)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
                    return;
                }
                if(datei2.compareTo(datei1)<0 || datei2.compareTo(datef1)<0 || datei2.compareTo(datef2)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
                    return;
                }
                if(datef1.compareTo(datei1)<0 || datef1.compareTo(datei2)>0 || datef1.compareTo(datef2)>0){
                    JOptionPane.showMessageDialog(null,"Error: Revise el orden de los valores ingresados");
                    return;
                }
                if(jLabel57.getText()!=""&&jLabel57.getText()!=null){
                    Manager.updateProceso(proceso);
                    jLabel57.setText("1era Revision - Fecha Inicio: "+formatoDeFecha.format(datei1)+" Fecha Fin: "+formatoDeFecha.format(datef1));
                    jLabel58.setText("2da Revision - Fecha Inicio: "+formatoDeFecha.format(datei2)+" Fecha Fin: "+formatoDeFecha.format(datef2));
                    JOptionPane.showMessageDialog(null,"Se atualizo los datos del proceso nacional");
                    jXDatePicker1.setDate(null);
                    jXDatePicker2.setDate(null);
                    jXDatePicker3.setDate(null);
                    jXDatePicker4.setDate(null);
                }else{
                    Manager.updateProceso(proceso);
                    jLabel57.setText("1era Revision - Fecha Inicio: "+formatoDeFecha.format(datei1)+" Fecha Fin: "+formatoDeFecha.format(datef1));
                    jLabel58.setText("2da Revision - Fecha Inicio: "+formatoDeFecha.format(datei2)+" Fecha Fin: "+formatoDeFecha.format(datef2));
                    JOptionPane.showMessageDialog(null,"Se atualizo los datos del proceso nacional");
                    jXDatePicker1.setDate(null);
                    jXDatePicker2.setDate(null);
                    jXDatePicker3.setDate(null);
                    jXDatePicker4.setDate(null);            
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error: Los valores de la fecha deben ser superiores a hoy");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos");
            return;
        }
    }//GEN-LAST:event_jButton50ActionPerformed

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
    
    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        ArrayList<Region> listaRegionesPas = null;
        TipoProcesoVotacion proceso=null;
        JFormattedTextField fechai1 = jXDatePicker5.getEditor();
        Date datei1 = (Date) fechai1.getValue();
        JFormattedTextField fechai2 = jXDatePicker6.getEditor();
        Date datei2 = (Date) fechai2.getValue();
        JFormattedTextField fechaf1 = jXDatePicker7.getEditor();
        Date datef1 = (Date) fechaf1.getValue();
        JFormattedTextField fechaf2 = jXDatePicker8.getEditor();
        Date datef2 = (Date) fechaf2.getValue();
        double por;
        Calendar cal = Calendar.getInstance(); 
        Date dateActual =cal.getTime();
        try{
            por=Double.parseDouble(jTextField6.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Error: El porcentaje debe ser un valor numerico");
            return;
        }
        if(datei1!=null&&datei2!=null&&datef1!=null&&datef2!=null){
            if(datei1.compareTo(dateActual)>0 && datei2.compareTo(dateActual)>0 && datef1.compareTo(dateActual)>0  && datef2.compareTo(dateActual)>0){
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
                proceso.setId(2);
                proceso.setFechaInicio1(datei1);
                proceso.setFechaInicio2(datei2);
                proceso.setFechaFin1(datef1);
                proceso.setFechaFin2(datef2);
                proceso.setPorcentajeMinimo(por);
                DefaultTableModel modelo = (DefaultTableModel)jTable6.getModel();
                listaRegionesPas=listaRegiones;
                for(int i=0;i<listaRegiones.size();i++){
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
            }else{
                JOptionPane.showMessageDialog(null,"Error: Los valores de la fecha deben ser superiores a hoy");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Error: Falta ingresar todos los campos de las fechas");
            return;
        }
        listaRegiones=listaRegionesPas;        
        Manager.updateProceso(proceso);
//        for(int i=0;i<listaRegiones.size();i++){
//            Region rd=listaRegiones.get(i);
//            if(rd.getNombre()=="*******" && rd.getId()!=0){
//                Manager.deleteRegion(rd.getId());
//            }
//        }
        for(int i=0;i<listaRegiones.size();i++){
            Region rd=listaRegiones.get(i);
            if(rd.getId()==0){
                Manager.addRegion(rd);
            }else{
                Manager.updateRegion(rd);
            }
        }
//        for(int i=0;i<listaRegiones.size();i++){
//            Region rd=listaRegiones.get(i);
//            if(rd.getNombre()!="*******" && rd.getId()!=0){
//                Manager.updateRegion(rd);
//            }
//        }
        JOptionPane.showMessageDialog(null,"Se Completo de actualizar los datos del Proceso de Votacion Regional");
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
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
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jTable6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyTyped
        
        
    }//GEN-LAST:event_jTable6KeyTyped

    private void nombre_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_partidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_partidoActionPerformed

    private void registro_tipo_procesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro_tipo_procesoActionPerformed
        // TODO add your handling code here:
        if(registro_tipo_proceso.getSelectedIndex()!=0){
            registro_lugar.setVisible(true);
            registro_seleccione_lugar.setVisible(true);
        }
        else{
            registro_lugar.setVisible(false);
            registro_seleccione_lugar.setVisible(false);
        }
    }//GEN-LAST:event_registro_tipo_procesoActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inicio dialog = new Inicio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos_rep;
    private javax.swing.JTextField apellidos_rep1;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField correo1;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField dni1;
    private gui.ImagePanel imP1;
    private gui.ImagePanel imP2;
    private gui.ImagePanel imP3;
    private gui.ImagePanel imP4;
    private gui.ImagePanel imP5;
    private gui.ImagePanel imP6;
    private gui.ImagePanel imP7;
    private gui.ImagePanel imP8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
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
    private javax.swing.JTextField nombre_partido;
    private javax.swing.JTextField nombre_partido1;
    private javax.swing.JTextField nombres_rep;
    private javax.swing.JTextField nombres_rep1;
    private javax.swing.JPanel panelRegistroPartidos;
    private javax.swing.JPanel panelRegistroPartidos1;
    private javax.swing.JComboBox<String> registro_lugar;
    private javax.swing.JLabel registro_seleccione_lugar;
    private javax.swing.JComboBox<String> registro_tipo_proceso;
    // End of variables declaration//GEN-END:variables
}
