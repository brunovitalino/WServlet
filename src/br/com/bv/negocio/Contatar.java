package br.com.bv.negocio;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
(
		name = "Contato",
		urlPatterns =
		{
				"/contato"
		},
		initParams =
		{
				@WebInitParam (name = "phNome", value = "Informe o nome"),
				@WebInitParam (name = "phTelefone", value = "Informe o telefone"),
				@WebInitParam (name = "phEmail", value = "Informe o E-mail"),
				@WebInitParam (name = "phMensagem", value = "Escreva sua mensagem")
		}		
)
public class Contatar extends HttpServlet
{
	private ServletConfig configuracao;
	
	@Override
	public void init (ServletConfig config) throws ServletException
	{
		super.init(config);
		configuracao = config;
	}
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Contato</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"adicionarVisitante\">");
		out.println("<fieldset>");
		out.println("<legend>Servlet Contato</legend>");
		out.println("<label for=\"Nome\">Nome: </label>");
		out.println("<input type=\"text\" id=\"Nome\" name=\"nome\" placeholder=\""+configuracao.getInitParameter("phNome")+"\" />");
		out.println("<br />");
		out.println("<label for=\"Telefone\">Telefone: </label>");
		out.println("<input type=\"text\" id=\"Telefone\" name=\"telefone\" placeholder=\""+configuracao.getInitParameter("phTelefone")+"\" />");
		out.println("<br />");
		out.println("<label for =\"Email\">E-mail: </label>");
		out.println("<input type=\"text\" id=\"Email\" name=\"email\", placeholder=\""+configuracao.getInitParameter("phEmail")+"\" />");
		out.println("<br>");
		out.println("<label for =\"Mensagem\"></label>");
		out.println("<textarea cols=60 id=\"Mensagem\" rows=\"10\" name=\"mensagem\" maxlength=\"500\" wrap=\"hard\" placeholder=\"" + configuracao.getInitParameter("phMensagem") + "\"></textarea>");
		out.println("<br />");
	    out.println("<input type=\"submit\" value=\"Enviar\" />");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
