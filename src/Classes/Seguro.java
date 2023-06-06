package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Seguro {
	private final int id;
	private static int cont = 0;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	private List<Sinistro> listaSinistros; // sinistrfos do cliente
	private List<Condutor> listaCondutores;
	private double valorMensal;

	// Constructor
	public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
		this.id = geraId();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = new ArrayList<>();
		this.listaCondutores = new ArrayList<>();
	}

	// GerarID
	private int geraId() {
		Seguro.cont += 1;
		return cont;
	}

	// Autoriza um condutor
	public boolean autorizarCondutor(Condutor condutor) {
		for (Condutor c : listaCondutores) {
			if (c.getCpf().replaceAll("[^0-9]", "").equals(condutor.getCpf().replaceAll("[^0-9]", ""))) {
				System.out.println("Condutor de CPF: " + condutor.getCpf() + " já está autorizado pelo cliente "
						+ this.getCliente().getNome() + " no seguro de ID: " + id);
				return false;
			}
		}
		listaCondutores.add(condutor);
		System.out.println("Condutor de CPF: " + condutor.getCpf() + " foi autorizado com sucesso pelo cliente "
				+ this.getCliente().getNome() + " no seguro de ID: " + id);
		return true;
	}

	// Desautoriza um condutor
	public boolean desautorizarCondutor(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		for (Condutor c : listaCondutores) {
			if (c.getCpf().replaceAll("[^0-9]", "").equals(cpf)) {
				int k = getListaCondutores().indexOf(c);
				listaCondutores.remove(k);
				System.out.println("Condutor de CPF: " + cpf + "desautorizado com sucesso pelo cliente "
						+ this.getCliente().getNome());
				return true;
			}
		}
		System.out.println("Não foi encontrado condutor de CPF: " + cpf + " para ser desautorizado.");
		return false;
	}

	public abstract void calcularValor();

	// Gerar sinistro para um Cliente
	public void gerarSinistro(LocalDate data, String endereco) {
		Sinistro sinistro = new Sinistro(data, endereco, null, this);
		this.getListaSinistros().add(sinistro); // p cliente
		System.out.println("Sinistro gerado com sucesso para o cliente " + this.getCliente().getNome()
				+ " o ID do sinistro é: " + sinistro.getId() + " o ID do seguro é " + id);
	}

	// Gera sinistro para um Condutor
	public void gerarSinistro(LocalDate data, String endereco, Condutor condutor) {
		if (listaCondutores.contains(condutor)) {
			Sinistro sinistro = new Sinistro(data, endereco, condutor, this);
			condutor.getListaSinistros().add(sinistro); // procurar o sinistro q tem o ID do seguro passado
			System.out.println("Sinistro para condutor " + condutor.getNome() + "gerado com sucesso o ID do sinistro é:"
					+ sinistro.getId() + " o ID do seguro é " + id);

		} else {
			System.out.println("Condutor " + condutor.getNome() + " não encontrado na lista de condutores");
		}

	}

	// A lista de condutores que um cliente possui,
	// cada condutor possui uma lista de sinistros
	public int totalSinistrosPorCondutor() {
		int total = 0;
		for (Condutor c : listaCondutores) {
			total += c.getListaSinistros().size();
		}
		return total;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public List<Condutor> getListaCondutores() {
		return listaCondutores;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public void exclui_sinistro(int opcao, int idsinistro, String cpfcondutor) {
		if (opcao == 1) { // eh cliente, busca sinistro em listaSinistros
			for (Sinistro s : listaSinistros) {
				if (s.getId() == idsinistro) {
					int k = listaSinistros.indexOf(s);
					listaSinistros.remove(k);
					System.out.println("Sinistro de ID: " + idsinistro + " removido com sucesso do cliente "
							+ getCliente().getNome());
				}
			}
		} else if (opcao == 2) { // eh um condutor
			for (Condutor c : listaCondutores) {
				List<Sinistro> listSinistroCondutor = c.getListaSinistros();
				for (Sinistro s : listSinistroCondutor) {
					if (s.getId() == idsinistro && c.getCpf().equals(cpfcondutor)) {
						int k = listSinistroCondutor.indexOf(s);
						listSinistroCondutor.remove(k);
						System.out.println(
								"Sinistro de ID: " + idsinistro + " removido com sucesso do condutor " + c.getNome());
					}
				}
			}
		}
	}

	public abstract Cliente getCliente();

	@Override
	public String toString() {
		return "ID: " + this.id + "\n" + "Data Inicio: " + this.dataInicio + "\n" + "Data Fim: " + this.dataFim + "\n"
				+ "Seguradora: " + this.seguradora.getNome() + "\n" + "Valor Mensal: "
				+ String.format("%.2f", this.valorMensal) + "\n";
	}

}
