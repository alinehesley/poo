package Classes;

public enum MenuExcluir {
	EXCLUIR_CLIENTE(1), EXCLUIR_VEICULO(2), EXCLUIR_SINISTRO(3), EXCLUIR_SEGURO(4), VOLTAR(0);

	public final int operacao;

	MenuExcluir(int operacao) {
		this.operacao = operacao;
	}

	// get
	public int getOperacao() {
		return this.operacao;
	}
}
