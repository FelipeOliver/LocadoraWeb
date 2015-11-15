<%@page import="java.util.ArrayList"%>
<%@page import="TO.ReservaTO, Model.Reserva"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Relatório</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>

</head>



<body>
	<form name="Relatorio">
		<div class="bs-example" data-example-id="bordered-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						
						<!-- <th>Modelo</th> -->
						<th>Placa</th>
						<th>Cpf</th>
						<th>Data de emprestimo</th>
						<th>Local de emprestimo</th>
						<th>Tipo de km</th>
					</tr>
				</thead>
				<tbody>
					<%
					ReservaTO to = (ReservaTO) request.getAttribute("listaDeMarcas");
					ArrayList<Reserva> lista = to.getLista();

					for (Reserva reserva : lista) {

						out.println("<tr>");
						out.println("<th>" + reserva.getPlaca() + "</th>");
						out.println("<td>" + reserva.getCpf() + "</td>");
						out.println("<td>" + reserva.getDtEmprestimo() + "</td>");
						out.println("<td>" + reserva.getLocalEmprestimo() + "</td>");
						out.println("<td>" + reserva.getTipoKm() + "</td>");
						out.println("</tr>");
					}
				%>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>