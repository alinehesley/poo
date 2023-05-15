package Classes;

import java.time.LocalDate;

public class ClientePJ extends Cliente {
	//Attributes
	private String cnpj;
	private LocalDate dataFundacao;
	private int qntFuncionarios;
	
	//Constructor 
	public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, int qntFuncionarios) {
		super(nome, endereco); 
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qntFuncionarios = qntFuncionarios; //preciso fazer um set ou apenas get?
	}
	
	//Calcula Score
	public double calculaScore(){
		double score = CalcSeguro.VALOR_BASE.getFator() * ((double)(1 + this.getQntFuncionarios())/100.0) * ((double)this.getListaVeiculos().size());
		return score;
	}

	//ToString
	@Override
	public String toString() {
		return "Informações Cliente PJ \nNome:" + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCNPJ: " + cnpj + "\nData de fundação: " + dataFundacao + "\n";
	}
	
	//Getters e Setters
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public int getQntFuncionarios() {
		return qntFuncionarios;
	}
	public void setQntFuncionarios(int qntFuncionarios){
		this.qntFuncionarios = qntFuncionarios; //atualiza score? acho q n pq usa qntFunc direto no calcscore
	}
}
