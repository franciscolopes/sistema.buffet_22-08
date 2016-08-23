package servico;



import java.util.List;

import dao.BuffetDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Buffet;




public class BuffetServico {

	

	private BuffetDao dao;
	
	public BuffetServico() {
		dao = DaoFactory.criarBuffetDao();
	}
	
	public void inserirAtualizar(Buffet x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Buffet x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Buffet buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Buffet> buscarTodos() {
		return dao.buscarTodos();
	}

	
	
}
