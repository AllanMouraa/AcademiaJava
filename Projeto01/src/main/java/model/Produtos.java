package model;

public class Produtos{
private String id;
private String codigo;
private String nome;
private String categoria;
private String preco;
private String quantidade;



public Produtos() {
	super();
}



public Produtos(String id, String codigo, String nome, String categoria, String preco, String quantidade) {
	super();
	this.id = id;
	this.codigo = codigo;
	this.nome = nome;
	this.categoria = categoria;
	this.preco = preco;
	this.quantidade = quantidade;
}



public String getId() {
	return this.id;
}

public void setId(String id) {
	this.id = id;
}

public String getCodigo() {
	return this.codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNome() {
	return this.nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCategoria() {
	return this.categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public String getPreco() {
	return this.preco;
}

public void setPreco(String preco) {
	this.preco = preco;
}

public String getQuantidade() {
	return this.quantidade;
}

public void setQuantidade(String quantidade) {
	this.quantidade = quantidade;
}

}