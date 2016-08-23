package dao;


import dao.impl.BuffetDaoImpl;
import dao.impl.ComponenteDaoImpl;
import dao.impl.BuffetComponenteDaoImpl;



public class DaoFactory {

	

	public static BuffetDao criarBuffetDao() {
		return new BuffetDaoImpl();
	}



	public static ComponenteDao criarComponenteDao() {
		return new ComponenteDaoImpl();
	}



	public static BuffetComponenteDao criarBuffetComponenteDao() {
		return new BuffetComponenteDaoImpl();
	}

	
	
}
