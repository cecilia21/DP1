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
			String sql = "SELECT * FROM TipoProcesoVotacion "
					+ "WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idTipoProcesoVotacion);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
                                String idUsuario = rs.getString("idUsuario");
				int cant = rs.getInt("cantidadDeVotantes");
                                Date fechaInicio1= rs.getDate("fechaInicio1");
                                Date fechaFin1= rs.getDate("fechaFin1");
                                Date fechaInicio2= rs.getDate("fechaInicio2");
                                Date fechaFin2= rs.getDate("fechaFin2");
                                double porcentajeMinimo= rs.getDouble("porcentajeMinimo");
				p=new TipoProcesoVotacion();
                                p.setId(id);
                                p.setCantidadVotantes(cant);
                                p.setFechaFin1(fechaFin1);
                                p.setFechaFin2(fechaFin2);
                                p.setFechaInicio1(fechaInicio1);
                                p.setFechaInicio2(fechaInicio2);
                                p.setPorcentajeMinimo(porcentajeMinimo);
                                p.setIdUsuario(idUsuario);
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
