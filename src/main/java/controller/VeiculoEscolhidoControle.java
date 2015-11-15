package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TO.AutomovelTO;
import DAO.AutomovelDAO;
import Factory.FactoryBD;

/**
 * Servlet implementation class SelecionarCervejasController
 */
@WebServlet("/veEscolhido.do")
public class VeiculoEscolhidoControle extends HttpServlet {
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
		String placa = request.getParameter("tPlaca");
		HttpSession se = request.getSession();
		se.setAttribute("placa", placa);
		
		RequestDispatcher view = request.getRequestDispatcher("Verifica_cliente.jsp");
		view.forward(request, response);

	}
}

