package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BuffetDao;
import dominio.Buffet;

public class BuffetDaoImpl implements BuffetDao {


	private EntityManager em;



	public BuffetDaoImpl() {
		this.em = EM.getLocalEm();
	}

	
	@Override
	public void inserirAtualizar(Buffet x) {
		// TODO Auto-generated method stub

		if (x.getCodBuffet() != null) {
			x = em.merge(x);
		}
		em.persist(x);

		
	}

	@Override
	public void excluir(Buffet x) {
		// TODO Auto-generated method stub

		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Buffet buscar(int cod) {

		return em.find(Buffet.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Buffet> buscarTodos() {

		String jpql = "SELECT x FROM Buffet x";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}

}
