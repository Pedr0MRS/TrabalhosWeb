package view;

import control.ControleService;
import control.InterfaceControle;
import model.Capinha;
import model.Celular;

public class Cliente {

	public static void main(String[] args) throws Exception {

		ControleService service = new ControleService();
		InterfaceControle controle = service.getControlePort();

		/*
		 * Capinha capinha1 = new Capinha(); capinha1.setCor("azul");
		 * capinha1.setMaterial("pedra"); controle.postCapinha(capinha1); Capinha
		 * capinha2 = new Capinha(); capinha2.setCor("rosa");
		 * capinha2.setMaterial("madeira"); controle.postCapinha(capinha2); Capinha
		 * capinha3 = new Capinha(); capinha3.setCor("preto");
		 * capinha3.setMaterial("vidro"); controle.postCapinha(capinha3);
		 */

		/*
		 * Capinha c = controle.getCapinhaId(2); System.out.println(c.getCor());
		 * c.setCor("Amarelo"); controle.putCapinha(c);
		 * 
		 * c = controle.getCapinhaId(2); System.out.println(c.getCor());
		 * 
		 * for (Capinha capinha : controle.getCapinha()) {
		 * System.out.println(capinha.toString()); }
		 */

		/*Celular celular1 = new Celular();
		celular1.setModelo("modelo1");
		celular1.setAltura((float) 0.6);
		celular1.setLargura((float) 0.5);
		celular1.setMarca("marca1");
		Celular celular2 = new Celular();
		celular2.setModelo("modelo2");
		celular2.setAltura((float) 0.6);
		celular2.setLargura((float) 0.5);
		celular2.setMarca("marca2");
		Celular celular3 = new Celular();
		celular3.setModelo("modelo3");
		celular3.setAltura((float) 0.6);
		celular3.setLargura((float) 0.5);
		celular3.setMarca("marca3");

		controle.postCelular(celular1);
		controle.postCelular(celular2);
		controle.postCelular(celular3);*/
		
		controle.delCelular(2);
		
		Celular c1 = controle.getCelularId(1);
		System.out.println(c1.toString());
		c1.setMarca("windowsphone");
		c1.setModelo("Windows8");
		controle.putCelular(c1);
		
		c1 = controle.getCelularId(1);
		System.out.println(c1.toString());
		
		for (Celular celular : controle.getCelular()) {
			System.out.println(celular.toString());
		}

	}

}
