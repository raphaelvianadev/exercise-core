package br.com.raphaelfury.lp.exercises.semestre_4.ex4.objects;

import java.util.UUID;

public class Chocolate {

	private int codigo, percentual, prodAno, quantidade;
	private String nome;
	private double valorRevenda, valorProd, peso;
	private UUID uuid;

	public Chocolate(UUID uuid, int codigo, String nome, int quantidade, int percentual, int prodAno, double valorRevenda,
			double valorProd, double peso) {
		setUUID(uuid);
		setCodigo(codigo);
		setNome(nome);
		setQuantidade(quantidade);
		setPercentual(percentual);
		setProdAno(prodAno);
		setValorRevenda(valorRevenda);
		setValorProd(valorProd);
		setPeso(peso);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPercentual() {
		return percentual;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

	public int getProdAno() {
		return prodAno;
	}

	public void setProdAno(int prodAno) {
		this.prodAno = prodAno;
	}

	public double getValorRevenda() {
		return valorRevenda;
	}

	public void setValorRevenda(double valorRevenda) {
		this.valorRevenda = valorRevenda;
	}

	public double getValorProd() {
		return valorProd;
	}

	public void setValorProd(double valorProd) {
		this.valorProd = valorProd;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UUID getUUID() {
		return uuid;
	}

	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n\nCHOCOLATE REGISTRADO!\n\nCódigo: #" + getCodigo() + "\nId: " + getUUID() + "\nNome: " + getNome() + "\nQuantidade: " + getQuantidade() + "\nPercentual de chocolate: "
				+ getPercentual() + "%\nProdução por ano: " + getProdAno() + "\nValor de revenda: R$" + getValorRevenda()
				+ "\nValor de produção: R$" + getValorProd() + "\nPeso (g): " + getPeso() + "g\n\n";
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
