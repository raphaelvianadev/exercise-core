package br.com.raphaelfury.lp.exercises.semestre_4.ex5.objects;

import java.util.UUID;

public class Predio {

	/*
	 * nome, endereço, número de colaboradores, telefone e e-mail para contato
	 */

	private UUID uniqueId;
	private String nome, endereco, email;
	private int telefone, numeroColaboradores;
	
	public Predio(UUID uniqueId, String nome, String endereco, String email, int telefone, int numeroColaboradores) {
		setUniqueId(uniqueId);
		setNome(nome);
		setEndereco(endereco);
		setEndereco(endereco);
		setTelefone(telefone);
		setNumeroColaboradores(numeroColaboradores);
	}

	public UUID getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumeroColaboradores() {
		return numeroColaboradores;
	}

	public void setNumeroColaboradores(int numeroColaboradores) {
		this.numeroColaboradores = numeroColaboradores;
	}

}
