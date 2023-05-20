/**
 * validação de pagina 
 */
function validar() {
	let codigo = frmCadastro.codigo.value
	let nome = frmCadastro.nome.value
	let preco = frmCadastro.preco.value
	let quantidade = frmCadastro.quantidade.value
	if (codigo === "") {
		alert('Preencha o campo Código.')
		frmCadastro.codigo.focus()
		return false
	} else if (nome === "") {
		alert('Preencha o campo Nome.')
		frmCadastro.nome.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preço.')
		frmCadastro.preco.focus()
		return false
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade.')
		frmCadastro.quantidade.focus()
		return false
	} else {
		document.forms["frmCadastro"].submit()
	}
}