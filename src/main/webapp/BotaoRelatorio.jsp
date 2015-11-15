<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Busca relatorio</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<% 
		   HttpSession se = request.getSession(); %>
<% String tpu = "";
			Object te = se.getAttribute("tp_user");
			if(te != null) tpu = te.toString(); %>
</head>

<script type="text/javascript">
		function buscaRelatorio() {
			var form = document.forms["busca_relatorio"];
			form.action = "buscaRelatorio.do";
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
		<h2 align="center">Busca relatorio</h2>
		<hr>
		<div class="panel-body">
			<form name="busca_relatorio">
					
				<p>
					<button name="bNome" class="btn btn-primary" onClick="buscaRelatorio()">Buscar veículos alugados na presente data</button>
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