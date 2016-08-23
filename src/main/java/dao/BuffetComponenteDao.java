package dao;

import java.util.List;

import dominio.BuffetComponente;

public interface BuffetComponenteDao {


	public void inserirAtualizar(BuffetComponente x);
	public void excluir(BuffetComponente x);
	public BuffetComponente buscar(int cod);
	public List<BuffetComponente> buscarTodos();

	
}
