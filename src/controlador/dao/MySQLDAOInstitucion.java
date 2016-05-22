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
                                + "(idDistrito, idLocal, idRegion, nombre,CantidadVotantesRegistrados)"
                                + "VALUES (?,?,?,?,?)";
                
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                //pstmt.setInt(1, p.getId());
                pstmt.setInt(1, i.getIdDistrito());
                pstmt.setInt(2, i.getIdLocal());
                pstmt.setInt(3, i.getIdRegion());
                pstmt.setString(4, i.getNombre());
                pstmt.setInt(5, i.getCantidadVotantesRegistrados());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idInstitucion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Institucion> queryAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Institucion queryById(int idInstitucion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
