<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Cardapio</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
	
</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<!-- Conteudo da p�gina principal -->
		<div class="col-md-12">
		
			<h3>Cadastro de Card�pio</h3>
			<a href="homeCardapio.jsp"> <input type="submit" value="Voltar"/> </a> Para pagina inicial.
			<hr>
			
			<div class="col-md-4">
			
				<form name="formulario" method="post" action="CardapioServelet?acao=cadastrar">
				
					<label> Categoria do Card�pio </label>
					<input type="text" id="categoria" name="categoria" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Descri��o do Card�pio </label>
					<input type="text" id="descricao" name="descricao" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Pre�o do Card�pio </label>
					<input type="text" id="preco" name="preco" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Disponibilidade do Card�pio </label>
					<input type="text" id="disponibilidade" name="disponibilidade" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<input type="submit" value="Cadastrar" class="btn btn-success" />	
				</form>
				
				<h4>${mensagem}</h4>
			</div>
		</div>

	</body>
</html>