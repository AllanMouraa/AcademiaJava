/**
 * Confirmação de exclusão de um contato
 */
 function confirmar(id){
	let resposta = confirm("Confirma a excluão deste contato?")
	if(resposta === true){
		//alert(id) - teste de recebimento
		
		//redirecina passas um caminho delete e passa o paremetro id
		window.location.href = "delete?id=" + id
	}
}