<%@page import="java.util.ArrayList"%>
<%@page import="TO.AutomovelTO, Model.Automovel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleciona Veículo</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>

</head>



<body>
	<form name="Alugar">
		<div class="bs-example" data-example-id="bordered-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<!-- <th>Modelo</th> -->
						<th>Placa</th>
						<th>Veículo</th>
						<th>Categoria</th>
						<th>Acessório A</th>
						<th>Acessório B</th>
					</tr>
				</thead>
				<tbody>
					<%
					AutomovelTO to = (AutomovelTO) request.getAttribute("listaDeMarcas");
					ArrayList<Automovel> lista = to.getLista();

					for (Automovel automovel : lista) {

						out.println("<tr>");
						out.println("<th scope=\"row\"><img src=\"" + automovel.getImagem() + "\"\" width=\"230px\" height=\"120px\"></th>");
						out.println("<td>" + automovel.getPlaca() + "</td>");
						out.println("<td>" + automovel.getModelo() + "</td>");
						out.println("<td>" + automovel.getGrupo() + "</td>");
						out.println("<td>" + automovel.getAcessorioA() + "</td>");
						out.println("<td>" + automovel.getAcessorioB() + "</td>");
						out.println("</tr>");
					}
				%>
				</tbody>
			</table>
		</div>
		<p>
			<input type="text" class="form-control" name="tPlaca" id="placa"
				placeholder="Insira a placa do veículo que será alugado">
		</p>
	</form>

	<p>
		<button class="btn btn-primary" onClick="alugar()">Alugar</button>
	</p>
</body>
<script type="text/javascript">
		function alugar() {
			var form = document.forms["Alugar"];
			form.action = "veEscolhido.do";
			form.submit();
		}
		$(document).ready(function(){	
			$("#placa").mask("aaa-9999");
		});
	</script>

</html>