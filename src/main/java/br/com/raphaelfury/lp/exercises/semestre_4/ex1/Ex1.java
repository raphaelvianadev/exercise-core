package br.com.raphaelfury.lp.exercises.semestre_4.ex1;

import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_4.ex1.objects.Calculator;

public class Ex1 extends Exercise {

	public Ex1() {
		super("Ex1", "Funções", true);
	}

	@Override
	public void start() {
		double a, b;
		Calculator calculator = new Calculator();
		
		log("Digite os n�meros desejados.");
		
		a = getScanner().nextDouble();
		b = getScanner().nextDouble();
		
		log("Soma: " + calculator.add(a, b));
		log("Subtração: " + calculator.subtract(a, b));
		log("Multiplicação: " + calculator.multiply(a, b));
		log("Divisão: " + calculator.divide(a, b));
		
		finalize();
	}
}
