package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class SelecionarCervejasController
 */
@WebServlet("/cliEscolhido.do")
public class ClienteEscolhidoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//request.setCharacterEncoding("UTF-8");
		String cpf = request.getParameter("tCpf");
		HttpSession se = request.getSession();
		se.setAttribute("cpf", cpf);
		
		RequestDispatcher view = request.getRequestDispatcher("Dados_da_reserva.jsp");
		view.forward(request, response);

	}
}


