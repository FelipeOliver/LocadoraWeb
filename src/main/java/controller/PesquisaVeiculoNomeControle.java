package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TO.AutomovelTO;
import DAO.AutomovelDAO;
import Factory.FactoryBD;

/**
 * Servlet implementation class SelecionarCervejasController
 */
@WebServlet("/pesquisaNome.do")
public class PesquisaVeiculoNomeControle extends HttpServlet {
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

		request.setCharacterEncoding("UTF-8");
		String nome = request.getParameter("tNome");
		AutomovelDAO automovelDAO = FactoryBD.getFactoryDB(2).getAutomovelDAO();
		AutomovelTO lista = automovelDAO.consultaPorNome(nome);
		request.setAttribute("listaDeMarcas", lista);

		RequestDispatcher view = request.getRequestDispatcher("Seleciona_veiculo.jsp");
		view.forward(request, response);

	}
}

