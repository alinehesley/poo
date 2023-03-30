package Classes;

import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	//Attributes
	private String cnpj;
	private Date dataFundacao;
	
	//Constructor 
	public ClientePJ(String nome, String endereco, Date dataLicenca, String educacao,
			String genero, String classeEconomica, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao) {
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica); ////listaVeiculos pq tem isso no exemplo?
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	
	//ToString
	public String toString() {
		return "Informações Cliente PJ \nCNPJ:" + cnpj + 
				"\n Data de fundação:" + dataFundacao + "\n";
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
	
	//VALIDAÇÃO DE CNPJ//

}
