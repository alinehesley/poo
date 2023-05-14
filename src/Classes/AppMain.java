package Classes;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class AppMain {
	public static void main(String[] args) throws ParseException {

		// • Instanciar pelo menos 2 objetos da classe Veiculo
		Veiculo v1 = new Veiculo("AKJDE", "Ford", "Flex", 2020);
		Veiculo v2 = new Veiculo("GLSAP", "Chevrolet", "Uno", 2008);

		// • 1 objeto da classe ClientePF
		// • 1 objeto da classe ClientePJ
		ClientePF c_pf = new ClientePF("Maria Clara", "Rua Flores, 721", "612.977.023-52", "F",
				LocalDate.of(2020, 10, 5), "Superior Completo", LocalDate.of(1998, 2, 15), "Média");
		ClientePJ c_pj = new ClientePJ("C&A Modas", "Av. Brasil, 63", "45.242.914/0001-05", LocalDate.of(2000, 8, 1),
				30560);

		// • 1 objeto da classe Seguradora
		Seguradora s1 = new Seguradora("SegurosCar", "3381-3231", "seguroscar@seguros.com.br", "Rua MineMouse");

		// • Adicionar pelo menos 1 Veiculo em cada Cliente instanciado
		c_pf.addVeiculos(v1);
		c_pj.addVeiculos(v2);

		// • Cadastrar pelo menos 1 ClientePF e 1 ClientePJ na Seguradora
		s1.cadastrarCliente(c_pf);
		s1.cadastrarCliente(c_pj);

		// • Gerar pelo menos 2 objetos Sinistro
		s1.gerarSinistro(LocalDate.of(2023, 3, 3), "Av.la la la, n. 22", v1, c_pf);
		s1.gerarSinistro(LocalDate.of(2023, 4, 11), "É a vida, n. 01", v2, c_pj);

		// • Chamar os metodos da classe Seguradora: listarClientes();
		s1.listarClientes("PF");
		s1.listarClientes("PJ");

		// • Chamar os metodos da classe Seguradora: visualizarSinistro();
		s1.visualizarSinistro("61297702352");

		// • Chamar os metodos da classe Seguradora: listarSinistros();
		s1.listarSinistro();

		// • Chamar os metodos da classe Seguradora: calcularReceita();
		System.out.print("Valor da Receita: ");
		System.out.println(String.format("%.2f", s1.calcularReceita()));

		// • Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora
		// utilizando o metodo calcularPrecoSeguroCliente() da classe Seguradora;

		// • Mostrar na tela a receita total da seguradora utilizando o m ́etodo
		// calcularReceita();

		// • Implementar uma fun ̧c ̃ao para criar o menu de opera ̧c ̃oes usando o enum
		// MenuOperacoes;
		// • Apenas ao final da execu ̧c ̃ao do projeto: chamar o menu de opera ̧c ̃oes.

		// MENU

		int opcao;

		try {
			Scanner entrada = new Scanner(System.in);
			do {
				System.out.println("Menu Operações:");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Listar");
				System.out.println("3 - Excluir");
				System.out.println("4 - Gerar Sinistro");
				System.out.println("5 - Transferir Seguro");
				System.out.println("6 - Calcular Receita Seguradora");
				System.out.println("0 - Sair");

				System.out.printf("Informe a opção desejada: ");
				opcao = entrada.nextInt();

				if (opcao == MenuOperacoes.CADASTRAR.operacao) {
					CadastrarMenu(entrada);
				} else if (opcao == MenuOperacoes.LISTAR.operacao) {
					System.out.println("Chama menu de listar");
				} else if (opcao == MenuOperacoes.EXCLUIR.operacao) {
					System.out.println("Chama menu de excluir");
				} else if (opcao == MenuOperacoes.GERAR_SINISTRO.operacao) {
					System.out.println("Gera sinistro na seguradora p um cliente");
				} else if (opcao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
					System.out.println("Transfere seguro p outro cliente");
				} else if (opcao == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.operacao) {
					System.out.println("Calcula a receita total da seguradora");
				} else if (opcao == MenuOperacoes.SAIR.operacao) {
					System.out.println("Aplicação encerrada.");
				} else {
					System.out.println("Opção desejada é inválida.");
				}

			} while (opcao != MenuOperacoes.SAIR.operacao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void CadastrarMenu(Scanner entrada) {
		int cadastro_opcao;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Cadastrar Cliente PF");
			System.out.println("2 - Cadastrar Cliente PJ");
			System.out.println("3 - Cadastrar Veículo");
			System.out.println("4 - Cadastrar Seguradora");
			System.out.println("0 - Voltar");

			System.out.printf("Informe a opção desejada: ");
			cadastro_opcao = entrada.nextInt();

			if (cadastro_opcao == MenuCadastrar.CADASTRAR_CLIENTEPF.operacao) {
				System.out.println("Responda as perguntas a seguir para cadastrar cliente PF");
				System.out.printf("Nome completo do cliente: ");
				String nome = entrada.nextLine();
				System.out.println("Endereço do cliente: ");
				String endereco = entrada.nextLine();
				System.out.printf("CPF do cliente: "); // lembrar de verificar se é valido
				String cpf = entrada.nextLine();
				if (Validacao.validarCPF(cpf) == false) {
					System.out.println("O CPF do cliente é inválido.");
					break; // pode?
				}
				System.out.printf("Sexo do cliente F para Feminino e M para Masculino: ");
				String sexo = entrada.nextLine();
				System.out.printf("Data da licença de motorista (formato AAAA-MM-DD) do cliente: ");
				String dataL = entrada.nextLine();
				LocalDate dtlicenca = LocalDate.parse(dataL);
				System.out.printf("Nível de escolaridade do cliente: ");
				String escolaridade = entrada.nextLine();
				System.out.printf("Data de nascimento (formato AAAA-MM-DD) do cliente: ");
				String dataN = entrada.nextLine();
				LocalDate dtnasc = LocalDate.parse(dataN);
				System.out.printf("Classe econômica do cliente: ");
				String classe = entrada.nextLine();
				ClientePF c_pf = new ClientePF(nome, endereco, cpf, sexo, dtlicenca, escolaridade, dtnasc, classe);
				// adicionar ele na seguradora, cadastrar realmente

			} else if (cadastro_opcao == MenuCadastrar.CADASTRAR_CLIENTEPJ.operacao) {
				System.out.println("Responda as perguntas a seguir para cadastrar cliente PJ");
				System.out.printf("Nome completo do cliente: ");
				String nome = entrada.nextLine(); // lembrar de validar nome
				System.out.printf("Endereço do cliente: ");
				String endereco = entrada.nextLine();
				System.out.printf("CNPJ do cliente: "); // lembrar de verificar se é valido
				String cnpj = entrada.nextLine();
				if (Validacao.validarCNPJ(cnpj) == false) {
					System.out.println("O CNPJ do cliente é inválido.");
					break; // pode?
				}
				System.out.printf("Data de fundação da empresa (formato AAAA-MM-DD):");
				String dataF = entrada.nextLine();
				LocalDate dtfundacao = LocalDate.parse(dataF);
				System.out.printf("Número de funcionários: ");
				int numfunc = entrada.nextInt();
				ClientePJ c_pj = new ClientePJ(nome, endereco, cnpj, dtfundacao, numfunc);
				// add ele na seguradora, preciso ter a seguradora cadastrada

			} else if (cadastro_opcao == MenuCadastrar.CADASTRAR_VEICULO.operacao) {
				// Veiculo v2 = new Veiculo("GLSAP", "Chevrolet", "Uno", 2008);
				System.out.println("Responda as perguntas a seguir para cadastrar um novo veículo");
				System.out.printf("Placa do veículo: ");
				String placa = entrada.nextLine();
				System.out.printf("Marca do veículo: ");
				String marca = entrada.nextLine();
				System.out.printf("Modelo do veículo: ");
				String modelo = entrada.nextLine();
				System.out.printf("Ano de fabricação do veículo: ");
				int anofab = entrada.nextInt();
				Veiculo veiculo = new Veiculo(placa, marca, modelo, anofab);
				
			}else if (cadastro_opcao == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {
				// Seguradora s1 = new Seguradora("SegurosCar", "3381-3231",
				// "seguroscar@seguros.com.br", "Rua MineMouse");
				System.out.println("Responda as persguntas a seguir para cadastrar sua seguradora");
				System.out.printf("Nome da seguradora: ");
				String nome = entrada.nextLine();
				System.out.printf("Número da seguradora: ");
				String numero = entrada.nextLine();
				System.out.printf("E-mail da seguradora: ");
				String email = entrada.nextLine();
				System.out.printf("Endereço da seguradora: ");
				String endereco = entrada.nextLine();
				Seguradora seguradora = new Seguradora(nome, numero, email, endereco);
			}else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (cadastro_opcao != MenuCadastrar.VOLTAR.operacao); // ser dif de voltar
	}

}// chave appMain
