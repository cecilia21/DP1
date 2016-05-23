/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

/**
 *
 * @author USUARIO
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import model.PartidoPolitico;

public class MySQLDAOPartidoPolitico implements DAOPartidoPolitico{

	@Override
	public void add(PartidoPolitico p) {		
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                    //Paso 1: Registrar el Driver
                    DriverManager.registerDriver(new Driver());
                    //Paso 2: Obtener la conexión
                    conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
                    //Paso 3: Preparar la sentencia
                    String sql = "INSERT INTO PartidoPolicito "
                                    + "(nombre, cantidadRegistrosValidos, nombreRepresentante, "
                                    + "apellidoRepresentante, dniRepresentante, correoRepresentante, "
                                    + "correoPartido, fechaRegistro, estado)"
                                    + "VALUES (?,?,?,?,?,?,?,?,?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
                    pstmt.setString(2, "0");
                    pstmt.setString(3, p.getNombreRepresentante());
                    pstmt.setString(4, p.getApellidoRepresentante());
                    pstmt.setString(5, p.getDniRepresentante());
                    pstmt.setString(6, p.getCorreoRepresentante());
                    pstmt.setString(7, p.getCorreoPartido());
                    //pstmt.setDate(8, p.getFechaRegistro());
                    pstmt.setString(9, p.getEstado());
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
	public void update(PartidoPolitico p) {
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
                    String sql = "UPDATE PartidoPolitico SET nombre=?, cantidadRegistrosValidos=?, "
                                + "nombreRepresentante=?, apellidoRepresentante=?, dniRepresentante=?"
                                + ", correoRepresentante=?, correoPartido=?, fechaRegistro=?, estado=?"
                                + "WHERE id=?";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    pstmt = conn.prepareStatement(sql);
			//
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
                    pstmt.setString(2, ""+p.getCantidadRegistrosValidos());
                    pstmt.setString(3, p.getNombreRepresentante());
                    pstmt.setString(4, p.getApellidoRepresentante());
                    pstmt.setString(5, p.getDniRepresentante());
                    pstmt.setString(6, p.getCorreoRepresentante());
                    pstmt.setString(7, p.getCorreoPartido());
                    //pstmt.setDate(8, p.getFechaRegistro());
                    pstmt.setString(9, p.getEstado());
                    pstmt.setInt(10, p.getId());
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
	public void delete(int idPartido) {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try{
            //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                DBConnection.user,
                                                DBConnection.password);
            //Paso 3: Preparar la sentencia
                String sql = "DELETE FROM PartidoPolitico "
                                + "WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idPartido);
                //Paso 4: Ejecutar la sentencia
                //pstmt.
                pstmt.execute();
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
	public ArrayList<PartidoPolitico> queryAll() {
		return null;
	}

	@Override
	public PartidoPolitico queryById(int idProduct) {
		
		return null;	
	}

}