package Classes;

public class Cliente {
	//Attributes
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//Constructor 
	public Cliente (String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	
	// VALIDAÇÃO DE CPF //
	
	private boolean validarCPF(String cpf) {
		//Pq foi colocado no UML String se não é num?
		cpf = ApenasNumeros(cpf);
		if(QuantDigitosOk(cpf) && DigitosIguais(cpf) && CalculaDigitos(cpf))
			return true;
		return false;
		
	}
	
	//Remove todos os caracteres não numericos utilizando replaceAll
	public static String ApenasNumeros(String cpf){
		   cpf = cpf.replaceAll("[^0-9]","");
		   return cpf;
		}
	
	//Verifica se possui 11 dígitos
	private boolean QuantDigitosOk(String cpf){  
	      if (cpf.length() != 11 )
	        return false;  
	      else {
	    	return true;
	      }
	  }
	 
	 //Verifica se todos os dígitos são iguais	 @SuppressWarnings("unused")
	private boolean DigitosIguais(String cpf) {
		 int i;
		 for (i = 1; i < cpf.length(); i++)
		        if (cpf.charAt(0) != cpf.charAt(i))
		          return false;
		      return true;
	 }
	 
	 //Calcula os digitos verificadores (O que seria isso?)
	 private boolean CalculaDigitos(String cpf) {
		 //cpf string, pego cada caractere .charAt
		 int i;
		 int soma_digito1 = 0;
		 int soma_digito2 = 0;
		 
		 for(i = 0; i < 9; i++) {
			 soma_digito1 += cpf.charAt(i)-48 * (i+1);
		 }
		 int mod_soma1 = soma_digito1%11;
		 int digito1 = cpf.charAt(9)-48;
		 if(mod_soma1 != digito1)
			 return false;
		 
		 for(i = 0; i < 10; i++) {
			 soma_digito2 += cpf.charAt(i)-48 * (i+1);
		 }
		 int mod_soma2 = soma_digito2%11;
		 int digito2 = cpf.charAt(10)-48;
		 if(mod_soma2 != digito2)
			 return false;
		 
		 return true;
	 }
	 

	 
	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade(int idade) {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco(String endereco) {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}