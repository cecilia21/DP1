package controlador.dao;

public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(int dbType){
		switch (dbType) {
			case DBConnection.SQL_SERVER:
				return new MySQLDAOFactory();
			case DBConnection.MYSQL:
				return new MySQLDAOFactory();
		}
		return null;
	}
	public abstract DAOPartidoPolitico getDAOPartidoPolitico();
}
