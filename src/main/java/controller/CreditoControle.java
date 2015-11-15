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
import DAO.CreditoDAO;
import Model.Credito;


@WebServlet("/credito.do")


public class CreditoControle extends HttpServlet{
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
			
			
			String bandeira = request.getParameter("bandeira");

			String nCartao = request.getParameter("nCartao");

			String cSeguranca = request.getParameter("cSeguranca");
			
			String nTitular = request.getParameter("nTitular");
			
			String dVencimento = request.getParameter("dVencimento");
			
			
			String nParcelas = request.getParameter("nParcelas");
			
			
			
			CreditoDAO creditoDAO = FactoryBD.getFactoryDB(2).getCreditoDAO();
			Credito credito = new Credito(bandeira,nCartao,cSeguranca,nTitular,dVencimento,nParcelas);
			
			creditoDAO.insereDados(credito);

			request.setAttribute("variavelRequestMsgErro", "Pagamento Efetuado");  
			response.sendRedirect("Processado.jsp");
			



			
			

	      
	   }
}
