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
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import model.Distrito;
import model.Local;

/**
 *
 * @author Franz
 */
public class DistritoComboBox extends AbstractCellEditor implements TableCellEditor{

    
    ArrayList<Distrito> distritos  = null;
    JComboBox jcb = new JComboBox();
    Object valorActual;
    Local local = null;
    
    
    public DistritoComboBox(){
        
        
       distritos =  Manager.queryAllDistrito();
       for(Distrito v : distritos){
       
           jcb.addItem(v);
       }
    
        ItemListener il =  new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
         
                if(e.getStateChange() == ItemEvent.SELECTED){
                
                    ItemSelectable is = e.getItemSelectable();
            //        String valor = (String) is.getSelectedObjects()[0];
                    
                    Distrito dist = (Distrito) is.getSelectedObjects()[0];
                //    valorActual = valor;
                //    System.out.println(valor);
                   System.out.println(dist.getId());
                    System.out.println(dist.getCantidadVotantesRegistrados());
                    local.setIdDistrito(dist.getId());
                    local.setNombre("Se debria modificar");
                    
                    
                    
                
                
                }
            
            
            }
        };
        
        jcb.addItemListener(il);
    
    
    }
    @Override
    public Object getCellEditorValue() {
    
        return valorActual;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    
                LocalTableModel model =     ( LocalTableModel)  table.getModel();
        
                local = model.getRow(row);
                
                return jcb;
    
    
    }
    
    
}
