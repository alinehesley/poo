package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//CADASTRO CLIENTE PF E PJ
		
		ClientePJ pj1 = new ClientePJ("Pedro", "R. Flores, 129", sdf.parse("20/03/2033"), "Ensino Superior Completo",
				"Masculino", "Média", "07.642.189/0001-65", sdf.parse("20/03/2033"));

		ClientePF pf1 = new ClientePF("Maria", "R. Sorvete, 999", sdf.parse("20/03/2033"), "Ensino Superior Completo",
				"Masculino", "Média", "612.977.023-52", sdf.parse("20/03/2033"));
		
		//CHAMADA DE METODOS VALIDAR CPF e CNPJ
		System.out.println(pj1.validarCNPJ(pj1.getCnpj()));
		System.out.println(pf1.validarCPF(pf1.getCpf()));
		
		//ADICIONA VEICULO
		pj1.getListaVeiculos().add(new Veiculo("DCJK", "Ford", "flex", 2020));
		pf1.getListaVeiculos().add(new Veiculo("FEJF", "UNO", "boot", 2012));
		
		//INSTANCIA UM OBJ NA SEGURADORA
		Seguradora s1 = new Seguradora("Seguros São Jorge", "9836263276", "segurossjorge@gmail.com", "Av. Limeira");
		
		//CADASTRA DOIS CLIENTES EM SEGURADORA
		s1.cadastrarCliente(pf1);
		s1.cadastrarCliente(pj1);
		
		//GERA UM SINISTRO 
		
		//CHAMADA DOS METODOS TOSTRING DE CADA CLASSE
		
		//CHAMA METODO LISTARCLIENTES
		
		//CHAMA METODO VISUALIZARSINISTRO
		
		//CHAMA METODO LISTARSINISTRO
		
	}
}