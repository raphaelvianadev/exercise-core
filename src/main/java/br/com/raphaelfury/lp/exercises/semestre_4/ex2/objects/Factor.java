package br.com.raphaelfury.lp.exercises.semestre_4.ex2.objects;

import br.com.raphaelfury.lp.utils.Logger;

public class Factor {

	public void factor(int number) {
		Logger logger = new Logger();
		int fat, id = 0;
		for (fat = 1; number > 1; number--) {
			fat *= number;
			id++;
			logger.log("Fatorial (" + id + "º estágio): " + fat);
		}
		
		logger.log("\n\nFatorial concluído!");
	}

}
