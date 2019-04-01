package br.com.raphaelfury.lp.exercises.semestre_5.ex1;

import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_5.ex1.controller.Ex2Runner;
import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.map.ProductMap;
import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.view.MainMenu;

public class Ex1 extends Exercise{
	
	public static final ProductMap productMap = new ProductMap();
	private static MainMenu menu = new MainMenu();

	public Ex1() {
		super("Ex1", "Mercado", true);
	}
	
	@Override
	public void start() {
		Ex2Runner runner = new Ex2Runner(menu);
		runner.init();
		getMainMenu().displayFinish();
		
		finalize();
	}
	
	public static ProductMap getProductMap() {
		return productMap;
	}
	
	public static MainMenu getMainMenu() {
		return menu;
	}
	
}
