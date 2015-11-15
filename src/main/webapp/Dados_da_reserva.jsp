<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Dados da reserva</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
</head>

<script type="text/javascript">
		function finalizar() {
			if(document.getElementById("dataEmp").value == "" || document.getElementById("horaEmp").value == "" || document.getElementById("dataDev").value == "" || document.getElementById("horaDev").value == "" || (document.getElementById("livre").value == "" && document.getElementById("controlado").value == "") ){
				alert("Preencha TODO o formul�rio para realizar o cadastro!");
			}
			else{
				var form = document.forms["Dados_da_reserva"];
				form.action = "addReserva.do";
				form.submit();
			}
		}
		
		$(document).ready(function(){
			$("#dataEmp").mask("99/99/9999");
			$("#horaEmp").mask("99:99");
			$("#dataDev").mask("99/99/9999");
			$("#horaDev").mask("99:99");
		});
	</script>

<body>
	<div class="panel panel-default col-lg-4 col-lg-offset-4">
		<h2 align="center">Dados da reserva</h2>
		<hr>
		<div class="panel-body">
			<form name="Dados_da_reserva">
				<p>
					<b>Data do empr�stimo</b>
				</p>
				<p>
					<input type="text" class="form-control" name="dataEmp" id="dataEmp"
						placeholder="99/99/9999" />
				</p>
				<p>
					<b>Hora do empr�stimo</b>
				</p>
				<p>
					<input type="text" class="form-control" name="horaEmp" id="horaEmp"
						placeholder="HH:MM" size="5" maxlength="5" required />
				</p>
				<p>Data da devolu��o</p>
				<p>
					<input type="text" class="form-control" name="dataDev" id="dataDev"
						placeholder="99/99/9999" />
				</p>
				<p>
					<b>Hora da devolu��o</b>
				</p>
				<p>
					<input type="text" class="form-control" name="horaDev" id="horaDev"
						placeholder="HH:MM" size="5" maxlength="5" required />
				</p>
				<p>
					<b>Local do empr�stimo</b>
				</p>
				<p>
					<select class="form-control" name="localEmp">
						<option value="Ag�ncia 1">Ag�ncia 1</option>
						<option value="Ag�ncia 2">Ag�ncia 2</option>
						<option value="Ag�ncia 3">Ag�ncia 3</option>
						<option value="Ag�ncia 4">Ag�ncia 4</option>
						<option value="Ag�ncia 5">Ag�ncia 5</option>
					</select>
				</p>
				<p>
					<b>Local da devolu��o</b>
				</p>
				<p>
					<select class="form-control" name="localDev">
						<option value="Ag�ncia 1">Ag�ncia 1</option>
						<option value="Ag�ncia 2">Ag�ncia 2</option>
						<option value="Ag�ncia 3">Ag�ncia 3</option>
						<option value="Ag�ncia 4">Ag�ncia 4</option>
						<option value="Ag�ncia 5">Ag�ncia 5</option>
					</select>
				</p>
				<p>
					<b>Tarifa</b>
				</p>
				<p>
					<input type="radio" name="rTarifa" id="livre" value="Km Livre" /><b>Km
						Livre</b> <input type="radio" name="rTarifa" id="controlado"
						value="Km Controlado" /><b>Km Controlado</b>
				</p>
				<p>
					<input type="button" class="btn btn-primary" name="bFinalizar"
						value="Efetuar Reserva" onClick="finalizar()" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>