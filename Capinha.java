package model;

import java.util.Arrays;

public class Capinha {

	private long id;
	private String cor;
	private String material;
	private byte[] imagemCap;

	public Capinha(long id, String cor, String material, byte[] imagemCap) throws Exception {
		super();
		setId(id);
		setCor(cor);
		setMaterial(material);
		setImagemCap(imagemCap);
	}

	// Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id >= 0)
			this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) throws Exception {
		if (cor.isEmpty() || cor == null) {
			throw new Exception("O campo cor está vazio");
		}
		this.cor = cor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) throws Exception {
		if (material.isEmpty() || material == null) {
			throw new Exception("O campo material está vazio");
		}
		this.material = material;
	}

	public byte[] getImagemCap() {
		return imagemCap;
	}

	public void setImagemCap(byte[] imagem) throws Exception {
		if (imagem == null) {
			throw new Exception("O campo imagem está vazio");
		}
		this.imagemCap = imagem;
	}

	@Override
	public String toString() {
		return "Capinha [id=" + id + ", cor=" + cor + ", material=" + material + ", imagemCap="
				+ Arrays.toString(imagemCap) + "]";
	}
}
