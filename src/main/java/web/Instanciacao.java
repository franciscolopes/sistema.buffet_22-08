package web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Buffet;
import dominio.BuffetComponente;
import dominio.Componente;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Buffet b1 = new Buffet(null, "Casamento", new BigDecimal("10000.00"));
		Buffet b2 = new Buffet(null, "Aniversário", new BigDecimal("4000.00"));
		
		Componente c1 = new Componente(null, "Bolo", new BigDecimal("300.00"));
		Componente c2 = new Componente(null, "Docinho", new BigDecimal("400.00"));
		Componente c3 = new Componente(null, "Cerveja", new BigDecimal("600.00"));
		
		BuffetComponente bc1 = new BuffetComponente(null, new BigDecimal("50.00"), b1, c1);
		BuffetComponente bc2 = new BuffetComponente(null, new BigDecimal("100.00"), b2, c1);
		BuffetComponente bc3 = new BuffetComponente(null, new BigDecimal("0.00"), b2, c2);
		BuffetComponente bc4 = new BuffetComponente(null, new BigDecimal("50.00"), b1, c3);
		BuffetComponente bc5 = new BuffetComponente(null, new BigDecimal("0.00"), b2, c3);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(bc1);
		em.persist(bc2);
		em.persist(bc3);
		em.persist(bc4);
		em.persist(bc5);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		response.getWriter().append("Fim da instanciação");

	}
}


