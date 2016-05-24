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
import java.util.ArrayList;
import java.util.Calendar;
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
                    String sql = "UPDATE TipoProceso SET nombre=?, fechaInicio1=?, "
                                + "fechaFin1=?, fechaInicio2=?, fechaFin2=?, porcentaje=?"
                                + "WHERE id=?";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    pstmt = conn.prepareStatement(sql);
			//
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
                    pstmt.setDate(2, new java.sql.Date(p.getFechaInicio1().getTimeInMillis()));
                    pstmt.setDate(3, new java.sql.Date(p.getFechaFin1().getTimeInMillis()));
                    pstmt.setDate(4, new java.sql.Date(p.getFechaInicio2().getTimeInMillis()));
                    pstmt.setDate(5, new java.sql.Date(p.getFechaFin2().getTimeInMillis()));
                    pstmt.setFloat(6,p.getPorcentajeMinimo());
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
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,null
                                                            /*DBConnection.password*/);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM TipoProceso "
					+ "WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idTipoProcesoVotacion);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
                            Calendar fechaInicio1 = Calendar.getInstance();
                            fechaInicio1.setTime(rs.getDate("fechaInicio1"));
                            Calendar fechaInicio2 = Calendar.getInstance();
                            fechaInicio2.setTime(rs.getDate("fechaInicio2"));
                            Calendar fechaFin1 = Calendar.getInstance();
                            fechaFin1.setTime(rs.getDate("fechaFin1"));
                            Calendar fechaFin2 = Calendar.getInstance();
                            fechaFin2.setTime(rs.getDate("fechaFin2"));
                            float porc = rs.getFloat("porcentaje");
                            TipoProcesoVotacion tpv = new TipoProcesoVotacion();
                            tpv.setId(id);
                            tpv.setFechaFin1(fechaFin1);
                            tpv.setFechaFin2(fechaFin2);
                            tpv.setFechaInicio1(fechaInicio1);
                            tpv.setFechaInicio2(fechaInicio2);
                            tpv.setNombre(nombre);
                            tpv.setPorcentajeMinimo(porc);
                            return tpv;
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
		return null;          
    }
    @Override
    public ArrayList<TipoProcesoVotacion> queryAll() {
        Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<TipoProcesoVotacion> resultados= new ArrayList<TipoProcesoVotacion>();
            try {
                    //Paso 1: Registrar el Driver
                    DriverManager.registerDriver(new Driver());
                    //Paso 2: Obtener la conexión
                    conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
                    //Paso 3: Preparar la sentencia
                    String sql = "SELECT * FROM TipoProceso";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    while (rs.next()){
                        int id = rs.getInt("idProceso");
                        String nombre = rs.getString("nombre");
                        Calendar fechaInicio1 = Calendar.getInstance();
                        fechaInicio1.setTime(rs.getDate("fechaInicio1"));
                        Calendar fechaInicio2 = Calendar.getInstance();
                        fechaInicio2.setTime(rs.getDate("fechaInicio2"));
                        Calendar fechaFin1 = Calendar.getInstance();
                        fechaFin1.setTime(rs.getDate("fechaFin1"));
                        Calendar fechaFin2 = Calendar.getInstance();
                        fechaFin2.setTime(rs.getDate("fechaFin2"));
                        float porc = rs.getFloat("porcentaje");
                        TipoProcesoVotacion tpv = new TipoProcesoVotacion();
                        tpv.setId(id);
                        tpv.setFechaFin1(fechaFin1);
                        tpv.setFechaFin2(fechaFin2);
                        tpv.setFechaInicio1(fechaInicio1);
                        tpv.setFechaInicio2(fechaInicio2);
                        tpv.setNombre(nombre);
                        tpv.setPorcentajeMinimo(porc);
                        resultados.add(tpv);                       
                    }
                    pstmt.close();
                    conn.close();
                    return resultados;
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

            return null;
    }
}
