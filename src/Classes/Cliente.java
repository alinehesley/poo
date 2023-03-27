package Classes;

public class Cliente {
  //Attributes
  private String nome;
  private String cpf;
  private String dataNascimento;
  private int idade;
  private String endereco;

  //Constructor 
  public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
    this.nome = nome;
    this.cpf = ApenasNumeros(cpf);
    this.dataNascimento = dataNascimento;
    this.idade = idade;
    this.endereco = endereco;
  }

  // VALIDAÇÃO DE CPF //
  public boolean validarCPF(String cpf) {
    if (QuantDigitosOk(cpf) && DigitosIguais(cpf) == false && CalculaDigitos(cpf))
      return true;
    return false;
  }

  //Remove todos os caracteres não numericos utilizando replaceAll
  private static String ApenasNumeros(String cpf) {
    cpf = cpf.replaceAll("[^0-9]", "");
    return cpf;
  }

  //Verifica se o cpf possui 11 dígitos
  private boolean QuantDigitosOk(String cpf) {
    if (cpf.length() != 11)
      return false;
    else {
      return true;
    }
  }

  //Verifica se todos os dígitos são iguais
  private boolean DigitosIguais(String cpf) {
    int i;
    for (i = 1; i < cpf.length(); i++)
      if (cpf.charAt(0) != cpf.charAt(i))
        return false;
    return true;
  }

  //Calcula os digitos verificadores
  private boolean CalculaDigitos(String cpf) {
    int i;
    int soma_digito1 = 0;
    int soma_digito2 = 0;

    for (i = 0; i < 9; i++) {
      soma_digito1 += (cpf.charAt(i) - 48) * (10 - i);
    }
    int mod_soma1 = soma_digito1 % 11;
    int digito1 = cpf.charAt(9) - 48;

    if (mod_soma1 <= 1) {
      if (digito1 != 0) return false;
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
      if (digito2 != 0) return false;
    } else {
      if (11 - mod_soma2 != digito2)
        return false;
    }

    return true;
  }

  //Retorna uma string com todos os atributos da classe Cliente
  public String toString() {
    return "Informações do Cliente\nNome:" + nome + "\nCPF:" + cpf + 
    		"\nData de Nascimento:" + dataNascimento +
    		"\nIdade:"+ idade + "\nEndereço:" + endereco + '\n';
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

  public int getIdade() {
    return idade;
  }
  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}