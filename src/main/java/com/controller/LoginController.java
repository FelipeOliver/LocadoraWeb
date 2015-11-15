package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Factory.FactoryBD;
import Model.User;

import com.Model.MD5;

import static java.lang.System.out;

@WebServlet("/loginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		
		String userName = request.getParameter("inputLogin");
		String password = request.getParameter("inputSenha");
		MD5 md = new MD5();
		out.println("User: " + userName);
		out.println("Senha: "+ md.MD5Encode(password));
		UserDAO dao = FactoryBD.getFactoryDB(2).getUserDAO();
		boolean existe = false;
		try
		{
			existe = dao.verificarUser(userName, md.MD5Encode(password));
		}
		catch(Exception e)
		{
			out.println("Erro ao validar usuário e senha");
		}
		if(existe)	
		{
			//response.encodeRedirectURL("index.html");/*RedirectUrl("index.html");*/
			String nome = "";
			String tp = "";
			try{
				dao = FactoryBD.getFactoryDB(2).getUserDAO();
				User user = dao.getUser(userName, md.MD5Encode(password));
				nome = user.getNome();
				tp = user.getTp_user();
			}catch(Exception e){
				e.printStackTrace();
			} 
			HttpSession se = request.getSession();
			se.setAttribute("logado", "S");
			se.setAttribute("nome", nome);
			se.setAttribute("tp_user", tp);
			out.println("Nome: " + nome);
			out.println("tp_user: "+ tp);
			request.getRequestDispatcher("Pesquisa_de_veiculo.jsp").forward(request, response);
		}
		else
		{
			//request.setAttribute("", arg1);
			request.setAttribute("logado", "N");
			request.setAttribute("existe", "1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
	