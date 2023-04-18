package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// INSTANCIA CLIENTES
		ClientePF pf1 = new ClientePF("Celso", "R. Leilei, n. 521", "612.977.023 - 52", "Masculino",
				sdf.parse("20/02/2003"), "Ensino Superior Completo", sdf.parse("15/06/1987"), "Alta");
		ClientePF pf2 = new ClientePF("Marcelina", "Av. Versalli, n. 1124", "637.035.133-49", "Feminino",
				sdf.parse("07/12/2012"), "Ensino Médio Completo", sdf.parse("23/02/1993"), "Alta");

		ClientePJ pj1 = new ClientePJ("Cacau Show", "Av. São Pedro, n. 12", "32.143.933/0001-24",
				sdf.parse("30/11/2018"));
		ClientePJ pj2 = new ClientePJ("Mdlc Comercio de Bijuterias Ltda", "R. Amora, n. 777", "28.893.453/0002-94",
				sdf.parse("23/09/2023"));

		// INSTANCIA UM OBJ DE SEGURADORA
		Seguradora s1 = new Seguradora("Seguros São Jorge", "9836263276", "segurossjorge@gmail.com", "Av. Limeira");

		// CADASTRA CLIENTES EM SEGURADORA
		s1.cadastrarCliente(pf1);
		s1.cadastrarCliente(pf2);
		s1.cadastrarCliente(pj1);
		s1.cadastrarCliente(pj2);
		s1.cadastrarCliente(pj2); // não será cadastrado, pois já existe

		// REMOVE UM CLIENTE
		s1.removerCliente("637.035.133-49"); // remove pf2

		// CHAMADA DE METODOS VALIDAR CPF e CNPJ
		System.out.println("Validacão de CPF e CNPJ");
		System.out.println(ClientePJ.validarCNPJ(pj1.getCnpj()));
		System.out.println(ClientePF.validarCPF(pf1.getCpf()));

		// ADICIONA VEICULO
		Veiculo v1 = new Veiculo("FEJF", "UNO", "boot", 2012);
		Veiculo v2 = new Veiculo("DWJK", "Pallo", "dual", 2002);
		Veiculo v3 = new Veiculo("DCJK", "Ford", "flex", 2020);

		pf1.addVeiculos(v1);
		pj2.addVeiculos(v2);
		pj1.addVeiculos(v3);

		// GERA SINISTROS
		s1.gerarSinistro(sdf.parse("16/04/2023"), "Av. Dobro, n. 22", v1, pf1);
		s1.gerarSinistro(sdf.parse("10/01/2018"), "Rua Todo Santo Dia, n. 321", v1, pf1);
		s1.gerarSinistro(sdf.parse("03/11/2020"), "Rua Minha Algeria, n. 09", v3, pj1);

		// CHAMADA DOS METODOS TOSTRING DE CADA CLASSE
		System.out.println("Chamada dos métodos ToString das classes:");
		// toString classe clientePF
		System.out.println(pf1.toString());
		// toString classe clientePJ
		System.out.println(pj1.toString());
		// toString classe veiculo
		System.out.println(v1.toString());
		// toString classe sinistro
		Sinistro sinistro_teste = new Sinistro(sdf.parse("10/02/2023"), "Rua ToString, n. 1", s1, v2, pf2);
		System.out.println(sinistro_teste.toString());

		// CHAMA METODO LISTARCLIENTES
		System.out.println("Listando clientes PF");
		s1.listarClientes("PF");
		System.out.println("Listando clientes PJ");
		s1.listarClientes("PJ");

		// CHAMA METODO VISUALIZARSINISTRO
		System.out.println("Lista de sinistros associados ao cliente pf1");
		s1.visualizarSinistro("612.977.023 - 52"); // sinistros gerados com cliente pf1

		// CHAMA METODO LISTARSINISTROS
		s1.listarSinistro();

		System.out.println("|              Menu de Opções               |");
		System.out.println("| 01 - Listar Clientes                      |"); // pede se eh pf ou pf
		System.out.println("| 02 - Visualizar Sinistro                  |"); // pede cpf ou cnpj
		System.out.println("| 05 - Listar Sinistros                     |"); // pede a seguradora e lista tds os													// sinistros
		System.out.println("| 00 - Sair                                 |");
		
		
		int opcao;
		
        try (Scanner entrada = new Scanner(System.in)) {
			do{
				System.out.printf("Informe a opção desejada: ");
			    opcao = entrada.nextInt();
			    
			    switch(opcao){
			    case 1:
			    	
			        System.out.println("Digite o número 1 para listar clientes PF e 2 para PJ.");
			        int tipo = entrada.nextInt();
			        if(tipo == 1) {
			        	s1.listarClientes("PF");
			        }else {
			        	s1.listarClientes("PJ");
			        }
			        
			        break;
			        
			    case 2:
			    	System.out.println("caso 2");
			        break;
			        
			    case 3:
			    	System.out.println("caso 3");
			        break;
			        
			    case 4:
			    	System.out.println("caso 4");
			        break;
			    
			    default:
			        System.out.println("Opção inválida.");
			    }
			} while(opcao != 0);
		}
    }

	}

