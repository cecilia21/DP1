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
import model.Adherente;
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
                    String sql = "INSERT INTO PartidoPolitico "
                                    + "(nombre, cantRegistrosValidos, nombreRep, "
                                    + "apellidoRep, dniRep, correo, "
                                    + "fechaReg, estado, idTipoProceso, idRegion, "
                                    + " idLocal, idDistrito, idInstitucion)"
                                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    pstmt.setInt(9, p.getIdTipoProceso());
                    if(p.getIdRegion()>0)
                        pstmt.setInt(10, p.getIdRegion());
                    else pstmt.setString(10, null);
                    if(p.getIdLocal()>0)
                        pstmt.setInt(11, p.getIdLocal());
                    else pstmt.setString(11, null);
                    if(p.getIdDistrito()>0)
                        pstmt.setInt(12, p.getIdDistrito());
                    else pstmt.setString(12,null);
                    if(p.getIdInstitucion()>0)
                        pstmt.setInt(13, p.getIdInstitucion());
                    else pstmt.setString(13, null);
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
                                + "WHERE idPartido=?";
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
	public PartidoPolitico queryById(int idPartido) {
		
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
                    String sql = "SELECT * "
                            + "FROM PartidoPolitico WHERE idPartido="+idPartido;

                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    PartidoPolitico p = new PartidoPolitico();
                    while (rs.next()){
                        int id = rs.getInt("idPartido");
                        String name = rs.getString("nombre");
                        String nombre_rep =rs.getString("nombreRep");
                        String apellido_rep = rs.getString("apellidoRep");
                        int cant = rs.getInt("cantRegistrosValidos");
                        String dni = rs.getString("dniRep");
                        String correo = rs.getString("correo");
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(rs.getDate("fechaReg"));
                        String estado = rs.getString("estado");
                        int proceso = rs.getInt("idTipoProceso");
                        int region = rs.getInt("idRegion");
                        int local = rs.getInt("idLocal");
                        int insti = rs.getInt("idInstitucion");
                        int distrito = rs.getInt("idDistrito");
                        p.setNombre(name);
                        p.setNombreRepresentante(nombre_rep);
                        p.setApellidoRepresentante(apellido_rep);
                        p.setCantidadRegistrosValidos(cant);
                        p.setDniRepresentante(dni);
                        p.setCorreoPartido(correo);
                        p.setFechaRegistro(cal);
                        p.setEstado(estado);
                        p.setIdDistrito(distrito);
                        p.setIdInstitucion(insti);
                        p.setIdLocal(local);
                        p.setIdRegion(region);
                        p.setIdTipoProceso(proceso);                   
                    }
                    pstmt.close();
                    conn.close();
                    return p;
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
	public ArrayList<PartidoPolitico> queryByNombTipoLug(String nombre, int tipo, int lugar) {
		
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
                    String sql = "SELECT DISTINCT nombre "
                            + "FROM PartidoPolitico WHERE nombre like '%"+nombre+"%'";
                    if(tipo>0){
                        sql += " AND idTipoProceso=" + tipo;
                        if(lugar>0){
                            if(tipo==2)
                                sql += " AND idRegion="+lugar;
                            if(tipo==3)
                                sql +=" AND idDistrito="+lugar;
                            if(tipo==4)
                                sql +=" AND idLocal="+lugar;
                            if(tipo==5)
                                sql +=" AND idInstitucion="+lugar+";";
                        }
                    }
      
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    while (rs.next()){
                        String name = rs.getString("nombre");
                        PartidoPolitico p = new PartidoPolitico();
                        p.setNombre(name);
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
	public ArrayList<PartidoPolitico> queryByNombTipo(String nombre, int tipo) {
		
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
                    String sql = "SELECT * "
                            + "FROM PartidoPolitico WHERE nombre like '%"+nombre+"%'";
                    if(tipo>0){
                        sql += " AND idTipoProceso=" + tipo;
                    }
      
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    while (rs.next()){
                        int id = rs.getInt("idPartido");
                        String name = rs.getString("nombre");
                        String nombre_rep =rs.getString("nombreRep");
                        String apellido_rep = rs.getString("apellidoRep");
                        int cant = rs.getInt("cantRegistrosValidos");
                        String dni = rs.getString("dniRep");
                        String correo = rs.getString("correo");
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(rs.getDate("fechaReg"));
                        String estado = rs.getString("estado");
                        int proceso = rs.getInt("idTipoProceso");
                        int region = rs.getInt("idRegion");
                        int local = rs.getInt("idLocal");
                        int insti = rs.getInt("idInstitucion");
                        int distrito = rs.getInt("idDistrito");
                        PartidoPolitico p = new PartidoPolitico();
                        p.setId(id);
                        p.setNombre(name);
                        p.setNombreRepresentante(nombre_rep);
                        p.setApellidoRepresentante(apellido_rep);
                        p.setCantidadRegistrosValidos(cant);
                        p.setDniRepresentante(dni);
                        p.setCorreoPartido(correo);
                        p.setFechaRegistro(cal);
                        p.setEstado(estado);
                        p.setIdDistrito(distrito);
                        p.setIdInstitucion(insti);
                        p.setIdLocal(local);
                        p.setIdRegion(region);
                        p.setIdTipoProceso(proceso);
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
	public ArrayList<PartidoPolitico> queryByName(String nombre) {
		
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
                    String sql = "SELECT * FROM PartidoPolitico WHERE nombre like '"+nombre+"'";
                        
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
                        int reg = rs.getInt("cantRegistrosValidos");
                        int tipoproc = rs.getInt("idTipoProceso");
                        int iddistrito = rs.getInt("idDistrito");
                        int idregion = rs.getInt("idRegion");
                        int idlocal = rs.getInt("idLocal");
                        int idinst  = rs.getInt("idInstitucion");
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
                        p.setIdDistrito(iddistrito);
                        p.setIdInstitucion(idinst);
                        p.setIdLocal(idlocal);
                        p.setIdRegion(idregion);
                        p.setIdTipoProceso(tipoproc);
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
        public int[] queryTipoProcesoNombrePartido(String nombre){
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            int[] resultados= new int[6];
            for(int i=0; i<6;i++) resultados[i]=0;
            try {
                    //Paso 1: Registrar el Driver
                    DriverManager.registerDriver(new Driver());
                    //Paso 2: Obtener la conexión
                    conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                            DBConnection.user,
                                                            DBConnection.password);
                    //Paso 3: Preparar la sentencia
                    String sql = "SELECT idTipoProceso FROM PartidoPolitico WHERE nombre like '"+nombre+"'";
                        
                    pstmt = conn.prepareStatement(sql);
                    //Paso 4: Ejecutar la sentencia
                    rs = pstmt.executeQuery();
                    //Paso 5(opc.): Procesar los resultados
                    while (rs.next()){
                        int tipoproc = rs.getInt("idTipoProceso");
                        resultados[tipoproc]=1;
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

            return resultados;
        }
        
    @Override
    public ArrayList<Adherente> queryAdherentesById(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Adherente> resultados= new ArrayList<Adherente>();
        try {
                //Paso 1: Registrar el Driver
                DriverManager.registerDriver(new Driver());
                //Paso 2: Obtener la conexión
                conn = DriverManager.getConnection(DBConnection.URL_JDBC_MySQL,
                                                        DBConnection.user,
                                                        DBConnection.password);
                //Paso 3: Preparar la sentencia
                String sql = "SELECT * "
                        + "FROM Adherente WHERE idPartido="+id;

                pstmt = conn.prepareStatement(sql);
                //Paso 4: Ejecutar la sentencia
                rs = pstmt.executeQuery();
                //Paso 5(opc.): Procesar los resultados
                while (rs.next()){
                    String name = rs.getString("nombreJPG");
                    String dni = rs.getString("dni");
                    int idpartido = rs.getInt("idPartido");
                    Adherente ad = new Adherente(dni);
                    ad.setJpg(name);
                    ad.setIdPartido(idpartido);
                    resultados.add(ad);                       
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