package servico;



import java.util.List;

import dao.ComponenteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Componente;




public class ComponenteServico {

	

	private ComponenteDao dao;
	
	public ComponenteServico() {
		dao = DaoFactory.criarComponenteDao();
	}
	
	public void inserirAtualizar(Componente x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Componente x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Componente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Componente> buscarTodos() {
		return dao.buscarTodos();
	}

	
	
}
