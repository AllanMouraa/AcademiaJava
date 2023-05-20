package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.Produtos;

@WebServlet(urlPatterns = { "/home", "/create", "/insert", "/read", "/delete", "/select", "/update" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Produtos produto = new Produtos();
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/create")) {
			response.sendRedirect("cadastro.html");
			
		} else if (action.equals("/insert")) {
			adicionarProduto(request, response);
			
		} else if (action.equals("/read")) {
			ListaDeProdutos(request, response);
			
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
			
		} else if (action.equals("/select")) {
			listarProduto(request, response);
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("codigo"));
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("categoria"));
			System.out.println(request.getParameter("preco"));
			System.out.println(request.getParameter("quantidade"));
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	} 

	protected void adicionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//produto.setId(request.getParameter("id"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setPreco(request.getParameter("preco"));
		dao.inserirProduto(produto);
		response.sendRedirect("read");
	}

	protected void ListaDeProdutos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Produtos> lista = dao.ListaDeProdutos();
		request.setAttribute("produto", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
	}

	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(id);
		dao.deltarProduto(produto);
		response.sendRedirect("read");
	}
//edita os valores e armazena eles de volta ao banco de dados
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(id);
		dao.selecionarProduto(produto);
		request.setAttribute("id", produto.getId());
		request.setAttribute("codigo", produto.getCodigo());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("preco", produto.getPreco());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	//importa do banco de dados os valores armazenados 
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//produto.setId(request.getParameter("id"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setPreco(request.getParameter("preco"));
		dao.alterarProduto(produto);
		response.sendRedirect("read");
	}
	
}