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
import java.util.Calendar;
import java.util.Locale;
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
                                                            DBConnection.user,null
                                                            /*DBConnection.password*/);
                    //Paso 3: Preparar la sentencia
                    String sql = "INSERT INTO PartidoPolitico "
                                    + "(nombre, cantidadRegistrosValidos, nombreRepresentante, "
                                    + "apellidoRepresentante, dniRepresentante, correo, "
                                    + "fechaRegistro, estado)"
                                    + "VALUES (?,?,?,?,?,?,?,?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, p.getNombre());
                    pstmt.setInt(2, 0);
                    pstmt.setString(3, p.getNombreRepresentante());
                    pstmt.setString(4, p.getApellidoRepresentante());
                    pstmt.setString(5, p.getDniRepresentante());
                    //pstmt.setString(6, p.getCorreoRepresentante());
                    pstmt.setString(6, p.getCorreoPartido());
                    pstmt.setDate(7, new java.sql.Date(p.getFechaRegistro().getTimeInMillis()));
                    pstmt.setString(8, p.getEstado());
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
                                + ", correo=?, fechaRegistro=?, estado=?, idTipoProceso=?, idRegion=?,"
                                + "idLocal=?, idInstitucion=?, idDistrito=?"
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
                    pstmt.setString(6, p.getCorreoPartido());
                    //pstmt.setDate(7, p.getFechaRegistro());
                    pstmt.setString(8, p.getEstado());
                    pstmt.setInt(10, p.getIdTipoProceso());
                    pstmt.setInt(11, p.getIdRegion());
                    pstmt.setInt(12, p.getIdLocal());
                    pstmt.setInt(13, p.getIdInstitucion());
                    pstmt.setInt(14, p.getIdDistrito());
                    pstmt.setInt(15, p.getId());
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
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<PartidoPolitico> resultados= new ArrayList<PartidoPolitico>();
            try {
                    //Paso 1: Registrar el Driver
                    DriverManager.registerDriver(new Driver());
                    //Paso 2: Obtener la conexión
                    conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
                    //Paso 3: Preparar la sentencia
                    String sql = "SELECT * FROM PartidoPolitico";
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    while (rs.next()){
                        int id = rs.getInt("idPartido");

                        String name = rs.getString("nombre");
                        String nombreRep = rs.getString("nombreRep");
                        String apellidoRep = rs.getString("apellidoRep");
                        String correo = rs.getString("correo");
                        String dni = rs.getString("dniRep");
                        int reg = rs.getInt("cantidadRegistrosValidos");
                        String estado = rs.getString("estado");
                        Calendar fecha = Calendar.getInstance();
                        fecha.setTime(rs.getDate("fechaReg"));
                        PartidoPolitico p = new PartidoPolitico();
                        p.setNombre(name);
                        p.setNombreRepresentante(nombreRep);
                        p.setApellidoRepresentante(apellidoRep);
                        p.setCorreoPartido(correo);
                        p.setDniRepresentante(dni);
                        p.setCantidadRegistrosValidos(reg);
                        p.setEstado(estado);
                        p.setFechaRegistro(fecha);
                        resultados.add(p);                       
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

	@Override
	public PartidoPolitico queryById(int idProduct) {
		
		return null;	
	}

}