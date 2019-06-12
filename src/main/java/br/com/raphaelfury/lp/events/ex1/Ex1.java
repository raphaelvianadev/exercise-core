package br.com.raphaelfury.lp.events.ex1;

import br.com.raphaelfury.lp.exercises.Exercise;

public class Ex1 extends Exercise {

	public Ex1() {
		super("Ex1", "ENG TECH. | Números primos.", true);
	}

	@Override
	public void start() {
		int width;

		width = getScanner().nextInt();

		int[] v = new int[width];

		for (int i = 0; i < v.length; i++)
			v[i] = getScanner().nextInt();

		for (int i = 0; i < v.length; i++) {
			int counter = 0;
			for (int x = 1; x <= v[i]; x++)
				if (v[i] % x == 0)
					counter++;

			if (counter == 2)
				System.out.println(v[i] + " eh primo");
			else
				System.out.println(v[i] + " nao eh primo");
		}
		finalize();
	}

}
