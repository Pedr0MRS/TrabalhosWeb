package view;

import control.ControleInterface;
import control.ControleService;

public class Cliente {

	public static void main(String[] args) {
		
		ControleService service = new ControleService();
		ControleInterface controle = service.getControlePort();
		
		System.out.println("Teste");
		System.out.println(controle.getCelular());
		
	}
	
}
