package Classes;

import java.time.LocalDate;
import java.time.Period;

public class SeguroPF {
	//Attributes
	private Veiculo veiculo;
	private ClientePF clientepf;
	
	//Constructor
	public SeguroPF(Veiculo veiculo, ClientePF clientepf) {
		this.veiculo = veiculo;
		this.clientepf = clientepf;
	}
	
	//autorizar condutor
	//desautorizar condutor
	//gerarSinistro
	
	
	//calcularValor
	public double calcularValor() { //pq no UML pede int???
		LocalDate data_hoje = LocalDate.now();
		LocalDate data_nascimento = clientepf.getDataNascimento();
		Period periodo = Period.between(data_nascimento, data_hoje);
		int idade = periodo.getYears();
		int qnt_veiculos = clientepf.getListaVeiculos().size();
		//int qnt_sinistroscliente = clientepf ?? //numero de sinistros q o cliente possui cadastrado na seguradora
		//int qnt_sinistroscondutor ?? num de sinistros q o condutor possui cadastrado naquela seguradora
		double x = (1 + 1/(qnt_veiculos+2))* (2 + (qnt_sinistroscliente/10)) * (5 + (qnt_sinistroscondutor/10));

		if (idade >= 18 && idade < 30){
			return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * x);
		}else if(idade >= 30 && idade < 60){
			return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * x);
		}else{ //>=60 e <90
			return(CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * x);
		}
		
	}
	
	//Getters e Setters
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
	
}
