/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.mysql.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Region;

/**
 *
 * @author RAMON
 */
public class MySQLDAORegion implements DAORegion {

    @Override
    public void add(Region p) {
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
			String sql = "INSERT INTO region "
					+ "(idRegion, nombre,cantidadVotantes,idTipoProceso)"
					+ "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getNombre());
                        pstmt.setInt(3, p.getCantidadVotantesRegistrados());
                        pstmt.setInt(4,2);
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
    public void update(Region p) {
        
        // TODO Auto-generated method stub
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
			String sql = "UPDATE region "
					+ "SET nombre=?, cantidadVotantes=? "
					+ "WHERE idRegion=?";
			pstmt = conn.prepareStatement(sql);
			//
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getNombre());
                        pstmt.setInt(2, p.getCantidadVotantesRegistrados());			
			pstmt.setInt(3, p.getId());
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
    public void delete(int idRegion) {
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
			String sql = "DELETE FROM region "
					+ "WHERE idRegion=?";
			pstmt = conn.prepareStatement(sql);
			//
			pstmt.setInt(1, idRegion);
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
    public ArrayList<Region> queryAll() {
        	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Region> arr = new ArrayList<Region>();
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM Region";
			pstmt = conn.prepareStatement(sql);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			while (rs.next()){
				int id = rs.getInt("idRegion");
				String name = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int t = rs.getInt("idTipoProceso");
				Region p=new Region(id,name,cant);
                                p.setTipoProceso(t);
				arr.add(p);
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
    public Region queryById(int idRegion) {
                Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Region p=null;
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM Region "
					+ "WHERE idRegion=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idRegion);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("idRegion");
				String name = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int t = rs.getInt("idTipoProceso");
                                p=new Region(id,name,cant);
                                p.setTipoProceso(t);
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

    @Override
    public Region queryByName(String nameb) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Region p=null;
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM region "
					+ "WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nameb);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("idRegion");
				String name = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int t = rs.getInt("idTipoProceso");
                                p.setTipoProceso(t);
				p=new Region(id,name,cant);
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
