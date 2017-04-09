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
		name = "FaleConosco",
		urlPatterns =
		{
				"/faleconosco",
				"/enviarmensagem"
		},
		initParams =
		{
				@WebInitParam (name = "phNome", value = "Informe o nome"),
				@WebInitParam (name = "phTelefone", value = "Informe o telefone"),
				@WebInitParam (name = "phMensagem", value = "Escreva sua mensagem")
		}		
)
public class Falar extends HttpServlet
{
	private String phNome = "";
	private String phTelefone = "";
	private String phMensagem = "";
	
	@Override
	public void init (ServletConfig config) throws ServletException
	{
		super.init(config);
		phNome = config.getInitParameter("phNome");
		phTelefone = config.getInitParameter("phTelefone");
		phMensagem = config.getInitParameter("phMensagem");
	}
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html5>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Fale Conosco Servlet3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<fieldset>");
		out.println("<legend>Deixe sua mensagem</legend>");
		out.println("<label for =\"Nome\">Nome: </label>");
		out.println("<input type=\"text\" id=\"Nome\" placeholder=\""+phNome+"\" />");
		out.println("<br>");
		out.println("<label for =\"Telefone\">Telefone: </label>");
		out.println("<input type=\"text\" id=\"Telefone\" placeholder=\""+phTelefone+"\" />");
		out.println("<br>");
		out.println("<label for =\"Mensagem\"></label>");
		out.println("<textarea cols=60 id=\"Mensagem\" rows=\"10\" name=\"opiniao\" maxlength=\"500\" wrap=\"hard\" placeholder=\"" + phMensagem + "\"></textarea>");
		out.println("</fieldset>");	
		out.println("</body>");
		out.println("</html>");
	}

}
