/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import java.awt.Component;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAMON
 */
public class ButtonEditor3 extends DefaultCellEditor   {    
        
    protected JButton button;
//    private DeleteButtonListener bListener = new DeleteButtonListener();
    private String label;
    private boolean isPushed;
    @SuppressWarnings("deprecation")
    public ButtonEditor3(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
//    button.addActionListener(bListener);
    
    button.addActionListener(new ActionListener() {
//        private int row;
//	private JTable table;
//        public void setRow(int row){this.row = row;}
//	public void setTable(JTable table){this.table = table;}
        public void actionPerformed(ActionEvent e) {
          fireEditingStopped();
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
//            int i = jTable6.getSelectedRow();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            EliminaA window = new EliminaA(new javax.swing.JFrame(), true);
//            window.setLocationRelativeTo(null);
//            window.setVisible(true);
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
            if(n==JOptionPane.YES_OPTION){
//                System.out.println("eliminado");
//	          if(table.getRowCount() > 0){
//	            //On affiche un message
////	            System.out.println("coucou du bouton: "+ ((JButton)e.getSource()).getText() );
//	            ((DefaultTableModel)table.getModel()).removeRow(this.row);
//                    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
//	          }
            }
        }
    });
        
  }
    
public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
      JOptionPane.showMessageDialog(button, label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
//  
//    class DeleteButtonListener implements ActionListener {
// 
//	        private int row;
//	        private JTable table;
// 
//	        public void setRow(int row){this.row = row;}
//	        public void setTable(JTable table){this.table = table;}
// 
//	        public void actionPerformed(ActionEvent event) {
//                    int dialogButton = JOptionPane.YES_NO_OPTION;
//                    int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
//                    if(n==JOptionPane.YES_OPTION){
//                        if(table.getRowCount() > 0){
//	            ((DefaultTableModel)table.getModel()).removeRow(this.row);
//                    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
//	          	         }
//                    }
//	        	
//	      }
//
//        @Override
//        public void actionPerformed(java.awt.event.ActionEvent e) {
//            int dialogButton = JOptionPane.YES_NO_OPTION;
//            int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
//            if(n==JOptionPane.YES_OPTION){
//                        if(table.getRowCount() > 0){
//	            ((DefaultTableModel)table.getModel()).removeRow(this.row);
//                    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
//	          	         }
//            }
////            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
//    
}
