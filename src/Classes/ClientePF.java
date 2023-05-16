package Classes;

import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;

	// Constructor
	public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao,
			LocalDate dataNascimento, String classeEconomica) {

		super(nome, endereco);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}

//Calcula Score
@Override
public double calculaScore(){
	LocalDate data_hoje = LocalDate.now();
	LocalDate data_nascimento = this.getDataNascimento();
	Period periodo = Period.between(data_nascimento, data_hoje);
	int idade = periodo.getYears();
	int qnt_carros = this.getListaVeiculos().size();

	if (idade >= 18 && idade < 30){
		return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * qnt_carros);
	}else if(idade >= 30 && idade < 60){
		return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * qnt_carros);
	}else{ //>=60 e <90
		return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * qnt_carros);
	}
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

}
