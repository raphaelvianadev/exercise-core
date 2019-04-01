package br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.impl;

import java.util.Comparator;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import br.com.raphaelfury.lp.exercises.semestre_5.ex1.Ex1;
import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.Product;

public class ProductImpl {

	public void registerProduct() {
		if (Ex1.getProductMap().getProducts().size() < 20) {
			int id = Integer.valueOf(JOptionPane.showInputDialog("Digite o código do produto:"));
			String name = JOptionPane.showInputDialog("Digite o nome do produto:");
			float value = Integer.valueOf(JOptionPane.showInputDialog("Digite o valor do produto:"));
			int quantity = Integer.valueOf(JOptionPane.showInputDialog("Digite a quantidade em estoque do produto:"));
			Product product = new Product(id, quantity, name, value, 0);
			Ex1.getProductMap().addProduct(product);
		} else {
			JOptionPane.showMessageDialog(null, "Quantidade de produtos excedida.", "Erro", 0);
		}
	}

	public void sellProduct() {
		int id = Integer.valueOf(JOptionPane.showInputDialog("Digite o código do produto:"));
		int quantityDesired = Integer
				.valueOf(JOptionPane.showInputDialog("Digite a quantidade desejada para a venda:"));
		Product product = Ex1.getProductMap().getProduct(id);

		if (product == null) {
			Ex1.getMainMenu().displayProductNotValid();
			return;
		}

		if (product.getQuantity() >= quantityDesired) {
			product.setQuantity(product.getQuantity() - quantityDesired);
			product.addSellQuantity(quantityDesired);
			JOptionPane.showMessageDialog(null,
					"Produto vendido: " + product.getName() + "\nQuantidade: " + quantityDesired, "Sucesso", 1);
		} else
			JOptionPane.showMessageDialog(null, "Quantidade insuficiente.", "Erro", 0);
	}

	public void updateProduct() {
		int id = Integer.valueOf(JOptionPane.showInputDialog("Digite o código do produto:"));
		int quantityDesired = Integer.valueOf(JOptionPane.showInputDialog("Digite a quantidade para adição:"));
		Product product = Ex1.getProductMap().getProduct(id);

		if (product == null) {
			Ex1.getMainMenu().displayProductNotValid();
			return;
		}

		product.setQuantity(product.getQuantity() + quantityDesired);
		JOptionPane.showMessageDialog(null,
				"Produto atualizado: " + product.getName() + "\nQuantidade adicionada: " + quantityDesired, "Sucesso",
				1);
	}

	public void changeProduct() {
		int id = Integer.valueOf(JOptionPane.showInputDialog("Digite o código do produto:")), oldQuantity;
		String oldName;
		Product product = Ex1.getProductMap().getProduct(id);

		if (product == null) {
			Ex1.getMainMenu().displayProductNotValid();
			return;
		}

		oldName = product.getName();
		oldQuantity = product.getQuantity();

		String newName = JOptionPane.showInputDialog("Digite o nome:");
		int newQuantity = Integer.valueOf(JOptionPane.showInputDialog("Digite a quantidade desejada:"));

		product.setName(newName);
		product.setQuantity(newQuantity);

		StringBuilder b = new StringBuilder();
		b.append("\n");
		b.append("Código: " + product.getId());
		b.append("\n");
		b.append("\n");
		b.append("Nome antigo: " + oldName);
		b.append("\n");
		b.append("Nome novo: " + product.getName());
		b.append("\n");
		b.append("\n");
		b.append("Quantidade antiga: " + oldQuantity);
		b.append("\n");
		b.append("Quantidade nova: " + product.getQuantity());
		b.append("\n");
		b.append("\n");

		JOptionPane.showMessageDialog(null, b.toString(), "Sucesso", 1);
	}

	public void applyDiscount() {
		int id = Integer.valueOf(JOptionPane.showInputDialog("Digite o código do produto:"));
		float oldValue;
		Product product = Ex1.getProductMap().getProduct(id);

		if (product == null) {
			Ex1.getMainMenu().displayProductNotValid();
			return;
		}

		oldValue = product.getValue();
		float discount = Float.valueOf(JOptionPane.showInputDialog("Digite o código do produto:"));

		product.setValue(product.getValue() - (product.getValue() * discount));

		StringBuilder b = new StringBuilder();
		b.append("\n");
		b.append("Código: " + product.getId());
		b.append("\n");
		b.append("\n");
		b.append("Preço antigo: " + oldValue);
		b.append("\n");
		b.append("Preço novo (" + discount + "% OFF): " + product.getValue());
		b.append("\n");
		b.append("\n");

		JOptionPane.showMessageDialog(null, b.toString(), "Sucesso", 1);
	}

	public void showMoreQuantity() {
		Product product = Ex1.getProductMap().getStream() .collect(Collectors.maxBy(Comparator.comparingInt(Product::getSellQuantity))).get();

		StringBuilder b = new StringBuilder();
		b.append("\n");
		b.append("Código: " + product.getId());
		b.append("\n");
		b.append("Nome: " + product.getName());
		b.append("\n");
		b.append("Quantidade de vendas: " + product.getSellQuantity());
		b.append("\n");

		JOptionPane.showMessageDialog(null, b.toString(), "Sucesso", 1);
	}

	public void viewProducts() {
		StringBuilder b = new StringBuilder();
		for (Product products : Ex1.getProductMap().getProducts()) {
			b.append("\n");
			b.append("Produto: " + products.getName());
			b.append("\n");
			b.append("Código: " + products.getId());
			b.append("\n");
			b.append("Quantidade no estoque: " + products.getQuantity());
			b.append("\n");
			b.append("\n");
		}

		JOptionPane.showMessageDialog(null, b.toString(), "Listagem de produtos", 1);
	}

	public void media() {
		int media = 0;
		for (Product products : Ex1.getProductMap().getProducts()) {
			media += products.getValue();
		}

		media /= Ex1.getProductMap().getProducts().size();

		JOptionPane.showMessageDialog(null, "Média de preços: " + media, "Sucesso", 1);
	}
}
