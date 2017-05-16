<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TodoList</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Bem vindo ao sistema de tarefas.</h1>
		<form action="sistema" method="post">
			<div class="form-group">
			<input class="btn btn-default" type="hidden" name="logica" value="inserirTarefa"> <input
				type="submit" value="Inserir Tarefa">
			</div>
		</form>
		<form action="sistema" method="post">
			<input type="hidden" name="logica" value="listaTarefas"> <input
				type="submit" value="Listar Tarefas">
		</form>
	</div>
</body>
</html>