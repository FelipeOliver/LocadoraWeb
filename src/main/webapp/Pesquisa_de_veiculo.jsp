<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Pesquisa de veículo</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<% 
		   HttpSession se = request.getSession(); %>
<% String tpu = "";
			Object te = se.getAttribute("tp_user");
			if(te != null) tpu = te.toString(); %>
</head>

<script type="text/javascript">
		function Nome() {
			var form = document.forms["Pesquisa_de_veiculo"];
			form.action = "pesquisaNome.do";
			form.submit();
		}
		
		function Grupo() {
			var form = document.forms["Pesquisa_de_veiculo"];
			form.action = "pesquisaGrupo.do";
			form.submit();
		}
	</script>

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
			<a class="navbar-brand" href="Pesquisa_de_veiculo.jsp">BMC</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<!-- nav-pills -->
				<li role="presentation"><a href="login.jsp">Locadora</a></li>
				<li class="sup" role="presentation"><a
					href="Cadastro_de_cliente.jsp">Cadastro de Cliente</a></li>
				<li class="sup"><a href="Cadastro_de_veiculo.jsp">Cadastro
						de Veículos</a></li>
				<li class="sup" role="presentation"><a href="BotaoRelatorio.jsp">Relatórios</a>
				</li>
				<li class="sup"><a href="Pagamento.jsp">Devolucao</a></li>
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
	<div class="panel panel-default col-lg-4 col-lg-offset-4">
		<h2 align="center">Pesquisa de veículo</h2>
		<hr>
		<div class="panel-body">
			<form name="Pesquisa_de_veiculo">
				<p>
					<select class="form-control" name="categoria">
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
						<option value="Y-Blindado">Y-Blindado</option>
					</select>
				</p>
				<p>
					<b>Acessórios</b>
				</p>
				<p>
					<input type="checkbox" name="acessorioA" value="Navegador GPS" /><b>Navegador
						GPS</b> <input type="checkbox" name="acessorioB"
						value="Cadeira de bebê" /><b>Cadeira de bebê</b>
				</p>
				<p>
					<button name="bGrupo" class="btn btn-primary" onClick="Grupo()">Pesquisar
						por grupo</button>
				</p>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<p>
					<b>Modelo</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tNome"
						placeholder="Nome" size="45" maxlength="45" />
				</p>
				<p>
					<button name="bNome" class="btn btn-primary" onClick="Nome()">Pesquisar
						por nome</button>
				</p>
			</form>
		</div>
	</div>
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