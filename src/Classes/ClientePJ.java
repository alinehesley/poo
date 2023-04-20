package Classes;

import java.util.Date;

public class ClientePJ extends Cliente {
	//Attributes
	private String cnpj;
	private Date dataFundacao;
	
	//Constructor 
	public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao) {
		super(nome, endereco); 
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Informações Cliente PJ \nNome:" + this.getNome() + "\nEndereço: " + this.getEndereco() + "\nCNPJ: " + cnpj + "\nData de fundação: " + dataFundacao + "\n";
	}
	
	
	//Getters e Setters
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	//VALIDAÇÃO DE CNPJ//
	
	public static boolean validarCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[^0-9]", "");
		if(QuantDigitosCNPJ(cnpj) && CalculaDigitosCNPJ(cnpj))
			return true;
		return false;
	}
	
	//Verifica se o cnpj possui 14 digitos
	private static boolean QuantDigitosCNPJ(String cnpj) {
		if (cnpj.length() != 14) {
            return false;
        }
		return true;
	}
	
	//Calcula os digitos verificadores CNPJ
	public static boolean CalculaDigitosCNPJ(String cnpj) {
		int i;	
		int soma_digito1 = 0;
		int soma_digito2 = 0;
		int digito1;
		int digito2;
		
		int[] m1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] m2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        
        for (i = 0; i < 12; i++) {
			soma_digito1 += (cnpj.charAt(i) - 48) * m1[i];
			}
        
        int mod_digito1 = soma_digito1 % 11;
        if(mod_digito1 < 2) {
        	digito1 = 0;
        }else {
        	digito1 = 11 - mod_digito1;
        }
        
        for (i = 0; i < 13; i++) {
			soma_digito2 += (cnpj.charAt(i) - 48) * m2[i];
			}
        
        int mod_digito2 = soma_digito2 % 11;
        if(mod_digito2 < 2) {
        	digito2 = 0;
        }else {
        	digito2 = 11 - mod_digito2;
        }
        
        if(digito1 == (cnpj.charAt(12)-48) && digito2 == (cnpj.charAt(13)-48)) {
        	return true;
        }
        return false;
	}
}
