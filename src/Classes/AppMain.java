package Classes;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppMain {
	public static void main(String[] agrs) {

		Seguradora SegurosBrasil = new Seguradora("Seguros Brasil", "3381-3231", "segurosbrasil@gmail.com",
				"Rua Vitoria, n. 977", "11.878.898/0001-11");

		// Cliente PF e PJ

		ClientePF juca = new ClientePF("Juca Pirama", "Av. Taiapó, s/n", "612977023-52", "M", "Ens. Superior Completo",
				LocalDate.of(2003, 02, 15), "98966212332", "juquinha@hotmail.com");
		ClientePF luan = new ClientePF("Luan Hiller", "Av. Chiclete, n. 77", "637035133-49", "M", "Ens. Médio Completo",
				LocalDate.of(2000, 11, 03), "989432212332", "lukitaa@gamil.com");

		ClientePJ cacauShow = new ClientePJ("Cacau Show", "Av. Pinheiro, n.22", "11.878.898/0001-11",
				LocalDate.of(1999, 02, 12), "12378137218", "cacaushow@outlook.com");
		ClientePJ carrefour = new ClientePJ("Carrefour", "Av. Santa Isabel, n.44", "45.543.915/0001-81",
				LocalDate.of(1990, 11, 01), "12378137218", "carrefour@outlook.com");

		// Condutores
		Condutor joao = new Condutor("6129-7702352", "João Paulo", "810928319", "Rua Brasil, n. 55", "joao@gmail.com",
				LocalDate.of(2000, 01, 21));
		Condutor maria = new Condutor("27098036315", "Maria Silva", "819273849", "Avenida das Flores, n. 123",
				"maria@gmail.com", LocalDate.of(1995, 06, 10));
		Condutor pedro = new Condutor("61297.702352", "Pedro Santos", "812349876", "Rua das Palmeiras, n. 78",
				"pedro@gmail.com", LocalDate.of(1988, 11, 27));
		Condutor ana = new Condutor("6129770-2352", "Ana Oliveira", "819273849", "Avenida dos Pinheiros, n. 456",
				"ana@gmail.com", LocalDate.of(1992, 03, 15));

		// Veiculos
		Veiculo veiculo1 = new Veiculo("ABC1234", "Fiat", "Uno", 2010);
		Veiculo veiculo2 = new Veiculo("DEF5678", "Volkswagen", "Gol", 2015);
		Veiculo veiculo3 = new Veiculo("GHI9012", "Chevrolet", "Onix", 2020);
		Veiculo veiculo4 = new Veiculo("JKL3456", "Ford", "Fiesta", 2012);
		Veiculo veiculo5 = new Veiculo("MNO7890", "Honda", "Civic", 2018);
		Veiculo veiculo6 = new Veiculo("PQR2345", "Toyota", "Corolla", 2019);
		Veiculo veiculo7 = new Veiculo("STU6789", "Renault", "Sandero", 2014);
		Veiculo veiculo8 = new Veiculo("VWX0123", "Hyundai", "HB20", 2017);
		Veiculo veiculo9 = new Veiculo("YZA4567", "Nissan", "March", 2013);
		Veiculo veiculo10 = new Veiculo("BCD8901", "Jeep", "Renegade", 2021);

		// Frota
		Frota frota1 = new Frota("FROTA001");
		Frota frota2 = new Frota("FROTA002");

		// Cadastra Clientes na seguradora
		SegurosBrasil.cadastrarCliente(juca);
		SegurosBrasil.cadastrarCliente(luan);
		SegurosBrasil.cadastrarCliente(carrefour);
		SegurosBrasil.cadastrarCliente(cacauShow);

		// Cadastra Frota nos clientes PJ
		carrefour.cadastrarFrota(frota1);
		cacauShow.cadastrarFrota(frota2);

		// Cadastra veiculos na frota
		frota1.addVeiculoFrota(veiculo3);
		frota1.addVeiculoFrota(veiculo4);
		frota1.addVeiculoFrota(veiculo5);
		frota1.addVeiculoFrota(veiculo6);
		frota2.addVeiculoFrota(veiculo7);
		frota2.addVeiculoFrota(veiculo8);
		frota2.addVeiculoFrota(veiculo9);
		frota2.addVeiculoFrota(veiculo10);

		// Cadastra Veiculos nos clientes PF
		juca.cadastrarVeiculo(veiculo1);
		luan.cadastrarVeiculo(veiculo2);

		// Gera seguros PF e PJ
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 02, 15), LocalDate.of(2024, 02, 15), veiculo2, juca);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 02, 15), LocalDate.of(2024, 02, 15), veiculo4, juca);

		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 02, 15), LocalDate.of(2024, 02, 15), veiculo2, luan);

		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota1, carrefour);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota2, cacauShow);

		// Gerar Sinistros e autoriza condutores

		List<Seguro> segurosJuca = SegurosBrasil.getSegurosPorCliente(juca);
		List<Seguro> segurosLuan = SegurosBrasil.getSegurosPorCliente(luan);
		List<Seguro> segurosCarrefour = SegurosBrasil.getSegurosPorCliente(carrefour);
		List<Seguro> segurosCacauShow = SegurosBrasil.getSegurosPorCliente(cacauShow);

		for (Seguro s : segurosJuca) {
			if (s.getId() == 2) { // Gera sinistro e autoriza condutor no seguro de ID == 2
				s.gerarSinistro(LocalDate.of(2023, 10, 11), "Rua Flores, n. 22");
				s.autorizarCondutor(ana);
				break;
			}
		}

		for (Seguro s : segurosLuan) {
			if (s.getId() == 1) {
				s.gerarSinistro(LocalDate.of(2023, 07, 02), "Rua H20, n. 188");
				s.autorizarCondutor(pedro);
				break;
			}
		}

		for (Seguro s : segurosCarrefour) {
			if (s.getId() == 1) {
				s.gerarSinistro(LocalDate.of(2023, 10, 10), "Avenue Si Sinhor, n. 1024");
				s.autorizarCondutor(joao);
				s.autorizarCondutor(maria);

				break;
			}
		}

		for (Seguro s : segurosCacauShow) {
			if (s.getId() == 1) {
				s.gerarSinistro(LocalDate.of(2023, 10, 10), "Avenue Si Sinhor, n. 1024");
				break; // para este cliente PJ não foi autorizado nenhum condutor
			}
		}

		// Gera um sinistro para um condutor
		Sinistro sinistrocondutor = new Sinistro(LocalDate.of(2023, 06, 06), "Rua Paiol, n. 77", ana,
				SegurosBrasil.getSeguro(2));

		ana.adicionarSinistro(sinistrocondutor); // gera sinistro para o condutor ana autorizado por Juca,
		// ela está no seguro ID = 2 dele.

		// Calcula o valor mensal de cada um dos seguros
		for (Seguro s : SegurosBrasil.getListaSeguros()) {
			s.calcularValor();
		}

		// ToString
		System.out.println("\nToStrings:" + "\n");
		System.out.println(SegurosBrasil.toString() + "\n");
		System.out.println(juca.toString() + "\n");
		System.out.println(cacauShow.toString() + "\n");
		System.out.println(joao.toString() + "\n");
		System.out.println(veiculo1.toString() + "\n");
		System.out.println(frota1.toString() + "\n");
		System.out.println("-----------------------");

		// Listar Cliente
		System.out.println("Listando clientes PF e PJ da seguradora " + SegurosBrasil.getNome());
		SegurosBrasil.listarClientes("PF");
		SegurosBrasil.listarClientes("PJ");

		System.out.println("Listando sinistros por Cliente do cliente " + juca.getNome() + " da Seguradora "
				+ SegurosBrasil.getNome());
		for (Sinistro s : SegurosBrasil.getSinistrosPorCliente(juca)) {
			System.out.println(s.toString());
		}

		for (Seguro s : SegurosBrasil.getListaSeguros()) {
			System.out.println("O valor mensal pago pelo " + s.getCliente().getNome() + " é de R$ "
					+ String.format("%.2f", s.getValorMensal()) + " no seguro de ID :" + s.getId());
		}

		// Calcula Receita da Seguradora,
		// temos 4 clientes cadastrados, 2 PF e 2 PJ
		SegurosBrasil.calcularReceita();

		// Atualiza a frota do cliente CacauShow
		// A opção 1 cadastra veiculo na frota, 2 remove veiculo e 3 remove frota
		// inteira
		carrefour.atualizarFrota("FROTA001", veiculo3, 2);
		cacauShow.atualizarFrota("FROTA002", null, 3);

		// Cancela o seguro do cliente PJ Cacau Show pelo ID
		for (Seguro s : SegurosBrasil.getListaSeguros()) {
			if (s.getCliente().equals(cacauShow)) {
				int id = s.getId();
				SegurosBrasil.cancelarSeguro(id);
				break;
			}
		}

		// Remove Cliente, nesse caso remove o Cliente PJ CacauShow
		SegurosBrasil.removerCliente("11.878.898/0001-11");

		System.out.println("\n----- MENU INTERATIVO ------");

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
				System.out.println("5 - Calcular Receita Seguradora");
				System.out.println("6 - Sair");

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
		System.out.println("Insira o cnpj da seguradora: ");
		String cnpj = entrada.nextLine();
		for (Seguradora s : seguradoraList) {
			if (s.getCnpj().equals(cnpj)) {
				s.calcularReceita();
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

		System.out.println("Genero do cliente: ");
		String genero = entrada.nextLine();

		System.out.println("Nível de escolaridade do cliente: ");
		String escolaridade = entrada.nextLine();
		System.out.println("Data de nascimento (formato AAAA-MM-DD) do cliente: ");
		String dataN = entrada.nextLine();
		LocalDate dtnasc = LocalDate.parse(dataN);

		System.out.println("Telefone do cliente: ");
		String telefone = entrada.nextLine();

		System.out.println("Email do cliente: ");
		String email = entrada.nextLine();

		ClientePF c_pf = new ClientePF(nome, endereco, cpf, genero, escolaridade, dtnasc, telefone, email);
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

		System.out.println("Telefone do cliente: ");
		String telefone = entrada.nextLine();

		System.out.println("Email do cliente: ");
		String email = entrada.nextLine();

		ClientePJ c_pj = new ClientePJ(nome, endereco, cnpj, dtfundacao, telefone, email);
		return c_pj;
	}

	private static Seguradora leSeguradoraDoInput(Scanner entrada) {
		System.out.println("Responda as perguntas a seguir sobre a seguradora");
		System.out.println("Nome da seguradora: ");
		String nome = entrada.nextLine();
		System.out.println("Telefone da seguradora: ");
		String telefone = entrada.nextLine();
		System.out.println("E-mail da seguradora: ");
		String email = entrada.nextLine();
		System.out.println("Endereço da seguradora: ");
		String endereco = entrada.nextLine();

		System.out.println("CNPJ da seguradora: ");
		String cnpj = entrada.nextLine();

		Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, cnpj);
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

	private static void gerarSinistro(Scanner entrada, List<Seguradora> seguradoraList) {
		System.out.println("Digite o ID do seguro: ");
		int idSeguro = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite o cnpj da seguradora: ");
		String cnpjSeguradora = entrada.nextLine();

		LocalDate data = leDataDoInput(entrada);
		String endereco = leEnderecoDoInput(entrada);

		for (Seguradora s : seguradoraList) {
			if (s.getCnpj().equals(cnpjSeguradora)) {
				for (Seguro seguro : s.getListaSeguros()) {
					if (seguro.getId() == idSeguro) {
						seguro.gerarSinistro(data, endereco);
						System.out.println("Sinistro gerado com sucesso!");
						return;
					}
				}
			}
		}

		System.out.println("Problema ao gerar o sinistro ID do seguro ou CNPJ da seguradora é inválido.");
	}

	private static boolean cadastraVeiculoSeguradoraClientePF(Veiculo veiculo, String cpf, String cnpjseguradora,
			List<Seguradora> seguradoraList) {
		for (Seguradora s : seguradoraList) {
			if (s.getCnpj().equals(cnpjseguradora)) { // encontrei a seguradora desejada
				List<ClientePF> listaPF = s.obterListaPF();
				for (ClientePF clientepf : listaPF) {
					if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpf)) {
						return clientepf.cadastrarVeiculo(veiculo); // busco ele na lista e add o veiculo
					}
				}
			}
		}

		return false;
	}

	private static boolean cadastraFrotaSeguradoraClientePJ(Frota frota, String cnpj, String cnpjseguradora,
			List<Seguradora> seguradoraList) {
		for (Seguradora s : seguradoraList) {
			if (s.getCnpj().equals(cnpjseguradora)) { // encontrei a seguradora desejada
				List<ClientePJ> listaPJ = s.obterListaPJ();
				for (ClientePJ clientepj : listaPJ) {
					if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cnpj)) {
						return clientepj.cadastrarFrota(frota); // busco ele na lista e add a frota
					}
				}
			}
		}
		return false;
	}

	private static Frota leFrotaDoInput(Scanner entrada) {
		System.out.println("Digite o codigo da frota: ");
		String codigoFrota = entrada.nextLine();
		Frota frota = new Frota(codigoFrota);
		System.out.println("Digite a quantidade de veiculos da frota: ");
		int qtdVeiculos = entrada.nextInt();
		entrada.nextLine();
		for (int i = 0; i < qtdVeiculos; i++) {
			Veiculo veiculo = leVeiculoDoInput(entrada);
			frota.addVeiculoFrota(veiculo);
		}
		return frota;
	}

	private static void leSeguroDoInput(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		System.out.println("Digite o CNPJ da seguradora que deseja cadastrar um seguro: ");
		String cnpjseguradora = entrada.nextLine();
		LocalDate dataInicio = leDataDoInput(entrada);
		LocalDate dataFim = leDataDoInput(entrada);
		Cliente cliente = leClienteDoInput(entrada);
		if (cliente instanceof ClientePF) {
			Veiculo veiculo = leVeiculoDoInput(entrada);
			for (Seguradora s : seguradoraList) {
				if (s.getCnpj().equals(cnpjseguradora)) {
					s.gerarSeguro(dataInicio, dataFim, veiculo, (ClientePF) cliente);
				}
			}
		} else {
			Frota frota = leFrotaDoInput(entrada);
			for (Seguradora s : seguradoraList) {
				if (s.getCnpj().equals(cnpjseguradora)) {
					s.gerarSeguro(dataInicio, dataFim, frota, (ClientePJ) cliente);
				}
			}
		}
	}

	public static void menuCadastrar(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int opcao_cadastrar;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Cadastrar Cliente PF/PJ");
			System.out.println("2 - Cadastrar Veículo");
			System.out.println("3 - Cadastrar Seguradora");
			System.out.println("4 - Cadastrar Seguro");
			System.out.println("0 - Voltar");

			System.out.println("Informe a opção desejada: ");
			opcao_cadastrar = entrada.nextInt();
			entrada.nextLine();

			if (opcao_cadastrar == MenuCadastrar.CADASTRAR_CLIENTEPFPJ.operacao) {
				Cliente cliente = leClienteDoInput(entrada);
				System.out.println("CNPJ da seguradora em que deseja cadastrar o cliente: ");
				String cnpjseguradora = entrada.nextLine();
				Seguradora seguradora = null;
				for (Seguradora s : seguradoraList) {
					if (s.getCnpj().equals(cnpjseguradora)) {
						s.cadastrarCliente(cliente);
						seguradora = s;
					}
				}
				if (seguradora == null) {
					System.out.println("Seguradora não encontrada");
					return;
				}

			} else if (opcao_cadastrar == MenuCadastrar.CADASTRAR_VEICULO.operacao) {

				System.out.println("Digite o CPF/CNPJ do cliente em que deseja cadastrar um veiculo: ");
				String cpfoucnpj = entrada.nextLine();

				System.out.println("CNPJ da seguradora que possui esse cliente: ");
				String cnpjseguradora = entrada.nextLine();

				if (Validacao.validarCPF(cpfoucnpj)) {
					Veiculo veiculo = leVeiculoDoInput(entrada);
					if (cadastraVeiculoSeguradoraClientePF(veiculo, cpfoucnpj, cnpjseguradora, seguradoraList)) {
						System.out.println("Veiculo de placa " + veiculo.getPlaca()
								+ "adicionado com sucesso no cliente e seguradora pedidos.");
					}
				} else {
					System.out.println("Eh cliente PJ, portanto precisamos registrar uma frota");
					Frota frota = leFrotaDoInput(entrada);
					cadastraFrotaSeguradoraClientePJ(frota, cpfoucnpj, cnpjseguradora, seguradoraList);
				}

			} else if (opcao_cadastrar == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {
				Seguradora seguradora = leSeguradoraDoInput(entrada);
				seguradoraList.add(seguradora);
				System.out.println("Seguradora " + seguradora.getNome() + " cadastrada com sucesso.");

			} else if (opcao_cadastrar == MenuCadastrar.CADASTRAR_SEGURO.operacao) {
				leSeguroDoInput(entrada, seguradoraList);
				System.out.println("Seguro cadastrado com sucesso");

			} else if (opcao_cadastrar == MenuCadastrar.VOLTAR.operacao) {
				System.out.println("Voltando para Menu Principal");
			} else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (opcao_cadastrar != MenuCadastrar.VOLTAR.operacao);
	}

	private static void visualizarSinistroDaSeguradora(Seguradora seguradora, String cpfcpnj) {
		List<ClientePF> listaPF = seguradora.obterListaPF();
		for (ClientePF clientepf : listaPF) {
			if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpfcpnj)) {
				List<Sinistro> listaSinistros = seguradora.getSinistrosPorCliente(clientepf);
				System.out.println("Os sinistros sao:");
				for (Sinistro sinistro : listaSinistros) {
					System.out.println(sinistro);
				}
			}
		}
		List<ClientePJ> listaPJ = seguradora.obterListaPJ();
		for (ClientePJ clientepj : listaPJ) {
			if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cpfcpnj)) {
				List<Sinistro> listaSinistros = seguradora.getSinistrosPorCliente(clientepj);
				System.out.println("Os sinistros sao:");
				for (Sinistro sinistro : listaSinistros) {
					System.out.println(sinistro);
				}
			}
		}
	}

	private static void listarSinistrosDaSeguradora(Seguradora s) {
		System.out.println("Os sinistros da seguradora " + s.getNome() + " sao:");
		for (Cliente c : s.getListaClientes()) {
			List<Sinistro> listaSinistros = s.getSinistrosPorCliente(c);
			System.out.println("Para o cliente " + c.getNome() + ": ");
			for (Sinistro sinistro : listaSinistros) {
				System.out.println(sinistro);
			}
		}
	}

	public static void menuListar(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int opcao_listar;
		do {
			System.out.println("Menu Listar:");
			System.out.println("1 - Listar Cliente (PF/PJ)");
			System.out.println("2 - Listar Sinistros por Seguradora");
			System.out.println("3 - Listar Sinistros por Cliente");
			System.out.println("4 - Listar Veiculos por Cliente");
			System.out.println("5 - Listar Seguros por Cliente");
			System.out.println("0 - Voltar");

			System.out.println("Informe a opção desejada: ");
			opcao_listar = entrada.nextInt();
			entrada.nextLine();

			if (opcao_listar == MenuListar.LISTAR_CLIENTE_PFPJ.operacao) {

				System.out.println("O tipo do cliente é PF ou PJ: ");
				String tipocliente = entrada.nextLine();

				System.out.println("CNPJ da seguradora que deseja listar esses clientes: ");
				String cnpjseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getCnpj().equals(cnpjseguradora)) {
						s.listarClientes(tipocliente);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTRO_CLIENTE.operacao) {
				System.out.println("CPF/CNPJ do cliente para listar sinistros: ");
				String cpfoucnpj = entrada.nextLine();

				System.out.println("CNPJ da seguradora que deseja listar esses clientes: ");
				String cnpjseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getCnpj().equals(cnpjseguradora)) {
						visualizarSinistroDaSeguradora(s, cpfoucnpj);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTROS_SEGURADORA.operacao) {
				System.out.println("CNPJ da seguradora que deseja listar os sinistros: ");
				String cnpjseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getCnpj().equals(cnpjseguradora)) {
						listarSinistrosDaSeguradora(s);
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
								System.out.println(((ClientePF) c).getListaVeiculos());
							}
						} else if (c instanceof ClientePJ) {
							if (((ClientePJ) c).getCnpj().equals(cpfoucnpj)) {
								System.out.println("Lista de veiculos do cliente " + c.getNome());
								for (Frota frota : ((ClientePJ) c).getListaFrota()) {
									System.out.println("Para a frota " + frota.getCode() + ": ");
									System.out.println(frota.getListaVeiculos());
								}
							}
						}
					}
				}
			} else if (opcao_listar == MenuListar.LISTAR_SEGUROS_CLIENTE.operacao) {

				System.out.println("Digite o CNPJ da seguradora em que deseja realizar essa operação: ");
				String cnpjseguradora = entrada.nextLine();

				System.out.println("Digite as informações do cliente que deseja listar os seguros: ");
				Cliente cliente = leClienteDoInput(entrada);

				for (Seguradora seguradora : seguradoraList) {
					if (seguradora.getCnpj().equals(cnpjseguradora)) {
						for (Seguro seguro : seguradora.getSegurosPorCliente(cliente)) {
							System.out.println(seguro.toString());
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
			System.out.println("4 - Excluir/Cancelar Seguro");
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
				System.out.println("Digite a placa do veiculo a ser excluido");
				String placa = entrada.nextLine();
				int ok = 0;
				for (Seguradora s : seguradoraList) {
					for (Cliente c : s.getListaClientes()) {
						if (c instanceof ClientePF) {
							if (((ClientePF) c).removerVeiculo(placa)) {
								System.out.println("Veiculo excluido!");
								ok = 1;
							}
						} else {
							for (Frota frota : ((ClientePJ) c).getListaFrota()) {
								if (frota.removeVeiculoFrota(placa)) {
									System.out.println("Veiculo excluido!");
									ok = 1;
								}
							}
						}
					}
				}

				if (ok == 0) {
					System.out.println("Veiculo não encontrado!");
				}

			} else if (opcao_excluir == MenuExcluir.EXCLUIR_SINISTRO.operacao) {
				System.out.println("Digite o CNPJ da seguradora em que deseja realizar essa operação: ");
				String cnpjseguradora = entrada.nextLine();

				System.out.println("Digite o ID do seguro que deseja excluir o sinistro: ");
				int idseguro = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Se o sinistro é de um cliente digite 1, se for de um condutor 2: ");
				int opcao = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Digite o ID do sinistro que deseja excluir: ");
				int idsinistro = entrada.nextInt();
				entrada.nextLine();

				System.out.println("Digite o CPF/CNPJ de quem está no nome o sinistro: ");
				String cpfoucnpj = entrada.nextLine();

				for (Seguradora seguradora : seguradoraList) {
					if (seguradora.getCnpj().equals(cnpjseguradora)) {
						Seguro seguro = seguradora.getSeguro(idseguro);
						seguro.exclui_sinistro(opcao, idsinistro, cpfoucnpj);
					}
				}

			} else if (opcao_excluir == MenuExcluir.EXCLUIR_SEGURO.operacao) {
				System.out.println("Digite o CNPJ da seguradora em que deseja realizar essa operação: ");
				String cnpjseguradora = entrada.nextLine();
				System.out.println("Digite o ID do seguro que deseja cancelar/excluir: ");
				int idseguro = entrada.nextInt();
				entrada.nextLine();
				for (Seguradora seguradora : seguradoraList) {
					if (seguradora.getCnpj().equals(cnpjseguradora)) {
						seguradora.cancelarSeguro(idseguro);
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
