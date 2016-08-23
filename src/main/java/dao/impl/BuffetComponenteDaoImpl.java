package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BuffetComponenteDao;
import dominio.BuffetComponente;

public class BuffetComponenteDaoImpl implements BuffetComponenteDao {


	private EntityManager em;



	public BuffetComponenteDaoImpl() {
		this.em = EM.getLocalEm();
	}

	
	@Override
	public void inserirAtualizar(BuffetComponente x) {
		// TODO Auto-generated method stub

		if (x.getCodBuffetComponente() != null) {
			x = em.merge(x);
		}
		em.persist(x);

		
	}

	@Override
	public void excluir(BuffetComponente x) {
		// TODO Auto-generated method stub

		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public BuffetComponente buscar(int cod) {

		return em.find(BuffetComponente.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BuffetComponente> buscarTodos() {

		String jpql = "SELECT x FROM Componente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}

}
