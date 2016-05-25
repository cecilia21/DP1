package controlador.dao;

public class DBConnection {
	public static final int SQL_SERVER = 1;
	public static final int MYSQL = 2;
	public static final int ORACLE = 3;
	public static final int XML = 4;
	
	public static String URL_JDBC_SQLServer = 
	"jdbc:sqlserver://inti.lab.inf.pucp.edu.pe:1433;databaseName=inf282";
        public static String URL_JDBC_MySQL = 
	 "jdbc:mysql://localhost:3307/dp1?autoReconnect=true&useSSL=false";
	public static String user = "root";
	public static String password = "";
	public static int dbType = MYSQL;
	
}

