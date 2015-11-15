<%@page language="java" import="javax.servlet.http.HttpServletRequest"%>

<html>
<head>
<title>Alugue um carro</title>

<!-- ConfiguraÃ§Ã£o do Navegador CodificaÃ§Ã£o e tamanho de tela -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Classes de Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<% 
		   HttpSession se = request.getSession(); %>
<% String tpu = "";
			Object te = se.getAttribute("tp_user");
			if(te != null) tpu = te.toString(); %>
</head>
<body>

	<!-- Barra de Navegar Mais simples -->
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">BMC</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<!-- nav-pills -->
				<li role="presentation"><a href="login.jsp">Locadora</a></li>
				<li role="presentation" class="active"><a href="index.jsp">Pesquisar
						Carros</a></li>
				<li class="sup" role="presentation"><a
					href="Cadastro_de_cliente.jsp">Cadastro de Cliente</a></li>
				<li class="sup"><a href="Cadastro_de_veiculo.jsp">Cadastro
						de Veículos</a></li>
				<li class="sup" role="presentation"><a href="#">Relatórios</a>
				</li>
				<% Object tt = se.getAttribute("nome");
	                    if(tt != null){%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Usuário<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-header"><%=tt.toString()%></li>
						<li role="separator" class="divider"></li>
						<li><a href="login.jsp">Logout</a></li>
					</ul></li>
				<li>
					<p class="navbar-text navbar-right">
						</a>
					</p>
				</li>
				<%}%>
			</ul>
		</div>
	</div>

	<div class="panel panel-default ">
		<!--col-md-8 col-sm-8 col-xs-8  col-md-offset-2 col-sm-offset-2 col-xs-offset-2 -->
		<div class="panel-heading">
			<div class="panel-heading">
				<h3 class="panel-title">Pesquisa de aluguel de Carros</h3>
			</div>
		</div>
		<div class="panel-body">
			<form>
				<label>Grupo</label> <select class="form-control"> <
					<option value="A-Econômico">A - Econômico</option>
					<option value="C-Econômico com ar">C - Econômico com ar</option>
					<option value="F-Intermediário">F - Intermediário</option>
					<option value="G-Intermediário Wagon Especial">G -
						Intermediário Wagon Especial</option>
					<option value="H-Executivo">H - Executivo</option>
					<option value="I-Utilitário">I - Utilitário</option>
					<option value="K-Executivo de luxo">K - Executivo de luxo</option>
					<option value="M-Intermediário Wagon">M - Intermediário
						Wagon</option>
					<option value="N-Pick-up">N - Pick-up</option>
					<option value="P-4X4 Especial">P - 4X4 Especial</option>
					<option value="R-Minivan">R - Minivan</option>
					<option value="U-Furgão">U - Furgão</option>
					<option value="Y-Blindado">Y - Blindado</option>
				</select>

				<div class="">
					<p>
						<b><br>Acessórios</b>
					</p>
					<input type="checkbox" /> Navegador de GPS <input type="checkbox" />
					Cadeira de Bebê
				</div>
				<br>

				<div class="panel panel-default col-md-12 col-sm-12 col-xs-12">
					<div class="panel-heading">
						<h3 class="panel-title">Automóvel</h3>
					</div>
					<div class="panel-body">
						<label>Chassi</label><input type="text" id="chassi"
							class="form-control" placeholder="Chassi"></br> <label>Placa</label><input
							type="text" id="placa" class="form-control" placeholder="Placa"></br>
						<label>Cidade</label><input type="text" id="cidade"
							class="form-control" placeholder="Cidade"></br> <label>KM</label><input
							type="text" id="km" class="form-control" placeholder="KM"></br>
						<label>Estado</label> <select class="form-control" id="estado">
							<option>AC</option>
							<option>AL</option>
							<option>AP</option>
							<option>AM</option>
							<option>BA</option>
							<option>CE</option>
							<option>DF</option>
							<option>ES</option>
							<option>GO</option>
							<option>MA</option>
							<option>MT</option>
							<option>MS</option>
							<option>MG</option>
							<option>PA</option>
							<option>PB</option>
							<option>PR</option>
							<option>PE</option>
							<option>PI</option>
							<option>RJ</option>
							<option>RN</option>
							<option>RS</option>
							<option>RO</option>
							<option>RR</option>
							<option>SC</option>
							<option>SP</option>
							<option>SE</option>
							<option>TO</option>
						</select></br> <label>Modelo</label><input type="text" id="modelo"
							class="form-control" placeholder="Modelo"></br> <label>Fabricante</label><input
							type="text" id="fabricante" class="form-control"
							placeholder="Fabricante"></br>
					</div>
				</div>
			</form>

		</div>
	</div>
	<script src="jQuery/jQuery-2.1.3.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery.js"></script>
	<script src="js/jQuery-2.1.3.min.js"></script>
</body>
<script type="text/javascript">
		     function t(){
	            var tp = "<%=tpu %>";
	        	if(tp == 'F')
	        	{
	        		var o = document.getElementsByClassName("sup");
	        		i = 0;
	        		while(i < o.length)
	        		{
	        			o[i].style.display= 'none';
	        			i++;	
	        		}
	        	}
            }
		     t();
        </script>
</html>
