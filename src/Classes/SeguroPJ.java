package Classes;

import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ {
	//Attributes
	private Frota frota;
	private ClientePJ clientepj;
	
	//autorizar condutor
	//desautorizar condutor
	//gerarSinistro
	//calcularValor
	
	public double calcularValor() {
//		 ( VALOR_BASE * (10 + ( quantidadeFunc ) /10) *
//				 (1 + 1/( quantidadeVeiculos +2) ) *
//				 (1 + 1/( AnosPosFundacao +2) ) *
//				 (2 + quantidadeSinistrosCliente /10) *
//				 (5 + quantidadeSinistrosCondutor /10) )
		int qnt_funcionarios = clientepj.getQntFuncionarios();
		int qnt_veiculos = frota.getListaVeiculos().size();
		
		LocalDate data_hoje = LocalDate.now();
		LocalDate data_fundacao = clientepj.getDataFundacao();
		Period periodo = Period.between(data_fundacao, data_hoje);
		int anos_posfundacao = periodo.getYears();
		int qnt_sinistrocliente = 
	}
	
	
	//Getters e Setters
	public Frota getFrota() {
		return frota;
	}
	
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	
	public ClientePJ getClientepj() {
		return clientepj;
	}
	
	public void setClientePJ(ClientePJ clientepj) {
		this.clientepj = clientepj;
	}
}
