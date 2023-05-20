<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Produtos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Controller"%>
<%@page import="model.DAO"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Produtos> lista = (ArrayList<Produtos>) request.getAttribute("produto");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Consulta</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<nav id="navbar-example2" class="navbar bg-light px-3">
		<a style="color: inherit" href="home" class="navbar-brand"><img
			src="imagens/home.png"> HOME </a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a style="color: inherit" class="nav-link"
				href="create"><img src="imagens/cadastrar.png" alt="lista">
					CADASTRAR</a></li>
		</ul>
	</nav>
	<h1 class="text-center">Lista de Produtos Cadastrados</h1>
	<div class="container px-4" >
		<div class="row gx-5">
			<div class="col">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nº</th>
							<th>Código</th>
							<th>Nome</th>
							<th>Categoria</th>
							<th>Estoque</th>
							<th>Preço</th>
							<th>Opções</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < lista.size(); i++) {
						%>
						<tr>
							<td><%=lista.get(i).getId()%></td>
							<td><%=lista.get(i).getCodigo()%></td>
							<td><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getCategoria()%></td>
							<td><%=lista.get(i).getQuantidade()%></td>
							<td><%=lista.get(i).getPreco()%></td>
							<td><a 
								href="javascript: confirmar(<%=lista.get(i).getId()%>)"><img
									src="imagens/61-trash.png"></a><a 
								href="select?id=<%=lista.get(i).getId()%>"><img
									src="imagens/26-write.png"></a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<p>
		<script src="scripts/confirmador.js"></script>
		<script src="scripts/bootstrap.bundle.min.js"></script>
</body>
</html>