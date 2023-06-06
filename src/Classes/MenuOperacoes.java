package Classes;

public enum MenuOperacoes {
	CADASTRAR(1), LISTAR(2), EXCLUIR(3), GERAR_SINISTRO(4), CALCULAR_RECEITA_SEGURADORA(5), SAIR(6);

	public final int operacao;

	MenuOperacoes(int operacao) {
		this.operacao = operacao;
	}

	// get
	public int getOperacao() {
		return this.operacao;
	}
}
