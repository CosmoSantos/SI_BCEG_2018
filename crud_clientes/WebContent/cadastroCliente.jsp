<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Cliente</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
	
</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>CRUD DE CLIENTES</h2>
		</div>
		
		<!-- Conteudo da página principal -->
		<div class="col-md-12">
		
			<h3>Cadastro de Clientes</h3>
			<a href="index.jsp"> <input type="submit" value="Voltar"/> </a> Para pagina inicial.
			<hr>
			
			<div class="col-md-4">
			
				<form name="formulario" method="post" action="ClienteServelet?acao=cadastrar">
				
					<label> Nome do Cliente </label>
					<input type="text" id="nome" name="nome" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Telefone do Cliente </label>
					<input type="text" id="fone" name="fone" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Email do Cliente </label>
					<input type="text" id="email" name="email" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<input type="submit" value="Cadastrar" class="btn btn-success" />	
				</form>
				
				<h4>${mensagem}</h4>
			</div>
		</div>

	</body>
</html>