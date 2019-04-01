package br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.view;

import javax.swing.JOptionPane;

public class MainMenu {

	public int displayMainMenu() {
		StringBuilder b = new StringBuilder();
		b.append("Menu (escolha uma opção):");
		b.append("\n");
		b.append("1. Cadastrar produto.");
		b.append("\n");
		b.append("2. Vender produto.");
		b.append("\n");
		b.append("3. Atualizar produto.");
		b.append("\n");
		b.append("4. Trocar produto.");
		b.append("\n");
		b.append("5. Visualizar produtos.");
		b.append("\n");
		b.append("6. Finalizar.");
		return Integer.valueOf(JOptionPane.showInputDialog(null, b.toString(), "Escolha uma opção", 3));
	}

	public void displayWrongOption() {
		JOptionPane.showMessageDialog(null, "Esta opção não é válida", "Erro", 0);
	}

	public void displayFinish() {
		JOptionPane.showMessageDialog(null, "Fim do programa", "Encerrando", 2);
	}

	public int displaySelectProduct() {
		return Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o código do produto", "Busca", -1));
	}

	public void displayProductNotValid() {
		JOptionPane.showMessageDialog(null, "Produto inválido", "Erro", 0);
	}

	public void displayProductError() {
		JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto", "Erro", 0);
	}

	public void displayNoProductSlotAvailable() {
		JOptionPane.showMessageDialog(null, "Você não pode exceder o número máximo para cadastro de produtos. Máximo: 20", "Erro", 0);
	}

	public void displayProductRegisterSuccess(int i) {
		JOptionPane.showMessageDialog(null, "Produto de número " + i + " registrado com sucesso!", "Registro realizado", 1);
	}


}
