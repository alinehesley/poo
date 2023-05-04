package Classes;

public enum MenuListar {
	LISTAR_CLIENTE_PFPJ(1),
	LISTAR_SINISTROS_SEGURADORA(2),
	LISTAR_SINISTRO_CLIENTE(3),
	LISTAR_VEICULO_CLIENTE(4),
	LISTAR_VEICULO_SEGURADORA(5),
	VOLTAR(6),
	SAIR(0);
	
	public final int operacao;
	
	MenuListar(int operacao){
		this.operacao = operacao;
	}
	//get
	public int getOperacao() {
		return this.operacao;
	}
}
