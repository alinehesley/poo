package Classes;

import java.time.LocalDate;


public class AppMain{
	public static void main(String[] agrs){
		//Instanciar pelo menos 1 objeto de cada classe na ordem mais conveniente ( ́e fortemente recomendado
		//que se instancie m ́ultiplos objetos para cada classe);
		
		//Seguradoras
		
		Seguradora SegurosBrasil = new Seguradora("Seguros Brasil", "3381-3231", "segurosbrasil@gmail.com", "Rua Vitoria, n. 977", "11.878.898/0001-11");
		
		//Cliente PF e PJ
		
		ClientePF juca = new ClientePF("Juca Pirama", "Av. Taiapó, s/n", "612977023-52", "M", "Ens. Superior Completo", LocalDate.of(1999, 02, 12), "98966212332", "juquinha@hotmail.com");
		ClientePF luan = new ClientePF("Luan Hiller", "Av. Chiclete, n. 77", "637035133-49", "M", "Ens. Médio Completo", LocalDate.of(2000, 11, 03), "989432212332", "lukitaa@gamil.com");
		ClientePF nati = new ClientePF("Natielly Sousa", "Rua Paris, n. 1052", "612977009-03", "F", "Ens. Fundamental Completo", LocalDate.of(2003, 01, 06), "23564652332", "natisousa@gmail.com");
		ClientePF ruan = new ClientePF("Ruan Victor", "Rua Estrela Brilante, n. 168", "270980363-15", "M", "Pós-Graduação Completa", LocalDate.of(1987, 12, 05), "73219012321", "juquinha@hotmail.com");
		
		ClientePJ cacauShow = new ClientePJ("Cacau Show", "Av. Pinheiro, n.22", "11.878.898/0001-11", LocalDate.of(1999, 02, 12), "12378137218", "cacaushow@outlook.com");
		ClientePJ carrefour = new ClientePJ("Carrefour", "Av. Santa Isabel, n.44", "45.543.915/0001-81", LocalDate.of(1990, 11, 01), "12378137218", "carrefour@outlook.com");
		ClientePJ icpc = new ClientePJ("ICPC", "Av. Pinheiro, n.22", "05.534.398/0001.60", LocalDate.of(1889, 10, 10), "12378137218", "icpc@outlook.com");
		ClientePJ huawei = new ClientePJ("Huawei", "Rua Store Nur, n. 323", "02.975.504/0001-52", LocalDate.of(2000, 01, 21), "7238183211", "huawei@outlook.com");
//		
		//Condutores
		Condutor joao = new Condutor("6129-7702352", "João Paulo", "810928319", "Rua Brasil, n. 55", "joao@gmail.com", LocalDate.of(2000, 01, 21));
		Condutor maria = new Condutor("6129770235-2", "Maria Silva", "819273849", "Avenida das Flores, n. 123", "maria@gmail.com", LocalDate.of(1995, 06, 10));
		Condutor pedro = new Condutor("61297.702352", "Pedro Santos", "812349876", "Rua das Palmeiras, n. 78", "pedro@gmail.com", LocalDate.of(1988, 11, 27));
		Condutor ana = new Condutor("6129770-2352", "Ana Oliveira", "819273849", "Avenida dos Pinheiros, n. 456", "ana@gmail.com", LocalDate.of(1992, 03, 15));
		Condutor lucas = new Condutor("61297702352", "Lucas Costa", "810928319", "Rua dos Girassóis, n. 30", "lucas@gmail.com", LocalDate.of(1999, 10, 05));
		Condutor isabela = new Condutor("61297702352", "Isabela Almeida", "812349876", "Avenida das Acácias, n. 21", "isabela@gmail.com", LocalDate.of(1997, 07, 18));
		Condutor matheus = new Condutor("61297702352", "Matheus Rodrigues", "819273849", "Rua dos Lírios, n. 98", "matheus@gmail.com", LocalDate.of(1990, 04, 02));
		Condutor fernanda = new Condutor("612.977.023-52", "Fernanda Santos", "810928319", "Avenida das Hortênsias, n. 65", "fernanda@gmail.com", LocalDate.of(1994, 12, 12));
		

		//Veiculos
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
		
		//Frota
		Frota frota1 = new Frota("FROTA001");
		Frota frota2 = new Frota("FROTA002");
		Frota frota3 = new Frota("FROTA003");
		Frota frota4 = new Frota("FROTA004");
		
		
		//Seguros PF e PJ
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 02, 15), LocalDate.of(2024, 02, 15), veiculo2, luan);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 03, 15), LocalDate.of(2024, 03, 15), veiculo3, nati);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 04, 15), LocalDate.of(2024, 04, 15), veiculo4, ruan);

		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota1, icpc);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota2, cacauShow);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota3, carrefour);
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 06, 01), LocalDate.of(2024, 06, 01), frota4, huawei);

		
		//Sinistros
		
		
		//ToString
		System.out.println("ToString de objetos:");
		System.out.println(SegurosBrasil.toString());
		System.out.println(juca.toString());
		System.out.println(cacauShow.toString());
		System.out.println(joao.toString());
		System.out.println(veiculo1.toString());
		System.out.println(frota1.toString());
		System.out.println("-----------------------");
		
		//Principais metodos do sistema de Seguradora
		
		//Listar Cliente 
		System.out.println("Listando clientes PF e PJ da seguradora " + SegurosBrasil.getNome());
		SegurosBrasil.listarClientes("PF");
		SegurosBrasil.listarClientes("PJ");
		
		//Cadastra Cliente 
		System.out.println("Cadastro do cliente " + juca.getNome());
		SegurosBrasil.cadastrarCliente(juca);
		
		//Gera Seguro
		System.out.println("Gera Seguro para cliente " + juca.getNome());
		SegurosBrasil.gerarSeguro(LocalDate.of(2023, 05, 15), LocalDate.of(2024, 05, 15), veiculo1, juca);
		
		System.out.println("Listando seguros por Cliente do cliente " + juca.getNome() + " da Seguradora " + SegurosBrasil.getNome());
		System.out.println(SegurosBrasil.getSegurosPorCliente(juca));
		
		System.out.println("Gera Sinistro para cliente " + juca.getNome());
		for(Seguro s: SegurosBrasil.getListaSeguros()) {
			if(s.getCliente().equals(juca)) {
				s.gerarSinistro(LocalDate.of(2023, 10, 11), "Rua Flores, n. 22");
				break;
			}
		}
		
		System.out.println("Listando sinistros por Cliente do cliente " + juca.getNome() + " da Seguradora " + SegurosBrasil.getNome());
		System.out.println(SegurosBrasil.getSinistrosPorCliente(juca));
		
		//Calcula Receita da Seguradora
		SegurosBrasil.calcularReceita();
		
		//Cancela o seguro de ID 01
		SegurosBrasil.cancelarSeguro(1);
		
		//Remove Cliente
		SegurosBrasil.removerCliente("61297702352");
		
	
		
		
		//Seguros devem ser instanciados a partir do m ́etodo apropriado da classe Seguradora;
		
		//Sinistros devem ser criados a partir do m ́etodo apropriado da classe Seguro;
		
		//Apresentar exemplos da utiliza ̧c ̃ao dos principais m ́etodos das classes do Sistema de Seguradora.
		
		//Apenas ao final da execu ̧c ̃ao do projeto: chamar o menu de opera ̧c ̃oes.
		
		
	}
}