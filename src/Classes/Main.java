package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// INSTANCIA CLIENTES
		ClientePF pf1 = new ClientePF("Celso", "R. Leilei, n. 521", "612.977.023 - 52", "Masculino",
				sdf.parse("20/02/2003"), "Ensino Superior Completo", sdf.parse("15/06/1987"), "Alta");
		ClientePF pf2 = new ClientePF("Marcelina", "Av. Versalli, n. 1124", "612.977.009-03", "Feminino",
				sdf.parse("07/12/2012"), "Ensino Médio Completo", sdf.parse("23/02/1993"), "Alta");
		ClientePJ pj1 = new ClientePJ("Cacau Show", "Av. São Pedro, n. 12", "32.143.933/0001-24",
				sdf.parse("30/11/2018"));
		ClientePJ pj2 = new ClientePJ("Labele Biju", "R. Amora, n. 777", "82.143.933/99921-24",
				sdf.parse("23/09/2023"));
		
		// INSTANCIA UM OBJ DE SEGURADORA
		Seguradora s1 = new Seguradora("Seguros São Jorge", "9836263276", "segurossjorge@gmail.com", "Av. Limeira");

		// CADASTRA CLIENTES EM SEGURADORA
		s1.cadastrarCliente(pf1);
		s1.cadastrarCliente(pf2);
		s1.cadastrarCliente(pj1);
		s1.cadastrarCliente(pj2);
		s1.cadastrarCliente(pj2); //não será cadastrado, pois já existe
		
		//REMOVE UM CLIENTE 
		s1.removerCliente(pj2);
		
		// CHAMADA DE METODOS VALIDAR CPF e CNPJ
		System.out.println("Validacão de CPF e CNPJ");
		System.out.println(pj1.validarCNPJ(pj1.getCnpj()));
		System.out.println(pf1.validarCPF(pf1.getCpf()));

		// ADICIONA VEICULO
		Veiculo v1 = new Veiculo("FEJF", "UNO", "boot", 2012);
		Veiculo v2 = new Veiculo("DWJK", "Pallo", "dual", 2002);
		Veiculo v3 = new Veiculo("DCJK", "Ford", "flex", 2020);
		
		pf1.addVeiculos(v1);
		pf2.addVeiculos(v2);
		pj1.addVeiculos(v3);

		// GERA SINISTROS
		s1.gerarSinistro(sdf.parse("16/04/2023"), "Av. Dobro, n. 22", s1, v1, pf1);
		s1.gerarSinistro(sdf.parse("10/01/2018"), "Rua Todo Santo Dia, n. 321", s1, v1, pf1);
		s1.gerarSinistro(sdf.parse("03/11/2020"), "Rua Minha Algeria, n. 09", s1, v3, pj1);

		// CHAMADA DOS METODOS TOSTRING DE CADA CLASSE
		System.out.println("Chamada dos métodos ToString das classes:");
		//toString classe clientePF
		System.out.println(pf1.toString());
		//toString classe clientePJ
		System.out.println(pj1.toString());
		//toString classe veiculo
		System.out.println(v1.toString());
		//toString classe sinistro 
		Sinistro sinistro_teste = new Sinistro(sdf.parse("10/02/2023"), "Rua ToString, n. 1", s1, v2, pf2);
		System.out.println(sinistro_teste.toString());
		
		
		// CHAMA METODO LISTARCLIENTES
		System.out.println("Listando clientes PF\n");
		s1.listarClientes("PF");
		System.out.println("Listando clientes PJ\n");
		s1.listarClientes("PJ");

		// CHAMA METODO VISUALIZARSINISTRO
		System.out.println("Lista de sinistros associados ao cliente pf1");
		System.out.println(s1.visualizarSinistro(pf1)); //sinistros gerados com cliente pf1
		

		// CHAMA METODO LISTARSINISTROS
		System.out.println("");
		s1.listarSinistro();
	}
}