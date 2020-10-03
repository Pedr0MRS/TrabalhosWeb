package model;

public class Celular {
	
	private long id;
	private String modelo;
	private String marca;
	private float altura;
	private float largura;
	private byte[] imagemCel;
	
	public Celular() {
		
	}

	//Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public byte[] getImagemCel() {
		return imagemCel;
	}

	public void setImagemCel(byte[] imagemCel) {
		this.imagemCel = imagemCel;
	}
	
	
	
}
