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
import Model.Automovel;

@WebServlet("/altAuto.do")
public class AutomovelAlteraControle extends HttpServlet {
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
      String chassi = request.getParameter("tChassi");
      String placa = request.getParameter("tPlaca");
      String cidade = request.getParameter("tCidade");
      double km = Double.parseDouble(request.getParameter("tKm"));
      double valorKm = Double.parseDouble(request.getParameter("tValorKm"));
      String estado = request.getParameter("est");
      String modelo = request.getParameter("tModelo");
      String fabricante = request.getParameter("tFabricante");
      String grupo = request.getParameter("veiculo");
      String acessorioA = request.getParameter("navGps");
      String acessorioB = request.getParameter("cadBebe");
      String imagem = request.getParameter("tImagem");
      
      Automovel automovel = new Automovel(chassi, placa, cidade, km, valorKm, estado, modelo, fabricante, grupo, acessorioA, acessorioB, imagem);
	
      AutomovelDAO automovelDAO = FactoryBD.getFactoryDB(2).getAutomovelDAO();
      automovelDAO.alteraAutomovel(automovel);
      RequestDispatcher view = request.getRequestDispatcher("Cadastro_de_veiculo.jsp");
      view.forward(request, response);
   }  
   
}

