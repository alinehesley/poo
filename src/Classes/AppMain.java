package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AppMain {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// • Instanciar pelo menos 2 objetos da classe Veiculo, 1 objeto da classe
		// ClientePF, 1 objeto da classe
		// ClientePJ, 1 objeto da classe Seguradora;

		Veiculo v1 = new Veiculo("AKJDE", "Ford", "Flex", 2020);
		Veiculo v2 = new Veiculo("GLSAP", "Chevrolet", "Uno", 2008);
		ClientePF c_pf = new ClientePF("Maria Clara", "Rua Flores, 721", "612.977.023-52", "F", sdf.parse("10/01/2018"),
				"Superior Completo", LocalDate.of(1998, 2, 15), "Média");
		ClientePJ c_pj = new ClientePJ("C&A Modas", "Av. Brasil, 63", "45.242.914/0001-05", sdf.parse("12/01/1981"), 30560);
		Seguradora s1 = new Seguradora("SegurosCar", "3381-3231", "seguroscar@seguros.com.br", "Rua MineMouse");
		
		
		// • Adicionar pelo menos 1 Veiculo em cada Cliente instanciado;
		// • Cadastrar pelo menos 1 ClientePF e 1 ClientePJ na Seguradora;
		// • Gerar pelo menos 2 objetos Sinistro;
		// • Chamar os metodos da classe Seguradora: listarClientes();
		// visualizarSinistro(); listarSinistros(); e
		// calcularReceita() (veja a se ̧c ̃ao 4);

		// • Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora
		// utilizando o m ́etodo calcu-
		// larPrecoSeguroCliente() da classe Seguradora;

		// • Mostrar na tela a receita total da seguradora utilizando o m ́etodo
		// calcularReceita();
		// • Implementar uma fun ̧c ̃ao para criar o menu de opera ̧c ̃oes usando o enum
		// MenuOperacoes;
		// • Apenas ao final da execu ̧c ̃ao do projeto: chamar o menu de opera ̧c ̃oes.
		
		//MENU
		
		
	}
}
