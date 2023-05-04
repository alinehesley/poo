package Classes;

import java.util.Date;

public class ClientePJ extends Cliente {
	//Attributes
	private String cnpj;
	private Date dataFundacao;
	private int qntFuncionarios;
	
	//Constructor 
	public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao, int qntFuncionarios) {
		super(nome, endereco); 
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qntFuncionarios = qntFuncionarios; //preciso fazer um set ou apenas get?
	}
	
	//Calcula Score
	public double calculaScore(){
		return(CalcSeguro.VALOR_BASE.getFator() * (1 + (qntFuncionarios*100)) * qnt_carros);
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
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public int setQntFuncionarios(int qntFuncionarios){
		this.qntFuncionarios = qntFuncionarios; //atualiza score? acho q n pq usa qntFunc direto no calcscore
	}
}
