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

	public boolean atualizarFrota(String code_frota, Veiculo veiculo, int opcao) {
		// precisa cadastrar veiculo em um frota = 1
		if (opcao == 1) {
			return cadastrarVeiculo(veiculo, code_frota);
		} else if (opcao == 2) { // precisa remover veiculo de uma frota = 2
			return removerVeiculo(code_frota, veiculo.getPlaca());
		} else { // precisa remover a frota inteira = 3
			return removerFrota(code_frota);
		}
	}

	public boolean cadastrarVeiculo(Veiculo veiculo, String code_frota) {
		for (Frota f : listaFrota) {
			if (f.getCode().equals(code_frota)) {
				f.addVeiculoFrota(veiculo);
				System.out.println("Veiculo cadastrado com sucesso na frota code " + code_frota + " para cliente "
						+ this.getNome());
				return true;
			}
		}
		System.out.println("Frota code " + code_frota + " não encontrada para cadastrar veiculo.");
		return false;
	}

	public boolean removerFrota(String code_frota) {
		for (Frota f : listaFrota) {
			if (f.getCode().equals(code_frota)) {
				int k = listaFrota.indexOf(f);
				listaFrota.remove(k);
				System.out.println("Frota " + code_frota + " removida com sucesso do cliente " + this.getNome());
				return true;
			}
		}
		System.out.println("Frota " + code_frota + " não foi encontrada para remover.");
		return false;

	}

	public boolean removerVeiculo(String code_frota, String placa) {
		for (Frota f : listaFrota) {
			if (f.getCode().equals(code_frota)) {
				for (int k = 0; k < f.getListaVeiculos().size(); k++) {
					if (f.getListaVeiculos().get(k).getPlaca().equals(placa)) {
						f.getListaVeiculos().remove(k);
						System.out.println("Veiculo de placa " + placa + " removido com sucesso da frota " + code_frota
								+ " do cliente " + this.getNome());
						return true;
					}
				}
			}
		}

		System.out.println("Veiculo com a placa " + placa + " não encontrado para ser removido. ");
		return false;
	}

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
		return "Nome cliente PJ:" + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCNPJ: " + cnpj
				+ "\nData de fundação: " + dataFundacao + "\n";
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
