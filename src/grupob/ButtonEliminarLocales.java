/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Local;


/**
 *
 * @author Franz
 */
public class ButtonEliminarLocales extends DefaultCellEditor {
    protected JButton button;
	private DeleteButtonListener bListener = new DeleteButtonListener();

	@SuppressWarnings("deprecation")
	public ButtonEliminarLocales(JCheckBox checkBox) {
		super(checkBox);
            button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(bListener);
 
	}
 
	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		    bListener.setRow(row);
		    bListener.setTable(table);
//		    button.setText( (value == null) ? "" : value.toString() );
		    return button;
		  }
 
	  class DeleteButtonListener implements ActionListener {
 
	        private int row;
	        private JTable table;
 
	        public void setRow(int row){this.row = row;}
	        public void setTable(JTable table){this.table = table;}
 
	        public void actionPerformed(ActionEvent event) {
	        	if(table.getRowCount() > 0){
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
                            if(n==JOptionPane.YES_OPTION){
                                Local re=TipoProceso.listaLocales.get(this.row);
                                if(re.getId()!=0){
                                    Manager.deleteRegion(re.getId());
                                    TipoProceso.listaLocales.remove(this.row);
                                }
//                                re.setNombre("*******");
//                                TipoProceso.listaRegiones.set(this.row,re);
//                                Inicio.listaRegiones.remove(this.row);
                                ((DefaultTableModel)table.getModel()).removeRow(this.row);
                                ((DefaultTableModel)table.getModel()).fireTableDataChanged();
                            }     
                        }
	      }
	   } 
    
}
