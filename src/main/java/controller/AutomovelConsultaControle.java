package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DAO.AutomovelDAO;
import Factory.FactoryBD;
import Model.Automovel;

@WebServlet("/conAuto.do")
public class AutomovelConsultaControle extends HttpServlet {
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
      String placa = request.getParameter("tPlaca");
      
      
      AutomovelDAO automovelDAO = FactoryBD.getFactoryDB(2).getAutomovelDAO();
      Automovel automovel = automovelDAO.consultaAutomovel(placa);
      
      response.setContentType("applicaton/json");
      //response.setCharacterEnconding("utf-8");
      
      PrintWriter  out = response.getWriter();
      
      JSONObject json = new JSONObject();
      try{
    	  json.put("grupo", automovel.getGrupo());
    	  json.put("acessorioA", automovel.getAcessorioA());
    	  json.put("acessorioB", automovel.getAcessorioB());
    	  json.put("chassi", automovel.getChassi());
    	  json.put("placa", automovel.getPlaca());
    	  json.put("cidade", automovel.getCidade());
    	  json.put("km", automovel.getKm());
    	  json.put("estado", automovel.getEstado());
    	  json.put("modelo", automovel.getModelo());
    	  json.put("fabricante", automovel.getFabricante());
    	  json.put("valorKm", automovel.getValorKm());
      }catch(Exception e){
    	 
      }
      out.print(json.toString());
      System.out.println(json.toString());
   }  
   
}
