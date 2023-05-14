package Classes;

public enum MenuCadastrar { 
	CADASTRAR_CLIENTEPF(1),
	CADASTRAR_CLIENTEPJ(2),
	CADASTRAR_VEICULO(3),
	CADASTRAR_SEGURADORA(4),
	VOLTAR(0);
	
	public final int operacao;
	
	MenuCadastrar(int operacao){
		this.operacao = operacao;
	}
	
	//get
	public int getOperacao() {
		return this.operacao;
	}
}
