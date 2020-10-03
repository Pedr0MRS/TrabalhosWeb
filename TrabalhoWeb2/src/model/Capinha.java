package model;

import java.util.ArrayList;
import java.util.List;

public class Capinha {
	
	private long id;
	private List<Celular> modelos = new ArrayList<Celular>();
	private String cor;
	private String material;
	private byte[] imagemCap;
	
	
	public Capinha() {
		
	}		
	
	//Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Celular> getModelos() {
		return modelos;
	}


	public void setModelos(List<Celular> modelos) {
		this.modelos = modelos;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public byte[] getImagemCap() {
		return imagemCap;
	}


	public void setImagemCap(byte[] imagem) {
		this.imagemCap = imagem;
	}
	
	
	
}
