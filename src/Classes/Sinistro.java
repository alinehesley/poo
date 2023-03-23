package Classes;

import java.util.Random;

public class Sinistro {
	//Attributes
	private int id;
	private String data;
	private String endereco;
	
	//Constructor 
	public Sinistro (int id, String data, String endereco) {
		this.id = geraId(id);
		this.data = data;
		this.endereco = endereco;
	}
	
	//GerarID
	//aleatorio.nextInt((max - min) + 1) + min;
	private int geraId(int id) {
		Random aleatorio = new Random();
		this.id = aleatorio.nextInt(10000);
		return id;
	}
	
	//Getters e setters
	
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
}
