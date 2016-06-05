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
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Local;


/**
 *
 * @author Franz
 */
public class ButtonEliminarLocales extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
     protected JButton button;
    Object value;
    ImageIcon icon;
	private DeleteButtonListener bListener = new DeleteButtonListener();

	
	public ButtonEliminarLocales() {
	    button = new JButton();
	    button.setOpaque(true);
            icon = new ImageIcon(getClass().getResource("/Imagenes/delete1.png"));
            button.setIcon(icon);
	    button.addActionListener(bListener);
            
 
	}
 
	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		    bListener.setRow(row);
		    bListener.setTable(table);
                    this.value = value;
                    
                    button.setIcon(new ImageIcon(icon.getImage().getScaledInstance(8, 8, 
                            java.awt.Image.SCALE_DEFAULT)));
//		    button.setText( (value == null) ? "" : value.toString() );
		    return button;
		  }

    @Override
    public Object getCellEditorValue() {
        return null;
    
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       
        if(value instanceof Icon){
            button.setIcon((Icon) value);
        }else
            button.setIcon(null);
                    
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
                            
                                    LocalTableModel model = (LocalTableModel) table.getModel();
                                    Local re  = model.localList.get(this.row);

                             
                                if(re.getId()!=0){
                                    Manager.deleteLocal(re.getId());
                                   // TipoProceso.listaLocales.remove(this.row);
                                }
//                             
                                ((LocalTableModel)table.getModel()).localList.remove(row);
                                ((LocalTableModel)table.getModel()).fireTableRowsDeleted(row, row);
                                ((LocalTableModel)table.getModel()).fireTableDataChanged();
                                
                                 
                            }     
                        }
	      }
	   } 
    
    
}
