/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import model.Distrito;
import model.Local;



/**
 *
 * @author Franz
 */
public class CellListenerEditor extends AbstractCellEditor implements TableCellEditor {
    
    private String oldValue;
    private String newValue;
    private JComponent component  = new JTextField();
    Local local = null;
    String colName;

    
     

    @Override
    public Object getCellEditorValue() {

            //This is TextField
        
             return  ((JTextField)component).getText();
           
          
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    
         oldValue = value.toString();//Toma valor de celda antes de cualquier modificación
        
            LocalTableModel model =     ( LocalTableModel)  table.getModel();
            colName = model.getColumnName(column);
            local = model.getRow(row);
                /*
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
       */
         
             
       
        return component;
         
    
    }
    
    
    public boolean stopCellEditing(){
    
        newValue = (String)getCellEditorValue();
        
        if(colName.equals("Nombre"))
            local.setNombre(newValue);
        if(colName.equals("Cantidad de Votantes")){
        
            try{
                int val = Integer.parseInt(newValue);
                local.setCantidadVotantesRegistrados(val);
                
            }catch(Exception ex){
            
                   JOptionPane.showMessageDialog(null,"Incorrecto");
                   ((JTextField)component).setText(oldValue);
                
            }
            
        
        }

    
        
        return super.stopCellEditing();
    }

}
