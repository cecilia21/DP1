/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import model.Distrito;

import com.mysql.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Distrito;

public class MySQLDAODistrito implements DAODistrito {

    @Override
    public void add(Distrito p) {
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
			String sql = "INSERT INTO dp1.Distrito "
					+ "(idDistrito, nombre, cantidadDeVotantes, idRegion)"
					+ "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getNombre());
                        pstmt.setInt(3, p.getCantidadVotantesRegistrados());
                        pstmt.setInt(4, p.getIdRegion());
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
    public void update(Distrito p) {       
        
        // TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "UPDATE dp1.Distrito "
					+ "SET name=?, cantidadDeVotantes=?,idRegion=? "
					+ "WHERE idDistrito=?";
			pstmt = conn.prepareStatement(sql);
			//
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getNombre());
                        pstmt.setInt(2, p.getCantidadVotantesRegistrados());
                        pstmt.setInt(3, p.getIdRegion());
			pstmt.setInt(4, p.getId());
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
    public void delete(int idDistrito) {        
        Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "DELETE FROM dp1.Distrito "
					+ "WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			//
			pstmt.setInt(1, idDistrito);
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
    public ArrayList<Distrito> queryAll() {
        
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Distrito> arr = new ArrayList<Distrito>();
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM dp1.Distrito";
			pstmt = conn.prepareStatement(sql);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			while (rs.next()){
				int id = rs.getInt("idDistrito");
				String name = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int idReg = rs.getInt("idRegion");
				Distrito p=new Distrito(id,idReg,name,cant);
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
    public Distrito queryById(int idDistrito) {
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Distrito p=null;
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM dp1.Distrito "
					+ "WHERE idDistrito=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idDistrito);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("idDistrito");
				String name = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int idReg = rs.getInt("idRegion");
				p=new Distrito(id,idReg,name,cant);
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
    public Distrito queryByName(String name) {
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Distrito p=null;
		try {
			//Paso 1: Registrar el Driver
			DriverManager.registerDriver(new Driver());
			//Paso 2: Obtener la conexión
			conn = DriverManager.getConnection(DBConnection.URL_JDBC_SQLServer,
								DBConnection.user,
								DBConnection.password);
			//Paso 3: Preparar la sentencia
			String sql = "SELECT * FROM dp1.Distrito "
					+ "WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			//Paso 4: Ejecutar la sentencia
			rs = pstmt.executeQuery();
			//Paso 5(opc.): Procesar los resultados
			if (rs.next()){
				int id = rs.getInt("idDistrito");
				String named = rs.getString("nombre");
				int cant = rs.getInt("cantidadVotantes");
                                int idReg = rs.getInt("idRegion");
				p=new Distrito(id,idReg,named,cant);
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
