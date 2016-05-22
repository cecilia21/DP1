package controlador.dao;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public DAOPartidoPolitico getDAOPartidoPolitico() {
		// TODO Auto-generated method stub
		return new MySQLDAOPartidoPolitico();
	}

}
