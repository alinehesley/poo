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
	private List<Sinistro> listaSinistros; // sinistros do cliente
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
				System.out.println("Condutor de CPF: " + condutor.getCpf() + " já está autorizado");
				return false;
			}
		}
		listaCondutores.add(condutor);
		System.out.println("Condutor de CPF: " + condutor.getCpf() + " foi autorizado com sucesso.");
		return true;
	}

	// Desautoriza um condutor
	public boolean desautorizarCondutor(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		for (Condutor c : listaCondutores) {
			if (c.getCpf().replaceAll("[^0-9]", "").equals(cpf)) {
				int k = getListaCondutores().indexOf(c);
				listaCondutores.remove(k);
				System.out.println("Condutor de CPF: " + cpf + "desautorizado com sucesso.");
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
	}

	// Gera sinistro para um Condutor
	public void gerarSinistro(LocalDate data, String endereco, Condutor condutor) {
		Sinistro sinistro = new Sinistro(data, endereco, condutor, this);
		condutor.getListaSinistros().add(sinistro);
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

	public abstract Cliente getCliente();

//	// A seguradora gera um sinistro (ocorrência de acidente) para um cliente
//	public boolean gerarSinistro(LocalDate data, String endereco, Veiculo veiculo, Cliente cliente) {
//		Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente, condutor);
//		listaSinistros.add(sinistro);
//		return true;
//	}
//
//	public boolean gerarSinistro(LocalDate data, String endereco, String placa, String cpfcnpj) {
//		Cliente cliente = null;
//		Veiculo veiculo = null;
//		List<ClientePF> listaPF = Seguradora.obterListaPF();
//		List<ClientePJ> listaPJ = Seguradora.obterListaPJ();
//
//		for (ClientePF c_pf : listaPF) {
//			if (c_pf.getCpf().equals(cpfcnpj)) {
//				cliente = c_pf;
//				break;
//			}
//		}
//		for (ClientePJ c_pj : listaPJ) {
//			if (c_pj.getCnpj().equals(cpfcnpj)) {
//				cliente = c_pj;
//				break;
//			}
//		}
//		if (cliente == null) {
//			System.out.println("Cliente nao encontrado no registro");
//			return false;
//		}
//		return true;
//
//	}

//	// Imprime todos os sinistros associados a um CPF/CNPJ de um cliente
//	public boolean visualizarSinistro(String cpfoucnpj) {
//		List<ClientePF> listaPF = obterListaPF();
//		List<ClientePJ> listaPJ = obterListaPJ();
//
//		cpfoucnpj = cpfoucnpj.replaceAll("[^0-9]", "");
//
//		Cliente escolhido = null;
//
//		if (Validacao.validarCPF(cpfoucnpj)) { // entao eh cpf
//			for (ClientePF cliente : listaPF) {
//				if (cliente.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
//					escolhido = cliente;
//					break;
//				}
//			}
//		} else if (Validacao.validarCNPJ(cpfoucnpj)) {// entao eh cnpj
//			for (ClientePJ cliente : listaPJ) {
//				if (cliente.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
//					escolhido = cliente;
//					break;
//				}
//			}
//		} else {
//			System.out.println("Não existe sinistros no cpf/cnpj desse cliente");
//			return false;
//		}
//		for (Sinistro s : listaSinistros) {
//			if (s.getCliente() == escolhido) {
//				System.out.println(s.toString());
//			}
//		}
//		return true;
//	}
//
//	// Lista todos os sinistros registrados pela seguradora
//	public void listarSinistro() {
//		System.out.println("Listando todos os sinistros");
//		for (Sinistro s : listaSinistros) {
//			System.out.println(s.toString());
//		}
//	}
//
//	public boolean excluirSinistro(String placaVeiculo, String nomeCliente) {
//		for (int k = 0; k < listaSinistros.size(); k++) {
//			if (listaSinistros.get(k).getVeiculo().getPlaca().equals(placaVeiculo)
//					&& listaSinistros.get(k).getCliente().getNome().equals(nomeCliente)) {
//				listaSinistros.remove(k);
//				return true;
//			}
//		}
//		return false;
//	}

}
