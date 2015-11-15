package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Factory.FactoryBD;
import Model.MD5;
import static java.lang.System.out;

@WebServlet("/loginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		
		String userName = request.getParameter("inputLogin");
		String password = request.getParameter("inputSenha");
		String tp_user="";
		MD5 md = new MD5();
		out.println("User: " + userName);
		out.println("Senha: "+ md.MD5Encode(password));
		boolean existe = false;
		try
		{
			UserDAO dao = FactoryBD.getFactoryDB(1).getUserDAO();
			existe = dao.verificarUser(userName, md.MD5Encode(password));
			tp_user = dao.getUser(userName, md.MD5Encode(password)).getTp_user();
		}
		catch(Exception e)
		{
			out.println("Erro ao validar usuário e senha");
		}
		if(existe)
		{
			//response.encodeRedirectURL("index.html");/*RedirectUrl("index.html");*/
			HttpSession se = request.getSession();
			se.setAttribute("nome", "Felipe");
			se.setAttribute("logado", "S");
			se.setAttribute("tp_user",tp_user);
			request.getRequestDispatcher("Pesquisa_de_veiculo.jsp").forward(request, response);  
		}
		else
		{
			//request.setAttribute("", arg1);
			request.setAttribute("existe", "1");
			request.setAttribute("logado", "N");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	

}
