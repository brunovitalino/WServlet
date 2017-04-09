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
		name = "NosContate",
		urlPatterns =
		{
				"/contato"
		},
		initParams =
		{
				@WebInitParam (name = "phNome", value = "Informe o nome"),
				@WebInitParam (name = "phTelefone", value = "Informe o telefone")
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
		out.println("<body>");
		out.println("<form action=\"adicionaContato\">");
		out.println("<fieldset>");
		out.println("<legend>Deixe sua mensagem</legend>");
		out.println("<label for=\"Nome\">Nome: </label>");
		out.println("<input type=\"text\" id=\"Nome\" name=\"nome\" placeholder=\""+configuracao.getInitParameter("phNome")+"\" />");
		out.println("<br />");
		out.println("<label for=\"Telefone\">Telefone: </label>");
		out.println("<input type=\"text\" id=\"Telefone\" name=\"nome\" placeholder=\""+configuracao.getInitParameter("phTelefone")+"\" />");
		out.println("<br />");
	    out.println("<input type=\"submit\" value=\"Gravar\" />");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
