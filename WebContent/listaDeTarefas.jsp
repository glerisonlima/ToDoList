<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de tarefas</h1>
	<table>
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
							<input type="hidden" name="id" value="${tarefas.id}">
							<input type="submit" value="Deletar">
						</form>
					</td>
					<td>
						<form action="sistema" method="post">
							<input type="hidden" name="logica" value="alterarTarefa">
							<input type="hidden" name="id" value="${tarefas.id}">
							<input type="submit" value="Alterar">
						</form>
					</td>
			</c:forEach>				
		</tbody>
	</table>
</body>
</html>