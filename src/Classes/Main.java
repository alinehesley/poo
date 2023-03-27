package Classes;

public class Main {
	public static void main(String[] args) {
		Cliente aline = new Cliente("Aline", "612977023-52", "15/02/2003", 20, "Rua Agostinho Ramalho");
		System.out.println(aline.getCpf());
		System.out.println(aline.validarCPF(aline.getCpf()));
		
		Sinistro contrato_aline = new Sinistro("24/03/2023", "ulaula");
		System.out.println(contrato_aline.getId());
		
	}
}