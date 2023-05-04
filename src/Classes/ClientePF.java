package Classes;

import java.util.Date;
import java.util.Calendar;

public class ClientePF extends Cliente {
	private final String cpf;
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

//Calcula Score
@Override
public double calculaScore(){
	//o valor é dado por
	//VALOR_BASE * FATOR_IDADE * qnt_carros
	Calendar c = c.getInstance();
	c.setTime(dataNascimento);
	int ano_nasc = c.get(Calendar.YEAR);
	int idade = 2023 - ano_nasc;
	int qnt_carros = this.listaVeiculos().size; //deste

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
				//coloco veiculos do cliente? sinistros?
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

}
