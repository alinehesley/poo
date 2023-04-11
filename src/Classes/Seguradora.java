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
		// retorno booleano
		// como faz o cadastro do cliente?
		//posso verificar se o cliente já esta cadastrado (verificar cpf) false
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
	
	
	//public List<Cliente> listarClientes(String tipoCliente){ //tipo de cliente eh PJ e PF
	//	List<Cliente> listaPedida = new ArrayList<>();
		//verificar se tipoCliente eh PJ ou PF
		//if(tipoCliente == "PF") {
			//percorrer lista buscando clientes que possuem cpf
			//for(Cliente c: listaClientes) {
				//if( //busca qm tem cpf) {
					//listaPedida.add(c);
				//}
			//}
		//}else {
			//eh PJ
			//buscar clientes que possuem cnpj
		//}
		
		//buscar e add nessa listaPedida conforme o tipo
		//return listaPedida;
		
	//} //str pj ou pf

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
