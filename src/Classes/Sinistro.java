package Classes;

import java.util.Date;

public class Sinistro {
	// Attributes
	private final int id;
	private static int cont = 0;
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

	// Constructor
	public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = geraId();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	// GerarID
	private int geraId() {
		Sinistro.cont += 1;
		return cont;
	}

	// toString
	public String toString() {
		return "Informações Sinistro \nID :" + id + "\nData do Ocorrido: " + data + "\nEndereço: " + endereco
				+ "\nSeguradora: " + seguradora.getNome() + "\nCliente: " + cliente.getNome() + "\n";
	}

	// Getters e setters
	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
