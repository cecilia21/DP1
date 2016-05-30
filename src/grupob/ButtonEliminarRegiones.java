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
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Region;

/**
 *
 * @author RAMON
 */
public class ButtonEliminarRegiones extends DefaultCellEditor {
	protected JButton button;
	private DeleteButtonListener bListener = new DeleteButtonListener();

	@SuppressWarnings("deprecation")
	public ButtonEliminarRegiones(JCheckBox checkBox) {
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
//                                Region re=TipoProceso.listaRegiones.get(this.row);
                                String r=this.table.getModel().getValueAt(this.row, 0).toString();
                                ArrayList<Region> arr=Manager.queryByNameRegion(r);
                                Region re=arr.get(0);
//                                TipoProceso.listaRegiones.remove(this.row);                                
//                                System.out.println(""+this.row);
                                ((DefaultTableModel)table.getModel()).removeRow(this.row-1);
//                                ((DefaultTableModel)table.getModel()).fireTableDataChanged();
                                if(re.getId()!=0){
                                    Manager.deleteRegion(re.getId());
                                }
                            }     
                        }
                        
                        
	      }
	   } 
    
}
