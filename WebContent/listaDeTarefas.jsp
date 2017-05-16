<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Tarefas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>Lista de tarefas</h1>
		<form action="sistema" method="post">
			<div class="form-group">
			<input class="btn btn-default" type="hidden" name="logica" value="inserirTarefa"> <input
				type="submit" value="Inserir Tarefa">
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Titulo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tarefas" items="${tarefas}">
					<tr>
						<td>${tarefas.id}</td>
						<td>${tarefas.titulo}</td>
						<td>${tarefas.descricao}</td>
						<td>
							<form action="sistema" method="post">
								<input type="hidden" name="logica" value="removerTarefa">
								<input type="hidden" name="id" value="${tarefas.id}"> <input
									type="submit" value="Deletar">
							</form>
						</td>
						<td>
							<form action="sistema" method="post">
								<input type="hidden" name="logica" value="alterarTarefa">
								<input type="hidden" name="id" value="${tarefas.id}"> <input
									type="submit" value="Alterar">
							</form>
						</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>