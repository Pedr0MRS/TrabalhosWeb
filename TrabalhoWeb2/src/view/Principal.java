package view;
import javax.xml.ws.Endpoint;

import control.Controle;

public class Principal {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2484/ws/celular", new Controle());
		System.out.println("Serviço inicializado!");
	}

}
