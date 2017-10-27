package br.com.bv.negocio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bv.dados.VisitanteDao;

@WebServlet("/adicionarVisitante")
public class AdicionarVisitante extends HttpServlet
{
	// O ideal seria utilizar o metodo doPost() ou entao incluir o atributo method=POST dentro da tag form da pagina requisitante,
	// dessa forma os parametros nao seriam passados atraves da URL mas sim no corpo do protocolo HTTP
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Informa que a sequencia de bytes que procuramos no pacote http eh a de HTML
		response.setContentType("text/html");	
		// Busca o writer
		PrintWriter out = response.getWriter();

		// Busca os parametros no request
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");
		
		// Monta um objeto visitante
		VisitanteDao visitante = new VisitanteDao();
        visitante.setNome(nome);
        visitante.setTelefone(telefone);
        visitante.setEmail(email);
        visitante.setMensagem(mensagem);

        // Pega as informacoes que o visitante forneceu e adiciona no banco de dados
		//dao.adicionar("Bruno", "123", "bv@hot.com", "deu certo?");
		//dao.adicionar(request.getParameter("nome"), request.getParameter("telefone"), request.getParameter("email"), request.getParameter("mensagem"));
        VisitanteDao dao = new VisitanteDao();
        dao.adicionar(visitante.getNome(), visitante.getTelefone(), visitante.getEmail(), visitante.getMensagem());
		
        out.println("<!DOCTYPE html5>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Adicionando Contato</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
        out.println("Visitante " + visitante.getNome() + " sua mensagem foi enviada com sucesso!");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
