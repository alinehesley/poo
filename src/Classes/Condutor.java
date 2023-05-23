package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Condutor {
	//Attributes
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNascimento;
	private List<Sinistro> listaSinistros;
	
	//Constructor 
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
		listaSinistros = new ArrayList<>();
		
	}
	
	//public void adicionarSinistro() {}
	
	//Getters e Setters
	public String getCpf() {
		return cpf;
	}
	
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
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
