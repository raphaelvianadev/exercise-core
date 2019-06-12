package br.com.raphaelfury.lp.exercises.semestre_4.ex2;

import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_4.ex2.objects.Factor;

public class Ex2 extends Exercise {
	
	public Ex2() {
		super("Ex2", "Fatoração", false);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start() {
		int number = 0;
		Factor factor = new Factor();
		
		log("Digite um número para ser fatorado");
		number = getScanner().nextInt();
		
		factor.factor(number);
		
		finalize();
	}

}
