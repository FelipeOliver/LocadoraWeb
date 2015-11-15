<!DOCTYPE html>

<head>
	<title>Devolução</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- <link href="css/simple-sidebar.css" rel="stylesheet"> --> 
		<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
		<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<!-- <script src="jquery.js" type="text/javascript"></script> -->
		<!-- <script src="maskedinput-1.3.js" type="text/javascript"></script> -->
		<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
		<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
		<!--<script src="js/bootstrap-modal.js"></script>-->
		<!--<script src="js/bootstrap.min.js"></script>-->
<script type="text/javascript">
 
    jQuery(document).ready(function($) {
 
            $("#placa").mask("aaa-9999");     // Máscara para Placa
 
            $("#nCartao").mask("9999.9999.9999.9999");    // Máscara para Numero do cartao
 
            $("#dDevolucao").mask("99/99/9999");    // Máscara para DATA
 
            $("#cSeguranca").mask("999");    // Máscara para Código de Segurança
 
            $('#cpf').mask('999.999.999-99');    // Máscara para CPF
       
            $('#nAgencia').mask('9999');    // Máscara para AGÊNCIA BANCÁRIA
 
            $('#cConta').mask('99999999-9');    // Máscara para CONTA BANCÁRIA
            
            $('#nKm').mask('9999');    // Máscara para AGÊNCIA BANCÁRIA
 
    }); 
 
    
    	
    
</script>
		</script>



</head>

<form>
	<body>
		<h2>Devolução</h2>
			<div class="panel-body">
				<form>
					<div class="panel panel-default col-lg-6 ">
					<div class="panel-heading">
						<h3 class="panel-title">Dados de Devolução</h3>
					</div>
						<div class="panel-body">
							<%if(request.getAttribute("variavelRequestMsgErro")!= null){%>
						<div>
							<p>
								<%request.getAttribute("variavelRequestMsgErro").toString(); %>
							</p>
						</div>
						<%} %>
						</div>
						
						<label>Cpf</label><input required type="text" name="cpf" id="cpf" class="form-control" ></br> 
						<label>Placa</label><input required type="text" name="placa" id="placa" class="form-control" placeholder="Placa do veículo" ></br> 
						<label>Data de devolução</label><input required type="date" max="99/99/9999" name="dDevolucao" id="ddevolucao" class="form-control" placeholder="Devolução"></br>
						<label>Agencia</label> <select class="form-control" name="agencia" id="agencia" required>
							<option>Agencia 1</option>
							<option>Agencia 2</option>
							<option>Agencia 3</option>
							<option>Agencia 4</option>
							<option>Agencia 5</option>
							</select></br> <label>KM</label><input required type="text" name="nkm" id="nkm" maxlength="6" min="0" max="1000.00" class="form-control" placeholder="KM" /></br> 
						<label>Tipo de tarifa</label> <select required class="form-control" name="tkm" id="tkm">
							<option value="livre">Livre</option>
							<option value="controlado">Controlado</option>
							</select><br /> <div id="teste">R$: </div>
						
						<br/><br/>
						
						<input type="button" name="calcular" onclick="Consulta()"
							value="Calcular" class="btn btn-default" aria-label="Calcular">
						<label class="glyphicon glyphicon-refresh" aria-hidden="true"></label>
					</div>
					</div>

					<script type="text/javascript">
			function calcula_valor() {
			var forma = document.forms["calcula_valor"];
			forma.action = "pagamento.do";
			forma.submit();
		
			}	
	</script>
			</form>


		</div>
		</div>
		<!--<div class="panel-body">
		<div class="panel panel-default col-lg-6 ">
                      <div class="panel-heading">
                        
                      </div>
					  </div>
					  
		<label>Valor</label><Output style="size:50" type="label" id="valor" class="form-control" placeholder="R$0,00"></br>
		</div>-->
		<div class="container">

			<!-- Trigger the modal with a button -->
			<!--Criar o botÃ£o com este estilo-->
			<button type="button" data-toggle="modal" class="btn btn-default btn-lg" data-target="#mPagamento">Forma de Pagamento</button>
			<h2></h2>
			<h2></h2>
			<h2></h2>
			<h2></h2>

			<!-- Modal  Primerio Modal-->
			<div class="modal fade" id="mPagamento" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" color="Black"
								data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Escolha a Forma de Pagamento</h4>
						</div>
						<div class="modal-body">
							<p>
								<button type="button" class="btn btn-default btn-lg"
									data-toggle="modal" data-target="#mCredito">
									Crédito <span class="glyphicon glyphicon-credit-card"
										aria-hidden="true"></span>
								</button>
							</p>
							<p>
								<button type="button" class="btn btn-default btn-lg"
									data-toggle="modal" data-target="#mDebito">
									Débito <span class="glyphicon glyphicon-credit-card"
										aria-hidden="true"></span>
								</button>
							</p>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>


			<!------------------------------------------------------------------------------------------------------>
			<!--   Modal de crédito -->


			<script>
function Pagamento()
{
alert("Pagamento Efetuado!");
}
</script>




			<div class="modal fade" id="mCredito" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" color="Black"
								data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Digite os dados do seu cartão de
								crédito</h4>
						</div>
						<div class="modal-body">


							<!-- Formulário -->
							<div class="panel-body">
								<form method="post" action="credito.do">
									<label>Bandeira</label> <select required class="form-control"
										name="bandeira" id="bandeira">

										<option>Visa</option>
										<option>MasterCard</option>
										<option>American Express</option>
										<option>Elo</option>
									</select>

									<div class="">

										<label>Número do Cartão</label><input required type="text" name="nCartao" id="nCartao" class="form-control"	maxlength="19" placeholder="Número do Cartão"></br> 
										<label>Código de Segurança</label><input required type="text" name="cSeguranca"	id="cSeguranca" class="form-control" maxlength="3" placeholder="Código de Segurança"></br> 
										<label>Nome do Titular</label><input required type="text" name="nTitular" id="nTitular" class="form-control" maxlength="30"	placeholder="Nome do Titular"></br> 
										<label>Vencimento</label><input required type="month" name="dVencimento" id="dVencimento" class="form-control" placeholder="MM/AAAA"></br> 
										<label>Número de Parcelas</label> 
											<select required class="form-control" name="nParcelas">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
												<option>9</option>
												<option>10</option>
											</select>


										<div class=""></div>
										<div>



											<div class="row">
												<br></br>
											</div>

											<input type="submit" class="btn btn-default" name="bCredito"
												value="Efetuar Pagamento">
										</div>
								</form>

							</div>

						</div>



					</div>


					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
			<script type="text/javascript">
		function Efetua_Pagamento() {
			var form = document.forms["Efetua_Pagamento"];
			form.action = "credito.do";
			form.submit();
		}	
	</script>
		</div>

		<!------------------------------------------------------------------------------------------------------>
		<!--   Modal de Débito -->

		<div class="modal fade" id="mDebito" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" color="Black"
							data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Digite os dados do seu cartão de
							débito</h4>
					</div>
					<div class="modal-body">

						<!-- Formulário -->
						<div class="panel-body">
							<form method="post" action="debito.do">
								<label>Banco</label> <select required class="form-control" name="banco" id=Banco>

									<option>Santander - 033</option>
									<option>Itaú - 341</option>
									<option>Bradesco - 237</option>
									<option>Banco do Brasil - 001</option>
									<option>Caixa - 104</option>
								</select>

								<div class="">

									<label>Agência</label><input type="text" required name="agencia" id="nAgencia" class="form-control" maxlength="5" placeholder="Número da Agência"></br> 
									<label>Conta Corrente</label><input type="text" required name="cConta" id="cConta"	class="form-control" maxlength="10" placeholder="Número da Conta Corrente"></br> 
									<label>Nome do Titular</label><input type="text" required name="nTitular" id="nTitular" class="form-control" maxlength="30" placeholder="Nome doTitular"></br> 
									<label>Cpf</label><input type="text" id="cpf" required name="cpf" class="form-control" maxlength="14"	placeholder="Insira apenas números"></br>



								<div class=""></div>
									<div>

										<div class="row">
											<br></br>
										</div>
										<input type="submit" class="btn btn-default" name="bDebito"
											value="Efetuar Pagamento">
									</div>
							</form>

						</div>


						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>










		</div>

		<script>
		function Consulta() {
			var placa = document.getElementById("placa").value;
			if(placa == null || placa == "") {
				alert("Insira a PLACA para fazer a busca!");
				document.getElementById("placa").focus();
			}
			else {
				$(document).ready(function(){
					var cpf = document.getElementById("cpf").value;
					var placa = document.getElementById("placa").value;
					//var dDevolucao = document.getElementById("dDevolucao").value; "
					var agencia = document.getElementById("agencia").value;
					var nkm = document.getElementById("nkm").value;
					var tkm = document.getElementById("tkm").value;
					$.ajax({
						type: "POST",
						url: "pagamento.do",
						data: {cpf:cpf, placa:placa,agencia:agencia,nkm:nkm,tkm:tkm}, 
						dataType: "json",
						success: function (data){
							
							document.getElementById("teste").innerHTML = "R$: " + data.valor;
						}
					
					})	
				})
			}
}
</script>
	</body>
</html>