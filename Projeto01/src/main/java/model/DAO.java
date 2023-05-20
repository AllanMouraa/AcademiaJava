package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/projeto1?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// testando a conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// CRUDE - Create
	public void inserirProduto(Produtos produto) {
		String create = "insert into produto (codigo, nome, categoria, quantidade, preco)  values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getQuantidade());
			pst.setString(5, produto.getPreco());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//CRUDE - Read
	public ArrayList<Produtos> ListaDeProdutos() {
		ArrayList<Produtos> produto = new ArrayList<Produtos>();
		String read = "select * from produto order by nome;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String codigo = rs.getString(2);
				String nome = rs.getString(3);
				String categoria = rs.getString(4);
				String preco = rs.getString(5);
				String quantidade = rs.getString(6);
				produto.add(new Produtos(id, codigo, nome, categoria, preco, quantidade));
			}
			con.close();
			return produto;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	// Crude Delete
	public void deltarProduto(Produtos produto) {
		String delete = "delete from produto where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUDE UPDATE
	public void selecionarProduto(Produtos produto) {
		String read2 = "select * from produto where id = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setId(rs.getString(1));
				produto.setCodigo(rs.getString(2));
				produto.setNome(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setPreco(rs.getString(5));
				produto.setQuantidade(rs.getString(6));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarProduto(Produtos produto) {
		String update = "update produto set codigo = ?, nome = ?, categoria = ?, preco = ?, quantidade = ? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getQuantidade());
			pst.setString(5, produto.getPreco());
			pst.setString(6, produto.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		
	}

}