package controlador.dao;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public DAOPartidoPolitico getDAOPartidoPolitico() {
		// TODO Auto-generated method stub
		return new MySQLDAOPartidoPolitico();
	}
        
	public DAOInstitucion getDAOInstitucion() {
		// TODO Auto-generated method stub
		return new MySQLDAOInstitucion();
	}

        @Override
	public DAORegion getDAORegion() {
		// TODO Auto-generated method stub
		return new MySQLDAORegion();
	}

    @Override
    public DAOTipoProcesoVotacion getDAOTipoProcesoVotacion() {
        return new MySQLDAOTipoProcesoVotacion();
    }

    @Override
    public DAOLocal getDAOLocal() {
        
     return new MySQLDAOLocal();
    
    }

        
}
