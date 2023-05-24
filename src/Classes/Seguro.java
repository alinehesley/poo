package Classes;

import java.time.LocalDate;
import java.util.List;

public abstract class Seguro {
	private final int id;
	private static int cont = 0;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	private List<Sinistro> listaSinistros;
	private List<Condutor> listaCondutores;
	private double valorMensal; 
	
	//Constructor
	public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, int valorMensal) {
		this.id = geraId();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = listaSinistros;
		this.listaCondutores = listaCondutores;
		this.valorMensal = calcularValor();
	}
	
	// GerarID
	private int geraId() {
		Seguro.cont += 1;
		return cont;
	}
	
	public abstract boolean autorizarCondutor();
	public abstract boolean desautorizarCondutor();
	public abstract void gerarSinistro();
	public abstract double calcularValor();
	
	//Getters e Setters
	public int getId() {
		return id;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public List<Condutor> getListaCondutores(){
		return listaCondutores;
	}
	
	public double getValorMensal() {
		return valorMensal;
	}
	
	public void setValorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}

}
