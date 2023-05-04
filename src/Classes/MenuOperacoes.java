package Classes;

public enum MenuOperacoes {
	CADASTRAR(1), 
	CADASTRAR_CLIENTE(1.1),
	CADASTRAR_VEICULO(1.2),
	CADASTRAR_SEGURADORA(1.3),
	VOLTAR(1.4),
	LISTAR(2),
	LISTAR_CLIENTE-PF/PJ(2.1), //estamos construindo o sistema p uma segurada, certo?
	LISTAR_SINISTROS-SEGURADORA(2.2),
	LISTAR_SINISTRO-CLIENTE(2.3),
	LISTAR_VEICULO-CLIENTE(2.4),
	LISTAR_VEICULO-SEGURADORA(2.5),
	VOLTAR(2.6),
	EXCLUIR(3),
	EXCLUIR_CLIENTE(3.1),
	EXCLUIR_VEICULO(3.2),
	EXCLUIR_SINISTRO(3.3),
	VOLTAR(3.4),
	GERAR_SINISTROS(4),
	TRANSFERIR_SEGURO(5), //coloco em Seguradora?
	CALCULAR_RECEITA_SEGURADORA(6),
	SAIR(0);
	
	public final double operacao;
	
	MenuOperacoes(double operacao){
		this.operacao = operacao;
	}
	
	//get
	public double getOperacao() {
		return this.operacao;
	}
}
