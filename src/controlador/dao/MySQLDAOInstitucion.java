/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Institucion;

/**
 *
 * @author Raul
 */
public class MySQLDAOInstitucion implements DAOInstitucion {

    @Override
    public void add(Institucion i) {
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
                String sql = "INSERT INTO Institucion "
                                + "(idLocal,nombre,cantidadVotantes,idTipoProceso)"
                                + "VALUES (?,?,?,?)";
                
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, i.getIdLocal());
                pstmt.setString(2, i.getNombre());
                pstmt.setInt(3, i.getCantidadVotantesRegistrados());
                pstmt.setInt(4, i.getTipoProceso());
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
    public void update(Institucion i) {
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
            String sql = "UPDATE Institucion "
                            + "SET nombre=?,cantidadVotantes=?,idlocal=? "
                            + "WHERE idInstitucion=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, i.getNombre());
            pstmt.setInt(2, i.getCantidadVotantesRegistrados());
            pstmt.setInt(3, i.getIdLocal());
            pstmt.setInt(4, i.getId());			
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
    public void delete(int idInstitucion) {
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
                String sql = "DELETE FROM Institucion WHERE idInstitucion=?";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, idInstitucion);
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
    public ArrayList<Institucion> queryAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Institucion> arr = new ArrayList<Institucion>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * FROM Institucion";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                    int id = rs.getInt("idInstitucion");
                    int idLocal = rs.getInt("idLocal");
                    String nombre = rs.getString("nombre");
                    int cantidadVotantes = rs.getInt("cantidadVotantes");
                    int tipoProceso=rs.getInt("idTipoProceso");
                                       
                    Institucion i = new Institucion();
                    i.setId(id);
                    i.setIdLocal(idLocal);
                    i.setNombre(nombre);
                    i.setCantidadVotantesRegistrados(cantidadVotantes);
                    i.setTipoProceso(tipoProceso);
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
    public Institucion queryById(int idInstitucion) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Institucion i=null;
        try {
            //Paso 1: Registrar el Driver
            DriverManager.registerDriver(new Driver());
            //Paso 2: Obtener la conexión
            conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                    DBConnection.user,
                                                    DBConnection.password);
            //Paso 3: Preparar la sentencia
            String sql = "SELECT * FROM Institucion WHERE id=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,idInstitucion);
            //Paso 4: Ejecutar la sentencia
            rs = pstmt.executeQuery();
            //Paso 5(opc.): Procesar los resultados
            rs.next();
            int id = rs.getInt("idInstitucion");
            int idLocal = rs.getInt("idLocal");
            String nombre = rs.getString("nombre");
            int CantidadVotantesRegistrados = rs.getInt("cantidadVotantes");
            int tipoProceso=rs.getInt("idTipoProceso");  
            i.setId(id);
            i.setIdLocal(idLocal);
            i.setNombre(nombre);
            i.setCantidadVotantesRegistrados(CantidadVotantesRegistrados);
            i.setTipoProceso(tipoProceso);
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

    @Override
    public ArrayList<Institucion> queryByName(String nombre) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Institucion> arr = new ArrayList<Institucion>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * FROM Institucion WHERE NOMBRE LIKE ?";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setString(1,"%"+nombre+"%");
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                    int id = rs.getInt("idInstitucion");
                    int idLocal = rs.getInt("idLocal");
                    String nombreQ = rs.getString("nombre");
                    int CantidadVotantesRegistrados = rs.getInt("cantidadVotantes");
                    int tipoProceso=rs.getInt("idTipoProceso");                   
                    Institucion i = new Institucion();
                    i.setId(id);
                    i.setIdLocal(idLocal);
                    i.setNombre(nombreQ);
                    i.setCantidadVotantesRegistrados(CantidadVotantesRegistrados);
                    i.setTipoProceso(tipoProceso);
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
    
}
