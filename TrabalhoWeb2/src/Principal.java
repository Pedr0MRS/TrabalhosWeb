import javax.xml.ws.Endpoint;

import control.Controle;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:1515/ws/celular", new Controle());

	}

}
