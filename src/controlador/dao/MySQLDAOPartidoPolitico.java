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
			String sql = "INSERT INTO Person "
					+ "(id, name, lastName, dni, email, birthday)"
					+ "VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getLastName());
			pstmt.setString(4, p.getDni());
			pstmt.setString(5, p.getEmail());
			pstmt.setDate(6, Date.valueOf(p.getBirthday()));
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
		
            
	}

	@Override
	public void delete(int idProduct) {
		
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