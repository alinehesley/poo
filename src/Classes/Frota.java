package Classes;

import java.util.List;
import java.util.ArrayList;

public class Frota {
	//Attributes 
	private String code;
	private List<Veiculo> listaVeiculos;
	
	//Constructor 
	public Frota(String code) {
		this.code = code;
		listaVeiculos = new ArrayList<>();
	}
	
	//melhorar
	public String toString() {
		return "O código desta frota de veículos é " + code;
	}
	
	//addVeiculoFrota
	//removeVeiculoFrota
	
	//Getters e Setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
}
