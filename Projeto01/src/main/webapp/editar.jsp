<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="bootstrap.min.css">
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<nav id="navbar-example2" class="navbar bg-light px-3">
		<a style="color: inherit" href="home" class="navbar-brand"><img
			src="imagens/home.png"> HOME </a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a style="color: inherit" class="nav-link"
				href="create"><img src="imagens/cadastrar.png" alt="lista">
					Cadastrar</a></li>
			<li class="nav-item"><a style="color: inherit" class="nav-link"
				href="read"><img src="imagens/consulta.png"
					alt=" img consulta"> Consultar</a></li>
		</ul>
	</nav>
	<h1 class="text-center">EDITAR PRODUTOS</h1>
	<div class="centralizarcadastro">

				<div class="centralizarcadastro">
					<form name="frmCadastro" action="update">
						<div class="">
							<table class="">
								<tr>
									<td>Código*</td>
									<td><input type="text" class="form-control" name="codigo"
										value="<%out.print(request.getAttribute("codigo"));%>"></td>
								</tr>
								<tr>
									<td>Nome*</td>
									<td><input type="text" class="form-control" name="nome"
										value="<%out.print(request.getAttribute("nome"));%>"></td>
								</tr>
								<tr>
									<td>Categoria</td>
									<td><input type="text" class="form-control"
										name="categoria"
										value="<%out.print(request.getAttribute("categoria"));%>"></td>
								</tr>
								<tr>
									<td>Quantidade*</td>
									<td><input type="text" class="form-control"
										name="quantidade"
										value="<%out.print(request.getAttribute("quantidade"));%>"></td>
								</tr>
								<tr>
									<td>Preço*</td>
									<td><input type="text" class="form-control" name="preco"
										value="<%out.print(request.getAttribute("preco"));%>"></td>
								</tr>
							</table>
						</div>
						<input class="btn btn-dark" type="button" value="Salvar"
							onclick="validar()">
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="scripts/validador.js"></script>
	<script src="scripts/bootstrap.bundle.min.js"></script>
</body>
</html>