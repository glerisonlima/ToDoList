<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Cadastro de tarefas</title>
</head>
<body>
	<h1>Cadastro de Tarefas</h1>
	<form action="sistema" method="post">
		<input type="hidden" name="logica" value="salvarTarefa">
		<label>Titulo</label>
		<input type="text" name="titulo" id="titulo" placeholder="informe o titulo">
		<label>Descrição</label>
		<textarea rows="10" cols="50" name="descricao" id="descricao"></textarea>
		<input type="submit" value="Salvar Tarefa">
	</form>
</body>
</html>