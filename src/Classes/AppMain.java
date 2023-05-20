package Classes;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppMain {
	public static void main(String[] args) throws ParseException {

		// Instanciar pelo menos 2 objetos da classe Veiculo
		Veiculo v1 = new Veiculo("AKJDE", "Ford", "Flex", 2020);
		Veiculo v2 = new Veiculo("GLSAP", "Chevrolet", "Uno", 2008);

		// Instanciar pelo menos 1 objeto da classe ClientePF
		ClientePF c_pf = new ClientePF("Maria Clara", "Rua Flores, 721", "612.977.023-52", "F",
				LocalDate.of(2020, 10, 5), "Superior Completo", LocalDate.of(1998, 2, 15), "Média");

		// Instanciar pelo menos 1 objeto da classe ClientePJ
		ClientePJ c_pj = new ClientePJ("C&A Modas", "Av. Brasil, 63", "45.242.914/0001-05", LocalDate.of(2000, 8, 1),
				6000);

		// Instanciar pelo menos 1 objeto da classe Seguradora
		Seguradora s1 = new Seguradora("SegurosCar", "3381-3231", "seguroscar@seguros.com.br", "Rua MineMouse");

		// Adicionar pelo menos 1 Veiculo em cada Cliente instanciado
		c_pf.addVeiculos(v1);
		c_pj.addVeiculos(v2);

		// Cadastrar pelo menos 1 ClientePF e 1 ClientePJ na Seguradora
		s1.cadastrarCliente(c_pf);
		s1.cadastrarCliente(c_pj);

		// Gerar pelo menos 2 objetos Sinistro
		s1.gerarSinistro(LocalDate.of(2023, 3, 3), "Av.la la la, n. 22", v1, c_pf);
		s1.gerarSinistro(LocalDate.of(2023, 4, 11), "É a vida, n. 01", v2, c_pj);

		// Chamar os metodos da classe Seguradora: listarClientes();
		s1.listarClientes("PF");
		s1.listarClientes("PJ");

		// Chamar os metodos da classe Seguradora: visualizarSinistro();
		s1.visualizarSinistro("61297702352");

		// Chamar os metodos da classe Seguradora: listarSinistros();
		s1.listarSinistro();

		// Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora
		for (ClientePF clientepf : s1.obterListaPF()) {
			clientepf.setValorSeguro(s1.calcularPrecoSeguroCliente(clientepf.getCpf()));
		}
		for (ClientePJ clientepj : s1.obterListaPJ()) {
			clientepj.setValorSeguro(s1.calcularPrecoSeguroCliente(clientepj.getCnpj()));
		}

		// Preço do seguro de cada cliente
		System.out.println("O preço do seguro de " + c_pf.getNome() + " é de R$" + c_pf.getValorSeguro());

		System.out.println("O preço do seguro de " + c_pj.getNome() + " é de R$" + c_pj.getValorSeguro());

		// Chamar os metodos da classe Seguradora: calcularReceita();
		System.out.print("Valor da Receita: ");
		System.out.println(String.format("%.2f", s1.calcularReceita()));

		// MENU INTERATIVO

		System.out.println("----- MENU INTERATIVO ------");

		List<Seguradora> seguradoraList = new ArrayList<>();

		int opcao = -1;

		do {
			try {
				Scanner entrada = new Scanner(System.in);

				System.out.println("Menu Operações:");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Listar");
				System.out.println("3 - Excluir");
				System.out.println("4 - Gerar Sinistro");
				System.out.println("5 - Transferir Seguro");
				System.out.println("6 - Calcular Receita Seguradora");
				System.out.println("0 - Sair");

				System.out.println("Informe a opção desejada: ");
				opcao = entrada.nextInt();
				entrada.nextLine();

				if (opcao == MenuOperacoes.CADASTRAR.operacao) {
					menuCadastrar(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.LISTAR.operacao) {
					menuListar(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.EXCLUIR.operacao) {
					menuExcluir(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.GERAR_SINISTRO.operacao) {
					gerarSinistro(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
					transferirSeguro(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.operacao) {
					calcularReceitaSeguradora(entrada, seguradoraList);

				} else if (opcao == MenuOperacoes.SAIR.operacao) {
					System.out.println("Aplicação encerrada.");

				} else {
					System.out.println("Opção desejada é inválida.");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcao != MenuOperacoes.SAIR.operacao);

	}

	private static void calcularReceitaSeguradora(Scanner entrada, List<Seguradora> seguradoraList) {
		System.out.println("Insira o nome da seguradora: ");
		String nome = entrada.nextLine();
		for (Seguradora s : seguradoraList) {
			if (s.getNome().equals(nome)) {
				System.out.println("A receita da seguraradora foi de R$" + s.calcularReceita() + " reais");
			}
		}
	}

	private static Cliente leClienteDoInput(Scanner entrada) throws ParseException {
		System.out.println("Digite PF se quer um cliente Pessoa Física ou PJ se cliente Pessoa Jurídica: ");
		String tipocliente = entrada.nextLine();
		if (tipocliente.startsWith("PF")) {
			return leClientePFdoInput(entrada);
		} else {
			return leClientePJdoInput(entrada);
		}
	}

	private static ClientePF leClientePFdoInput(Scanner entrada) throws ParseException {
		System.out.println("Responda as perguntas a seguir sobre o cliente PF");
		System.out.println("Nome completo do cliente: ");
		String nome = entrada.nextLine();
		if (Validacao.validaNome(nome) == false) {
			System.out.println("Nome inválido, deve conter apenas letras");
			throw new ParseException("Nome inválido", 0);
		}
		System.out.println("Endereço do cliente: ");
		String endereco = entrada.nextLine();
		System.out.println("CPF do cliente: ");
		String cpf = entrada.nextLine();
		if (Validacao.validarCPF(cpf) == false) {
			System.out.println("O CPF do cliente é inválido.");
			throw new ParseException("CPF invalido", 0);
		}
		System.out.println("Sexo do cliente F para Feminino e M para Masculino: ");
		String sexo = entrada.nextLine();
		System.out.println("Data da licença de motorista (formato AAAA-MM-DD) do cliente: ");
		String dataL = entrada.nextLine();
		LocalDate dtlicenca = LocalDate.parse(dataL);
		System.out.println("Nível de escolaridade do cliente: ");
		String escolaridade = entrada.nextLine();
		System.out.println("Data de nascimento (formato AAAA-MM-DD) do cliente: ");
		String dataN = entrada.nextLine();
		LocalDate dtnasc = LocalDate.parse(dataN);
		System.out.println("Classe econômica do cliente: ");
		String classe = entrada.nextLine();
		ClientePF c_pf = new ClientePF(nome, endereco, cpf, sexo, dtlicenca, escolaridade, dtnasc, classe);
		return c_pf;
	}

	private static ClientePJ leClientePJdoInput(Scanner entrada) throws ParseException {
		System.out.println("Responda as perguntas a seguir sobre o cliente PJ");
		System.out.println("Nome completo do cliente: ");
		String nome = entrada.nextLine();
		if (Validacao.validaNome(nome) == false) {
			System.out.println("Nome inválido, deve conter apenas letras");
			throw new ParseException("Nome inválido", 0);
		}
		System.out.println("Endereço do cliente: ");
		String endereco = entrada.nextLine();
		System.out.println("CNPJ do cliente: ");
		String cnpj = entrada.nextLine();
		if (Validacao.validarCNPJ(cnpj) == false) {
			System.out.println("O CNPJ do cliente é inválido.");
			throw new ParseException("CPF invalido", 0);
		}
		System.out.println("Data de fundação da empresa (formato AAAA-MM-DD):");
		String dataF = entrada.nextLine();
		LocalDate dtfundacao = LocalDate.parse(dataF);
		System.out.println("Número de funcionários: ");
		int numfunc = entrada.nextInt();
		entrada.nextLine();
		ClientePJ c_pj = new ClientePJ(nome, endereco, cnpj, dtfundacao, numfunc);
		return c_pj;
	}

	private static Seguradora leSeguradoraDoInput(Scanner entrada) {
		System.out.println("Responda as perguntas a seguir sobre a seguradora");
		System.out.println("Nome da seguradora: ");
		String nome = entrada.nextLine();
		System.out.println("Número da seguradora: ");
		String numero = entrada.nextLine();
		System.out.println("E-mail da seguradora: ");
		String email = entrada.nextLine();
		System.out.println("Endereço da seguradora: ");
		String endereco = entrada.nextLine();
		Seguradora seguradora = new Seguradora(nome, numero, email, endereco);
		return seguradora;
	}

	private static Veiculo leVeiculoDoInput(Scanner entrada) {
		System.out.println("Responda as perguntas a seguir sobre o veiculo");
		System.out.println("Placa do veiculo: ");
		String placa = entrada.nextLine();
		System.out.println("Marca do veiculo: ");
		String marca = entrada.nextLine();
		System.out.println("Modelo do veiculo: ");
		String modelo = entrada.nextLine();
		System.out.println("Ano de fabricação do veículo: ");
		int anofab = entrada.nextInt();
		entrada.nextLine();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, anofab);
		return veiculo;
	}

	private static LocalDate leDataDoInput(Scanner entrada) {
		System.out.println("Digite a data (formato AAAA-MM-DD)");
		String data = entrada.nextLine();
		LocalDate dt = LocalDate.parse(data);
		return dt;
	}

	private static String leEnderecoDoInput(Scanner entrada) {
		System.out.println("Digite o enredeço: ");
		String endereco = entrada.nextLine();
		return endereco;
	}

	private static boolean transferirSeguro(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		// pergunto nome da segurdora que deseja realizar essa operacao
		System.out.println("Nome da seguradora em que deseja realizar essa operação: ");
		String nomeseguradora = entrada.nextLine();
		List<ClientePF> listaPF = null;
		List<ClientePJ> listaPJ = null;

		Cliente cliente1 = null;
		Cliente cliente2 = null;

		for (Seguradora s : seguradoraList) { // encontra seguradora e faz as listas PJ e PF
			if (s.getNome().equals(nomeseguradora)) {
				listaPF = s.obterListaPF();
				listaPJ = s.obterListaPJ();
				break;
			}
		}

		System.out.println("CPF/CNPJ do cliente que deseja tranferir o seguro: ");
		String cpfoucnpjc1 = entrada.nextLine();

		// Descobrindo o cliente que vai transferir
		if (Validacao.validarCPF(cpfoucnpjc1)) { // eh um cliente PF
			for (ClientePF clientepf : listaPF) {
				if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpjc1.replaceAll("[^0-9]", ""))) {
					cliente1 = clientepf;
				}
			}
		} else if (Validacao.validarCNPJ(cpfoucnpjc1)) { // eh um cliente PJ
			for (ClientePJ clientepj : listaPJ) {
				if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpjc1.replaceAll("[^0-9]", ""))) {
					cliente1 = clientepj;
				}
			}
		} else {
			System.out.println("O CPF/CNPJ é inválido");
			return false;
		}
		
		System.out.println("CPF/CNPJ do cliente que vai receber o seguro: ");
		String cpfoucnpjc2 = entrada.nextLine();

		// Descobrindo cliente que vai receber
		if (Validacao.validarCPF(cpfoucnpjc2)) { // eh um cliente PF
			for (ClientePF clientepf : listaPF) {
				if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpjc2.replaceAll("[^0-9]", ""))) {
					cliente2 = clientepf;
				}

			}
		} else if (Validacao.validarCNPJ(cpfoucnpjc2)) { // eh um cliente PJ
			for (ClientePJ clientepj : listaPJ) {
				if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpjc2.replaceAll("[^0-9]", ""))) {
					cliente2 = clientepj;
				}
			}
		} else {
			System.out.println("O CPF/CNPJ é inválido");
			return false;
		}

		if(cliente1 == null || cliente2==null){
			System.out.println("Clientes não encontrados");
			return false;
		}

		// Transferindo seguro do cliente1 para cliente2
		List<Veiculo> listaVeiculosc1 = cliente1.getListaVeiculos(); // salvo os veiculos de cliente1 em uma lista

		for (Veiculo v : listaVeiculosc1) { //add os veiculos para o cliente2
			cliente2.addVeiculos(v);
		}

		cliente1.clearListaVeiculo();
		System.out.println("Seguro transferido com sucesso do cliente " + cliente1.getNome() + " para cliente " + cliente2.getNome());
		return true;
	}

	private static void gerarSinistro(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		System.out.println("Digite o CPF/CNPJ do cliente");
		String cpfcnpj = entrada.nextLine();
		System.out.println("Digite a placa do veiculo");
		String placa = entrada.nextLine();
		System.out.println("Digite o nome da seguradora");
		String nomeseguradora = entrada.nextLine();
		LocalDate data = leDataDoInput(entrada);
		String endereco = leEnderecoDoInput(entrada);
		for (Seguradora s : seguradoraList) {
			if (s.getNome().equals(nomeseguradora)) {
				if(s.gerarSinistro(data, endereco, placa, cpfcnpj)){
					System.out.println("Sinistro gerado com sucesso!");
					return;
				}
			}
		}
		System.out.println("Problema ao gerar o sinistro :(");
	}

	private static boolean cadastraVeiculoSeguradora(Veiculo veiculo, String cpfoucnpj, String nomeseguradora,
			List<Seguradora> seguradoraList) {
		for (Seguradora s : seguradoraList) {
			if (s.getNome().equals(nomeseguradora)) { // encontrei a seguradora desejada
				if (Validacao.validarCPF(cpfoucnpj)) { // eh um cliente PF
					List<ClientePF> listaPF = s.obterListaPF();
					for (ClientePF clientepf : listaPF) {
						if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
							clientepf.addVeiculos(veiculo); // busco ele na lista e add o veiculo
							return true;
						}
					}
				}

			} else if (Validacao.validarCNPJ(cpfoucnpj)) { // eh um cliente PJ
				List<ClientePJ> listaPJ = s.obterListaPJ();
				for (ClientePJ clientepj : listaPJ) {
					if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
						clientepj.addVeiculos(veiculo); // busco ele na lista e add um veiculo
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void menuCadastrar(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int opcao_cadastrar;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Cadastrar Cliente PF/PJ");
			System.out.println("2 - Cadastrar Veículo");
			System.out.println("3 - Cadastrar Seguradora");
			System.out.println("0 - Voltar");

			System.out.println("Informe a opção desejada: ");
			opcao_cadastrar = entrada.nextInt();
			entrada.nextLine();

			if (opcao_cadastrar == MenuCadastrar.CADASTRAR_CLIENTEPFPJ.operacao) {
				Cliente cliente = leClienteDoInput(entrada);
				System.out.println("Nome da seguradora em que deseja cadastrar o cliente: ");
				String nomeseguradora = entrada.nextLine();
				Seguradora seguradora = null;
				for (Seguradora s : seguradoraList) {
					if (s.getNome().equals(nomeseguradora)) {
						s.cadastrarCliente(cliente);
						seguradora = s;
					}
				}
				if(seguradora == null){
					System.out.println("Seguradora nao encontrada");
					return;
				}
				System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso na seguradora "
						+ seguradora.getNome());

			} else if (opcao_cadastrar == MenuCadastrar.CADASTRAR_VEICULO.operacao) {
				Veiculo veiculo = leVeiculoDoInput(entrada);

				System.out.println("Digite o CPF/CNPJ do cliente em que deseja cadastrar um veiculo: ");
				String cpfoucnpj = entrada.nextLine();

				System.out.println("Nome da seguradora que possui esse cliente: ");
				String nomeseguradora = entrada.nextLine();

				if (cadastraVeiculoSeguradora(veiculo, cpfoucnpj, nomeseguradora, seguradoraList)) { // se foi
																										// cadastrado
					System.out.println("Veiculo de placa " + veiculo.getPlaca()
							+ "adicionado com sucesso no cliente e seguradora pedidos.");
				}

			} else if (opcao_cadastrar == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {
				Seguradora seguradora = leSeguradoraDoInput(entrada);
				seguradoraList.add(seguradora);
				System.out.println("Seguradora " + seguradora.getNome() + " cadastrada com sucesso.");

			} else if (opcao_cadastrar == MenuCadastrar.VOLTAR.operacao) {
				System.out.println("Voltando para Menu Principal");
			} else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (opcao_cadastrar != MenuCadastrar.VOLTAR.operacao);
	}

	public static void menuListar(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int opcao_listar;
		do {
			System.out.println("Menu Listar:");
			System.out.println("1 - Listar Cliente (PF/PJ)");
			System.out.println("2 - Listar Sinistros por Seguradora");
			System.out.println("3 - Listar Sinistros por Cliente");
			System.out.println("4 - Listar Veiculo por Cliente");
			System.out.println("0 - Voltar");

			System.out.println("Informe a opção desejada: ");
			opcao_listar = entrada.nextInt();
			entrada.nextLine();

			if (opcao_listar == MenuListar.LISTAR_CLIENTE_PFPJ.operacao) {

				System.out.println("O tipo do cliente é PF ou PJ: ");
				String tipocliente = entrada.nextLine();

				System.out.println("Nome da seguradora que deseja listar esses clientes: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome().equals(nomeseguradora)) {
						s.listarClientes(tipocliente);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTRO_CLIENTE.operacao) {
				System.out.println("CPF/CNPJ do cliente para listar sinistros: ");
				String cpfoucnpj = entrada.nextLine();

				System.out.println("Nome da seguradora que deseja listar esses clientes: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome().equals(nomeseguradora)) {
						s.visualizarSinistro(cpfoucnpj);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTROS_SEGURADORA.operacao) {
				System.out.println("Nome da seguradora que deseja listar os sinistros: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome().equals(nomeseguradora)) {
						s.listarSinistro();
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_VEICULO_CLIENTE.operacao) {

				System.out.println("Digite o CPF/CNPJ do cliente que deseja listar os veiculos: ");
				String cpfoucnpj = entrada.nextLine();
				for (Seguradora seguradora : seguradoraList) {
					for (Cliente c : seguradora.getListaClientes()) {
						if (c instanceof ClientePF) {
							if (((ClientePF) c).getCpf().equals(cpfoucnpj)) {
								System.out.println("Lista de veiculos do cliente " + c.getNome());
								System.out.println(c.getListaVeiculos());
							}
						} else if (c instanceof ClientePJ) {
							if (((ClientePJ) c).getCnpj().equals(cpfoucnpj)) {
								System.out.println("Lista de veiculos do cliente " + c.getNome());
								System.out.print(c.getListaVeiculos());
							}
						}
					}
				}
			} else if (opcao_listar == MenuListar.VOLTAR.operacao) {
				System.out.println("Voltando para Menu Principal");
			} else {
				System.out.println("Opção desejada é inválida.");
			}

		} while (opcao_listar != MenuListar.VOLTAR.operacao);

	}

	public static void menuExcluir(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int opcao_excluir;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Excluir Cliente");
			System.out.println("2 - Excluir Veículo");
			System.out.println("3 - Excluir Sinistro");
			System.out.println("0 - Voltar");

			System.out.println("Informe a opção desejada: ");
			opcao_excluir = entrada.nextInt();
			entrada.nextLine();

			if (opcao_excluir == MenuExcluir.EXCLUIR_CLIENTE.operacao) {
				System.out.println("Digite o CPF/CNPJ do cliente que deseja excluir:");
				String cpfoucnpj = entrada.nextLine();

				for (Seguradora seguradora : seguradoraList) {
					if (seguradora.removerCliente(cpfoucnpj)) {
						System.out.println("Cliente removido de " + seguradora.getNome());
					}
				}

			} else if (opcao_excluir == MenuExcluir.EXCLUIR_VEICULO.operacao) {
				System.out.println("Coloque os detalhes do veiculo a ser excluido");
				Veiculo v = leVeiculoDoInput(entrada);
				for (Seguradora s : seguradoraList) {
					for (Cliente c : s.getListaClientes()) {
						c.removeVeiculo(v);
					}
				}
			} else if (opcao_excluir == MenuExcluir.EXCLUIR_SINISTRO.operacao) {
				System.out.println("Coloque os detalhes do sinistro a ser excluido");
				System.out.println("Digite o nome do cliente: ");
				String nomeCliente = entrada.nextLine();
				System.out.println("Digite a placa do veiculo: ");
				String placaVeiculo = entrada.nextLine();
				System.out.println("Digite o nome da seguradora: ");
				String nomeseguradora = entrada.nextLine();

				for (Seguradora s : seguradoraList) {
					if (s.getNome().equals(nomeseguradora)) {
						s.excluirSinistro(placaVeiculo, nomeCliente);
					}
				}
			} else if (opcao_excluir == MenuExcluir.VOLTAR.operacao) {
				System.out.println("Voltando para Menu Principal");

			} else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (opcao_excluir != MenuCadastrar.VOLTAR.operacao);
	}
}
