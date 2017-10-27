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
		name = "ContatoInicial",
		urlPatterns =
		{
				"/contatoInicial1",
				"/contatoInicial2"
		},
		initParams =
		{
				@WebInitParam (name = "phNome", value = "Informe o nome"),
				@WebInitParam (name = "phTelefone", value = "Informe o telefone"),
				@WebInitParam (name = "phEmail", value = "Informe o e-mail"),
				@WebInitParam (name = "phMensagem", value = "Escreva sua mensagem")
		}		
)
public class ContatarInicial extends HttpServlet
{
	private String phNome = "";
	private String phTelefone = "";
	private String phEmail = "";
	private String phMensagem = "";
	
	@Override
	public void init (ServletConfig config) throws ServletException
	{
		super.init(config);
		phNome = config.getInitParameter("phNome");
		phTelefone = config.getInitParameter("phTelefone");
		phEmail = config.getInitParameter("phEmail");
		phMensagem = config.getInitParameter("phMensagem");
	}
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html5>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Contato Inicial</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"adicionarVisitante\">");
		out.println("<fieldset>");
		out.println("<legend>Servlet Contato Inicial</legend>");
		out.println("<label for =\"Nome\">Nome: </label>");
		out.println("<input type=\"text\" id=\"Nome\" name=\"nome\" placeholder=\""+phNome+"\" />");
		out.println("<br>");
		out.println("<label for =\"Telefone\">Telefone: </label>");
		out.println("<input type=\"text\" id=\"Telefone\" name=\"telefone\" placeholder=\""+phTelefone+"\" />");
		out.println("<br>");
		out.println("<label for =\"Email\">E-mail: </label>");
		out.println("<input type=\"text\" id=\"Email\" name=\"email\" placeholder=\""+phEmail+"\" />");
		out.println("<br>");
		out.println("<label for =\"Mensagem\"></label>");
		out.println("<textarea cols=60 id=\"Mensagem\" name=\"mensagem\" rows=\"10\" maxlength=\"500\" wrap=\"hard\" placeholder=\"" + phMensagem + "\"></textarea>");
		out.println("<br />");
	    out.println("<input type=\"submit\" value=\"Enviar\" />");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
