package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	// Attributes
	private String nome;
	private String endereco;
	private Date dataLicenca; 
	private String educacao;
	private String genero;
	private String classeEconomica;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		listaVeiculos = new ArrayList<>();
		
	}

	// Retorna uma string com todos os atributos da classe Cliente // retorno listaVeiculos no toString?
	public String toString() {
		return "Informações do Cliente\nNome:" + nome + "\nEndereço:" + endereco + "\nData da Licença:" + dataLicenca
				+ "\nEducacão:" + educacao + "\nGênero:" + genero + "\nClasse Econômica:" + classeEconomica + "\n";

	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public List<Veiculo> getListaVeiculos() { //nao faz sentido ter um set para alterar a lista
		return listaVeiculos;
	}
}