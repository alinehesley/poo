package Classes;

import java.time.LocalDate;
import java.time.Period;

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

	public void calcularValor() {
		int qnt_funcionarios = super.getListaCondutores().size();
		int qnt_veiculos = frota.getListaVeiculos().size();

		LocalDate data_hoje = LocalDate.now();
		LocalDate data_fundacao = clientepj.getDataFundacao();

		Period periodo = Period.between(data_fundacao, data_hoje);

		int anos_posfundacao = periodo.getYears();
		int qnt_sinistroscliente = getSeguradora().getSinistrosPorCliente(clientepj).size();
		int qnt_sinistroscondutor = super.totalSinistrosPorCondutor();

		double resultado = CalcSeguro.VALOR_BASE.getFator() * (10.0 + (qnt_funcionarios / 10.0))
				* (1.0 + (1.0 / (qnt_veiculos + 2))) * (1.0 + (1.0 / (anos_posfundacao + 2.0)))
				* (2.0 + (qnt_sinistroscliente / 10.0)) * (5.0 + (qnt_sinistroscondutor / 10.0));

		super.setValorMensal(resultado);
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
