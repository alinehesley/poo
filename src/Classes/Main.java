package Classes;

public class Main {
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Aline", "612.977.023-52", "15/02/2003", 19, "Av. Santa Isabel, n. 1125");
		System.out.println(cliente1.getNome());
		System.out.println(cliente1.getCpf());
		System.out.println(cliente1.validarCPF(cliente1.getCpf()));
		cliente1.setIdade(20);
		System.out.println(cliente1.getIdade());
		System.out.print(cliente1.toString());
		
		Seguradora seguradora1 = new Seguradora("SafeLife", "+5598984669707", "safelife@life.br", "Av. Alan Turing");
		System.out.println(seguradora1.getEmail());
		seguradora1.setEndereco("Av. Ada Lovelace");
		System.out.println(seguradora1.getEndereco());
		
		Sinistro sinistro1 = new Sinistro("27/03/2023", "Rua Aparecida, n. 233");
		System.out.println(sinistro1.getId());
		System.out.println(sinistro1.getData());
		
		Veiculo veiculo1 = new Veiculo("XP73H", "Hyundai", "Creta 2019");
		System.out.println(veiculo1.getPlaca());
		veiculo1.setModelo("flex");
		System.out.println(veiculo1.getModelo());
		
	}
}