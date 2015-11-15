package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DAO.AutomovelDAO;
import Factory.FactoryBD;
import Model.Automovel;
import Util.JSonFacade;

@WebServlet("/selecao.json")
public class retornoVeiculos extends HttpServlet{
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrou aqui");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		System.out.println("Passou aqui");
		url = url.substring(0, url.lastIndexOf('/'));
		String estado = request.getParameter("estado");
		System.out.println("Passou aqui 2");
		ArrayList<Automovel> lista =  FactoryBD.getFactoryDB(2).getAutomovelDAO().consultaAutomovelEstado(estado);
		PrintWriter out = response.getWriter();
		//for(Automovel automovel:lista){
		//}
		out.println(JSonFacade.listToJSon(lista));
		System.out.println(JSonFacade.listToJSon(lista));	
		//String estado = request.getParameter("estado").toString();
	   }
}
