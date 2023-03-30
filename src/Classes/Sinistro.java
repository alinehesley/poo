package Classes;

import java.util.Random;

public class Sinistro {
	//Attributes
	private int id; //AGORA ELE DEVE SER ÚNICO UMA VARIAVEL FINAL, ESCREVER ID.
	private String data;
	private String endereco;
	private Seguradora Seguradora;
	private Veiculo Veiculo;
	private Cliente Cliente;
	
	//Constructor 
	public Sinistro (String data, String endereco, Seguradora Seguradora, Veiculo Veiculo, Cliente Cliente) {
		this.id = geraId();
		this.data = data;
		this.endereco = endereco;
		this.Seguradora = Seguradora;
		this.Veiculo = Veiculo;
		this.Cliente = Cliente;
	}
	
	//GerarID
	//aleatorio.nextInt((max - min) + 1) + min;
	private int geraId() {
		Random aleatorio = new Random();
		this.id = aleatorio.nextInt(10000);
		return id;
	}
	
	//toString
	
	
	//Getters e setters
	public int getId() {
		return geraId();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguradora getSeguradora() {
		return Seguradora;
	}
	public void setSeguradora(Seguradora Seguradora) {
		this.Seguradora = Seguradora;
	}
	
	public Veiculo getVeiculo() {
		return Veiculo;
	}
	public void setVeiculo(Veiculo Veiculo) {
		this.Veiculo = Veiculo;
	}
	
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente Cliente) {
		this.Cliente = Cliente;
	}
}
