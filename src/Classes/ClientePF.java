package Classes;

import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao,
			LocalDate dataNascimento, String classeEconomica, String telefone, String email) {

		super(nome, endereco, telefone, email);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}

//ToString
	@Override
	public String toString() {
		return "Informações Cliente PF\n" + "Nome: " + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCPF: "
				+ cpf + "\nGenêro: " + genero + "\nData Licença: " + dataLicenca + "\nEducação: " + educacao
				+ "\nData de Nascimento: " + dataNascimento + "\nClasse Econômica: " + classeEconomica + "\n";
	}

	public boolean cadastrarVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
		return true;
	}

	public boolean removerVeiculo(Veiculo veiculo) {
		for (int k = 0; k < listaVeiculos.size(); k++) {
			if (listaVeiculos.get(k).getPlaca().equals(veiculo.getPlaca())) {
				listaVeiculos.remove(k);
				return true;
			}
		}
		return false;
	}

	public void clearListaVeiculo() {
		listaVeiculos.clear();
	}

//Getters e Setters
	public String getCpf() {
		return cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

}
