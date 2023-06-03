package Classes;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Seguradora {
	// Attributes
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Cliente> listaClientes;
	private List<Seguro> listaSeguros;
	private final String cnpj;

	// Constructor
	public Seguradora(String nome, String telefone, String email, String endereco, String cnpj) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaClientes = new ArrayList<>();
		listaSeguros = new ArrayList<>();
		this.cnpj = cnpj;
	}

	// Cadastra um cliente na seguradora, se já estiver castrado retorna false
	public boolean cadastrarCliente(Cliente cliente) {
		boolean ja_existe = listaClientes.contains(cliente);
		if (ja_existe) {
			System.out.println("O Cliente" + cliente.getNome() + "já está cadastrado nesta seguradora.");
			return false;
		} else {
			listaClientes.add(cliente);
			System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso. ");
			return true;
		}
	}

	// Remove cliente PF ou PJ da listaClientes, retorna true se remover
	public boolean removerCliente(String cpfoucnpj) {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();

		if (Validacao.validarCPF(cpfoucnpj)) { // entao eh cpf
			for (ClientePF cliente : listaPF) {
				if (cliente.getCpf().equals(cpfoucnpj)) {
					int i = listaClientes.indexOf(cliente);
					listaClientes.remove(i);
					System.out.println("Cliente PF removido com sucesso da seguradora. ");
					break;
				}
			}
		} else if (Validacao.validarCNPJ(cpfoucnpj)) { // entao eh cnpj
			for (ClientePJ cliente : listaPJ) {
				if (cliente.getCnpj().equals(cpfoucnpj)) {
					int k = listaClientes.indexOf(cliente);
					listaClientes.remove(k);
					System.out.println("Cliente PJ removido com sucesso da seguradora. ");
					break;
				}
			}
		} else {
			System.out.println("Cliente não encontrado. ");
			return false;
		}
		return true;
	}

	// Imprime na tela os clientes PJ ou PF conforme o parâmetro passado
	public void listarClientes(String tipoCliente) {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();

		if (tipoCliente.equals("PJ")) {
			for (ClientePJ c : listaPJ) {
				System.out.println(c.toString());
			}
		} else if (tipoCliente.equals("PF")) {
			for (ClientePF c : listaPF) {
				System.out.println(c.toString());
			}
		} else {
			System.out.println("Não existe.");
		}
	}

	// gera seguro para PF, CONFIRMAR SE É VEICULO MSM
	public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo, ClientePF clientepf) {
		Seguro seguropf = new SeguroPF(veiculo, clientepf, dataInicio, dataFim, this);
		if (listaSeguros.contains(seguropf)) {
			System.out.println("Esse seguro já existe.");
		}
		listaSeguros.add(seguropf);
		System.out.println("Seguro cadastrado com sucesso. Id do seguro = " + seguropf.getId());
		return true;
	}

	// gera seguro para PJ
	public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Frota frota, ClientePJ clientepj) {
		Seguro seguropj = new SeguroPJ(frota, clientepj, dataInicio, dataFim, this);
		if (listaSeguros.contains(seguropj)) {
			System.out.println("Esse seguro já existe.");
		}
		listaSeguros.add(seguropj);
		System.out.println("Seguro cadastrado com sucesso. Id do seguro = " + seguropj.getId());
		return true;
	}

	public boolean cancelarSeguro(int id) {
		for (Seguro s : listaSeguros) {
			if (s.getId() == id) {
				int k = listaSeguros.indexOf(s);
				listaSeguros.remove(k);
				System.out.println("Seguro de " + id + " removido com sucesso.");
				return true;
			}
		}
		System.out.println("Seguro de ID: " + id + " não encontrado.");
		return false;
	}

	// Retorna a lista de Clientes PJ
	public List<ClientePJ> obterListaPJ() {
		List<ClientePJ> listaPJ = new ArrayList<>();
		for (Cliente c : listaClientes) {
			if (c instanceof ClientePJ) {
				ClientePJ c_pj = (ClientePJ) c; // casting
				listaPJ.add(c_pj);
			}
		}
		return listaPJ;
	}

	// Retorna a lista de Clientes PF
	public List<ClientePF> obterListaPF() {
		List<ClientePF> listaPF = new ArrayList<>();
		for (Cliente c : listaClientes) {
			if (c instanceof ClientePF) {
				ClientePF c_pf = (ClientePF) c; // casting
				listaPF.add(c_pf);
			}
		}
		return listaPF;
	}

	// Retorna a receita total da seguradora (soma de todos valores mensais)
	public void calcularReceita() {
		double receita = 0.0;
		for (Seguro s : listaSeguros) {
			receita += s.getValorMensal();
		}
		System.out.println("A receita total da seguradora " + this.getNome() + "é de R$" + receita);
	}

	// Retorna a lista de seguros associada ao cliente desejado
	public List<Seguro> getSegurosPorCliente(Cliente cliente) {
		List<Seguro> segurosCliente = new ArrayList<>();
		for (Seguro seguro : listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				segurosCliente.add(seguro);
			}
		}
		return segurosCliente;
	}

//Nesse caso devolve apenas os sinistros do Cliente em si, não dos condutores associados a ele e o seguro
	public List<Sinistro> getSinistrosPorCliente(Cliente cliente) {
		List<Sinistro> sinistrosCliente = new ArrayList<>();
		List<Seguro> listaSeguros = this.getListaSeguros();
		for (Seguro s : listaSeguros) {
			if (s.getCliente().equals(cliente)) {
				sinistrosCliente.addAll(s.getListaSinistros());
			}
		}
		return sinistrosCliente;
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public List<Seguro> getListaSeguros() {
		return listaSeguros;
	}

}
