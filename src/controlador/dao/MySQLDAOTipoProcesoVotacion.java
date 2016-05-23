/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TipoProcesoVotacion;

/**
 *
 * @author RAMON
 */
public class MySQLDAOTipoProcesoVotacion implements DAOTipoProcesoVotacion {

    @Override
    public void update(TipoProcesoVotacion p) {
        Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                    //Paso 1: Registrar el Driver
                    DriverManager.registerDriver(new Driver());
                    //Paso 2: Obtener la conexión
                    conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
                    //Paso 3: Preparar la sentencia
                    String sql = "UPDATE TipoProcesoVotacion SET nombre=?, fechaInicio1=?, "
                                + "fechaFin1=?, fechaInicio2=?, fechaFin2=?, porcentajeMinimo=?"
                                + ", cantidadVotantes=?, idUsuario=?, idDistrito=?, idPartido=?"
                                + ", idLocal=?, idRegion=?, idInstitucion=? "
                                + "WHERE id=?";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    pstmt = conn.prepareStatement(sql);
			//
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
//                    pstmt.setDate(2, p.getFechaInicio1());
//                    pstmt.setDate(3, p.getFechaFin1());
//                    pstmt.setDate(4, p.getFechaInicio2());
//                    pstmt.setDate(5, p.getFechaFin2());
                    pstmt.setString(6, ""+p.getPorcentajeMinimo());
                    pstmt.setString(7, ""+p.getCantidadVotantes());
                    pstmt.setString(8, ""+p.getIdUsuario());
                    pstmt.setInt(9, p.getIdDistrito());
                    pstmt.setInt(10, p.getIdPartido());
                    pstmt.setInt(11, p.getIdLocal());
                    pstmt.setInt(12, p.getIdRegion());
                    pstmt.setInt(13, p.getIdInstitucion());
                    pstmt.setInt(14, p.getId());
                    //Paso 4: Ejecutar la sentencia
                    pstmt.executeUpdate();
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
    
}
