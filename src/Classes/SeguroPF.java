package Classes;

import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro {
	// Attributes
	private Veiculo veiculo;
	private ClientePF clientepf;

	// Constructor
	public SeguroPF(Veiculo veiculo, ClientePF clientepf, LocalDate dataInicio, LocalDate dataFim,
			Seguradora seguradora) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.clientepf = clientepf;
	}

	// calcularValor
	public void calcularValor() {
		LocalDate data_hoje = LocalDate.now();
		LocalDate data_nascimento = clientepf.getDataNascimento();
		Period periodo = Period.between(data_nascimento, data_hoje);
		int idade = periodo.getYears();
		int qnt_veiculos = clientepf.getListaVeiculos().size();
		int qnt_sinistroscliente = super.getSeguradora().getSinistrosPorCliente(clientepf).size();
		int qnt_sinistroscondutor = super.totalSinistrosPorCondutor();

		double x = (1 + 1 / (qnt_veiculos + 2)) * (2 + (qnt_sinistroscliente / 10))
				* (5 + (qnt_sinistroscondutor / 10));
		double resultado = 0.0;
		if (idade >= 18 && idade < 30) {
			resultado = (CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * x);
		} else if (idade >= 30 && idade < 60) {
			resultado = (CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * x);
		} else { // >=60 e <90
			resultado = (CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * x);
		}
		
		super.setValorMensal(resultado);

	}
	
	public void gerarSinistro() {
		System.out.println("sei la");
	}

	public void gerarSinistro(Condutor condutor) {
		System.out.println("sei la");
	}
	
	// Getters e Setters
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public ClientePF getClientepf() {
		return clientepf;
	}

	public void setClientePF(ClientePF clientepf) {
		this.clientepf = clientepf;
	}

	public Cliente getCliente() {
		return clientepf;
	}

}
