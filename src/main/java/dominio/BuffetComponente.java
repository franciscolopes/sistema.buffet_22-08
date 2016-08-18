/**
 * 
 */
package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Guilherme Oliveira
 *
 */
@Entity
@Table(name="buffet_componentes")
public class BuffetComponente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codBuffetComponente;
	
	private BigDecimal desconto;
	
	@ManyToOne
	@JoinColumn(name="buffet")
	private Buffet buffet;
	
	@ManyToOne
	@JoinColumn(name="componente")
	private Componente componente;
	
	public BuffetComponente(){
	}
	

	public BuffetComponente(Integer codBuffetComponente, BigDecimal desconto, Buffet buffet, Componente componente) {
		super();
		this.codBuffetComponente = codBuffetComponente;
		this.desconto = desconto;
		this.buffet = buffet;
		this.componente = componente;
	}
	
	public Integer getCodBuffetComponente() {
		return codBuffetComponente;
	}


	public void setCodBuffetComponente(Integer codBuffetComponente) {
		this.codBuffetComponente = codBuffetComponente;
	}


	public BigDecimal getDesconto() {
		return desconto;
	}


	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}


	public Buffet getBuffet() {
		return buffet;
	}


	public void setBuffet(Buffet buffet) {
		this.buffet = buffet;
	}


	public Componente getComponente() {
		return componente;
	}


	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	@Override
	public String toString() {
		return "BuffetComponente [codBuffetComponente=" + codBuffetComponente + ", desconto=" + desconto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codBuffetComponente == null) ? 0 : codBuffetComponente.hashCode());
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
		BuffetComponente other = (BuffetComponente) obj;
		if (codBuffetComponente == null) {
			if (other.codBuffetComponente != null)
				return false;
		} else if (!codBuffetComponente.equals(other.codBuffetComponente))
			return false;
		return true;
	}

}