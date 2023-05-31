package Classes;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
	// Attributes
	private final String cnpj;
	private LocalDate dataFundacao;
	private List<Frota> listaFrota;

	// Constructor
	public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, String telefone, String email) {
		super(nome, endereco, telefone, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.listaFrota = new ArrayList<>();
	}

	public boolean cadastrarFrota(Frota frota) {
		if (listaFrota.contains(frota)) {
			System.out.println("Essa frota já esta cadastrada. ");
			return false;
		}
		listaFrota.add(frota);
		System.out.println(
				"Frota de code " + frota.getCode() + " cadastrado com sucesso para o cliente " + this.getNome() + ".");
		return true;
	}

//	public boolean atualizarFrota() {
//		// precisa cadastrar veiculo em um frota
//		// precisa remover veiculo de uma frota
//		// precisa remover a frota inteira
//	}

	public boolean getVeiculosPorFrota(String code_frota) {
		List<Veiculo> listaVeiculosFrota = new ArrayList<>();
		int flag = 0;
		for (Frota f : listaFrota) {
			if (f.getCode().equals(code_frota)) {
				listaVeiculosFrota = f.getListaVeiculos();
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println("Lista de veiculos cadastrados na frota de code " + code_frota);
			for (Veiculo v : listaVeiculosFrota) {
				System.out.println(v.toString());
			}
			return true;

		}
		System.out.println("Não foi encontrada uma frota de code " + code_frota + "para listar veiculos.");
		return false;
	}

	// ToString
	@Override
	public String toString() {
		return "Informações Cliente PJ \nNome:" + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCNPJ: "
				+ cnpj + "\nData de fundação: " + dataFundacao + "\n";
	}

	// Getters e Setters
	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public List<Frota> getListaFrota() {
		return listaFrota;
	}

}
