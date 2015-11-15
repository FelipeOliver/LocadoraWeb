package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AutomovelDAO;
import Factory.FactoryBD;

/**
 * Servlet implementation class SelecionarCervejasController
 */
@WebServlet("/pesquisaGrupo.do")
public class PesquisaVeiculoGrupoControle extends HttpServlet {
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
		String categoria = request.getParameter("categoria");
		String acessorioA = request.getParameter("acessorioA");
		String acessorioB = request.getParameter("acessorioB");
		AutomovelDAO automovelDAO = FactoryBD.getFactoryDB(1).getAutomovelDAO();
		//AutomovelTO lista = automovelDAO.consultaPorCategoria(categoria, acessorioA, acessorioB);
		//request.setAttribute("listaDeMarcas", lista);

		RequestDispatcher view = request.getRequestDispatcher("Seleciona_veiculo.jsp");
		view.forward(request, response);

	}
}
