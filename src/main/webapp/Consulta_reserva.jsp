<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Consulta reserva</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="fundo.css">
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.js"></script>
</head>

<script type="text/javascript">
		$(document).ready(function(){	
			$("#cpf").mask("999.999.999-99");
		});
	</script>

<body>
	<div class="panel panel-default col-lg-4 col-lg-offset-4">
		<h2 align="center">Consulta reserva</h2>
		<hr>
		<div class="panel-body">
			<form>
				<p>
					<b>Cpf do cliente</b>
				</p>
				<p>
					<input type="text" class="form-control" id="cpf" name="tReserva"
						placeholder="Insira o cpf do cliente que efetuou a reserva"
						size="25" maxlength="14" required />
				</p>
				<p>
					<input type="button" class="btn btn-primary" name="bConsultar"
						value="Consultar" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>