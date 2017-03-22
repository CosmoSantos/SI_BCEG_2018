<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean class="managdBeans.ManagdBeansCliente" id="mb"></jsp:useBean>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Clientes</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />

</head>
<body class="container">

	<div class="well well-sm">
		<h2>CRUD DE CLIENTES</h2>
	</div>

	<div class="col-md-12">

		<h3>Consulta de Clientes</h3>
		<a href="index.jsp"> <input type="submit" value="Voltar" />
		</a> Para página Inicial

		<table class="table table-horver">

			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Operações</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${mb.listagemCliente}" var="c">

					<tr>
						<td>${c.idCliente}</td>
						<td>${c.nome}</td>
						<td>${c.fone}</td>
						<td>${c.email}</td>
						<td>
							
							<a href="ClienteServelet?acao=excluir&id=${c.idCliente}"
								class="btn btn-danger btn-sm"
						  		onclick="return confirm('Deseja excluir o cliente?');">
						 		 Excluir
							</a>
							
							<a href="ClienteServelet?acao=editar&id=${c.idCliente}"
								class="btn btn-primary btn-sm">
								Editar
							
							</a>
							
						</td>
				</c:forEach>

			</tbody>
		</table>
		<h4>${mensagem}</h4>

	</div>

</body>
</html>

