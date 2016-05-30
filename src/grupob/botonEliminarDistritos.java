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
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import model.Distrito;
import model.Region;

/**
 *
 * @author RAMON
 */
public class botonEliminarDistritos extends AbstractCellEditor implements TableCellEditor {
private JButton editor;
        private Object value;
        private int row;
        private JTable table;

        public botonEliminarDistritos() {
            editor = new JButton();
            editor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (table != null) {                        
                        fireEditingStopped();
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int n =JOptionPane.showConfirmDialog (null, "Estas Seguro que deseas eliminar?","Advertencia",dialogButton);
                        if(n==JOptionPane.YES_OPTION){
                        TableModel model = table.getModel();
                        String r=table.getModel().getValueAt(row, 0).toString();
                        ArrayList<Distrito> arr=Manager.queryByNameDistrito(r);
                        Distrito di=arr.get(0);
                        if (model instanceof DefaultTableModel) {
                            ((DefaultTableModel) model).removeRow(row);
                            Manager.deleteDistrito(di.getId());
                        }
                        }
                    }
                }
            });
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

        @Override
        public Object getCellEditorValue() {
            return value;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            this.value = value;
            if (value != null) {
                editor.setText("X");
            } else {
                editor.setText("X");
            }
            if (isSelected) {
                editor.setForeground(table.getSelectionForeground());
                editor.setBackground(table.getSelectionBackground());
            } else {
                editor.setForeground(table.getForeground());
                editor.setBackground(UIManager.getColor("Button.background"));
            }
            return editor;
        }    
}
