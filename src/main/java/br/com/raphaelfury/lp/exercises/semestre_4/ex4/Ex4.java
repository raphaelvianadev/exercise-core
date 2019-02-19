package br.com.raphaelfury.lp.exercises.semestre_4.ex4;

import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_4.ex4.manager.ChocolateMap;
import br.com.raphaelfury.lp.exercises.semestre_4.ex4.objects.Chocolate;

public class Ex4 extends Exercise {
	
	public Ex4() {
		super("Ex4", "Prova bimestral", true);
		// TODO Auto-generated constructor stub
	}
	
	/* Prova bimestral */

	public int codigo = 0, percentual = 0, prodAno = 0, quantidade = 0;
	public String nome = "";
	public double valorRevenda = 0, valorProd = 0, peso = 0;
	public ChocolateMap chocolateMap;
	
	@Override
	public void start() {
		chocolateMap = new ChocolateMap();
		
		for (int i = 0; i < 2; i++) {
			log("Digite o c�digo");
			codigo = getScanner().nextInt();
			log("Digite o nome");
			nome = getScanner().next();
			log("Digite a quantidade");
			quantidade = getScanner().nextInt();
			log("Digite o percentual");
			percentual = getScanner().nextInt();
			log("Digite a prod por ano");
			prodAno = getScanner().nextInt();
			log("Digite o valor de revenda");
			valorRevenda = getScanner().nextDouble();
			log("Digite o valor de produção");
			valorProd = getScanner().nextDouble();
			log("Digite o peso");
			peso = getScanner().nextDouble();
			
			Chocolate chocolate = new Chocolate(UUID.randomUUID(), codigo, nome, quantidade, percentual, prodAno, valorRevenda, valorProd, peso);
			getChocolateMap().addChocolate(chocolate);
			
			log(chocolate.toString());
			
			cleanUp();
		}
		
		checkValorRevenda();
		reduzirPreco();
		media();
		
		finalize();
	}
	
	public ChocolateMap getChocolateMap() {
		return chocolateMap;
	}

	public void cleanUp() {
		codigo = 0;
		percentual = 0;
		prodAno = 0;
		valorRevenda = 0;
		valorProd = 0;
		peso = 0;
		nome = "";
	}
	
	public void verify() {
		for(Chocolate chocolates : getChocolateMap().getChocolates()) {
			double finalValue = chocolates.getValorRevenda() - chocolates.getValorProd();
			blankLine();
			log("Verificador", "Chocolate: " + chocolates.getNome());
			log("Verificador", "Valor de revenda: " + chocolates.getValorRevenda());
			log("Verificador", "Valor de produção: " + chocolates.getValorProd());
			log("Verificador", "Valor recebido com a venda de cada chocolate: " + finalValue);
			log("Verificador", "Valor total: " + finalValue * chocolates.getQuantidade());
			blankLine();
		}
	}

	public void checkValorRevenda() {
		Chocolate chocolate = getChocolateMap().getStream().collect(Collectors.minBy(Comparator.comparingDouble(Chocolate::getValorRevenda))).get();
		log("CheckerValorRevenda", "Chocolate: " + chocolate.getNome());
		log("CheckerValorRevenda", "Percentual: " + chocolate.getPercentual());
		blankLine();
	}

	public void reduzirPreco() {
		Chocolate chocolate = getChocolateMap().getStream().collect(Collectors.maxBy(Comparator.comparingDouble(Chocolate::getValorRevenda))).get();
		log("ReduzirPre�o", "Chocolate: " + chocolate.getNome());
		log("ReduzirPre�o", "Preço antigo: " + chocolate.getValorRevenda());
		chocolate.setValorRevenda(chocolate.getValorRevenda() - ((chocolate.getValorRevenda() * 50)/100));
		log("ReduzirPre�o", "Pre�o novo (50% OFF): " + chocolate.getValorRevenda());
		blankLine();
	}
	
	public void media() {
		int media = 0;
		for(Chocolate chocolates : getChocolateMap().getChocolates()) {
			media += chocolates.getPercentual(); 
		}
		
		media /= getChocolateMap().getChocolates().size();
		
		for(Chocolate chocolates : getChocolateMap().getChocolates()) {
			if(chocolates.getPercentual() < media) {
				log("Média", "Chocolate: " + chocolates.getNome() + " | " + chocolates.getPercentual());
			}
		}
	}

}
