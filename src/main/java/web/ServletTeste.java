package web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Buffet;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
    private static final long serialVersionUID = 1L;
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
    	EntityManager em = emf.createEntityManager();

    	List<Buffet> lista = em.createQuery("SELECT u FROM Buffet u").getResultList();

    	for (Buffet b : lista) {
    		response.getWriter().append(b.getNome() + ": " + b.precoTotal() + "\n");
    	}
    	
    	em.close();
    	emf.close();
    }

}

