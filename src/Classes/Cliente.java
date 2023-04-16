package Classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	// Attributes
	private String nome;
	private String endereco;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos = new ArrayList<>();
	}
	
	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Veiculo> getListaVeiculos() { // nao faz sentido ter um set para alterar a lista
		return listaVeiculos;
	}
	//preciso add na lista de veiculos e tbm remover 
}