package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Factory.FactoryBD;
import DAO.DebitoDAO;
import Model.Debito;

@WebServlet("/debito.do")


public class DebitoControle extends HttpServlet {

	 private static final long serialVersionUID = 1L;
		private static final String reserva = null;

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
				
				
				String banco = request.getParameter("banco");
				
				String agencia = request.getParameter("agencia");

				String cConta = request.getParameter("cConta");

				String nTitular = request.getParameter("nTitular");
				
				String nCpf = request.getParameter("nCpf");
				
			
				
				
				DebitoDAO debitoDAO = FactoryBD.getFactoryDB(2).getDebitoDAO();
				Debito debito = new Debito(banco,agencia,cConta,nTitular,nCpf);
				
				debitoDAO.insereDados(debito);
				request.setAttribute("variavelRequestMsgErro", "Pagamento Efetuado");  
				RequestDispatcher view = request.getRequestDispatcher("Processado.jsp");
				view.forward(request, response);

			}}
