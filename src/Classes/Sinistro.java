package Classes;

import java.time.LocalDate;

public class Sinistro {
	// Attributes
	private final int id;
	private static int cont = 0;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;

	// Constructor
	public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = geraId();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}

	// GerarID
	private int geraId() {
		Sinistro.cont += 1;
		return cont;
	}

	// toString
	public String toString() {
		return "Informações Sinistro \nID :" + id + "\nData do Ocorrido: " + data + "\nEndereço: " + endereco
				+ "\nCondutor responsável: " + condutor.getNome() + "\nId do seguro: " + seguro.getId() + "\n";
	}

	// Getters e setters
	public int getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
}
