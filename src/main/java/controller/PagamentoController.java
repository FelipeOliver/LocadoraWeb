package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import DAO.AutomovelDAO;
import DAO.ReservaDAO;
import Factory.FactoryBD;
import Model.Pagamento;
import Model.Reserva;
 
@WebServlet("/pagamento.do")


public class PagamentoController extends HttpServlet{
	
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
				request.setCharacterEncoding("UTF-8");
				
				String cpf = request.getParameter("cpf");
				
				String placa = request.getParameter("placa");
				String dDevolucao = request.getParameter("dDevolucao");

				String agencia = request.getParameter("agencia");
				
				double nkm = Double.parseDouble(request.getParameter("nkm"));
				String tkm = request.getParameter("tkm");
								
				String valor = "" ;
				ReservaDAO reservaDAO = FactoryBD.getFactoryDB(2).getReservaDAO();
				Reserva reserva = reservaDAO.consultarReserva(cpf);
				//Mudei o KM para 10		
				Pagamento pagamento = new Pagamento(reserva,nkm,agencia);
				System.out.println(tkm);
				if(tkm != null){
					if(tkm.equals("controlado")){
				
					valor = "" + pagamento.calculoControlado();
					}
				}else{valor = "" + pagamento.calculoLivre();}
					
				valor = ""+72.35;
				
				
				reservaDAO.alteraStatus(reserva.getPlaca(), "n");
				AutomovelDAO automovelDAO = FactoryBD.getFactoryDB(2).getAutomovelDAO();
			    automovelDAO.alteraStatus(reserva.getPlaca(), 0);
				//request.setAttribute("valor", valor);  
				//request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
			
				 PrintWriter  out = response.getWriter();
			      
			      JSONObject json = new JSONObject();
			      try{
			    	  json.put("valor", valor);
			    	  
			      }catch(Exception e){
			    	 
			      }
			      out.print(json.toString());
			      System.out.println(json.toString());
				
				
			}
			
			
			
			
	
}
