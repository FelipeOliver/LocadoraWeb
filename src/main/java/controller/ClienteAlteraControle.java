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
import Model.Cliente;

@WebServlet("/altClie.do")
public class ClienteAlteraControle extends HttpServlet {
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
      String nome = request.getParameter("tNome");
      String cpf = request.getParameter("tCpf");
      String rg = request.getParameter("tRg");
      String telefone = request.getParameter("tTelefone");
      String email = request.getParameter("tEmail"); 
      String dtNascimento = request.getParameter("dtNasc");
      String sexo = request.getParameter("rSexo");
      String numRegistro = request.getParameter("numRegistro");
      String estado = request.getParameter("est");
      String validadeCNH = request.getParameter("valCnh");
      String dataEmissaoCNH = request.getParameter("dtCnh");
      
      Cliente cliente = new Cliente(nome, cpf, rg, telefone, email, dtNascimento, sexo, numRegistro, estado, validadeCNH,dataEmissaoCNH);
	
      ClienteDAO clienteDAO = FactoryBD.getFactoryDB(2).getClienteDAO();
      clienteDAO.alteraCliente(cliente);
      RequestDispatcher view = request.getRequestDispatcher("Cadastro_de_cliente.jsp");
      view.forward(request, response);
   }  
   
}

