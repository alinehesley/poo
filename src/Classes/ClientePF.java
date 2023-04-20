package Classes;

import java.util.Date;

public class ClientePF extends Cliente {
	private String cpf;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;

	// Constructor
	public ClientePF(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao,
			Date dataNascimento, String classeEconomica) {

		super(nome, endereco); // chama o construtor da superclasse
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}

//ToString
	@Override
	public String toString() {
		return "Informações Cliente PF\n" + "Nome: " + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCPF: "
				+ cpf + "\nGenêro: " + genero + "\nData Licença: " + dataLicenca + "\nEducação: " + educacao
				+ "\nData de Nascimento: " + dataNascimento + "\nClasse Econômica: " + classeEconomica + "\n";
	}

//Getters e Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	// VALIDAÇÃO DE CPF //
	public static boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		if (QuantDigitosCPF(cpf) && DigitosIguais(cpf) == false && CalculaDigitosCPF(cpf))
			return true;
		return false;
	}

	// Verifica se o cpf possui 11 dígitos
	private static boolean QuantDigitosCPF(String cpf) {
		if (cpf.length() != 11)
			return false;
		else {
			return true;
		}
	}

	// Verifica se todos os dígitos são iguais
	private static boolean DigitosIguais(String cpf) {
		int i;
		for (i = 1; i < cpf.length(); i++)
			if (cpf.charAt(0) != cpf.charAt(i))
				return false;
		return true;
	}

	// Calcula os digitos verificadores
	private static boolean CalculaDigitosCPF(String cpf) {
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
