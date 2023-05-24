package Classes;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
	//Attributes
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qntFuncionarios;
	private List<Frota> listaFrota;
	
	//Constructor 
	public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, int qntFuncionarios, String telefone, String email) {
		super(nome, endereco, telefone, email); 
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qntFuncionarios = qntFuncionarios;
		this.listaFrota = new ArrayList<>();
	}
	
	public boolean cadastrarFrota(Frota frota) {
		listaFrota.add(frota);
		return true;
	}
	
	public boolean atualizarFrota(List<Frota> listaFrota) { //errado revise!!
		this.listaFrota = listaFrota;
		return true;
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
		this.qntFuncionarios = qntFuncionarios; 
	}
	//getVeiculosPorFrota: boolean?? n deveria devolver uma lista de veiculos?
}
