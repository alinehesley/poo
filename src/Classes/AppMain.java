package Classes;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppMain {
	public static void main(String[] args) throws ParseException {

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

				System.out.printf("Informe a opção desejada: ");
				opcao = entrada.nextInt();

				if (opcao == MenuOperacoes.CADASTRAR.operacao) {
					menuCadastrar(entrada, seguradoraList);
				} else if (opcao == MenuOperacoes.LISTAR.operacao) {
					menuListar(entrada, seguradoraList);
				} else if (opcao == MenuOperacoes.EXCLUIR.operacao) {
					menuExcluir(entrada, seguradoraList);
				} else if (opcao == MenuOperacoes.GERAR_SINISTRO.operacao) {
					gerarSinistro(entrada, seguradoraList);
				} else if (opcao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
					System.out.println("Transfere seguro p outro cliente");
				} else if (opcao == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.operacao) {
					System.out.println("Calcula a receita total da seguradora");
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

	private static Cliente leClienteDoInput(Scanner entrada) throws ParseException {
		System.out.println("Digite PF se quer um clientePF ou PJ se clientePJ");
		String val = entrada.nextLine();
		if (val == "PF") {
			return leClientePFdoInput(entrada);
		} else {
			return leClientePJdoInput(entrada);
		}
	}

	private static ClientePF leClientePFdoInput(Scanner entrada) throws ParseException {
		System.out.println("Responda as perguntas a seguir sobre o cliente PF");
		System.out.printf("Nome completo do cliente: ");
		String nome = entrada.nextLine();
		System.out.println("Endereço do cliente: ");
		String endereco = entrada.nextLine();
		System.out.printf("CPF do cliente: "); // lembrar de verificar se é valido
		String cpf = entrada.nextLine();
		if (Validacao.validarCPF(cpf) == false) {
			System.out.println("O CPF do cliente é inválido.");
			throw new ParseException("CPF invalido", 0);
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
		return c_pf;
	}

	private static ClientePJ leClientePJdoInput(Scanner entrada) throws ParseException {
		System.out.println("Responda as perguntas a seguir sobre o cliente PJ");
		System.out.printf("Nome completo do cliente: ");
		String nome = entrada.nextLine(); // lembrar de validar nome
		System.out.printf("Endereço do cliente: ");
		String endereco = entrada.nextLine();
		System.out.printf("CNPJ do cliente: "); // lembrar de verificar se é valido
		String cnpj = entrada.nextLine();
		if (Validacao.validarCNPJ(cnpj) == false) {
			System.out.println("O CNPJ do cliente é inválido.");
			throw new ParseException("CPF invalido", 0);
		}
		System.out.printf("Data de fundação da empresa (formato AAAA-MM-DD):");
		String dataF = entrada.nextLine();
		LocalDate dtfundacao = LocalDate.parse(dataF);
		System.out.printf("Número de funcionários: ");
		int numfunc = entrada.nextInt();
		ClientePJ c_pj = new ClientePJ(nome, endereco, cnpj, dtfundacao, numfunc);
		return c_pj;
	}

	private static Seguradora leSeguradoraDoInput(Scanner entrada) {
		System.out.println("Responda as perguntas a seguir sobre a seguradora");
		System.out.printf("Nome da seguradora: ");
		String nome = entrada.nextLine();
		System.out.printf("Número da seguradora: ");
		String numero = entrada.nextLine();
		System.out.printf("E-mail da seguradora: ");
		String email = entrada.nextLine();
		System.out.printf("Endereço da seguradora: ");
		String endereco = entrada.nextLine();
		Seguradora seguradora = new Seguradora(nome, numero, email, endereco);
		return seguradora;
	}

	private static Veiculo leVeiculoDoInput(Scanner entrada) {
		System.out.println("Responda as perguntas a seguir sobre o veiculo");
		System.out.printf("Placa do veiculo: ");
		String placa = entrada.nextLine();
		System.out.printf("Marca do veiculo: ");
		String marca = entrada.nextLine();
		System.out.printf("Modelo do veiculo: ");
		String modelo = entrada.nextLine();
		System.out.printf("Ano de fabricação do veículo: ");
		int anofab = entrada.nextInt();
		entrada.nextLine();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, anofab);
		return veiculo;
	}

	private static LocalDate leDataDoInput(Scanner entrada) {
		System.out.printf("Insira a data (formato AAAA-MM-DD)");
		String data = entrada.nextLine();
		LocalDate dt = LocalDate.parse(data);
		return dt;
	}

	private static String leEnderecoDoInput(Scanner entrada) {
		System.out.println("Insira o enredeço: ");
		String endereco = entrada.nextLine();
		return endereco;
	}

	private static void gerarSinistro(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		Cliente c = leClienteDoInput(entrada);
		Veiculo v = leVeiculoDoInput(entrada);
		Seguradora s = leSeguradoraDoInput(entrada);
		LocalDate data = leDataDoInput(entrada);
		String endereco = leEnderecoDoInput(entrada);
		for (Seguradora seg : seguradoraList) {
			if (seg.getNome() == s.getNome()) {
				seg.gerarSinistro(data, endereco, v, c);
			}
		}
	}

	public static void menuCadastrar(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int cadastro_opcao;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Cadastrar Cliente PF/PJ");
			System.out.println("2 - Cadastrar Veículo");
			System.out.println("3 - Cadastrar Seguradora");
			System.out.println("0 - Voltar");

			System.out.printf("Informe a opção desejada: ");
			cadastro_opcao = entrada.nextInt();
			entrada.nextLine();

			if (cadastro_opcao == MenuCadastrar.CADASTRAR_CLIENTEPFPJ.operacao) {
				Cliente cliente = leClienteDoInput(entrada);
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome() == nomeseguradora) {
						s.cadastrarCliente(cliente);
					}
				}
			} else if (cadastro_opcao == MenuCadastrar.CADASTRAR_VEICULO.operacao) {
				Veiculo veiculo = leVeiculoDoInput(entrada);
				System.out.println("CPF/CNPJ do cliente em que deseja cadastrar um veiculo");
				String cpfoucnpj = entrada.nextLine();

				for (Seguradora s1 : seguradoraList) {
					if (Validacao.validarCPF(cpfoucnpj)) {
						List<ClientePF> listaPF = s1.obterListaPF();
						for (ClientePF clientepf : listaPF) {
							if (clientepf.getCpf().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
								clientepf.addVeiculos(veiculo);
								break;
							}
						}
					}

					else if (Validacao.validarCNPJ(cpfoucnpj)) {
						List<ClientePJ> listaPJ = s1.obterListaPJ();
						for (ClientePJ clientepj : listaPJ) {
							if (clientepj.getCnpj().replaceAll("[^0-9]", "").equals(cpfoucnpj)) {
								clientepj.addVeiculos(veiculo);
								break;
							}
						}
					}
				}

			} else if (cadastro_opcao == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {
				Seguradora seguradora = leSeguradoraDoInput(entrada);
				seguradoraList.add(seguradora);

			} else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (cadastro_opcao != MenuCadastrar.VOLTAR.operacao); // ser dif de voltar
	}

	public static void menuListar(Scanner entrada, List<Seguradora> seguradoraList) {
		int opcao_listar;
		do {
			System.out.println("Menu Listar:");
			System.out.println("1 - Listar Cliente (PF/PJ)");
			System.out.println("2 - Listar Sinistros por Seguradora");
			System.out.println("3 - Listar Sinistros por Cliente");
			System.out.println("4 - Listar Veiculo por Cliente");
			System.out.println("0 - Voltar");

			System.out.printf("Informe a opção desejada: ");
			opcao_listar = entrada.nextInt();
			entrada.nextLine();

			if (opcao_listar == MenuListar.LISTAR_CLIENTE_PFPJ.operacao) {

				System.out.println("O tipo do cliente é PF ou PJ: ");
				String tipocliente = entrada.nextLine();

				System.out.println("Nome da seguradora que deseja listar esses clientes: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome() == nomeseguradora) {
						s.listarClientes(tipocliente);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTRO_CLIENTE.operacao) {
				System.out.println("CPF/CNPJ do cliente para listar sinistros: ");
				String cpfoucnpj = entrada.nextLine();

				System.out.println("Nome da seguradora que deseja listar esses clientes: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome() == nomeseguradora) {
						s.visualizarSinistro(cpfoucnpj);
					}
				}

			} else if (opcao_listar == MenuListar.LISTAR_SINISTROS_SEGURADORA.operacao) {
				// precisa dizer qual a seguradora é, buscar ela na lista de seguradora
				System.out.println("Nome da seguradora que deseja listar os sinistros: ");
				String nomeseguradora = entrada.nextLine();
				for (Seguradora s : seguradoraList) {
					if (s.getNome() == nomeseguradora) {
						s.listarSinistro();
					}
				}

			}

		} while (opcao_listar != MenuListar.VOLTAR.operacao);
	}

	public static void menuExcluir(Scanner entrada, List<Seguradora> seguradoraList) throws ParseException {
		int cadastro_opcao;
		do {
			System.out.println("Menu Cadastrar:");
			System.out.println("1 - Excluir Cliente");
			System.out.println("2 - Excluir Veículo");
			System.out.println("3 - Excluir Sinistro");
			System.out.println("0 - Voltar");

			System.out.printf("Informe a opção desejada: ");
			cadastro_opcao = entrada.nextInt();
			entrada.nextLine();

			if (cadastro_opcao == MenuExcluir.EXCLUIR_CLIENTE.operacao) {
				System.out.printf("Coloque o CPF ou CNPJ do cliente:");
				String cpfOucnpj = entrada.nextLine();

				for (Seguradora seguradora : seguradoraList) {
					if (seguradora.removerCliente(cpfOucnpj)) {
						System.out.println("Cliente removido de " + seguradora.getNome());
					}
				}

			} else if (cadastro_opcao == MenuExcluir.EXCLUIR_VEICULO.operacao) {
				System.out.println("Coloque os detalhes do veiculo a ser excluido");
				Veiculo v = leVeiculoDoInput(entrada);
				for (Seguradora s : seguradoraList) {
					for (Cliente c : s.getListaClientes()) {
						c.removeVeiculo(v);
					}
				}
			} else if (cadastro_opcao == MenuExcluir.EXCLUIR_SINISTRO.operacao) {
				System.out.println("Coloque os detalhes do sinistro a ser excluido");
				Cliente cliente = leClienteDoInput(entrada);
				Veiculo veiculo = leVeiculoDoInput(entrada);
				Seguradora seguradora = leSeguradoraDoInput(entrada);
				for (Seguradora s : seguradoraList) {
					if (s.getNome() == seguradora.getNome()) {
						s.excluirSinistro(veiculo, cliente);
					}
				}
			} else {
				System.out.println("Opção desejada é inválida.");
			}
		} while (cadastro_opcao != MenuCadastrar.VOLTAR.operacao); // ser dif de voltar
	}
}// chave appMain
