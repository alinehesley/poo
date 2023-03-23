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
	 
	 //Verifica se todos os dígitos são iguais
	 
	 
	 
	 //Calcula os digitos verificadores (O que seria isso?)
	 
	 
	 
	 //Verifica se os digitos verificadores calculados são iguais
	 //aos digitos verificadores do cpf
	 
	 
	 
	 
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