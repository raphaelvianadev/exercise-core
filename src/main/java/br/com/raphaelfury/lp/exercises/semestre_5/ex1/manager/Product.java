package br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager;

public class Product {

	private int id, quantity, sellQuantity, off;
	private float value;
	private String name;
	
	public Product(int id, int quantity, String name, float value, int off) {
		setId(id);
		setQuantity(quantity);
		setName(name);
		setValue(value);
		setOff(off);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(int sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	
	public void addSellQuantity(int sellQuantity) {
		this.sellQuantity += sellQuantity;
	}

}
