<%@page import="Model.*"%>
<%@page import="Factory.Mysql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de cliente</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
<%HttpSession se = request.getSession(); %>
</head>

<script type="text/javascript">
		
	</script>

<script type="text/javascript">
		function Cadastra() {
			if(document.getElementById("nome").value == "" || document.getElementById("cpf").value == "" || document.getElementById("rg").value == "" || document.getElementById("telefone").value == "" || document.getElementById("email").value == "" || document.getElementById("nascimento").value == "" || (document.getElementById("m").value == "" && document.getElementById("f").value == "") || document.getElementById("numRegistro").value == "" || document.getElementById("validade").value == "" || document.getElementById("dataCnh").value == ""){
				alert("Preencha TODO o formulário para realizar o cadastro!");
			}
			else{
				var form = document.forms["Cadastra_cliente"];
				form.action = "addClie.do";
				form.submit();
			}
		}
		function Consulta() {
			var cpf = document.getElementById("cpf").value;
			if(cpf == null || cpf == "") {
				alert("Insira o CPF para fazer a busca!");
				document.getElementById("cpf").focus();
			}
			else {
				$(document).ready(function(){
				$.ajax({
					type: "POST",
					url: "conClie.do",
					data: "tCpf="+cpf,
					dataType: "json",
					success: function (data){
						document.getElementById('nome').value = data.nome;
						document.getElementById('cpf').value = data.cpf;
						document.getElementById('rg').value = data.rg;
						document.getElementById('telefone').value = data.telefone;
						document.getElementById('email').value = data.email;
						document.getElementById('nascimento').value = data.nascimento;
						document.getElementById('numRegistro').value = data.numRegistro;
						document.getElementById('estado').value = data.estado;
						document.getElementById('validade').value = data.valCnh;
						document.getElementById('dataCnh').value = data.dtCnh;
						var sexo = data.sexo;
						if( sexo == "m" ) {
							document.getElementById('m').checked = "checked";
						}
						else {
							document.getElementById('f').checked = "checked";
						}
					}
				})	
			})
			}
		}
		
		function Altera() {
			var cpf = document.getElementById("cpf").value;
			if(cpf == null || cpf == "") {
				alert("Insira o CPF para fazer a busca e após realizar a alteração!");
				document.getElementById("cpf").focus();
			}
			else {
				var form = document.forms["Cadastra_cliente"];
				form.action = "altClie.do";
				form.submit();
			}
		}
		
		function Exclui() {
			var cpf = document.getElementById("cpf").value;
			if(cpf == null || cpf == "") {
				alert("Insira o CPF para fazer a busca e após realizar a exclusão!");
				document.getElementById("cpf").focus();
			}
			else {
				var form = document.forms["Cadastra_cliente"];
				form.action = "removeClie.do";
				form.submit();
			}
		}
		
		$(document).ready(function(){	
			$("#cpf").mask("999.999.999-99");
			$("#rg").mask("99.999.999-9");
			$("#telefone").mask("(99)99999-9999");
			$("#nascimento").mask("99/99/9999");
			$("#validade").mask("99/99/9999");
			$("#dataCnh").mask("99/99/9999");
		});
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
		<h2 align="center">Cadastro de cliente</h2>
		<hr>
		<% if(se.getAttribute("nome") != null){%>
		<p><%=se.getAttribute("nome").toString()%></p>
		<%}%>
		<div class="panel-body">
			<form name="Cadastra_cliente">
				<p>
					<b>Nome</b>
				</p>
				<p>
					<input type="text" class="form-control" id="nome" name="tNome"
						size="45" maxlength="45" required />
				</p>
				<p>
					<b>Cpf</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tCpf" id="cpf"
						size="14" maxlength="14" required />
				</p>
				<p>
					<b>Rg</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tRg" id="rg"
						size="12" maxlength="12" required />
				</p>
				<p>
					<b>Telefone</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tTelefone"
						id="telefone" required />
				</p>
				<p>
					<b>E-mail</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tEmail" id="email"
						size="45" maxlength="45" required />
				</p>
				<p>
					<b>Data de nascimento</b>
				</p>
				<p>
					<input type="text" class="form-control" name="dtNasc"
						id="nascimento" />
				</p>
				<p>
					<b>Sexo</b>
				</p>
				<p>
					<input type="radio" name="rSexo" value="m" id="m" /><b>
						Masculino</b><input type="radio" name="rSexo" value="f" id="f" /><b>
						Feminino</b>
				</p>
				<p>
					<b>Numero de registro</b>
				</p>
				<p>
					<input type="text" class="form-control" name="numRegistro"
						id="numRegistro" required />
				</p>
				<p>
					<b>Estado</b>
				</p>
				<p>
					<select class="form-control" name="est" id="estado">
						<option id="AC" value="AC">AC</option>
						<option id="AL" value="AL">AL</option>
						<option id="AP" value="AP">AP</option>
						<option id="AM" value="AM">AM</option>
						<option id="BA" value="BA">BA</option>
						<option id="CE" value="CE">CE</option>
						<option id="DF" value="DF">DF</option>
						<option id="ES" value="ES">ES</option>
						<option id="GO" value="GO">GO</option>
						<option id="MA" value="MA">MA</option>
						<option id="MT" value="MT">MT</option>
						<option id="MS" value="MS">MS</option>
						<option id="MG" value="MG">MG</option>
						<option id="PA" value="PA">PA</option>
						<option id="PB" value="PB">PB</option>
						<option id="PR" value="PR">PR</option>
						<option id="PE" value="PE">PE</option>
						<option id="PI" value="PI">PI</option>
						<option id="RJ" value="RJ">RJ</option>
						<option id="RN" value="RN">RN</option>
						<option id="RS" value="RS">RS</option>
						<option id="RO" value="RO">RO</option>
						<option id="RR" value="RR">RR</option>
						<option id="SC" value="SC">SC</option>
						<option id="SP" value="SP">SP</option>
						<option id="SE" value="SE">SE</option>
						<option id="TO" value="TO">TO</option>
					</select>
				</p>
				<p>
					<b>Validade CNH</b>
				</p>
				<p>
					<input type="text" class="form-control" name="valCnh" id="validade" />
				</p>
				<p>
					<b>Data de expedicao CNH</b>
				</p>
				<p>
					<input type="text" class="form-control" name="dtCnh" id="dataCnh" />
				</p>

				<p>
					<button type="reset" class="btn btn-primary" name="bNovo"
						value="Novo">Novo</button>
					<button type="submit" class="btn btn-primary" name="bCadastrar"
						value="Cadastrar" onClick="Cadastra()">Cadastrar</button>
					<button type="button" class="btn btn-primary" name="bConsultar"
						value="Consultar" onClick="Consulta()">Consultar</button>
					<button type="submit" class="btn btn-primary" name="bAlterar"
						value="Alterar" onClick="Altera()">Alterar</button>
					<button type="submit" class="btn btn-primary" name="bExcluir"
						value="Excluir" onClick="Exclui()">Excluir</button>
				</p>

			</form>
		</div>
	</div>
</body>
</html>