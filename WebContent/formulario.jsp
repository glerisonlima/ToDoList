<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Cadastro de tarefas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Cadastro de Tarefas</h1>
		<form action="sistema" method="post">
			<input type="hidden" name="logica" value="salvarTarefa"> 
			<input type="hidden" name="id" value=""> 
			<div class="form-group">
				<label>Titulo</label>
				<input class="form-control" type="text" name="titulo" id="titulo"
					placeholder="informe o titulo">
			</div>
			<div class="form-group">
				<label>Descrição</label>
				<textarea class="form-control" rows="10" cols="50" name="descricao" id="descricao"></textarea>
			</div>
			<div class="form-group">
				<input type="submit" value="Salvar Tarefa">
			</div>
		</form>
	</div>
</body>
</html>