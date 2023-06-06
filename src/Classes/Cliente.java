package Classes;

public abstract class Cliente {
	// Attributes
	private String nome;
	private String endereco;
	private String telefone;
	private String email;

	// Constructor
	public Cliente(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Informações Cliente\n" + "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone
				+ "\nE-mail: " + email;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String endereco) {
		this.endereco = endereco;
	}

}