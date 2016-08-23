package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Buffet;
import dominio.BuffetComponente;
import dominio.Componente;
import servico.BuffetComponenteServico;
import servico.BuffetServico;
import servico.ComponenteServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//try{
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


		BuffetServico bs = new BuffetServico();
		ComponenteServico cs = new ComponenteServico();
		BuffetComponenteServico bcs = new BuffetComponenteServico();
		
		bs.inserirAtualizar(b1);
		bs.inserirAtualizar(b2);

		cs.inserirAtualizar(c1);
		
		bcs.inserirAtualizar(bc1);
		bcs.inserirAtualizar(bc2);

		
		response.getWriter().append("Fim da instanciação");

	//}

		//catch (ParseException e) {
		//	System.out.println("Erro: " + e.getMessage());
		//}

	
	
	}
}
	
	



