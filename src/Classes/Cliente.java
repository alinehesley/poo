package Classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	// Attributes
	private String nome;
	private String endereco;
	private List<Veiculo> listaVeiculos;
	private double valorSeguro;

	// Constructor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos = new ArrayList<>();
		//valorSeguro, calculado pela seguradora
	}
	
	@Override
	public String toString() {
		return "Informações Cliente\n" + "Nome: " + nome + "\nEndereço: " + endereco;
	}
	
	//public calculaScore
	
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

	public List<Veiculo> getListaVeiculos() { 
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public void addVeiculos(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public double getValorSeguro() {
		return valorSeguro;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
}