package Classes;

import java.util.ArrayList;
import java.util.Date;
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

	public boolean removerCliente(String cpfoucnpj) {
		List<ClientePF> listaPF = new ArrayList<>();
		List<ClientePJ> listaPJ = new ArrayList<>();
		
		for (Cliente c : listaClientes) {
			if (c instanceof ClientePF) {
				ClientePF c_pf = (ClientePF) c; // casting
				listaPF.add(c_pf);
			} else {
				ClientePJ c_pj = (ClientePJ) c;
				listaPJ.add(c_pj);
			}
		}
		
		if(ClientePF.validarCPF(cpfoucnpj)) { //entao eh cpf
			for(ClientePF cliente : listaPF) {
				if(cliente.getCpf() == cpfoucnpj) {
					int i = listaClientes.indexOf(cliente);
					listaClientes.remove(i);
					System.out.println("Cliente com cpf removido com sucesso!");
				}
			}
		}else if(ClientePJ.validarCNPJ(cpfoucnpj)) { //entao eh cnpj
			for(ClientePJ cliente : listaPJ) {
				if(cliente.getCnpj() == cpfoucnpj) {
					int k = listaClientes.indexOf(cliente);
					listaClientes.remove(k);
				}
			}
		}else {
			System.out.println("Não existe");
			return false;
		}
		return true;
	}

	// Devolve a lista de clientes PF ou PJ conforme o tipoCliente passado por
	// parâmetro
	public void listarClientes(String tipoCliente) { // tipo de cliente eh PJ e PF
		List<ClientePF> listaPF = new ArrayList<>();
		List<ClientePJ> listaPJ = new ArrayList<>();

		for (Cliente c : listaClientes) {
			if (c instanceof ClientePF) {
				ClientePF c_pf = (ClientePF) c; // casting
				listaPF.add(c_pf);
			} else {
				ClientePJ c_pj = (ClientePJ) c;
				listaPJ.add(c_pj);
			}
		}
		if (tipoCliente == "PJ") {
			for (ClientePJ c : listaPJ) {
				System.out.println(c.toString());
			}
		} else if (tipoCliente == "PF") {
			for (ClientePF c : listaPF) {
				System.out.println(c.toString());
			}
		} else {
			System.out.println("Não existe");
		}
	}

	// A seguradora gera um sinistro (ocorrência de acidente) para um cliente
	public boolean gerarSinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) { // perguntar
																														// PED
		Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
		listaSinistros.add(sinistro);
		return true;
	}

	// Lista os sinistros associados a um cliente
	public List<Sinistro> visualizarSinistro(Cliente cliente) { // pra mim faz mais sentido passar o tipo Cliente
		List<Sinistro> ListaSinistros_cliente = new ArrayList<>();
		for (Sinistro s : listaSinistros) {
			if (s.getCliente() == cliente) {
				ListaSinistros_cliente.add(s);
			}
		}
		return ListaSinistros_cliente;
	}

	// Lista todos os sinistros registrados pela seguradora
	public void listarSinistro() {
		System.out.println("Listando Sinistros");
		for (Sinistro s : listaSinistros) {
			System.out.println(s.toString());
		}
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
