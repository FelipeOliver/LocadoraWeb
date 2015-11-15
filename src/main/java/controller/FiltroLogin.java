package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FiltroLogin implements Filter 
{
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException
	{
		chain.doFilter(req, res);
		String logado ="N";
		String tp_user = "F";
		String url = " http://enigmatic-beyond-6292.herokuapp.com/";
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession se = request.getSession();
		if(se.getAttribute("logado") != null)
			logado = se.getAttribute("logado").toString();
		//Tratamento do atributo de tipo de usuário
		if(se.getAttribute("tp_user") != null)
			tp_user = se.getAttribute("tp_user").toString();
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("PATH: " + request.getPathInfo());
		System.out.println("HOST: " + request.getRemoteHost().toString());
		System.out.println(url + "Cadastro_de_cliente.jsp");
		if(request.getRequestURL().toString().equals(url + "Cadastro_de_cliente.jsp")||request.getRequestURL().toString().equals(url + "Cadastro_de_veiculo.jsp")){
			System.out.println("Entrou na URL");
			if(tp_user.equals("F")){
				System.out.println("Entrou no Tipo de usuário");
				request.getRequestDispatcher("erro_login.jsp").forward(req, res);}}
		//Verificação se o usuário está logado.
		if(!request.getRequestURL().toString().equals(url + "selecao.json")){
		if(!logado.equals("S") )
		{
			//chain.doFilter(req, res);
			se.setAttribute("existe", logado);
			request.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}}
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

	public void destroy() {
		
	}
}
