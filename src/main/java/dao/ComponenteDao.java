package dao;

import java.util.List;

import dominio.Componente;

public interface ComponenteDao {


	public void inserirAtualizar(Componente x);
	public void excluir(Componente x);
	public Componente buscar(int cod);
	public List<Componente> buscarTodos();

	
}
