package Classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SeguroPJ extends Seguro {
	// Attributes
	private Frota frota;
	private ClientePJ clientepj;

	// Constructor
	public SeguroPJ(Frota frota, ClientePJ clientepj, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.clientepj = clientepj;
	}

	public double calcularValor() {
		int qnt_funcionarios = clientepj.getQntFuncionarios();
		int qnt_veiculos = frota.getListaVeiculos().size();

		LocalDate data_hoje = LocalDate.now();
		LocalDate data_fundacao = clientepj.getDataFundacao();
		Period periodo = Period.between(data_fundacao, data_hoje);
		int anos_posfundacao = periodo.getYears();
		int qnt_sinistroscliente = getSeguradora().getSinistrosPorCliente(clientepj).size();
		int qnt_sinistroscondutor = this.totalSinistrosCondutor();

		double resultado = CalcSeguro.VALOR_BASE.getFator() * (10 + (qnt_funcionarios) / 10)
				* (1 + 1 / (qnt_veiculos + 2)) * (1 + 1 / (anos_posfundacao + 2)) * (2 + qnt_sinistroscliente / 10)
				* (5 + qnt_sinistroscondutor / 10);

		return resultado;
	}

	// Getters e Setters
	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	public ClientePJ getClientepj() {
		return clientepj;
	}

	public Cliente getCliente() {
		return clientepj;
	}

	public void setClientePJ(ClientePJ clientepj) {
		this.clientepj = clientepj;
	}
}
