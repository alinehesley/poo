package Classes;

public class Veiculo {
	// Attributes
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;

	// Constructor
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}

	// toString

	public String toString() {
		return "Informações do Veículo\nPlaca:" + placa + "\nMarca:" + marca + "\nModelo:" + modelo
				+ "\nAno de fabricacão:" + anoFabricacao + "\n";
	}

	// Getters

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

}
