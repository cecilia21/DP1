/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import controlador.dao.DBConnection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Local;
import model.Region;

/**
 *
 * @author Franz
 */
public class MySQLDAOLocal implements DAOLocal{
    @Override
    public void add(Local i) {
      
         Connection conn = null;
        PreparedStatement pstmt = null;

        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                        DBConnection.user,
                                                        DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "INSERT INTO Local "
                                + "(idDistrito, idTipoProceso, nombre,cantidadVotantes)"
                                + "VALUES (?,?,?,?)";
                
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, i.getIdDistrito());
                pstmt.setInt(2, i.getIdProceso());
                pstmt.setString(3, i.getNombre());
                pstmt.setInt(4, i.getCantidadVotantesRegistrados());
                //Paso 4: Ejecutar la sentencia
                pstmt.executeUpdate();
                //Paso 5(opc.): Procesar los resultados			
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                //Paso 6(OJO): Cerrar la conexión
                try { if (pstmt!= null) pstmt.close();} 
                        catch (Exception e){e.printStackTrace();};
                try { if (conn!= null) conn.close();} 
                        catch (Exception e){e.printStackTrace();};						
        }       
    
    
    
    }

    @Override
    public void update(Local i) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //Paso 1: Registrar el Driver
            DriverManager.registerDriver(new Driver());
            //Paso 2: Obtener la conexión
            conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                            DBConnection.user,
                            DBConnection.password);
            //Paso 3: Preparar la sentencia
            String sql = "UPDATE Local "
                            + "SET nombre=?,cantidadVotantes=?"
                            + "WHERE id=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, i.getNombre());
            pstmt.setInt(2, i.getCantidadVotantesRegistrados());
            pstmt.setInt(3, i.getId());			
            //Paso 4: Ejecutar la sentencia
            pstmt.executeUpdate();
            //Paso 5(opc.): Procesar los resultados			
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } finally {
                    //Paso 6(OJO): Cerrar la conexión
                    try { if (pstmt!= null) pstmt.close();} 
                            catch (Exception e){e.printStackTrace();};
                    try { if (conn!= null) conn.close();} 
                            catch (Exception e){e.printStackTrace();};						
            }
        
    
    }

    @Override
    public void delete(int idLocal) {
   
          Connection conn = null;
        PreparedStatement pstmt = null;
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "DELETE FROM Local WHERE idLocal=?";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, idLocal);
                //Paso 4: Ejecutar la sentencia
                pstmt.executeUpdate();
                //Paso 5(opc.): Procesar los resultados			
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                //Paso 6(OJO): Cerrar la conexión
                try { if (pstmt!= null) pstmt.close();} 
                        catch (Exception e){e.printStackTrace();};
                try { if (conn!= null) conn.close();} 
                        catch (Exception e){e.printStackTrace();};						
        }
    
    
    
    
    
    }

    @Override
    public ArrayList<Local> queryAll() {
        
    
     Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Local> arr = new ArrayList<Local>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * FROM Local";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                   // int id = rs.getInt("id");
                    int idLocal = rs.getInt("idLocal");
                    int idDistrito = rs.getInt("idDistrito");
                    int idProceso = rs.getInt("idTipoProceso");
                    String nombre = rs.getString("nombre");
                    int CantidadVotantesRegistrados = rs.getInt("cantidadVotantes");
                                       
                  
                    Local i = new Local();
                   
                    i.setId(idLocal);
                    i.setIdDistrito(idDistrito);
                    i.setIdProceso(idProceso);
                    i.setNombre(nombre);
                    i.setCantidadVotantesRegistrados(CantidadVotantesRegistrados);
                    arr.add(i);
                }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                //Paso 6(OJO): Cerrar la conexión
                try { if (pstmt!= null) pstmt.close();} 
                        catch (Exception e){e.printStackTrace();};
                try { if (conn!= null) conn.close();} 
                        catch (Exception e){e.printStackTrace();};						
        }
        return arr;
    
    
    
    }

    @Override
    public Local queryById(int idLocal) {
 
      Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Local i= null;
        try {
            //Paso 1: Registrar el Driver
            DriverManager.registerDriver(new Driver());
            //Paso 2: Obtener la conexión
            conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                    DBConnection.user,
                                                    DBConnection.password);
            //Paso 3: Preparar la sentencia
            String sql = "SELECT * FROM Local WHERE idLocal=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,idLocal);
            //Paso 4: Ejecutar la sentencia
            rs = pstmt.executeQuery();
            //Paso 5(opc.): Procesar los resultados
            
         
			//Paso 5(opc.): Procesar los resultados
                if (rs.next()){
                            
                        int id = rs.getInt("idLocal");
                        int idDistrito = rs.getInt("idDistrito");
                        int idProceso = rs.getInt("idTipoProceso");
                        String nombre = rs.getString("nombre");
                        int CantidadVotantesRegistrados = rs.getInt("cantidadVotantes");
                         i = new Local();
            i.setId(id);
            i.setIdDistrito(idDistrito);
            i.setIdProceso(idProceso);
            i.setNombre(nombre);
            i.setCantidadVotantesRegistrados(CantidadVotantesRegistrados);
				
				
                }
            
            
         

           
            
            
           
            
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                //Paso 6(OJO): Cerrar la conexión
                try { if (pstmt!= null) pstmt.close();} 
                        catch (Exception e){e.printStackTrace();};
                try { if (conn!= null) conn.close();} 
                        catch (Exception e){e.printStackTrace();};						
        }
        return i;		
    
    
    
    }
 
    
}

