/**
 * 
 */
package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Guilherme Oliveira
 *
 */

@Entity
@Table(name="componentes")
public class Componente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codComponente;
	
	@Column(length=45)
	private String nome;
	
	private BigDecimal preco;
	
	@OneToMany(mappedBy="componente")
	private List<BuffetComponente> itens; 
	
	public Componente()
	{
		itens = new ArrayList<>();
	}
	

	public Componente(Integer codComponente, String nome, BigDecimal preco) {
		super();
		this.codComponente = codComponente;
		this.nome = nome;
		this.preco = preco;
		itens = new ArrayList<>();
	}	
	
	public Integer getCodComponente() {
		return codComponente;
	}


	public void setCodComponente(Integer codComponente) {
		this.codComponente = codComponente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public List<BuffetComponente> getItens() {
		return itens;
	}


	public void setItens(List<BuffetComponente> itens) {
		this.itens = itens;
	}

	public void addItem(BuffetComponente x) {
		itens.add(x);
		x.setComponente(this);
	}

	public void removeItem(BuffetComponente x) {
		itens.remove(x);
	}


	@Override
	public String toString() {
		return "Componente [codComponente=" + codComponente + ", nome=" + nome + ", preco=" + preco + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codComponente == null) ? 0 : codComponente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Componente other = (Componente) obj;
		if (codComponente == null) {
			if (other.codComponente != null)
				return false;
		} else if (!codComponente.equals(other.codComponente))
			return false;
		return true;
	}

	
}
