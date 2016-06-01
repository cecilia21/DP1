package controlador.dao;

public class DBConnection {
	public static final int SQL_SERVER = 1;
	public static final int MYSQL = 2;
	public static final int ORACLE = 3;
	public static final int XML = 4;
	
	public static String URL_JDBC_SQLServer = 
	"jdbc:sqlserver://inti.lab.inf.pucp.edu.pe:1433;databaseName=inf282";
        public static String URL_JDBC_MySQL =
                //"jdbc:mysql://localhost:3306/dp1";
                "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf226eb?zeroDateTimeBehavior=convertToNull";
	public static String user = "inf226eb";
	public static String password = "w4TrHBAc3hbAfGX2";
	public static int dbType = MYSQL;
	
}

