package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import Factory.FactoryBD;

@WebServlet("/removeClie.do")
public class ClienteExcluiControle extends HttpServlet {
   private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
      String cpf = request.getParameter("tCpf");
      
      ClienteDAO clienteDAO = FactoryBD.getFactoryDB(2).getClienteDAO();
      clienteDAO.excluiCliente(cpf);
      RequestDispatcher view = request.getRequestDispatcher("Cadastro_de_cliente.jsp");
      view.forward(request, response);
   }
}
