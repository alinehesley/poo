package Classes;

import java.util.ArrayList;
import java.util.List;

public class Seguradora {
	// Attributes
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	@SuppressWarnings("unused")
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

	public boolean cadastrarCliente(Cliente cliente) {
		// lista.contains()
		for (Cliente c : listaClientes) {
			if (c.getNome() == cliente.getNome()) { // melhor verificar pelo cpf/cnpj
				return false;
			}
		}
		listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(Cliente cliente) {
		int i = listaClientes.indexOf(cliente);
		try {
			listaClientes.remove(i);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public List<Cliente> listarClientes(String tipoCliente) { // tipo de cliente eh PJ e PF
		List<Cliente> listaPF = new ArrayList<>();
		List<Cliente> listaPJ = new ArrayList<>();

		for (Cliente c : listaClientes) {
			if (c instanceof ClientePF) {
				ClientePF c_pf = (ClientePF) c; //casting
				listaPF.add(c_pf);
			} else {
				ClientePJ c_pj = (ClientePJ) c;
				listaPJ.add(c_pj);
			}
		}
		
		
		if (tipoCliente == "PJ") {
			return listaPJ;
		} else {
			return listaPF;
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
}
