package br.com.raphaelfury.lp.exercises.semestre_4.ex5.objects;

public class Apartamento {

	/*
	 * Cada um desses apartamentos possui: número do apartamento (pode ser o mesmo
	 * índice do vetor usado), número do andar, número do interfone, status (ocupado
	 * ou não) e n�mero de moradores
	 */

	private int numero, numeroAndar, numeroInterfone, numeroMoradores;
	private boolean status;
	
	public Apartamento(int numero, int numeroAndar, int numeroInterfone, int numeroMoradores, boolean status) {
		setNumero(numero);
		setNumeroAndar(numeroAndar);
		setNumeroInterfone(numeroInterfone);
		setNumeroMoradores(numeroMoradores);
		setStatus(status);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroAndar() {
		return numeroAndar;
	}

	public void setNumeroAndar(int numeroAndar) {
		this.numeroAndar = numeroAndar;
	}

	public int getNumeroInterfone() {
		return numeroInterfone;
	}

	public void setNumeroInterfone(int numeroInterfone) {
		this.numeroInterfone = numeroInterfone;
	}

	public int getNumeroMoradores() {
		return numeroMoradores;
	}

	public void setNumeroMoradores(int numeroMoradores) {
		this.numeroMoradores = numeroMoradores;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
