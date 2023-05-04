package Classes;

public enum MenuOperacoes {
	CADASTRAR(1), 
	LISTAR(2),
	EXCLUIR(3),
	GERAR_SINISTROS(4),
	TRANSFERIR_SEGURO(5), //faco direto no proprio menu, passar veiculos p outro cliente, excluir lista
	CALCULAR_RECEITA_SEGURADORA(6),
	SAIR(0);
	
	public final int operacao;
	
	MenuOperacoes(int operacao){
		this.operacao = operacao;
	}
	
	//get
	public int getOperacao() {
		return this.operacao;
	}
}
