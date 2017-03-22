<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Atualizar Cliente</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
	
</head>
	<body>
	
		<div class="well well-sm">
			<h2>CRUD DE CLIENTES</h2>
		</div>
		
		<div class="col-md-12">
		
			<h3>Atuaizar dados do Cliente</h3>
			<a href="consultaCliente.jsp"> <input type="submit" value="Voltar"/> </a> Para págna Inicial
			<hr>
			
			<div class="col-md-4">
			
			<form class="formulario" method="post" action="ClienteServelet?acao=atualizar">
				
				<label>Id</label>
				<input type="text" id="id" name="idcliente" class="form-control"
					value="${cliente.idCliente}" readonly="readonly"/>
					<br>
				
				<label>Nome</label>
				<input type="text" id="nome" name="nome" class="form-control"
					value="${cliente.nome}"/>
					<br>
					
				<label>Telefone</label>
				<input type="text" id="fone" name="fone" class="form-control"
					value="${cliente.fone}"/>
					<br>
					
				<label>Email</label>
				<input type="text" id="email" name="email" class="form-control"
					value="${cliente.email}"/>
					<br>
					
				<input type="submit" value="Atualizar" class="btn btn-success"/>				
			</form>
			
			<h4>${mensagem}</h4>
			</div>
		</div>

	</body>
</html>













