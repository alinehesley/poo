package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Condutor {
	// Attributes
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNascimento;
	private List<Sinistro> listaSinistros;

	// Constructor
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
		listaSinistros = new ArrayList<>();

	}

	//Adiciona um sinistro para um condutor
	public void adicionarSinistro(Sinistro sinistro) {
		int flag = 0;
		for (Sinistro s : listaSinistros) {
			if (s.getId() == sinistro.getId()) {
				System.out
						.println("Sinistro de ID " + sinistro.getId() + "já adicionado no condutor " + this.getNome());
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			listaSinistros.add(sinistro);
			System.out.print("Sinistro: " + sinistro.getId()
					+ "adicionado com sucesso na lista de Sinistros do condutor " + this.getNome());
		}
	}

	// Getters e Setters
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
