/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupob;

import controlador.Manager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Distrito;
import model.Local;


/**
 *
 * @author Franz
 */
public class LocalTableModel extends AbstractTableModel {
    
    ArrayList<Local> localList =  null;
    String [] titles = {"Nombre", "Cantidad de distritos" , "Distritos" , "Eliminar" };
    private boolean[]  editables = {true, true, true, true};
    
    public LocalTableModel(){
    
    
        localList = new ArrayList<>();
        localList = Manager.queryAllLocales();
        
        
    }
    
    public boolean isCellEditable (int rowIndex, int colIndex){
    
             return editables[colIndex];
    
    }
    
    

    @Override
    public int getRowCount() {
        
    
        return localList.size();
    
    }

    @Override
    public int getColumnCount() {
    
        return titles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Local local  = localList.get(rowIndex);
                
        switch(columnIndex){
        
            case 0: 
                return local.getNombre();
            case 1:
                
                if( local.getCantidadVotantesRegistrados() != -1)
                    return Integer.toString(local.getCantidadVotantesRegistrados());
                else
                    return "";
            case 2: 
                   if (local.getIdDistrito() ==  -1) return "";
                   Distrito dist = Manager.queryByIdDistrito(local.getIdDistrito());
                   return dist.getNombre();
            
        
        };
    
        return "";
    
    
    }
    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    
   
        
        if(!localList.isEmpty() && aValue != null ){
        
           
            Local local = localList.get(rowIndex);
           
            
            switch(columnIndex){
            
                case 0:
                        String nombre = (String)aValue;
                        nombre.trim();
                        if(!nombre.equals(""))
                            local.setNombre(nombre);
                        else
                            JOptionPane.showMessageDialog(null, "Nombre no puede ser vacio", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                case 1:
                        String cant = (String)aValue;
                        try
                        {
                           int val =  Integer.parseInt(cant);
                           local.setCantidadVotantesRegistrados(val);
                            
                        }catch(Exception ex){
                            
                              JOptionPane.showMessageDialog(null, "Valor colocado no es numerico", "Error", JOptionPane.ERROR_MESSAGE);
                      
                        
                            
                        };
                        break;
            
            }
        
        
        
        }
        
    this.fireTableDataChanged();
    
    }
    
    @Override
    public String getColumnName(int col){
    
        return titles[col];
    
    }
    
    public Local getRow(int row ){
    
    
       if ( localList.size()== 0 ) return null;
       
       return localList.get(row);
       
    
    }
}
