package servico;



import java.util.List;

import dao.BuffetComponenteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.BuffetComponente;




public class BuffetComponenteServico {

	

	private BuffetComponenteDao dao;
	
	public BuffetComponenteServico() {
		dao = DaoFactory.criarBuffetComponenteDao();
	}
	
	public void inserirAtualizar(BuffetComponente x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(BuffetComponente x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public BuffetComponente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<BuffetComponente> buscarTodos() {
		return dao.buscarTodos();
	}

	
	
}
