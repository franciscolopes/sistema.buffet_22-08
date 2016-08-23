package dao;

import java.util.List;

import dominio.Buffet;

public interface BuffetDao {


	public void inserirAtualizar(Buffet x);
	public void excluir(Buffet x);
	public Buffet buscar(int cod);
	public List<Buffet> buscarTodos();

	
}
