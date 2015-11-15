<%@page language="java" import="javax.servlet.http.HttpServletRequest"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<link rel="icon" href="/favicon.ico">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>

<title>Locação de Carros</title>
</head>
<body>

	<% String existe = "0";
    	   out.println(existe);
    	   HttpSession se = request.getSession();
    	   se.setAttribute("logado", "N");
		  if (request.getAttribute("existe") != null)
		  {
		  	Object o = request.getAttribute("existe");
		  	existe = o.toString();
		  	out.println(existe);
		  }
		  %>
	<div class="row">
		<br></br>
		</br>
		</br>
		</br>
		</br>
		</br>
	</div>
	<div class="panel panel-default col-lg-8 col-lg-offset-2">
		<div class="panel-body">
			<% if(existe.equals("1")){ %>
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="false"></span> <span class="sr-only">Error:</span>
				Senha ou Login Incorretos.
			</div>
			<% }%>
			<div class="container col-lg-4 col-lg-offset-4 row">
				<form class="form-signin" action="loginController" method="POST">
					<h2 class="form-signin-heading">Login</h2>
					<label for="inputLogin" class="sr-only">Login</label> <input
						type="text" name="inputLogin" id="inputLogin" class="form-control"
						placeholder="Login" required autofocus> <label
						for="inputPassword" class="sr-only">Senha</label> <input
						type="password" id="inputSenha" name="inputSenha"
						class="form-control" placeholder="Password" required>
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember me
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
					<!-- <a href="index.html">SÃ³ para testes</a>-->
				</form>
			</div>
			<!-- /container -->
		</div>
	</div>
	<%if(request.getAttribute("existe") != null) {%>
	<div>
		<textarea rows="10" cols="1" hidden="true">
				<%=request.getAttribute("existe").toString() %>
			
			</textarea>
	</div>
	<%}%>
</body>
</html>
