package Classes;

public enum MenuCadastrar { 
	CADASTRAR_CLIENTEPFPJ(1),
	CADASTRAR_VEICULO(2),
	CADASTRAR_SEGURADORA(3),
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
