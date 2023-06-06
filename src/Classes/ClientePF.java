package Classes;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public ClientePF(String nome, String endereco, String cpf, String genero, String educacao, LocalDate dataNascimento,
			String telefone, String email) {
		super(nome, endereco, telefone, email);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		listaVeiculos = new ArrayList<>();
	}

//ToString
	@Override
	public String toString() {
		return "Nome cliente PF: " + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCPF: " + cpf
				+ "\nGenêro: " + genero + "\nEducação: " + educacao + "\nData de Nascimento: " + dataNascimento + "\n";
	}

	// Castra um veiculo na listaVieuclos do cliente
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		if (listaVeiculos.contains(veiculo)) {
			System.out.println("Esse veiculo já esta cadastrado. ");
			return false;
		}
		listaVeiculos.add(veiculo);
		System.out.println("Veiculo de placa " + veiculo.getPlaca() + " cadastrado com sucesso para o cliente "
				+ this.getNome() + ".");
		return true;
	}

	// Remove veiculo pela placa
	public boolean removerVeiculo(String placa) {
		for (int k = 0; k < listaVeiculos.size(); k++) {
			if (listaVeiculos.get(k).getPlaca().equals(placa)) {
				listaVeiculos.remove(k);
				System.out.println("Veiculo de placa " + placa + " removido com sucesso do cliente " + this.getNome());
				return true;
			}
		}
		System.out.println("Veiculo com a placa " + placa + " não encontrado para ser removido. ");
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

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
}
