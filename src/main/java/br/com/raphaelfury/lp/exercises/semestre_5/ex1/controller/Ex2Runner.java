package br.com.raphaelfury.lp.exercises.semestre_5.ex1.controller;

import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.impl.ProductImpl;
import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.view.MainMenu;

public class Ex2Runner {

	private MainMenu menu;
	private boolean running = true;
	private ProductImpl runner = new ProductImpl();
	
	public Ex2Runner(MainMenu menu) {
		this.menu = menu;
	}

	public void init() {
		while (running) {
			switch (menu.displayMainMenu()) {
			case 1: //CADASTRAR
				runner.registerProduct();
				break;
			case 2: //VENDER
				runner.sellProduct();
				break;
			case 3: //ATUALIZAR
				runner.updateProduct();
				break;
			case 4: //TROCAR
				runner.changeProduct();
				break;
			case 5: //LISTAR TODOS
				runner.viewProducts();
				break;
			case 6: //DESLIGAR
				running = false;
				break;
			default:
				menu.displayWrongOption();
				break;
			}
		}
	}

}
