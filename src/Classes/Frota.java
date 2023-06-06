package Classes;

import java.util.List;
import java.util.ArrayList;

public class Frota {
	// Attributes
	private String code;
	private List<Veiculo> listaVeiculos;

	// Constructor
	public Frota(String code) {
		this.code = code;
		listaVeiculos = new ArrayList<>();
	}

	// melhorar
	public String toString() {
		return "O código desta frota de veículos é " + code + ", possui " + listaVeiculos.size()
				+ " veiculos cadastrados.\n";
	}

	// Adiciona um veiculo na lista de veiculos da frota
	public boolean addVeiculoFrota(Veiculo veiculo) {
		for (Veiculo v : listaVeiculos) {
			if (v.getPlaca().equals(veiculo.getPlaca())) {
				System.out.println("Já existe um veiculo cadastrado com essa placa " + veiculo.getPlaca());
				return false;
			}
		}
		listaVeiculos.add(veiculo);
		System.out.println(
				"Veiculo de placa " + veiculo.getPlaca() + " adicionado com sucesso na frota code " + this.getCode());
		return true;
	}

	// Remove um veiculo da listadeveiculos da Frota pela placa
	public boolean removeVeiculoFrota(String placa) {
		for (Veiculo v : listaVeiculos) {
			if (v.getPlaca().equals(placa)) {
				int k = listaVeiculos.indexOf(v);
				listaVeiculos.remove(k);
				System.out
						.println("Veiculo de placa " + placa + " removido com sucesso da frota code " + this.getCode());
				return true;
			}
		}
		System.out.print(
				"Veiculo de placa " + placa + "não encontrado para ser removido da frota code " + this.getCode());
		return false;
	}

	public void clearListaVeiculo() {
		listaVeiculos.clear();
	}

	// Getters e Setters
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
