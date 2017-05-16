<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Bem vindo ao sistema de tarefas.</h1>
<form action="sistema" method="post">
<input type="hidden" name="logica" value="inserirTarefa">
<input type="submit" value="Inserir Tarefa">
</form>
<form action="sistema" method="post">
<input type="hidden" name="logica" value="listaTarefas">
<input type="submit" value="Listar Tarefas">
</form>
</body>
</html>