package model;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "celular", propOrder = { "altura", "id", "imagemCel", "largura", "lista", "marca", "modelo" })
public class Celular {

	private long id;
	private String modelo;
	private String marca;
	private List<Capinha> lista;
	private float altura;
	private float largura;
	private byte[] imagemCel;

	public Celular(long id, String modelo, String marca, float altura, float largura, byte[] imagemCel,
			List<Capinha> lista) throws Exception {
		super();
		setId(id);
		setModelo(modelo);
		setMarca(marca);
		setAltura(altura);
		setLargura(largura);
		setImagemCel(imagemCel);
		setLista(lista);
	}

	public Celular() {
	}

	// Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id >= 0)
			this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws Exception {
		if (modelo.isEmpty() || modelo == null) {
			throw new Exception("O campo modelo está vazio");
		}
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) throws Exception {
		if (marca.isEmpty() || marca == null) {
			throw new Exception("O campo marca está vazio");
		}
		this.marca = marca;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) throws Exception {
		if (altura >= 0) {
			this.altura = altura;
		} else
			throw new Exception("O campo altura tem que ser maior que zero");
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) throws Exception {
		if (largura >= 0) {
			this.largura = largura;
		} else
			throw new Exception("O campo largura tem que ser maior que zero");
	}

	public byte[] getImagemCel() {
		return imagemCel;
	}

	public void setImagemCel(byte[] imagemCel) throws Exception {
		if (imagemCel == null) {
			throw new Exception("O campo imagem está vazio");
		}
		this.imagemCel = imagemCel;
	}

	@Override
	public String toString() {
		return "Celular [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", altura=" + altura + ", largura="
				+ largura + ", imagemCel=" + Arrays.toString(imagemCel) + "]";
	}

	public List<Capinha> getLista() {
		return lista;
	}

	public void setLista(List<Capinha> lista) throws Exception {
		if (lista == null) {
			throw new Exception("Lista vazia");
		}
		this.lista = lista;
	}

}
