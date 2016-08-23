package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ComponenteDao;
import dominio.Componente;

public class ComponenteDaoImpl implements ComponenteDao {


	private EntityManager em;



	public ComponenteDaoImpl() {
		this.em = EM.getLocalEm();
	}

	
	@Override
	public void inserirAtualizar(Componente x) {
		// TODO Auto-generated method stub

		if (x.getCodComponente() != null) {
			x = em.merge(x);
		}
		em.persist(x);

		
	}

	@Override
	public void excluir(Componente x) {
		// TODO Auto-generated method stub

		x = em.merge(x);
		em.remove(x);

	}

	@Override
	public Componente buscar(int cod) {

		return em.find(Componente.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Componente> buscarTodos() {

		String jpql = "SELECT x FROM Componente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();

	}

}
