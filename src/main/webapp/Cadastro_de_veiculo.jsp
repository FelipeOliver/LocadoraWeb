<!DOCTYPE html>
<html>
<head>
<title>Cadastro de veículo</title>
<meta charset="ISO-8859-1"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
<%HttpSession se = request.getSession(); %>
</head>

<script type="text/javascript">
	
		function Cadastra() {
			if( document.getElementById("chassi").value == "" || document.getElementById("placa").value == "" || document.getElementById("cidade").value == "" || document.getElementById("km").value == "" || document.getElementById("modelo").value == "" || document.getElementById("fabricante").value == "" || document.getElementById("valorKm").value == "" ) {
				alert("Preencha TODO o formulário para realizar o cadastro!");
			}
			else {
				var form = document.forms["Cadastra_automovel"];
				form.action = "addAuto.do";
				form.submit();
			}
		}
		function Consulta() {
			var placa = document.getElementById("placa").value;
			if(placa == null || placa == "") {
				alert("Insira a PLACA para fazer a busca!");
				document.getElementById("placa").focus();
			}
			else {
				$(document).ready(function(){
					$.ajax({
						type: "POST",
						url: "conAuto.do",
						data: "tPlaca="+placa,
						dataType: "json",
						success: function (data){
							
							if(data.acessorioA != "null") {
								document.getElementById('acessorioA').checked = "checked";
							}
							if(data.acessorioB != "null") {
								document.getElementById('acessorioB').checked = "checked";
							}
							document.getElementById('chassi').value = data.chassi;
							document.getElementById('cidade').value = data.cidade;
							document.getElementById('km').value = data.km;
							document.getElementById('imagem').value = data.imagem;
							document.getElementById('modelo').value = data.modelo;
							document.getElementById('fabricante').value = data.fabricante;
							document.getElementById('valorKm').value = data.valorKm;
							document.getElementById('estado').value = data.estado;
							document.getElementById('grupo').value = data.grupo;
						}
					
					})	
				})
			}
		}
	
		function Altera() {
			var placa = document.getElementById("placa").value;
			if(placa == null || placa == "") {
				alert("Insira a PLACA para fazer a busca e após realizar a alteração!");
				document.getElementById("placa").focus();
			}
			else {
				var form = document.forms["Cadastra_automovel"];
				form.action = "altAuto.do";
				form.submit();
			}
		}
	
		function Exclui() {
			var placa = document.getElementById("placa").value;
			if(placa == null || placa == "") {
				alert("Insira a PLACA para fazer a busca e após realizar a exclusão!");
				document.getElementById("placa").focus();
			}
			else {
				var form = document.forms["Cadastra_automovel"];
				form.action = "removeAuto.do";
				form.submit();
			}
		}
		$(document).ready(function(){	
			$("#placa").mask("aaa-9999");
			$("#km").mask("9999999");
			$("#valorKm").mask("999.99");
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
		<h2 align="center">Cadastro de veículo</h2>
		<hr>
		<div class="panel-body">
			<form name="Cadastra_automovel" method="Post">
				<p>
					<b>Grupo</b>
				</p>
				<p>
					<select class="form-control" name="veiculo" id="grupo">
						<option id="A-Economico" value="A-Economico">A -
							Economico</option>
						<option id="C-Economico com ar" value="C-Economico com ar">C
							- Economico com ar</option>
						<option id="F-Intermediario" value="F-Intermediario">F -
							Intermediario</option>
						<option id="G-Intermediario Wagon Especial"
							value="G-Intermediario Wagon Especial">G - Intermediario
							Wagon Especial</option>
						<option id="H-Executivo" value="H-Executivo">H -
							Executivo</option>
						<option id="I-Utilitario" value="I-Utilitario">I -
							Utilitario</option>
						<option id="K-Executivo de luxo" value="K-Executivo de luxo">K
							- Executivo de luxo</option>
						<option id="M-Intermediario Wagon" value="M-Intermediario Wagon">M
							- Intermediario Wagon</option>
						<option id="N-Pick-up" value="N-Pick-up">N - Pick-up</option>
						<option id="P-4X4 Especial" value="P-4X4 Especial">P -
							4X4 Especial</option>
						<option id="R-Minivan" value="R-Minivan">R - Minivan</option>
						<option id="U-Furgao" value="U-Furgao">U - Furgao</option>
						<option id="Y-Blindado" value="Y-Blindado">Y-Blindado</option>
					</select>
				</p>
				<p>
					<b>Acessorios</b>
				</p>
				<p>
					<input type="checkbox" name="navGps" value="Navegador GPS"
						id="acessorioA" /> Navegador GPS <input type="checkbox"
						name="cadBebe" value="Cadeira de bebê" id="acessorioB" /> Cadeira
					de bebe
				</p>
				<p>
					<b>Chassi</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tChassi" id="chassi"
						size="17" maxlength="17" required />
				</p>
				<p>
					<b>Placa</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tPlaca" id="placa"
						size="8" maxlength="8" required />
				</p>
				<p>
					<b>Cidade</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tCidade" id="cidade"
						size="45" maxlength="45" required />
				</p>
				<p>
					<b>KM</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tKm" id="km"
						size="10" maxlength="10" required />
				</p>
				<p>
					<b>Estado</b>
				</p>
				<p>
					<select class="form-control" name="est">
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
					<b>Modelo</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tModelo" id="modelo"
						size="45" maxlength="45" />
				</p>
				<p>
					<b>Fabricante</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tFabricante"
						id="fabricante" size="30" maxlength="30" />
				</p>
				<p>
					<b>Valor Km</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tValorKm"
						id="valorKm" size="10" maxlength="10" required />
				</p>
				<p>
					<b>Imagem</b>
				</p>
				<p>
					<input type="text" class="form-control" name="tImagem" id="imagem"
						size="10" required />
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

