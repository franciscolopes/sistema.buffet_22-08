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
@Table(name="buffets")
public class Buffet implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codBuffet;
	
	private String nome;
	
	private BigDecimal precoBasico;
	
	@OneToMany(mappedBy="buffet")
	private List<BuffetComponente> itens; 
	
	public Buffet()
	{
		itens = new ArrayList<>();
	}
	
	public Buffet(Integer codBuffet, String nome, BigDecimal precoBasico)
	{
		this.codBuffet = codBuffet;
		this.nome = nome;
		this.precoBasico = precoBasico;
		itens = new ArrayList<>();
	}

	
	public Integer getCodBuffet() {
		return codBuffet;
	}

	public void setCodBuffet(Integer codBuffet) {
		this.codBuffet = codBuffet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoBasico() {
		return precoBasico;
	}

	public void setPrecoBasico(BigDecimal precoBasico) {
		this.precoBasico = precoBasico;
	}

	public List<BuffetComponente> getItens() {
		return itens;
	}

	public void setItens(List<BuffetComponente> itens) {
		this.itens = itens;
	}

	/**
	 * @param buffetComponente
	 */
	public void addBuffetToBuffeteComponente(BuffetComponente b)
	{
		itens.add(b);
		b.setBuffet(this);
	}
	
	/**
	 * @param buffetComponente
	 */
	public void removeBuffetComponente(BuffetComponente buffetComponente)
	{
		this.itens.remove(buffetComponente);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codBuffet == null) ? 0 : codBuffet.hashCode());
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
		Buffet other = (Buffet) obj;
		if (codBuffet == null) {
			if (other.codBuffet != null)
				return false;
		} else if (!codBuffet.equals(other.codBuffet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Buffet [codBuffet=" + codBuffet + ", nome=" + nome + ", precoBasico=" + precoBasico + "]";
	}

	/**
	 * @return the total
	 */	
	public BigDecimal precoTotal() {
		BigDecimal total = precoBasico;
		for(BuffetComponente bc : itens) {
			BigDecimal precoComDesconto = bc.getComponente().getPreco().subtract(bc.getDesconto());
			total = total.add(precoComDesconto);
		}
		return total;
	}
	
	/**
	 * @return the maisCaro
	 */	
	public Componente componenteMaisCaro()
	{
		Componente maisCaro = itens.get(0).getComponente();
						
		for(int i=1; i<itens.size(); i++) {
			Componente c = itens.get(i).getComponente();
			if (c.getPreco().compareTo(maisCaro.getPreco()) > 0) {
				maisCaro = c;
			}
		}
		
		return maisCaro;
	}

	
}
