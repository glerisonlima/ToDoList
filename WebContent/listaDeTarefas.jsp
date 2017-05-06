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
			</c:forEach>				
		</tbody>
	</table>
</body>
</html>