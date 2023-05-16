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
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;

	// Constructor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSinistros = new ArrayList<>();
		listaClientes = new ArrayList<>();
	}

	// Cadastra um cliente na seguradora, se já estiver castrado retorna false
	public boolean cadastrarCliente(Cliente cliente) {
		boolean ja_existe = listaClientes.contains(cliente);
		if (ja_existe) {
			return false;
		} else {
			listaClientes.add(cliente);
			return true;
		}
	}

	// Remove cliente PF ou PJ da listaClientes, retorna true se a operação for
	// realizada com sucesso
	public boolean removerCliente(String cpfoucnpj) {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();

		if (Validacao.validarCPF(cpfoucnpj)) { // entao eh cpf
			for (ClientePF cliente : listaPF) {
				if (cliente.getCpf().equals(cpfoucnpj)) {
					int i = listaClientes.indexOf(cliente);
					listaClientes.remove(i);
					break;
				}
			}
		} else if (Validacao.validarCNPJ(cpfoucnpj)) { // entao eh cnpj
			for (ClientePJ cliente : listaPJ) {
				if (cliente.getCnpj().equals(cpfoucnpj)) {
					int k = listaClientes.indexOf(cliente);
					listaClientes.remove(k);
					break;
				}
			}
		} else {
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

	// A seguradora gera um sinistro (ocorrência de acidente) para um cliente
	public boolean gerarSinistro(LocalDate data, String endereco, Veiculo veiculo, Cliente cliente) {
		Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
		listaSinistros.add(sinistro);
		return true;
	}

	// Imprime todos os sinistros associados a um CPF/CNPJ de um cliente
	public boolean visualizarSinistro(String cpfoucnpj) {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();

		cpfoucnpj = cpfoucnpj.replaceAll("[^0-9]", "");

		Cliente escolhido = null;

		if (Validacao.validarCPF(cpfoucnpj)) { // entao eh cpf
			for (ClientePF cliente : listaPF) {
				if (cliente.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
					escolhido = cliente;
					break;
				}
			}
		} else if (Validacao.validarCNPJ(cpfoucnpj)) {// entao eh cnpj
			for (ClientePJ cliente : listaPJ) {
				if (cliente.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
					escolhido = cliente;
					break;
				}
			}
		} else {
			System.out.println("Não existe sinistros no cpf/cnpj desse cliente");
			return false;
		}
		for (Sinistro s : listaSinistros) {
			if (s.getCliente() == escolhido) {
				System.out.println(s.toString());
			}
		}
		return true;
	}

	// Lista todos os sinistros registrados pela seguradora
	public void listarSinistro() {
		System.out.println("Listando todos os sinistros");
		for (Sinistro s : listaSinistros) {
			System.out.println(s.toString());
		}
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

	// Retorna o preço do seguro para Cliente PJ e PF
	public double calcularPrecoSeguroCliente(String cpfoucnpj) {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();
		int num_sinistros = 0;

		cpfoucnpj = cpfoucnpj.replaceAll("[^0-9]", "");

		Cliente escolhido = null;

		if (Validacao.validarCPF(cpfoucnpj)) { // entao eh cpf
			for (ClientePF cliente : listaPF) {
				if (cliente.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
					escolhido = cliente;
					break;
				}
			}
		} else if (Validacao.validarCNPJ(cpfoucnpj)) {// entao eh cnpj
			for (ClientePJ cliente : listaPJ) {
				if (cliente.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
					escolhido = cliente;
					break;
				}
			}
		} else {
			System.out.println("Não foi encontrado este cliente.");
			return 0;
		}
		for (Sinistro s : listaSinistros) {
			if (s.getCliente() == escolhido) {
				num_sinistros++;
			}
		}
		return (escolhido.calculaScore()) * (1 + num_sinistros);
	}

	// Retorna a receita total da seguradora
	public double calcularReceita() {
		List<ClientePF> listaPF = obterListaPF();
		List<ClientePJ> listaPJ = obterListaPJ();

		double total_receita = 0;

		for (ClientePF cliente : listaPF) {
			total_receita += calcularPrecoSeguroCliente(cliente.getCpf());
		}

		for (ClientePJ cliente : listaPJ) {
			total_receita += calcularPrecoSeguroCliente(cliente.getCnpj());
		}

		return total_receita;
	}

	public boolean excluirSinistro(String placaVeiculo, String nomeCliente) {
		for (int k = 0; k < listaSinistros.size(); k++) {
			if (listaSinistros.get(k).getVeiculo().getPlaca().equals(placaVeiculo)
					&& listaSinistros.get(k).getCliente().getNome().equals(nomeCliente)) {
				listaSinistros.remove(k);
				return true;
			}
		}
		return false;
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

	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

}
