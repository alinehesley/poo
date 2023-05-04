package Classes;

public enum MenuCadastrar { 
	CADASTRAR_CLIENTE(1),
	CADASTRAR_VEICULO(2),
	CADASTRAR_SEGURADORA(3),
	VOLTAR(4),
	SAIR(0);
	
	public final int operacao;
	
	MenuCadastrar(int operacao){
		this.operacao = operacao;
	}
	
	//get
	public int getOperacao() {
		return this.operacao;
	}
}
