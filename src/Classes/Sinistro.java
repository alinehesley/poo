package Classes;

import java.util.UUID;

public class Sinistro {
	//Attributes
	private int id;
	private String data;
	private String endereco;
	
	//Constructor 
	public Sinistro (int id, String data, String endereco) {
		this.id = id;
		this.data = data;
		this.endereco = endereco;
	}
	//Getters e setters
	
	//String uniqueID = UUID.randomUUID().toString();
	
	//public int getId() {
		//return UUID.randomUUID().toString();
	//}
	
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

//funcao randomica para geracao de ID