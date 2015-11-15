package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AutomovelDAO;
import DAO.ReservaDAO;
import Factory.FactoryBD;
import TO.AutomovelTO;
import Model.Automovel;
import Model.Reserva;

@WebServlet("/addReserva.do")
public class ReservaCadastraControle extends HttpServlet {
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
	    String dataEmp = request.getParameter("dataEmp");
	    String horaEmp = request.getParameter("horaEmp");
	    String dataDev = request.getParameter("dataDev");
	    String horaDev = request.getParameter("horaDev"); 
	    String localEmp = request.getParameter("localEmp");
	    String localDev = request.getParameter("localDev");
	    String rTarifa = request.getParameter("rTarifa");
	    HttpSession se = request.getSession();
	    String cpf = (String)se.getAttribute("cpf");
	    String placa = (String)se.getAttribute("placa");
	    
	    Reserva reserva = new Reserva(cpf, placa, dataEmp, horaEmp, dataDev, horaDev, localEmp, localDev, rTarifa);
	
	    ReservaDAO reservaDAO = FactoryBD.getFactoryDB(2).getReservaDAO();
	    reservaDAO.efetuarReserva(reserva, "s");
	    AutomovelDAO automoveDAO = FactoryBD.getFactoryDB(2).getAutomovelDAO();
	    automoveDAO.alteraStatus( placa, 1 );
	    RequestDispatcher view = request.getRequestDispatcher("Pesquisa_de_veiculo.jsp");
	    view.forward(request, response);
   }  
   
}
