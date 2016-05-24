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
import java.util.Date;
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
                    String sql = "UPDATE dp1.TipoProceso SET nombre=?, fechaInicio1=?, "
                                + "fechaFin1=?, fechaInicio2=?, fechaFin2=?, porcentaje=? "
                                + "WHERE idProceso=?";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    pstmt = conn.prepareStatement(sql);
			//
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
                    pstmt.setDate(2, new java.sql.Date(p.getFechaInicio1().getTime()));
                    pstmt.setDate(3, new java.sql.Date(p.getFechaFin1().getTime()));
                    pstmt.setDate(4, new java.sql.Date(p.getFechaInicio2().getTime()));
                    pstmt.setDate(5, new java.sql.Date(p.getFechaFin2().getTime()));
                    pstmt.setString(6, ""+p.getPorcentajeMinimo());
                    pstmt.setInt(7, p.getId());
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

    @Override
    public TipoProcesoVotacion queryById(int idTipoProcesoVotacion) {
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TipoProcesoVotacion p=null;
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM dp1.TipoProceso "
					+ "WHERE idProceso=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idTipoProcesoVotacion);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("idProceso");
				String name = rs.getString("nombre");
                                Date fechaInicio1= rs.getDate("fechaInicio1");
                                Date fechaFin1= rs.getDate("fechaFin1");
                                Date fechaInicio2= rs.getDate("fechaInicio2");
                                Date fechaFin2= rs.getDate("fechaFin2");
                                double porcentajeMinimo= rs.getDouble("porcentaje");
				p=new TipoProcesoVotacion();
                                p.setId(id);
                                p.setFechaFin1(fechaFin1);
                                p.setFechaFin2(fechaFin2);
                                p.setFechaInicio1(fechaInicio1);
                                p.setFechaInicio2(fechaInicio2);
                                p.setPorcentajeMinimo(porcentajeMinimo);
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
		return p;          
    }
    
}
