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
import model.Adherente;

/**
 *
 * @author Raul
 */
public class MySQLDAOAdherente implements DAOAdherente{
    
    @Override
    public void add(Adherente a) {
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
                String sql = "INSERT INTO Adherente "
                                + "(dni,nombreJPG,idPartido,estado)"
                                + "VALUES (?,?,?,?)";
                
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setString(1, a.getDni());
                pstmt.setString(2, a.getJpg());
                pstmt.setInt(3, a.getIdPartido());
                pstmt.setString(4, a.getEstado());
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
    public void update(Adherente a) {
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
            String sql = "UPDATE Adherente "
                            + "SET estado=? "
                            + "WHERE idAdherente=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, a.getEstado());
            pstmt.setInt(2, a.getId());
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
    public void delete(int idAdherente) {
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
                String sql = "DELETE FROM Adherente WHERE idAdherente=?";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, idAdherente);
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
    public ArrayList<Adherente> queryAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Adherente> arr = new ArrayList<Adherente>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * FROM Adherente";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                    int id = rs.getInt("idAdherente");
                    String dni = rs.getString("dni");
                    String nombreJPG = rs.getString("nombreJPG");
                    int idPartido = rs.getInt("idPartido");
                    String estado=rs.getString("estado");
                                       
                    Adherente a = new Adherente();
                    a.setId(id);
                    a.setDni(dni);
                    a.setJpg(nombreJPG);
                    a.setIdPartido(idPartido);
                    a.setEstado(estado);
                    arr.add(a);
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
    public Adherente queryById(int idAdherente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Adherente a=null;
        try {
            //Paso 1: Registrar el Driver
            DriverManager.registerDriver(new Driver());
            //Paso 2: Obtener la conexión
            conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                    DBConnection.user,
                                                    DBConnection.password);
            //Paso 3: Preparar la sentencia
            String sql = "SELECT * FROM Adherente WHERE id=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,idAdherente);
            //Paso 4: Ejecutar la sentencia
            rs = pstmt.executeQuery();
            //Paso 5(opc.): Procesar los resultados
            rs.next();
            int id = rs.getInt("idAdherente");
            String dni = rs.getString("dni");
            String nombreJPG = rs.getString("nombreJPG");
            int idPartido = rs.getInt("idPartido");
            String estado=rs.getString("estado");

            a.setId(id);
            a.setDni(dni);
            a.setJpg(nombreJPG);
            a.setIdPartido(idPartido);
            a.setEstado(estado);
            
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
        return a;		
    }

    @Override
    public void addLista(ArrayList<Adherente> listaAdherente) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                        DBConnection.user,
                                                        DBConnection.password);
                
                for(int i=0;i<listaAdherente.size();i++){                    
                    //Paso 3: Preparar la sentencia
                    String sql = "INSERT INTO Adherente "
                                    + "(dni,nombreJPG,idPartido,estado)"
                                    + "VALUES (?,?,?,?)";

                    pstmt = (PreparedStatement) conn.prepareStatement(sql);
                    //pstmt.setInt(1, p.getId());
                    pstmt.setString(1, listaAdherente.get(i).getDni());
                    pstmt.setString(2, listaAdherente.get(i).getJpg());
                    pstmt.setInt(3, listaAdherente.get(i).getIdPartido());
                    pstmt.setString(4, listaAdherente.get(i).getEstado());
                    //Paso 4: Ejecutar la sentencia
                    pstmt.executeUpdate();
                    //Paso 5(opc.): Procesar los resultados
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
        
        
    }

    @Override
    public ArrayList<Adherente> queryAllObservado(int idPartido) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Adherente> arr = new ArrayList<Adherente>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = (Connection) DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                DBConnection.user,
                                DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * FROM Adherente WHERE idPartido=? AND estado=? ";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setInt(1,idPartido);
                pstmt.setString(2,"Observado");
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                    int id = rs.getInt("idAdherente");
                    String dni = rs.getString("dni");
                    String nombreJPG = rs.getString("nombreJPG");
                    String estado=rs.getString("estado");
                                       
                    Adherente a = new Adherente();
                    a.setId(id);
                    a.setDni(dni);
                    a.setJpg(nombreJPG);
                    a.setIdPartido(idPartido);
                    a.setEstado("Observado");
                    arr.add(a);
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
