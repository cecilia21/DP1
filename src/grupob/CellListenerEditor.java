/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;



/**
 *
 * @author Franz
 */
public class CellListenerEditor extends AbstractCellEditor implements TableCellEditor {
    
    private String oldValue;
    private String newValue;
    private JComponent component  = new JTextField();
    

    @Override
    public Object getCellEditorValue() {
             return  ((JTextField)component).getText();
    
          
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    
         oldValue = value.toString();//Toma valor de celda antes de cualquier modificación
         
         switch(column){
         
             case 1:
                      String num =   (String) value;
                      try{
                        Integer.parseInt(num);
                       ((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
         
                      }catch(Exception ex){
                      
                        ((JTextField)component).setText(oldValue);//coloca valor de la celda al JTextField
                         
                      }
                      
         }
       // ID = table.getValueAt(row,0).toString();//obtiene el ID unico del registro
       
        return component;
    
    
    }
    
    
    public boolean stopCellEditing(){
    
        newValue = (String)getCellEditorValue();
        
        if(!newValue.equals(oldValue)){
        
         JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
         ((JTextField)component).setText(oldValue);
            
        
        }
    
        return super.stopCellEditing();
    }
    
    
    
   
    
}
