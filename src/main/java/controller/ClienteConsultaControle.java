package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DAO.ClienteDAO;
import Factory.FactoryBD;
import Model.Cliente;

@WebServlet("/conClie.do")
public class ClienteConsultaControle extends HttpServlet {
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
      System.out.println(cpf);
      Cliente cliente = clienteDAO.consultaCliente(cpf);
      
      response.setContentType("applicaton/json");
      //response.setCharacterEnconding("utf-8");
      
      PrintWriter  out = response.getWriter();
      
      JSONObject json = new JSONObject();
      try{
    	  json.put("nome", cliente.getNome());
    	  json.put("cpf", cliente.getCpf());
    	  json.put("rg", cliente.getRg());
    	  json.put("telefone", cliente.getTelefone());
    	  json.put("email", cliente.getEmail());
    	  json.put("nascimento", cliente.getDtNascimento());
    	  json.put("sexo", cliente.getSexo());
    	  json.put("numRegistro", cliente.getNumRegistro());
    	  json.put("estado", cliente.getEstado());
    	  json.put("valCnh", cliente.getValidadeCNH());
    	  json.put("dtCnh", cliente.getDataEmissaoCNH());
    	  //json.addProperty("sucesses", true);
    	  //json.put("nome", cliente.getNome());
    	  //json.put("nome", cliente.getNome());
      }catch(Exception e){
    	 
      }
      out.print(json.toString());
      System.out.println(json.toString());
   }  
   
}
