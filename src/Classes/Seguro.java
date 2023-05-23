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
	private int valorMensal;
	
	//Constructor
	public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, int valorMensal) {
		this.id = geraId();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = listaSinistros;
		this.listaCondutores = listaCondutores;
		this.valorMensal = valorMensal;
	}
	
	// GerarID
	private int geraId() {
		Seguro.cont += 1;
		return cont;
	}
	
	//desautorizarCondutor
	//autorizarCondutor
	//calcularValor
	//gerarSinistro
}
