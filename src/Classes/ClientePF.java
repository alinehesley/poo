package Classes;

import java.util.Date;

public class ClientePF extends Cliente {
	private String cpf;
	private Date dataNascimento;

	// Constructor
	public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero,
			String classeEconomica, String cpf, Date dataNascimento) {

		// chama o construtor da superclasse
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica);
		this.cpf = ApenasNumeros(cpf);
		this.dataNascimento = dataNascimento;
	}

//ToString
	public String toString() {
		return "Informações Cliente PF \nCPF: " + cpf + "\nData de nascimento: " + dataNascimento + "\n"; //add nome, endereco..?
	}

//Getters e Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

// VALIDAÇÃO DE CPF //
	public boolean validarCPF(String cpf) {
		if (QuantDigitosCPF(cpf) && DigitosIguais(cpf) == false && CalculaDigitosCPF(cpf))
			return true;
		return false;
	}

	// Remove todos os caracteres não numericos utilizando replaceAll
	private static String ApenasNumeros(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		return cpf;
	}

	// Verifica se o cpf possui 11 dígitos
	private boolean QuantDigitosCPF(String cpf) {
		if (cpf.length() != 11)
			return false;
		else {
			return true;
		}
	}

	// Verifica se todos os dígitos são iguais
	private boolean DigitosIguais(String cpf) {
		int i;
		for (i = 1; i < cpf.length(); i++)
			if (cpf.charAt(0) != cpf.charAt(i))
				return false;
		return true;
	}

	// Calcula os digitos verificadores
	private boolean CalculaDigitosCPF(String cpf) {
		int i;
		int soma_digito1 = 0;
		int soma_digito2 = 0;

		for (i = 0; i < 9; i++) {
			soma_digito1 += (cpf.charAt(i) - 48) * (10 - i);
		}
		int mod_soma1 = soma_digito1 % 11;
		int digito1 = cpf.charAt(9) - 48;

		if (mod_soma1 <= 1) {
			if (digito1 != 0)
				return false;
		} else {
			if (11 - mod_soma1 != digito1)
				return false;
		}
		for (i = 1; i < 10; i++) {
			soma_digito2 += (cpf.charAt(i) - 48) * (10 - i + 1);
		}
		int mod_soma2 = soma_digito2 % 11;
		int digito2 = cpf.charAt(10) - 48;

		if (mod_soma2 <= 1) {
			if (digito2 != 0)
				return false;
		} else {
			if (11 - mod_soma2 != digito2)
				return false;
		}

		return true;
	}
}
